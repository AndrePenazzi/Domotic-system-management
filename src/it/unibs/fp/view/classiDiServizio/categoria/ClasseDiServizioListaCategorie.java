package it.unibs.fp.view.classiDiServizio.categoria;


import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.categoria.CategoriaSensori;

public class ClasseDiServizioListaCategorie {

    /**
     * Visualizza la descrizione delle categorie di sensori
     *
     * @return i dati delle categorieSensori
     */
    public static String visualizzaCategorieSensori() {
        StringBuilder tmp = new StringBuilder();
        if (!categorieSensori.isEmpty()) {
            int i = 1;
            tmp.append("\nCategorie sensori:\n");
            for (CategoriaSensori categoriaSensori : categorieSensori) {
                tmp.append(i + " " + categoriaSensori.toString()).append("\n");
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
    public static String visualizzaCategorieAttuatori() {
        StringBuilder tmp = new StringBuilder();

        if (!categorieAttuatori.isEmpty()) {
            int i = 1;
            tmp.append("\nCategorie attuatori:\n");
            for (CategoriaAttuatori categorieAttuatori : categorieAttuatori) {
                tmp.append(i + " " + categorieAttuatori.toString()).append("\n");
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
    public static String toString() {
        return "ListaCategorie:\n" +
                visualizzaCategorieSensori() + "\n" +
                visualizzaCategorieAttuatori() + "\n";
    }


}
