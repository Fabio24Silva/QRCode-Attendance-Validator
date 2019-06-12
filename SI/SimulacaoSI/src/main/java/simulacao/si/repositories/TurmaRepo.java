package simulacao.si.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import simulacao.si.classes.Aluno;
import simulacao.si.classes.Turma;

import java.util.Optional;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author João Caçote 
 * @version 1.0
 */

@Repository
public interface TurmaRepo extends CrudRepository<Turma,String> {
    Optional<Turma> findBySigla(String sigla);
}
