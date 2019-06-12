package qrcode.api.JsonFiles;

import qrcode.api.Models.Aluno;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author Fábio Silva 
 *         Daniel Pinto
 * @version 1.0
 */
public class AulaJson {
    private long id_sumario;
    private String turma;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private ArrayList<Aluno> alunos;

    /**
     * Aula recebida pelo SI
     * @param id_sumario
     * @param turma
     * @param horaInicio
     * @param horaFim
     * @param alunos
     */
    public AulaJson(long id_sumario, String turma, LocalTime horaInicio, LocalTime horaFim, ArrayList<Aluno> alunos) {
        this.id_sumario = id_sumario;
        this.turma = turma;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.alunos = alunos;

    }

    public ArrayList<Aluno> getAlunos() { return alunos; }

    public long getId_sumario() {
        return id_sumario;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }
}
