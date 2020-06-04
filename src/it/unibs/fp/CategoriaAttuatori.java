package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoriaAttuatori implements Serializable {
    private String nome;
    private ArrayList<Attuatore> attuatori;

    /**
     * Costruttore categoria attuatori
     * @param nome
     */
    public CategoriaAttuatori(String nome) {
        this.nome = nome;
        this.attuatori = new ArrayList<>();
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
     *
     * @param nome modificato.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter
     *
     * @return attuatori.
     */
    public ArrayList<Attuatore> getAttuatori() {
        return attuatori;
    }

    /**
     * toString
     *
     * @return descrizione categoria attuatori
     */
    public String toString() {
        return "Categoria sensori: nome=" + nome + ".\n";
    }
}
