package simulacao.si.models;

import org.junit.Before;
import org.junit.Test;
import simulacao.si.classes.Curso;
import simulacao.si.classes.UnidadeCurricular;

import static org.junit.Assert.assertEquals;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author João Caçote 
 * @version 1.0
 */

public class CursoTest {

    @Before
    public void setUp() {

    }

    @Test
    public void testAddUnidadeCurso()
    {
        // ====================== Criação de Cursos =============================
        Curso c1 = new Curso("Engenharia Informática");
        Curso c2 = new Curso("Arquitetura e Urbanismo");

        // ====================== Criação de Cadeiras para Engenharia Informática =============================
        UnidadeCurricular un1 = new UnidadeCurricular("Inglês", "INF1");
        UnidadeCurricular un2 = new UnidadeCurricular("Introdução à Algoritima e Programação ", "INF1");
        UnidadeCurricular un3 = new UnidadeCurricular("Sistemas de Informação", "INF1");

        UnidadeCurricular un4 = new UnidadeCurricular("Algoritimos e estruturas de dados", "INF2");
        UnidadeCurricular un5 = new UnidadeCurricular("Linguagens de programação", "INF2");
        UnidadeCurricular un6 = new UnidadeCurricular("Sistemas operativos", "INF2");

        UnidadeCurricular un7 = new UnidadeCurricular("Laboratório de programação", "INF3");
        UnidadeCurricular un8 = new UnidadeCurricular("Engenharia de software", "INF3");
        UnidadeCurricular un9 = new UnidadeCurricular("Sistemas distribuídos ", "INF3");


        assertEquals(0, c1.getUnidadescurriculares().size());
        c1.addUnidadeCurricular(un1);
        c1.addUnidadeCurricular(un2);
        c1.addUnidadeCurricular(un3);
        c1.addUnidadeCurricular(un4);
        c1.addUnidadeCurricular(un5);
        c1.addUnidadeCurricular(un6);
        c1.addUnidadeCurricular(un7);
        c1.addUnidadeCurricular(un8);
        c1.addUnidadeCurricular(un9);
        assertEquals(9, c1.getUnidadescurriculares().size());



        UnidadeCurricular un10 = new UnidadeCurricular("Métodos e técnicas de comunicação", "AU1");
        UnidadeCurricular un11 = new UnidadeCurricular("Geometria e topologia", "AU1");
        UnidadeCurricular un12 = new UnidadeCurricular("Inglês", "AU1");

        UnidadeCurricular un13 = new UnidadeCurricular("Antropologia do espaço", "AU2");
        UnidadeCurricular un14 = new UnidadeCurricular("Computação gráfica", "AU2");
        UnidadeCurricular un15 = new UnidadeCurricular("Sistemas de construção", "AU2");

        assertEquals(0, c2.getUnidadescurriculares().size());
        c2.addUnidadeCurricular(un10);
        c2.addUnidadeCurricular(un11);
        c2.addUnidadeCurricular(un12);
        assertEquals(3, c2.getUnidadescurriculares().size());
        c2.addUnidadeCurricular(un13);
        c2.addUnidadeCurricular(un14);
        c2.addUnidadeCurricular(un15);
        assertEquals(6, c2.getUnidadescurriculares().size());
    }
}
