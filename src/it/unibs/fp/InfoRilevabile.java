package it.unibs.fp;

import java.io.Serializable;

public class InfoRilevabile implements Serializable {
    private String nome;
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
    public InfoRilevabile(String nome, double min, double max) throws IllegalArgumentException {
        this.nome = nome;
        this.min = min;
        this.max = max;
        if (min > max)
            throw new IllegalArgumentException("Il valore minimo deve essere più basso di quello massimo!!!");
        valore = min;
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
     * toString
     *
     * @return i dati dell'informazione
     */
    @Override
    public String toString() {
        return "InformazioneRilevabile:\n" +
                "nome='" + nome +
                ", valore=" + valore +
                '\n';
    }
}
