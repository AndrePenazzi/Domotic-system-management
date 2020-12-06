package it.unibs.fp.model.categoria;

import java.io.Serializable;
import java.util.List;

public class ListaCategorie implements Serializable {
    private CategorieSensori categorieSensori;
    private CategorieAttuatori categorieAttuatori;

    /**
     * Costruttore lista categorie
     */
    public ListaCategorie() {
        categorieSensori = new CategorieSensori();
        categorieAttuatori = new CategorieAttuatori();
    }

    /**
     * Inseriscie e salva categorie di attuatori
     *
     * @param categoriaAttuatori nuova categoria
     */
    public void inserisciESalvaCategoriaAttuatori(CategoriaAttuatori categoriaAttuatori) {
        if (controlloOmonimiaCatAtt(categoriaAttuatori))
            categorieAttuatori.inserisciCategoriaAttuatore(categoriaAttuatori);
    }

    /**
     * Inseriscie e salva categorie di sensori
     *
     * @param categoriaSensori nuova categoria
     */
    public void inserisciESalvaCategoriaSensori(CategoriaSensori categoriaSensori) {
        if (controlloOmonimiaCatSen(categoriaSensori))
            categorieSensori.inserisciCategoriaSensori(categoriaSensori);
    }


    /**
     * Getter
     *
     * @return size delle categorie di sensori
     */
    public int getSizeCategorieSensori() {
        return categorieSensori.getSize();
    }

    /**
     * Getter
     *
     * @return size delle categorie di attuatori
     */
    public int getSizeCategorieAttuatori() {
        return categorieAttuatori.getSize();
    }

    /**
     * Getter
     *
     * @return categorieSensori
     */
    public CategorieSensori getCategorieSensori() {
        return categorieSensori;
    }

    /**
     * Setter
     *
     * @param categorieSensori da modificare
     */
    public void setCategorieSensori(CategorieSensori categorieSensori) {
        this.categorieSensori = categorieSensori;
    }

    /**
     * Getter
     *
     * @return lista categorieSensori
     */
    public List<CategoriaSensori> getListaCategorieSensori() {
        return categorieSensori.getCategorieSensori();
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return categoriaSensori alla posizione i
     */
    public CategoriaSensori getCategoriaSensori(int i) {
        return categorieSensori.getCategoriaSensori(i);
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return CategoriaSensori alla posizione i
     */
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
        return categorieAttuatori.getCategoriaAttuatori(i);
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
    public CategorieAttuatori getCategorieAttuatori() {
        return categorieAttuatori;
    }

    /**
     * Setter
     *
     * @param categorieAttuatori da modificare
     */
    public void setCategorieAttuatori(CategorieAttuatori categorieAttuatori) {
        this.categorieAttuatori = categorieAttuatori;
    }

    /**
     * Getter
     *
     * @return lista categorieAttuatori
     */
    public List<CategoriaAttuatori> getListaCategorieAttuatori() {
        return categorieAttuatori.getCategorieAttuatori();
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

    public boolean controlloOmonimiaCatAtt(CategoriaAttuatori catAtt) {
        return categorieAttuatori.controlloOmonimia(catAtt);
    }

    public boolean controlloOmonimiaCatSen(CategoriaSensori catSen) {
        return categorieSensori.controlloOmonimia(catSen);
    }
}