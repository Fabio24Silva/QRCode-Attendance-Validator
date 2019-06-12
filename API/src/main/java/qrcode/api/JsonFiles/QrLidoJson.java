package qrcode.api.JsonFiles;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author Fábio Silva 
 *         Daniel Pinto
 * @version 1.0
 */
public class QrLidoJson {
    private long id_Sumario;
    private long uuid;
    private int numeroDeAluno;
    private String phoneId;

    /**
     * QRCode lido pela APP
     * @param qrcode
     * @param numeroDeAluno
     * @param phoneId
     */
    public QrLidoJson(String qrcode, int numeroDeAluno, String phoneId) {
        String[] splitted = qrcode.split("/");
        this.id_Sumario = Long.parseLong(splitted[0]);
        this.uuid = Long.parseLong(splitted[1]);
        this.numeroDeAluno = numeroDeAluno;
        this.phoneId = phoneId;
    }

    public Long getId_Sumario() {
        return id_Sumario;
    }

    public Long getUuid() {
        return uuid;
    }

    public int getNumeroDeAluno() { return numeroDeAluno; }

    public String getPhoneId() {
        return phoneId;
    }
}
