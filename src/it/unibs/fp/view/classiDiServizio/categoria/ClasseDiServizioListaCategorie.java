package it.unibs.fp.view.classiDiServizio.categoria;


import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioListaCategorie {

    public static CategoriaSensori scegliCategoriaSensori(ListaCategorie listaCategorie) {
        descrizioneCategorieSensori(listaCategorie);
        int i = InputDati.leggiIntero("Scgli la categoria sensori: ", 1, listaCategorie.getSizeCategorieSensori()) - 1;
        return listaCategorie.getCategoriaSensori(i);
    }

    public static CategoriaAttuatori scegliCategoriaAttuatori(ListaCategorie listaCategorie) {
        descrizioneCategorieAttuatori(listaCategorie);
        int i = InputDati.leggiIntero("Scgli la categoria attuatori: ", 1, listaCategorie.getSizeCategorieAttuatori()) - 1;
        return listaCategorie.getCategoriaAttuatori(i);
    }

    /**
     * Visualizza le categorieSensori
     *
     * @param listaCategorie per visualizzare la categoriaSensori
     * @return la String delle categorieSensori
     */
    public static String descrizioneCategorieSensori(ListaCategorie listaCategorie) {
        StringBuilder tmp = new StringBuilder();
        if (!listaCategorie.categorieSensoriIsEmpty()) {
            int i = 1;
            tmp.append("\nCategorie sensori:\n");
            for (CategoriaSensori categoriaSensori : listaCategorie.getCategorieSensori()) {
                tmp.append(i + ") " + ClasseDiServizioCategoriaSensori.toStringVisualizzazione(categoriaSensori));
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora categorie sensori");

        return tmp.toString();
    }

    /**
     * Descrizione del nome delle categorie di sensori
     *
     * @param listaCategorie da visualizzare
     * @return la descrizione dei nomi delle categorie di sensori
     */
    public static String descrizioneNomeCategorieSensori(ListaCategorie listaCategorie) {
        StringBuilder tmp = new StringBuilder();
        if (!listaCategorie.categorieSensoriIsEmpty()) {
            int i = 1;
            tmp.append("\nCategorie sensori:\n");
            for (CategoriaSensori categoriaSensori : listaCategorie.getCategorieSensori()) {
                tmp.append(i + ") " + categoriaSensori.getNome()).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora categorie sensori");

        return tmp.toString();
    }


    /**
     * Visualizza le categorieAttuatori
     *
     * @param listaCategorie per visualizzare la categoriaAttuatori
     * @return Descrizione categorieAttuatori
     */
    public static String descrizioneCategorieAttuatori(ListaCategorie listaCategorie) {
        StringBuilder tmp = new StringBuilder();

        if (!listaCategorie.categorieAttuatoriIsEmpty()) {
            int i = 1;
            tmp.append("\nCategorie attuatori:\n");
            for (CategoriaAttuatori categorieAttuatori : listaCategorie.getCategorieAttuatori()) {
                tmp.append(i + ") " + ClasseDiServizioCategoriaAttuatori.toStringVisualizzazione(categorieAttuatori)).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora categorie attuatori");
        return tmp.toString();
    }

    /**
     * Descrizione nome categorie attuatori
     *
     * @param listaCategorie di cui visualizzare i nomi
     * @return nomi delle categorie di attuatori
     */
    public static String descrizioneNomeCategorieAttuatori(ListaCategorie listaCategorie) {
        StringBuilder tmp = new StringBuilder();

        if (!listaCategorie.categorieAttuatoriIsEmpty()) {
            int i = 1;
            tmp.append("\nCategorie attuatori:\n");
            for (CategoriaAttuatori categorieAttuatori : listaCategorie.getCategorieAttuatori()) {
                tmp.append(i + ") " + categorieAttuatori.getNome()).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora categorie attuatori");
        return tmp.toString();
    }


    public static String toString(ListaCategorie listaCategorie) {
        return "ListaCategorie:\n" +
                descrizioneCategorieSensori(listaCategorie) + "\n" +
                descrizioneCategorieAttuatori(listaCategorie) + "\n";
    }

    /**
     * CreaCategoriaSensori
     *
     * @return categoria sensori
     */
    public static CategoriaSensori creaCategoriaSensori() {
        return ClasseDiServizioCategoriaSensori.creaCategoriaSensori();
    }

    /**
     * CreaCategoriaAttuatori
     *
     * @return categoria attuatori
     */
    public static CategoriaAttuatori creaCategoriaAttuatori() {
        return ClasseDiServizioCategoriaAttuatori.creaCategoriaAttuatori();
    }

}
