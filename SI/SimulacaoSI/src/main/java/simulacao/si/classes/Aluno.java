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
public class Aluno extends BaseModel {
    private Long numero;
    private String nomeAluno;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonInclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno", orphanRemoval = true)
    private Set<Presenca> presencas = new HashSet<>();
    @EqualsAndHashCode.Exclude
    @ToString.Include
    @JsonIgnore
    @ManyToMany(mappedBy="alunos")
    private Set<Turma> turmas = new HashSet<>();

    public Aluno(Long numero, String nomeAluno) {
        this.numero = numero;
        this.nomeAluno = nomeAluno;
    }
    public void addTurma(Turma t){
        this.turmas.add(t);
    }

}