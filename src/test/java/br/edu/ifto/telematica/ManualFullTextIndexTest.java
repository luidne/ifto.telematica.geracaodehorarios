package br.edu.ifto.telematica;

import br.edu.ifto.telematica.FullTextIndex;
import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Config;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import static org.neo4j.driver.v1.Values.parameters;
import org.neo4j.harness.junit.Neo4jRule;

/**
 *
 * @author Luídne
 * Pego em: https://neo4j.com/docs/developer-manual/current/extending-neo4j/procedures/
 */
public class ManualFullTextIndexTest {
    // This rule starts a Neo4j instance
    @Rule
    public Neo4jRule neo4j = new Neo4jRule()
            // This is the Procedure we want to test
            .withProcedure(FullTextIndex.class);
    
    //@Test
    public void shouldAllowIndexingAndFindingANode() {
        // In a try-block, to make sure we close the driver after the test
        try (Driver driver = GraphDatabase.driver("bolt://127.0.0.1:7687", AuthTokens.basic("admin", "admin"))) {
            // Given I've started Neo4j with the FullTextIndex procedure class
            //       which my 'neo4j' rule above does.
            Session session = driver.session();
            
            // And given I have a node in the database
            long nodeId = session.run("CREATE (d:disciplina {name: 'Disc. Ext.'}) RETURN id(d)")
                    .single()
                    .get(0)
                    .asLong();
            
            // When I use the index procedure to index a node
            session.run("CALL br.edu.ifto.telematica.index({id}, ['name'])", parameters("id", nodeId));
            
            // Then I can search for that node with lucene query syntax
            StatementResult result = session.run("CALL br.edu.ifto.telematica.search(('disciplina', 'name: Disc*')");
            System.out.println("nodeId = "+nodeId);
            System.out.println("result nodeId = "+result.single().get("nodeId").asLong());
            assertThat(result.single().get("nodeId").asLong(), equalTo(nodeId));
        } catch (Exception e) {}
    }
}
