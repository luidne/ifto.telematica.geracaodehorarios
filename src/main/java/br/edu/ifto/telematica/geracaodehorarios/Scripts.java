package br.edu.ifto.telematica.geracaodehorarios;

/**
 *
 * @author Luidne
 */
public class Scripts {

    public static String CREATE = "// Popular banco\n"
            + "create (p1:professor{name:'p1'})\n"
            + "create (p2:professor{name:'p2'})\n"
            + "create (p3:professor{name:'p3'})\n"
            + "create (p4:professor{name:'p4'})\n"
            + "create (p5:professor{name:'p5'})\n"
            + "\n"
            + "create(d1:disciplina{name:'d1', ch:4})\n"
            + "create(d2:disciplina{name:'d2', ch:4})\n"
            + "create(d3:disciplina{name:'d3', ch:4})\n"
            + "create(d4:disciplina{name:'d4', ch:4})\n"
            + "create(d5:disciplina{name:'d5', ch:2})\n"
            + "create(d6:disciplina{name:'d6', ch:2})\n"
            + "create(d7:disciplina{name:'d7', ch:4})\n"
            + "create(d8:disciplina{name:'d8', ch:4})\n"
            + "create(d9:disciplina{name:'d9', ch:4})\n"
            + "create(d10:disciplina{name:'d10', ch:4})\n"
            + "create(d11:disciplina{name:'d11', ch:2})\n"
            + "create(d12:disciplina{name:'d12', ch:2})\n"
            + "\n"
            + "create (pe1:periodo{name:'t1'})\n"
            + "create (pe2:periodo{name:'t2'})\n"
            + "\n"
            + "create(p1)-[:pa]->(d1)\n"
            + "create(p1)-[:pa]->(d4)\n"
            + "create(p2)-[:pa]->(d2)\n"
            + "create(p2)-[:pa]->(d5)\n"
            + "create(p2)-[:pa]->(d7)\n"
            + "create(p3)-[:pa]->(d10)\n"
            + "create(p3)-[:pa]->(d12)\n"
            + "create(p4)-[:pa]->(d6)\n"
            + "create(p4)-[:pa]->(d8)\n"
            + "create(p5)-[:pa]->(d9)\n"
            + "create(p5)-[:pa]->(d11)\n"
            + "\n"
            + "create(d1)-[:dt]->(pe1)\n"
            + "create(d2)-[:dt]->(pe1)\n"
            + "create(d3)-[:dt]->(pe1)\n"
            + "create(d4)-[:dt]->(pe1)\n"
            + "create(d5)-[:dt]->(pe1)\n"
            + "create(d6)-[:dt]->(pe1)\n"
            + "create(d7)-[:dt]->(pe2)\n"
            + "create(d8)-[:dt]->(pe2)\n"
            + "create(d9)-[:dt]->(pe2)\n"
            + "create(d10)-[:dt]->(pe2)\n"
            + "create(d11)-[:dt]->(pe2)\n"
            + "create(d12)-[:dt]->(pe2)\n"
            + "\n"
            + "create(h2_8:horario{name:'h1', dia:2,inicio:8,fim:9})\n"
            + "create(h2_9:horario{name:'h2', dia:2,inicio:9,fim:10})\n"
            + "create(h2_10:horario{name:'h3', dia:2,inicio:10,fim:11})\n"
            + "create(h2_11:horario{name:'h4', dia:2,inicio:11,fim:12})\n"
            + "\n"
            + "create(h3_8:horario{name:'h5', dia:3,inicio:8,fim:9})\n"
            + "create(h3_9:horario{name:'h6', dia:3,inicio:9,fim:10})\n"
            + "create(h3_10:horario{name:'h7', dia:3,inicio:10,fim:11})\n"
            + "create(h3_11:horario{name:'h8', dia:3,inicio:11,fim:12})\n"
            + "\n"
            + "create(h4_8:horario{name:'h9', dia:4,inicio:8,fim:9})\n"
            + "create(h4_9:horario{name:'h10', dia:4,inicio:9,fim:10})\n"
            + "create(h4_10:horario{name:'h11', dia:4,inicio:10,fim:11})\n"
            + "create(h4_11:horario{name:'h12', dia:4,inicio:11,fim:12})\n"
            + "\n"
            + "create(h5_8:horario{name:'h13', dia:5,inicio:8,fim:9})\n"
            + "create(h5_9:horario{name:'h14', dia:5,inicio:9,fim:10})\n"
            + "create(h5_10:horario{name:'h15', dia:5,inicio:10,fim:11})\n"
            + "create(h5_11:horario{name:'h16', dia:5,inicio:11,fim:12})\n"
            + "\n"
            + "create(h6_8:horario{name:'h17', dia:6,inicio:8,fim:9})\n"
            + "create(h6_9:horario{name:'h18', dia:6,inicio:9,fim:10})\n"
            + "create(h6_10:horario{name:'h19', dia:6,inicio:10,fim:11})\n"
            + "create(h6_11:horario{name:'h20', dia:6,inicio:11,fim:12})\n"
            + "\n"
            + "create(p1)<-[:rh]-(h2_8)\n"
            + "create(p1)<-[:rh]-(h2_9)\n"
            + "create(p1)<-[:rh]-(h2_10)\n"
            + "create(p1)<-[:rh]-(h2_11)\n"
            + "create(p1)<-[:rh]-(h4_8)\n"
            + "create(p1)<-[:rh]-(h4_9)\n"
            + "create(p1)<-[:rh]-(h4_10)\n"
            + "create(p1)<-[:rh]-(h4_11)\n"
            + "\n"
            + "create(p2)<-[:rh]-(h5_8)\n"
            + "create(p2)<-[:rh]-(h5_9)\n"
            + "create(p2)<-[:rh]-(h5_10)\n"
            + "create(p2)<-[:rh]-(h5_11)\n"
            + "\n"
            + "create(p3)<-[:rh]-(h3_8)\n"
            + "create(p3)<-[:rh]-(h3_9)\n"
            + "create(p3)<-[:rh]-(h3_10)\n"
            + "create(p3)<-[:rh]-(h3_11)\n"
            + "create(p3)<-[:rh]-(h5_8)\n"
            + "create(p3)<-[:rh]-(h5_9)\n"
            + "create(p3)<-[:rh]-(h5_10)\n"
            + "create(p3)<-[:rh]-(h5_11)\n"
            + "\n"
            + "create(p5)<-[:rh]-(h5_8)\n"
            + "create(p5)<-[:rh]-(h5_9)\n"
            + "create(p5)<-[:rh]-(h5_10)\n"
            + "create(p5)<-[:rh]-(h5_11)";

    public static String DELETE = "MATCH (x) DETACH DELETE x";
    
    public static String RETURN_IDS_PROFESSOR = "MATCH (p:professor) RETURN ID(p)";    

    public static String GERAR = "// Gera horários para o professor e uma de suas disciplinas\n"
            + "MATCH (p:professor)-[ma:pa]->(d:disciplina)-[:dt]->(per:periodo)\n"
            + "WHERE ID(p)={id}"
            + "MATCH (h:horario)\n"
            + "WHERE NOT (h)-[:rh]->(p) AND NOT (h)-[:rh]->(per) AND ma.dia IS NULL\n"
            + "WITH COLLECT(DISTINCT h) AS h, HEAD(COLLECT(d)) AS d, HEAD(COLLECT(per)) AS per, p, ma LIMIT 1\n"
            + "CALL telematica.gerar(h,d, d.ch) YIELD node\n"
            + "CREATE (p)<-[x:rh]-(node)-[y:rh]->(per)\n"
            + "WITH HEAD(COLLECT(node.dia)) AS dia, ma, HEAD(COLLECT(node)) AS inicio, LAST(COLLECT(node)) AS fim\n"
            + "SET ma.dia = dia, ma.inicio = inicio.inicio, ma.fim = fim.fim\n"
            + "RETURN *";
    
    public static final String TEM_DISCIPLINAS_SEM_PROFESSOR = "MATCH (d:disciplina) WHERE NOT (d)-[:pa]-(:professor)\n"
            + "RETURN COUNT(d) > 0";
    
    public static final String TEM_DISCIPLINAS_SEM_HORARIO = "MATCH (p)-[m:pa]->(n)\n"
            + "WHERE m.dia IS NULL\n"
            + "RETURN COUNT(m) > 0";

}
