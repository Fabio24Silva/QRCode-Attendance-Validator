package simulacao.si.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import simulacao.si.classes.Curso;

import java.util.Optional;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author João Caçote 
 * @version 1.0
 */

@Repository
public interface CursoRepo extends CrudRepository<Curso,String> {
    Optional<Curso> findByNome(String nome);
}