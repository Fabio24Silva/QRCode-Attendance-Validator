package simulacao.si;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import simulacao.si.classes.*;
import simulacao.si.repositories.AlunoRepo;
import simulacao.si.repositories.CursoRepo;
import simulacao.si.repositories.TurmaRepo;
import simulacao.si.repositories.UnidadeCurricularRepo;

import java.time.LocalDate;
import java.time.LocalTime;


@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private CursoRepo cursoRepo;
    private UnidadeCurricularRepo unidadeCurricularRepo;
    private TurmaRepo turmaRepo;
    private AlunoRepo alunoRepo;

    public Bootstrap(CursoRepo cursoRepo, UnidadeCurricularRepo unidadeCurricularRepo, AlunoRepo alunoRepo, TurmaRepo turmaRepo) {
        this.cursoRepo = cursoRepo;
        this.unidadeCurricularRepo = unidadeCurricularRepo;
        this.turmaRepo = turmaRepo;
        this.alunoRepo = alunoRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
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

        c1.addUnidadeCurricular(un1);
        c1.addUnidadeCurricular(un2);
        c1.addUnidadeCurricular(un3);
        c1.addUnidadeCurricular(un4);
        c1.addUnidadeCurricular(un5);
        c1.addUnidadeCurricular(un6);
        c1.addUnidadeCurricular(un7);
        c1.addUnidadeCurricular(un8);
        c1.addUnidadeCurricular(un9);

        cursoRepo.save(c1);

        // ====================== Criação de Cadeiras para Arquitectura e Urbanismo =============================

        UnidadeCurricular un10 = new UnidadeCurricular("Métodos e técnicas de comunicação", "AU1");
        UnidadeCurricular un11 = new UnidadeCurricular("Geometria e topologia", "AU1");
        UnidadeCurricular un12 = new UnidadeCurricular("Inglês", "AU1");

        UnidadeCurricular un13 = new UnidadeCurricular("Antropologia do espaço", "AU2");
        UnidadeCurricular un14 = new UnidadeCurricular("Computação gráfica", "AU2");
        UnidadeCurricular un15 = new UnidadeCurricular("Sistemas de construção", "AU2");

        c2.addUnidadeCurricular(un10);
        c2.addUnidadeCurricular(un11);
        c2.addUnidadeCurricular(un12);
        c2.addUnidadeCurricular(un13);
        c2.addUnidadeCurricular(un14);
        c2.addUnidadeCurricular(un15);

        cursoRepo.save(c2);

        // ====================== Criação das Turmas para as Unidades Curriculares =============================
        // Turmas Engenharia Informática 1º ano
        Turma t1 = new Turma("XHT", un1);   // Turma de Ingles
        Turma t2 = new Turma("IAP", un2);   // Turma de Introdução à Algoritima e Programação
        Turma t3 = new Turma("SIA", un3);   // Turma de Sistemas de Informação
        Turma t4 = new Turma("SIAX", un3);  // Turma de Sistemas de Informação

        // Turmas Engenharia Informática 2º ano
        Turma t5 = new Turma("AEDA", un4);  // Turma de Algoritimos e estruturas de dados
        Turma t6 = new Turma("AEDB", un4);  // Turma de Algoritimos e estruturas de dados
        Turma t7 = new Turma("LPA", un5);   // Linguagens de programação
        Turma t8 = new Turma("LPB", un5);   // Linguagens de programação
        Turma t9 = new Turma("SO", un6);   // Linguagens de programação

        // Turmas Engenharia Informática 3º ano
        Turma t10 = new Turma("LDP", un7);   // Laboratório de programação
        Turma t11 = new Turma("ESS", un8);   // Engenharia de software
        Turma t12 = new Turma("SDS", un9);    // Sistemas distribuídos

        // ====================== Criação dos Alunos =============================

        Aluno a1 = new Aluno((long) 35308, "Rafael Silva");
        Aluno a2 = new Aluno((long) 35556, "João Caçote");
        Aluno a3 = new Aluno((long) 35558, "Josué Braz");
        Aluno a4 = new Aluno((long) 35522, "Daniel Pinto");
        Aluno a5 = new Aluno((long) 35598, "Sara Oliveira");
        Aluno a6 = new Aluno((long) 39018, "Lucinda Abreu");
        Aluno a7 = new Aluno((long) 4017, "Catarina Marques");
        Aluno a8 = new Aluno((long) 28673, "Jean Italian");
        Aluno a9 = new Aluno((long) 35597, "Fábio Silva");
        Aluno a10 = new Aluno((long) 36578, "Alessandro Carmo");
        Aluno a11 = new Aluno((long) 37893, "Maria do Carmo");
        Aluno a12 = new Aluno((long) 34893, "Cátia Marques");
        Aluno a13 = new Aluno((long) 32892, "Vánia Alves");

        alunoRepo.save(a1);
        alunoRepo.save(a2);
        alunoRepo.save(a3);
        alunoRepo.save(a4);
        alunoRepo.save(a9);


        // ====================== Adição dos Alunos às suas Turmas Correspondentes =============================
        t10.adicionarAluno(a1);
        t10.adicionarAluno(a2);
        t10.adicionarAluno(a3);
        t10.adicionarAluno(a4);
        t10.adicionarAluno(a9);
        t11.adicionarAluno(a1);
        t11.adicionarAluno(a2);
        t11.adicionarAluno(a3);
        t11.adicionarAluno(a4);
        t11.adicionarAluno(a9);
        // ====================== Adição de Sumarios Pré Criados as Turmas =====================================

        //Turma T10
        Sumario s1 = new Sumario((long) 1, t10, LocalDate.of(2019, 4, 1), LocalTime.of(8, 0), LocalTime.of(10, 0));
        Sumario s2 = new Sumario((long) 2, t10, LocalDate.of(2019, 4, 5), LocalTime.of(16, 0), LocalTime.of(18, 0));
        Sumario s3 = new Sumario((long) 3, t10, LocalDate.of(2019, 4, 11), LocalTime.of(15, 0), LocalTime.of(17, 30));

        //Turma T11
        Sumario s4 = new Sumario((long) 4, t11, LocalDate.of(2019, 4, 13), LocalTime.of(11, 0), LocalTime.of(13, 30));
        Sumario s5 = new Sumario((long) 5, t11, LocalDate.of(2019, 4, 13), LocalTime.of(15, 30), LocalTime.of(17, 30));

        turmaRepo.save(t10);
        turmaRepo.save(t11);
    }
}