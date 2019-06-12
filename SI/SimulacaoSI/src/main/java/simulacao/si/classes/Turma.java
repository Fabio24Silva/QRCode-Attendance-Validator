package simulacao.si.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author João Caçote 
 * @version 1.0
 */

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@NoArgsConstructor
public class Turma extends BaseModel {

    private String sigla;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonInclude
    //@ManyToMany(cascade = CascadeType.ALL)
    @ManyToMany
    private Set<Aluno> alunos = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turma", orphanRemoval = true)
    private Set<Sumario> sumarios = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    private UnidadeCurricular unidadeCurricular;

    public Turma(String sigla) {
        this.sigla = sigla;
    }

    public Turma(String sigla, UnidadeCurricular unidadeCurricular) {
        this.sigla = sigla;
        this.unidadeCurricular = unidadeCurricular;
        unidadeCurricular.addTurma(this);
    }

    public void adicionarUnidadeCurricular(UnidadeCurricular unidadeCurricular) {
        this.unidadeCurricular = unidadeCurricular;
        this.unidadeCurricular.addTurma(this);
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
        aluno.addTurma(this);
    }

    public void adicionarSumario(Sumario sumario){
        this.sumarios.add(sumario);
    }
}