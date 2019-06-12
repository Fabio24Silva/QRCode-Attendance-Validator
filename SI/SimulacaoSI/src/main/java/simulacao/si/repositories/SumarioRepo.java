package simulacao.si.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import simulacao.si.classes.Sumario;
import java.util.Optional;

@Repository
public interface SumarioRepo extends CrudRepository<Sumario,Long> {
    Optional<Sumario> findById(Long id);
    Optional<Sumario> findByIdSumario(Long idSumario);
}
