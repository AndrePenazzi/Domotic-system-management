package it.unibs.fp.model.infoRilevabile;

import it.unibs.fp.view.mylib.NumeriCasuali;

import java.text.DecimalFormat;

public class InfoRilevabileNumerica implements InfoRilevabile<Double> {
    private static final DecimalFormat df2 = new DecimalFormat("#.##");
    private final double min;
    private final double max;
    private String nome;
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
        this.nome = nome;
        this.min = min;
        this.max = max;
        if (min > max)
            throw new IllegalArgumentException("Il valore minimo deve essere più basso di quello massimo!!!");
        valore = min;
    }

    @Override
    public Double rilevaVariabile() {
        return valore = Double.parseDouble(df2.format(NumeriCasuali.estraiDouble(min, max)));
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

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

}