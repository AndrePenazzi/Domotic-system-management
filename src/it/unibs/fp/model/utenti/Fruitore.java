package it.unibs.fp.model.utenti;

import java.io.Serializable;


public class Fruitore implements Serializable {
    private String nome;

    /**
     * Costruttore fruitore
     */
    public Fruitore(String nome) {
        this.nome = nome;
    }

    /**
     * Getter
     *
     * @return nome del fruitore
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter
     *
     * @param nome da modificare
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

}