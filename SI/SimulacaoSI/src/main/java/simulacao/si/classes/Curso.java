package simulacao.si.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@NoArgsConstructor
public class Curso extends BaseModel{

    private String nome;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<UnidadeCurricular> unidadescurriculares = new HashSet<>();

    public Curso(String nome) {
        this.nome = nome;
    }

    public void addUnidadeCurricular(UnidadeCurricular unidadeCurricular) {
        unidadeCurricular.addCurso(this);
        this.unidadescurriculares.add(unidadeCurricular);
    }
}