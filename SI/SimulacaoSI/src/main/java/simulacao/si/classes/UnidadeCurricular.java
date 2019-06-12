package simulacao.si.classes;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@NoArgsConstructor
public class UnidadeCurricular extends BaseModel {

    private String nome;
    private String code;

    @EqualsAndHashCode.Exclude
    @ToString.Include
    @JsonInclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeCurricular", orphanRemoval = true)
    private Set<Turma> turmas = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Include
    @JsonInclude
    @ManyToMany(mappedBy = "unidadescurriculares")
    private Set<Curso> cursos = new HashSet<>();

    public UnidadeCurricular(String nome, String code) {
        this.nome = nome;
        this.code = code;
    }

    public void addCurso(Curso curso) {
        this.cursos.add(curso);
    }
    public void addTurma(Turma turma) {
        this.turmas.add(turma);
    }
}