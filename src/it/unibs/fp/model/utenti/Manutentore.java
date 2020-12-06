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
     * Inseriscce e salva una categoria di attuatori se non esiste già
     *
     * @param listaCategorie     lista delle categorie esistenti
     * @param categoriaAttuatori nuova categoria di attuatori
     */
    public void inserisciESalvaCategoriaAttuatori(ListaCategorie listaCategorie, CategoriaAttuatori categoriaAttuatori) {
        listaCategorie.inserisciESalvaCategoriaAttuatori(categoriaAttuatori);
    }

    /**
     * Inseriscce e salva una categoria di sensori se non esiste già
     *
     * @param listaCategorie   lista delle categorie esistenti
     * @param categoriaSensori nuova categoria di sensori
     */
    public void inserisciESalvaCategoriaSensori(ListaCategorie listaCategorie, CategoriaSensori categoriaSensori) {
        listaCategorie.inserisciESalvaCategoriaSensori(categoriaSensori);
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
