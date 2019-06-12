package simulacao.si.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import simulacao.si.classes.Curso;

import java.util.Optional;

@Repository
public interface CursoRepo extends CrudRepository<Curso,String> {
    Optional<Curso> findByNome(String nome);
}