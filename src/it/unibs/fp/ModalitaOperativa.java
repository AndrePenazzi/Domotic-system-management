package it.unibs.fp;

public class ModalitaOperativa {
    private String nome;
    private double valore;

    public ModalitaOperativa(String nome) {
        this.nome = nome;
        valore = 0;

    }

    public ModalitaOperativa(String nome, double valore) {
        this.nome = nome;
        this.valore = valore;
    }

    @Override
    public String toString() {
        return "ModalitaOperativa{" +
                "nome='" + nome + '\'' +
                ", valore=" + valore +
                '}';
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValore(double valore) {
        this.valore = valore;
    }

    public String getNome() {
        return nome;
    }

    public double getValore() {
        return valore;
    }
}
