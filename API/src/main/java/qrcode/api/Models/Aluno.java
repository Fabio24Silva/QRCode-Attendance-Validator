package qrcode.api.Models;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author Fábio Silva 
 *         Daniel Pinto
 *         João Caçote 
 * @version 1.0
 */
public class Aluno {
    private int id;
    private int numero;
    private String nomeAluno;
    private boolean presenca;

    public Aluno(int id, int numero, String nomeAluno) {
        this.id = id;
        this.numero = numero;
        this.nomeAluno = nomeAluno;
        this.presenca = false;
    }

    public int getNumero() {
        return numero;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public boolean isPresenca() {
        return presenca;
    }

    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }
}
