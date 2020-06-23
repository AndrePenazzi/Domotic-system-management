package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaCategorie implements Serializable {
    private ArrayList<CategoriaSensori> categorieSensori;
    private ArrayList<CategoriaAttuatori> categorieAttuatori;

    /**
     * Costruttore lista categorie
     */
    public ListaCategorie() {
        categorieSensori = new ArrayList<>();
        categorieAttuatori = new ArrayList<>();
    }

    /**
     * Getter
     *
     * @return categorieSensori
     */
    public ArrayList<CategoriaSensori> getCategorieSensori() {
        return categorieSensori;
    }

    /**
     * Getter
     *
     * @return categorieAttuatori
     */
    public ArrayList<CategoriaAttuatori> getCategorieAttuatori() {
        return categorieAttuatori;
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
     * Visualizza la descrizione delle categorie di sensori
     *
     * @return i dati delle categorieSensori
     */
    public String visualizzaCategorieSensori() {
        StringBuilder tmp = new StringBuilder();
        if (!categorieSensori.isEmpty()) {
            int i = 1;
            tmp.append("\nCategorie sensori:\n");
            for (CategoriaSensori categoriaSensori : categorieSensori) {
                tmp.append(i+" "+categoriaSensori.toString()).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora categorie sensori");

        return tmp.toString();
    }

    /**
     * Visualizza la descrizione delle categorie di attuatori
     *
     * @return i dati delle categorieAttuatori
     */
    public String visualizzaCategorieAttuatori() {
        StringBuilder tmp = new StringBuilder();

        if (!categorieAttuatori.isEmpty()) {
            int i = 1;
            tmp.append("\nCategorie attuatori:\n");
            for (CategoriaAttuatori categorieAttuatori : categorieAttuatori) {
                tmp.append(i+" "+categorieAttuatori.toString()).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora categorie attuatori");

        return tmp.toString();
    }

    /**
     * toString
     *
     * @return dati della listaCategorie
     */
    @Override
    public String toString() {
        return "ListaCategorie:\n" +
                visualizzaCategorieSensori() + "\n" +
                visualizzaCategorieAttuatori() + "\n";
    }
}
