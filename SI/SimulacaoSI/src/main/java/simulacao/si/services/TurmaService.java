package simulacao.si.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simulacao.si.classes.Aluno;
import simulacao.si.classes.Turma;
import simulacao.si.repositories.AlunoRepo;
import simulacao.si.repositories.TurmaRepo;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepo turmaRepo;

    /**
     * Utilizado nos testes
     */
    public void save(Turma turma) {
        turmaRepo.save(turma);
    }
}
