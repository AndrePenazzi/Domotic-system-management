package it.unibs.fp;

import java.io.Serializable;

public class ModOperativa implements Serializable {
    private String nome;
    private double valore;

    /**
     * Costruttore
     *
     * @param nome della modalità operativa
     */
    public ModOperativa(String nome) {
        this.nome = nome;
        valore = 0;

    }

    /**
     * Costruttore
     *
     * @param nome   della modalità operativa
     * @param valore richiesto
     */
    public ModOperativa(String nome, double valore) {
        this.nome = nome;
        this.valore = valore;
    }

    /**
     * Getter
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter
     *
     * @param nome da modificare
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter
     *
     * @return valore
     */
    public double getValore() {
        return valore;
    }

    /**
     * Setter
     *
     * @param valore da cambiare
     */
    public void setValore(double valore) {
        this.valore = valore;
    }

    /**
     * toString
     *
     * @return i dati della modalità operativa
     */
    @Override
    public String toString() {
        return "ModalitaOperativa:\n" +
                "nome='" + nome +
                ", valore=" + valore;
    }
}
