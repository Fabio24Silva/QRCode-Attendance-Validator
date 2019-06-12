package simulacao.si.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import simulacao.si.classes.Turma;
import simulacao.si.classes.UnidadeCurricular;

import java.util.Optional;

@Repository
public interface UnidadeCurricularRepo extends CrudRepository<UnidadeCurricular,String> {
    Optional<UnidadeCurricular> findByCode(String code);
}
