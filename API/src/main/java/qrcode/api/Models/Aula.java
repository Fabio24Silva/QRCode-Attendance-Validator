package qrcode.api.Models;

import java.time.LocalTime;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author Fábio Silva 
 *         Daniel Pinto
 *         João Caçote 
 * @version 1.0
 */
public class Aula {

    private long id_sumario;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    /**
     * Dados recebidos do Sistema de Informação para gerar uma nova aula que esteja a decorrer
     *
     * @param id_sumario
     * @param horaInicio
     * @param horaFim
     */
    public Aula(long id_sumario, LocalTime horaInicio, LocalTime horaFim) {
        this.id_sumario = id_sumario;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public long getId_sumario() {
        return id_sumario;
    }
}
