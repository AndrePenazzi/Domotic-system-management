package it.unibs.fp;

import it.unibs.fp.mylib.NumeriCasuali;

import java.io.Serializable;
import java.text.DecimalFormat;

public class InfoRilevabileNumerica extends InfoRilevabile implements Serializable {
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    private double min;
    private double max;
    private double valore;

    /**
     * Costruttore
     *
     * @param nome dell'informazione
     * @param min  valore minimo del dominio
     * @param max  valore massimo del dominio
     * @throws IllegalArgumentException il valore minimo deve essere minore del valore massimo
     */
    public InfoRilevabileNumerica(String nome, double min, double max) throws IllegalArgumentException {
        super(nome, 1);
        this.min = min;
        this.max = max;
        if (min > max)
            throw new IllegalArgumentException("Il valore minimo deve essere più basso di quello massimo!!!");
        valore = min;
    }

    /**
     * Rilevamento della variabile casualmente
     *
     * @return un valore estratto casualmente tra quelli disponibili
     */
    public double rilevaVariabile() {
        return valore = Double.parseDouble(df2.format(NumeriCasuali.estraiDouble(min, max)));
    }

    /**
     * toString
     *
     * @return i dati dell'informazione
     */
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        tmp.append(getNome());
        tmp.append("\nMin: " + min);
        tmp.append("\nMax: " + max);
        return tmp.toString();
    }

    /**
     * Getter
     *
     * @return nome
     */
    public String getNome() {
        return super.getNome();
    }

    /**
     * Getter
     *
     * @return min
     */
    public double getMin() {
        return min;
    }

    /**
     * Getter
     *
     * @return max
     */
    public double getMax() {
        return max;
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
}