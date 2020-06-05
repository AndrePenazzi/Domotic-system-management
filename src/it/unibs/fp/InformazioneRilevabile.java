package it.unibs.fp;

public class InformazioneRilevabile {
    private String nome;
    private double min;
    private double max;
    private double valore;

    public InformazioneRilevabile(String nome, double min, double max) throws IllegalArgumentException {
        this.nome = nome;
        this.min = min;
        this.max = max;
        if (min > max) throw new IllegalArgumentException("Il valore minimo deve essere più basso di quello massimo!!!");
        valore = min;
    }

    @Override
    public String toString() {
        return "InformazioneRilevabile{" +
                "nome='" + nome + '\'' +
                ", min=" + min +
                ", max=" + max +
                ", valore=" + valore +
                '}';
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
}
