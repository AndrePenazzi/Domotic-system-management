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
        StringBuilder s = new StringBuilder("Le categorie sensori sono:\n");
        for (int i = 0; i < categorieSensori.size(); i++) {
            s.append(i + 1).append(" ").append(categorieSensori.get(i).toString()).append("\n");
        }
        return s.toString();
    }

    /**
     * Visualizza la descrizione delle categorie di attuatori
     *
     * @return i dati delle categorieAttuatori
     */
    public String visualizzaCategorieAttuatori() {
        StringBuilder s = new StringBuilder("Le categorie attuatori sono:\n");
        for (int i = 0; i < categorieAttuatori.size(); i++) {
            s.append(i + 1).append(" ").append(categorieAttuatori.get(i).toString()).append("\n");
        }
        return s.toString();
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
