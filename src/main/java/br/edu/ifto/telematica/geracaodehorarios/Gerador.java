package br.edu.ifto.telematica.geracaodehorarios;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;

/**
 *
 * @author Luidne
 */
public class Gerador {
    
    String USUARIO = "neo4j";
    String SENHA = "admin";
    private final Session session;
    
    public Gerador(){
        Driver driver = GraphDatabase.driver("bolt://127.0.0.1:7687", AuthTokens.basic(USUARIO, SENHA));
        session = driver.session();
    }

    public void popular() {
        try {
            session.run(Scripts.CREATE).hasNext();
        } catch (Exception e) {
            throw e;
        }
    }

    public void limparTudo() {
        try {
            session.run(Scripts.DELETE).hasNext();
        } catch (Exception e) {
            throw e;
        }
    }

    public void ordenar() {

    }

    public void gerar() {

    }

}
