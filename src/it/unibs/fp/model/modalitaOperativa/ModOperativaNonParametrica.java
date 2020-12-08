package it.unibs.fp.model.modalitaOperativa;

import java.text.DecimalFormat;

public class ModOperativaNonParametrica implements ModOperativa {
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    private double valore;
    private String nome;
    /**
     * Costruttore
     *
     * @param nome della modalità operativa
     */
    public ModOperativaNonParametrica(String nome) {
        this.nome = nome;
        valore = 0;
    }

    /**
     * Costruttore
     *
     * @param nome   della modalità operativa non parametrica
     * @param valore richiesto
     */
    public ModOperativaNonParametrica(String nome, double valore) {
        this.nome = nome;
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
     * Getter
     *
     * @return DecimalFormat per il valore
     */
    public DecimalFormat getDf2() {
        return df2;
    }


    /**
     * Getter
     *
     * @return nome
     */
    @Override
    public String getNome() {
        return nome;
    }

    /**
     * Setter
     *
     * @param nome da modificare
     */

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
}
