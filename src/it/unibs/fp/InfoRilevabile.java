package it.unibs.fp;

import java.io.Serializable;

public class InfoRilevabile implements Serializable {
    private String nome;
    private double min;
    private double max;
    private double valore;

    public InfoRilevabile(String nome, double min, double max) throws IllegalArgumentException {
        this.nome = nome;
        this.min = min;
        this.max = max;
        if (min > max)
            throw new IllegalArgumentException("Il valore minimo deve essere più basso di quello massimo!!!");
        valore = min;
    }


    public String getNome() {
        return nome;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getValore() {
        return valore;
    }

    @Override
    public String toString() {
        return "InformazioneRilevabile:\n" +
                "nome='" + nome + '\'' +
                ", min=" + min +
                ", max=" + max +
                ", valore=" + valore +
                '\n';
    }
}
