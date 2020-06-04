package it.unibs.fp;

import java.io.Serializable;

public class Sensore implements Serializable {
    private String nome;

    /**
     * Costruttore del sensore.
     * @param nome del sensore.
     */
    public Sensore(String nome) {
        this.nome = nome;
    }


    //TODO PENSACI TU!!! :)
    public String rilevaVariabileFisica() {
        return "";
    }

    /**
     * Getter.
     * @return name.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter.
     * @param nome del sensore.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * toString.
     * @return descrizione del sensore.
     */
    @Override
    public String toString() {
        return "Sensore: nome=" + nome + ".\n";
    }
}
