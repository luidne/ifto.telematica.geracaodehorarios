package br.edu.ifto.telematica.geracaodehorarios;

/**
 *
 * @author Luidne
 */
public class Scripts {

    public static String CREATE = "// Popular banco\n"
            + "create (p1:professor{name:'P1'})\n"
            + "create (p2:professor{name:'P2'})\n"
            + "create (p3:professor{name:'P3'})\n"
            + "create (p4:professor{name:'P4'})\n"
            + "create (p5:professor{name:'P5'})\n"
            + "\n"
            + "create(d1:disciplina{name:'D1', ch:4})\n"
            + "create(d2:disciplina{name:'D2', ch:4})\n"
            + "create(d3:disciplina{name:'D3', ch:4})\n"
            + "create(d4:disciplina{name:'D4', ch:4})\n"
            + "create(d5:disciplina{name:'D5', ch:2})\n"
            + "create(d6:disciplina{name:'D6', ch:2})\n"
            + "create(d7:disciplina{name:'D7', ch:4})\n"
            + "create(d8:disciplina{name:'D8', ch:4})\n"
            + "create(d9:disciplina{name:'D9', ch:4})\n"
            + "create(d10:disciplina{name:'D10', ch:4})\n"
            + "create(d11:disciplina{name:'D11', ch:2})\n"
            + "create(d12:disciplina{name:'D12', ch:2})\n"
            + "\n"
            + "create (pe1:periodo{name:'1ยบ Per.'})\n"
            + "create (pe2:periodo{name:'2ยบ Per.'})\n"
            + "\n"
            + "create(p1)-[:ministra_aula]->(d1)\n"
            + "create(p1)-[:ministra_aula]->(d4)\n"
            + "create(p2)-[:ministra_aula]->(d2)\n"
            + "create(p2)-[:ministra_aula]->(d5)\n"
            + "create(p2)-[:ministra_aula]->(d7)\n"
            + "create(p3)-[:ministra_aula]->(d10)\n"
            + "create(p3)-[:ministra_aula]->(d12)\n"
            + "create(p4)-[:ministra_aula]->(d6)\n"
            + "create(p4)-[:ministra_aula]->(d8)\n"
            + "create(p5)-[:ministra_aula]->(d9)\n"
            + "create(p5)-[:ministra_aula]->(d11)\n"
            + "\n"
            + "create(d1)-[:pertence]->(pe1)\n"
            + "create(d2)-[:pertence]->(pe1)\n"
            + "create(d3)-[:pertence]->(pe1)\n"
            + "create(d4)-[:pertence]->(pe1)\n"
            + "create(d5)-[:pertence]->(pe1)\n"
            + "create(d6)-[:pertence]->(pe1)\n"
            + "create(d7)-[:pertence]->(pe2)\n"
            + "create(d8)-[:pertence]->(pe2)\n"
            + "create(d9)-[:pertence]->(pe2)\n"
            + "create(d10)-[:pertence]->(pe2)\n"
            + "create(d11)-[:pertence]->(pe2)\n"
            + "create(d12)-[:pertence]->(pe2)\n"
            + "\n"
            + "create(h2_8:horario{name:'Seg. 08-09', dia:2,inicio:8,fim:9})\n"
            + "create(h2_9:horario{name:'Seg. 09-10', dia:2,inicio:9,fim:10})\n"
            + "create(h2_10:horario{name:'Seg. 10-11', dia:2,inicio:10,fim:11})\n"
            + "create(h2_11:horario{name:'Seg. 11-12', dia:2,inicio:11,fim:12})\n"
            + "\n"
            + "create(h3_8:horario{name:'Ter. 08-09', dia:3,inicio:8,fim:9})\n"
            + "create(h3_9:horario{name:'Ter. 09-10', dia:3,inicio:9,fim:10})\n"
            + "create(h3_10:horario{name:'Ter. 10-11', dia:3,inicio:10,fim:11})\n"
            + "create(h3_11:horario{name:'Ter. 11-12', dia:3,inicio:11,fim:12})\n"
            + "\n"
            + "create(h4_8:horario{name:'Qua. 08-09', dia:4,inicio:8,fim:9})\n"
            + "create(h4_9:horario{name:'Qua. 09-10', dia:4,inicio:9,fim:10})\n"
            + "create(h4_10:horario{name:'Qua. 10-11', dia:4,inicio:10,fim:11})\n"
            + "create(h4_11:horario{name:'Qua. 11-12', dia:4,inicio:11,fim:12})\n"
            + "\n"
            + "create(h5_8:horario{name:'Qui. 08-09', dia:5,inicio:8,fim:9})\n"
            + "create(h5_9:horario{name:'Qui. 09-10', dia:5,inicio:9,fim:10})\n"
            + "create(h5_10:horario{name:'Qui. 10-11', dia:5,inicio:10,fim:11})\n"
            + "create(h5_11:horario{name:'Qui. 11-12', dia:5,inicio:11,fim:12})\n"
            + "\n"
            + "create(h6_8:horario{name:'Sex. 08-09', dia:6,inicio:8,fim:9})\n"
            + "create(h6_9:horario{name:'Sex. 09-10', dia:6,inicio:9,fim:10})\n"
            + "create(h6_10:horario{name:'Sex. 10-11', dia:6,inicio:10,fim:11})\n"
            + "create(h6_11:horario{name:'Sex. 11-12', dia:6,inicio:11,fim:12})\n"
            + "\n"
            + "create(p1)<-[:restricao_horario]-(h2_8)\n"
            + "create(p1)<-[:restricao_horario]-(h2_9)\n"
            + "create(p1)<-[:restricao_horario]-(h2_10)\n"
            + "create(p1)<-[:restricao_horario]-(h2_11)\n"
            + "create(p1)<-[:restricao_horario]-(h4_8)\n"
            + "create(p1)<-[:restricao_horario]-(h4_9)\n"
            + "create(p1)<-[:restricao_horario]-(h4_10)\n"
            + "create(p1)<-[:restricao_horario]-(h4_11)\n"
            + "\n"
            + "create(p2)<-[:restricao_horario]-(h5_8)\n"
            + "create(p2)<-[:restricao_horario]-(h5_9)\n"
            + "create(p2)<-[:restricao_horario]-(h5_10)\n"
            + "create(p2)<-[:restricao_horario]-(h5_11)\n"
            + "\n"
            + "create(p3)<-[:restricao_horario]-(h3_8)\n"
            + "create(p3)<-[:restricao_horario]-(h3_9)\n"
            + "create(p3)<-[:restricao_horario]-(h3_10)\n"
            + "create(p3)<-[:restricao_horario]-(h3_11)\n"
            + "create(p3)<-[:restricao_horario]-(h5_8)\n"
            + "create(p3)<-[:restricao_horario]-(h5_9)\n"
            + "create(p3)<-[:restricao_horario]-(h5_10)\n"
            + "create(p3)<-[:restricao_horario]-(h5_11)\n"
            + "\n"
            + "create(p5)<-[:restricao_horario]-(h5_8)\n"
            + "create(p5)<-[:restricao_horario]-(h5_9)\n"
            + "create(p5)<-[:restricao_horario]-(h5_10)\n"
            + "create(p5)<-[:restricao_horario]-(h5_11)";

    public static String DELETE = "MATCH (x) DETACH DELETE x";

    public static String GERAR = "// Gera horários para o professor e uma de suas disciplinas\n"
            + "match (p:professor{name:'P1'})-[ma:ministra_aula]->(d:disciplina)-[:pertence]->(per:periodo)\n"
            + "match (h:horario)\n"
            + "where not (h)-[:restricao_horario]->(p) and not (h)-[:restricao_horario]->(per) and ma.dia IS NULL\n"
            + "with collect(distinct h) as h, head(collect(d)) as d, head(collect(per)) as per, p, ma limit 1\n"
            + "call telematica.gerar(h,d, d.ch) yield node\n"
            + "//with *\n"
            + "create (p)<-[x:restricao_horario]-(node)-[y:restricao_horario]->(per)\n"
            + "with head(collect(node.dia)) as dia, ma, head(collect(node)) as inicio, last(collect(node)) as fim\n"
            + "set ma.dia = dia, ma.inicio = inicio.inicio, ma.fim = fim.fim\n"
            + "return *\n"
            + "//return dia, inicio.inicio, fim.fim";

}