package it.unibs.fp.view.classiDiServizio.categoria;


import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioListaCategorie {

    public static CategoriaSensori scegliCategoriaSensori(ListaCategorie listaCategorie) {
        visualizzaCategorieSensori(listaCategorie);
        int i = InputDati.leggiIntero("Scgli la categoria sensori: ", 1, listaCategorie.getSizeCategorieSensori()) - 1;
        return listaCategorie.getCategorieSensori().get(i);
    }

    public static CategoriaAttuatori scegliCategoriaAttuatori(ListaCategorie listaCategorie) {
        visualizzaCategorieAttuatori(listaCategorie);
        int i = InputDati.leggiIntero("Scgli la categoria attuatori: ", 1, listaCategorie.getSizeCategorieAttuatori()) - 1;
        return listaCategorie.getCategorieAttuatori().get(i);
    }

    public static String visualizzaCategorieSensori(ListaCategorie listaCategorie) {
        StringBuilder tmp = new StringBuilder();
        if (!listaCategorie.getCategorieSensori().isEmpty()) {
            int i = 1;
            tmp.append("\nCategorie sensori:\n");
            for (CategoriaSensori categoriaSensori : listaCategorie.getCategorieSensori()) {
                tmp.append(i + " " + ClasseDiServizioCategoriaSensori.toString(categoriaSensori)).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora categorie sensori");

        return tmp.toString();
    }


    public static String visualizzaCategorieAttuatori(ListaCategorie listaCategorie) {
        StringBuilder tmp = new StringBuilder();

        if (!listaCategorie.getCategorieAttuatori().isEmpty()) {
            int i = 1;
            tmp.append("\nCategorie attuatori:\n");
            for (CategoriaAttuatori categorieAttuatori : listaCategorie.getCategorieAttuatori()) {
                tmp.append(i + " " + ClasseDiServizioCategoriaAttuatori.toString(categorieAttuatori)).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora categorie attuatori");
        return tmp.toString();
    }


    public static String toString(ListaCategorie listaCategorie) {
        return "ListaCategorie:\n" +
                visualizzaCategorieSensori(listaCategorie) + "\n" +
                visualizzaCategorieAttuatori(listaCategorie) + "\n";
    }


}
