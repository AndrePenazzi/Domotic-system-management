package it.unibs.fp.model.modalitaOperativa;

import java.io.Serializable;
import java.text.DecimalFormat;

public class ModOperativaNonParamentrica extends ModOperativa implements Serializable {
    private static DecimalFormat df2 = new DecimalFormat("#.##");
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
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n");
        tmp.append(getNome() + "\n");
        tmp.append("Valore: " + df2.format(valore));
        return tmp.toString();
    }

    public int getType() {
        return 1;
    }
}
