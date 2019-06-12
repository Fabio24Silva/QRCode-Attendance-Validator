package simulacao.si.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import simulacao.si.classes.Curso;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author João Caçote 
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class CursoRepoIntegrationTest {

    @Autowired
    private CursoRepo cursoRepo;

    @Test
    public void crud() {
        assertEquals(0,cursoRepo.count());
        Curso c1 = new Curso("Engenharia Informática");
        cursoRepo.save(c1);
        assertEquals(1,cursoRepo.count());
        Curso c2 = new Curso("Arquitetura e Urbanismo");
        cursoRepo.save(c2);
        assertEquals(2,cursoRepo.count());
    }

}
