package it.unibs.fp;

import java.io.Serializable;

public class Attuatore implements Serializable {
    private String nome;

    /**
     * Costruttore dell'attuatore.
     *
     * @param nome dell'attuatore.
     */
    public Attuatore(String nome) {
        this.nome = nome;
    }

    /**
     * Getter.
     *
     * @return name.
     */
    public String getNome() {
        return nome;
    }
    /**
     * Setter.
     *
     * @param nome dell'attuatore.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * toString.
     *
     * @return descrizione dell'attuatore.
     */
    @Override
    public String toString() {
        return "Attuatore: nome=" + nome + ".\n";
    }
}
