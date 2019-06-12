package simulacao.si.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import simulacao.si.classes.Curso;
import simulacao.si.classes.Sumario;
import simulacao.si.classes.Turma;
import simulacao.si.classes.UnidadeCurricular;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author João Caçote 
 * @version 1.0
 */

@RunWith(MockitoJUnitRunner.class)
public class SumarioRepoUnitTest {
    Curso c1 = new Curso("Engenharia Informática");
    UnidadeCurricular un7 = new UnidadeCurricular("Laboratório de programação", "INF3");
    Turma t10 = new Turma("LDP", un7);   // Laboratório de programação
    Sumario s1 = new Sumario((long) 1, t10, LocalDate.of(2019, 4, 1), LocalTime.of(8, 0), LocalTime.of(10, 0));

    @Mock
    private SumarioRepo sumarioRepo;

    @Before
    public void setup() {
        c1.addUnidadeCurricular(un7);
        when(sumarioRepo.findByIdSumario((long) 1))
                .thenReturn(Optional.of(s1));
    }

    @Test
    public void findByIdSumario() {
        assertEquals(s1, sumarioRepo.findByIdSumario((long) 1).get());
    }

}
