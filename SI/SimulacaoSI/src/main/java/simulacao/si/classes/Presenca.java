package simulacao.si.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@NoArgsConstructor
public class Presenca extends BaseModel {
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ToString.Include
    @ManyToOne
    private Aluno aluno;

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ToString.Include
    @ManyToOne
    private Sumario sumario;

    private Boolean isPresent;

    public Presenca(Aluno aluno, Sumario sumario, Boolean isPresent) {
        this.aluno = aluno;
        this.sumario = sumario;
        this.isPresent = isPresent;
    }

    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public Sumario getSumario() {
        return sumario;
    }
    public void setSumario(Sumario sumario) {
        this.sumario = sumario;
    }
    public Boolean getPresent() {
        return isPresent;
    }

    public void setPresent(Boolean present) {
        isPresent = present;
    }
}