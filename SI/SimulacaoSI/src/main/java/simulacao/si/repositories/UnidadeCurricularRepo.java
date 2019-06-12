package simulacao.si.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import simulacao.si.classes.Turma;
import simulacao.si.classes.UnidadeCurricular;

import java.util.Optional;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author João Caçote 
 * @version 1.0
 */

@Repository
public interface UnidadeCurricularRepo extends CrudRepository<UnidadeCurricular,String> {
    Optional<UnidadeCurricular> findByCode(String code);
}
