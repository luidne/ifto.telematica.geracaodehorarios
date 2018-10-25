package br.edu.ifto.telematica.geracaodehorarios;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import static org.neo4j.driver.v1.Values.parameters;
import org.neo4j.driver.v1.exceptions.NoSuchRecordException;

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
        try {
            List<Long> ids = session.run(Scripts.RETURN_IDS_PROFESSOR)
                    .list()
                    .stream()
                    .map(x -> x.get(0).asLong())
                    .collect(Collectors.toList());
            
            for(Long id : ids) {
                session.run(Scripts.GERAR, parameters("id", id));
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Verifica se todas disicplinas têm horário.
     * @return true se não há disciplinas sem horário.
     */
    public boolean todasDisciplinasComHorarios(){
        return !session.run(Scripts.TEM_DISCIPLINAS_SEM_HORARIO).single().get(0).asBoolean();
    }

}
