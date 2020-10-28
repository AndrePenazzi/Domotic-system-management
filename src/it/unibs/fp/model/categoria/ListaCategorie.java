package it.unibs.fp.model.categoria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaCategorie implements Serializable {
    private List<CategoriaSensori> categorieSensori;
    private List<CategoriaAttuatori> categorieAttuatori;

    /**
     * Costruttore lista categorie
     */
    public ListaCategorie() {
        categorieSensori = new ArrayList<>();
        categorieAttuatori = new ArrayList<>();
    }

    /**
     * Inseriscie e salva categorie di attuatori
     *
     * @param categoriaAttuatori nuova categoria
     */
    public void inserisciESalvaCategoriaAttuatori(CategoriaAttuatori categoriaAttuatori) {
        categorieAttuatori.add(categoriaAttuatori);
    }

    /**
     * Inseriscie e salva categorie di sensori
     *
     * @param categoriaSensori nuova categoria
     */
    public void inserisciESalvaCategoriaSensori(CategoriaSensori categoriaSensori) {
        categorieSensori.add(categoriaSensori);
    }


    /**
     * Getter
     *
     * @return size delle categorie di sensori
     */
    public int getSizeCategorieSensori() {
        return categorieSensori.size();
    }

    /**
     * Getter
     *
     * @return size delle categorie di attuatori
     */
    public int getSizeCategorieAttuatori() {
        return categorieAttuatori.size();
    }

    /**
     * Getter
     *
     * @return categorieSensori
     */
    public List<CategoriaSensori> getCategorieSensori() {
        return categorieSensori;
    }

    public void setCategorieSensori(List<CategoriaSensori> categorieSensori) {
        this.categorieSensori = categorieSensori;
    }

    /**
     * Getter
     *
     * @return categorieAttuatori
     */
    public List<CategoriaAttuatori> getCategorieAttuatori() {
        return categorieAttuatori;
    }

    public void setCategorieAttuatori(List<CategoriaAttuatori> categorieAttuatori) {
        this.categorieAttuatori = categorieAttuatori;
    }

    public boolean categorieAttuatoriIsEmpty() {
        return categorieAttuatori.isEmpty();
    }
    public boolean categorieSensoriIsEmpty() {
        return categorieSensori.isEmpty();
    }
}