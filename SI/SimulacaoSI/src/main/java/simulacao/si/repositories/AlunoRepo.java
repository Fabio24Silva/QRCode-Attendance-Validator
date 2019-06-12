package simulacao.si.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import simulacao.si.classes.Aluno;

import java.util.Optional;

@Repository
public interface AlunoRepo extends CrudRepository<Aluno,Long> {
    Optional<Aluno> findByNumero(Long numero);
}
