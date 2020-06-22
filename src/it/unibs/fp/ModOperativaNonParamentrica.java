package it.unibs.fp;

import java.io.Serializable;

public class ModOperativaNonParamentrica extends ModOperativa implements Serializable {
    private double valore;

    /**
     * Costruttore
     *
     * @param nome della modalità operativa
     */
    public ModOperativaNonParamentrica(String nome) {
        super(nome);
        valore = 0;

    }

    /**
     * Costruttore
     *
     * @param nome   della modalità operativa
     * @param valore richiesto
     */
    public ModOperativaNonParamentrica(String nome, double valore) {
        super(nome);
        this.valore = valore;
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
                "nome='" + super.getNome()+
                ", valore=" + valore;
    }
}
