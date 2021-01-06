package it.unibs.fp.model.utenti;

import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.categoria.ListaCategorie;

import java.io.Serializable;

public class Manutentore implements Serializable {
    private String nome;

    /**
     * Costruttore Manutentore
     *
     * @param nome del manutentore
     */
    public Manutentore(String nome) {
        this.nome = nome;
    }


    /**
     * Getter
     *
     * @return nome del manutentore
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter
     *
     * @param nome del manutentore
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
