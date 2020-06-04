package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

//TODO c'è un attributo descrizione in generalità da rivedere
public class CategoriaSensori implements Serializable {
    private String nome;
    private ArrayList<Sensore> sensori;

    /**
     * Costruttore categoria sensori
     * @param nome
     */
    public CategoriaSensori(String nome) {
        this.nome = nome;
        this.sensori = new ArrayList<>();
    }

    /**
     * Getter
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter
     * @param nome modificato.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter
     * @return sensori.
     */
    public ArrayList<Sensore> getSensori() {
        return sensori;
    }

    /**
     * toString
     * @return descrizione categoria attuatori
     */
    public String toString() {
        return "Categoria sensori: nome=" + nome + ".\n";
    }

}
