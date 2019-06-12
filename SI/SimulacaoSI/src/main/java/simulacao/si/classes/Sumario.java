package simulacao.si.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@NoArgsConstructor
public class Sumario extends BaseModel {

    public Long idSumario;

    public LocalDate dia;
    public LocalTime horaInicio;
    public LocalTime horaFim;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sumario", orphanRemoval = true)
    public Set<Presenca> presencas = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Include
    @JsonInclude
    @ManyToOne
    public Turma turma;

    public Sumario(Long idSumario, Turma turma, LocalDate dia, LocalTime horaInicio, LocalTime horaFim) {
        this.idSumario = idSumario;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.turma = turma;
        this.turma.adicionarSumario(this);
    }
}