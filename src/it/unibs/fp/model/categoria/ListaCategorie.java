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

    /**
     * Setter
     *
     * @param categorieSensori da modificare
     */
    public void setCategorieSensori(List<CategoriaSensori> categorieSensori) {
        this.categorieSensori = categorieSensori;
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return categoriaSensori alla posizione i
     */
    public CategoriaSensori getCategoriaSensori(int i) {
        return categorieSensori.get(i);
    }
    public String getNomeCategoriaSensori(int i) {
        return getCategoriaSensori(i).getNome();
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return categoriaAttuatori alla posizione i
     */
    public CategoriaAttuatori getCategoriaAttuatori(int i) {
        return categorieAttuatori.get(i);
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return nome della categoria attuatori alla posizione i
     */
    public String getNomeCategoriaAttuatori(int i) {
        return getCategoriaAttuatori(i).getNome();
    }

    /**
     * Getter
     *
     * @return categorieAttuatori
     */
    public List<CategoriaAttuatori> getCategorieAttuatori() {
        return categorieAttuatori;
    }

    /**
     * Setter
     *
     * @param categorieAttuatori da modificare
     */
    public void setCategorieAttuatori(List<CategoriaAttuatori> categorieAttuatori) {
        this.categorieAttuatori = categorieAttuatori;
    }

    /**
     * Controlla se categorieAttuatori è vuota
     *
     * @return true if is Empty
     */
    public boolean categorieAttuatoriIsEmpty() {
        return categorieAttuatori.isEmpty();
    }

    /**
     * Controlla se categorieSensori è vuota
     *
     * @return true if is Empty
     */
    public boolean categorieSensoriIsEmpty() {
        return categorieSensori.isEmpty();
    }
}