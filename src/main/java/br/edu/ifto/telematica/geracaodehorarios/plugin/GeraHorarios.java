package br.edu.ifto.telematica.geracaodehorarios.plugin;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.logging.Log;
import org.neo4j.procedure.Context;
import org.neo4j.procedure.Description;
import org.neo4j.procedure.Mode;
import org.neo4j.procedure.Name;
import org.neo4j.procedure.Procedure;
import org.neo4j.procedure.UserFunction;

/**
 *
 * @author Luídne
 */
public class GeraHorarios {
    
    @Context
    public GraphDatabaseService db;
    
    @Context
    public Log log;
    
    @Description("Retorna o dia, a hora de início e fim.")
    @Procedure(name = "telematica.melhorHorario1", mode = Mode.WRITE)
    public Stream<Horario> search(@Name("restricoes") List<Node> nodes, @Name("dias") List<Long> dias, @Name("horarios") Map<String, Object> horarios) {
        boolean encontrouHorario = true;
        LocalDateTime horarioCandidatoInicio = null;
        LocalDateTime horarioCandidatoFim = null;

        // Sem restrições
        for (Long d : dias) {
            log.info("telematica.gerarhorario: dia " + d);
            int dia = d.intValue();
            int inicio = (int)(long)horarios.get("inicio");
            int fim = (int)(long)horarios.get("fim");
            
            horarioCandidatoInicio = LocalDateTime.of(2018, Month.MARCH, dia, inicio, 0);
            horarioCandidatoFim = LocalDateTime.of(2018, Month.MARCH, dia, fim, 0);
            
            // Restrições
            for (Node node : nodes) {
                log.info("telematica.gerarhorario: node.id " + node.getId());
                Map<String, Object> props = node.getAllProperties();
                int rDia = (int)(long) props.get("dia");
                int rInicio = (int)(long) props.get("inicio");
                int rFim = (int)(long) props.get("fim");
                
                LocalDateTime horarioRestritivoInicio = LocalDateTime.of(2018, Month.MARCH, rDia, rInicio, 0);
                LocalDateTime horarioRestritivoFim = LocalDateTime.of(2018, Month.MARCH, rDia, rFim, 0);
                
                //rp.fim <= ra.inicio OR ra.fim <= rp.inicio))
                if(horarioRestritivoFim.isBefore(horarioCandidatoInicio) || horarioCandidatoFim.isBefore(horarioRestritivoInicio)) {
                    // horário candidato se ele não conflitar com outro horário
                    log.info("telematica.gerarhorario: Candidato Inicio "+horarioCandidatoInicio + " Candidato Fim "+horarioCandidatoFim);
                    log.info("telematica.gerarhorario: Restrição Inicio "+horarioRestritivoInicio + " Restrição Fim "+horarioRestritivoFim);
                    encontrouHorario = true;
                } else {
                    // Finaliza esse laço e seleciona outro horário candidato
                    log.info("telematica.gerarhorario: Candidato Inicio "+horarioCandidatoInicio + " Candidato Fim "+horarioCandidatoFim);
                    log.info("telematica.gerarhorario: Restrição Inicio "+horarioRestritivoInicio + " Restrição Fim "+horarioRestritivoFim);
                    log.info("telematica.gerarhorario: break");
                    encontrouHorario = false;
                    break;
                }
            }
            
            if(encontrouHorario) {
                break;
            }
        }
        
        log.info("telematica.gerarhorario: encontrou horário? " + encontrouHorario);
        
        Horario horario = new Horario(
                (long)horarioCandidatoInicio.getDayOfMonth(),
                (long)horarioCandidatoInicio.getHour(),
                (long)horarioCandidatoFim.getHour());
        
        log.info("telematica.gerarhorario: " + horario);
        
        return encontrouHorario ? Stream.of(horario) 
            : Stream.empty();
    }
    
    @Description("Retorna os nodes dos melhores horários de acordo com a carga horária.")
    @Procedure(name = "telematica.melhorHorario", mode = Mode.WRITE)
    public Stream<NodeResult> gerar(@Name("horarios") List<Node> horarios, @Name("disciplina") Node disciplina, @Name("ch") long cargaHoraria) {
        log.info("telematica.gerar(horarios = size "+horarios.size()+", disciplina = "+disciplina.getProperty("name")+", cargaHoraria = "+cargaHoraria+")");
        List<Node> nodes = Collections.emptyList();
        boolean sairDoLoop = false;
        //outerloop:
        for(Node node : horarios) {            
            nodes = new ArrayList<>(4);
            long dia = (long) node.getProperty("dia");
            long ch = 0;
            
            log.info("telematica.gerar: node.id =  " + node.getId() + " dia = "+dia);
            
            for(Node n : horarios) {
                if((long)n.getProperty("dia") == dia) {   
                    nodes.add(n);
                    ch++;
                    log.info("telematica.gerar: ch = " + ch + " nodeHorario = "+node.getId() +" dia = "+n.getProperty("dia")+" inicio =  "+n.getProperty("inicio")+" fim = "+n.getProperty("fim"));
                    if(ch == cargaHoraria) {
                        log.info("telematica.gerar: carga horária bateu | ch = " + ch);
                       //break outerloop;
                       sairDoLoop = true;
                       break;
                    }
                }
            }
            
            if(sairDoLoop) break;
        }
        
        
        return nodes.stream().map(NodeResult::new);
    }
    
    @UserFunction(name = "telematica.funcaoTeste")
    public String test(@Name("restricoes") List<Node> nodes, @Name("dias") List<String> dias, @Name("horarios") Map<String, Object> horarios) {
        log.info(":::::: NODES ::::::");
        //List<Node> nodes = Arrays.asList(db.getNodeById(idNodes.get(0)));
        
        for (Node node : nodes) {
            log.info("node:"+node);
            for (String prop : node.getPropertyKeys()) {
                log.info(prop+":"+node.getAllProperties().get(prop));
            }
        }
        
        log.info(":::::: DIAS ::::::");
        for (String dia : dias) {
            log.debug("dia:", dia);
        }
        
        log.info(":::::: HORARIOS ::::::");
        for (Object key : horarios.keySet()) {
            log.debug(key+":", horarios.get((String)key));
        }
        
        return "retorno da função telematica.funcaoTeste()";
    }
    
    public static class Horario {
        
        public long dia;
        public long inicio;
        public long fim;

        public Horario() {}

        public Horario(long dia, long inicio, long fim) {
            this.dia = dia;
            this.inicio = inicio;
            this.fim = fim;
        }

        @Override
        public String toString() {
            return "Horario{" + "dia=" + dia + ", inicio=" + inicio + ", fim=" + fim + '}';
        }
    }
    
    public class NodeResult {
        public Node node;

        public NodeResult(Node node) {
            this.node = node;
        }
    }
}
