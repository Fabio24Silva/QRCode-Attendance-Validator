package simulacao.si.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simulacao.si.classes.Curso;
import simulacao.si.repositories.CursoRepo;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author João Caçote 
 * @version 1.0
 */

@Service
public class CursoService {
    @Autowired
    private CursoRepo cursoRepo;

    /**
     * Utilizado nos testes
     */
    public void save(Curso curso) {
        cursoRepo.save(curso);
    }
}
