package it.unibs.fp;

import java.io.Serializable;

public class Contenitore implements Serializable {
    private Manutentore manutentore;
    private ListaCategorie listaCategorie;

    /**
     * Costruttore del contenitore degli oggetti importanti da salvare
     *
     * @param manutentore      da salvare
     * @param listaCategorie   da salvare
     */
    public Contenitore(Manutentore manutentore, ListaCategorie listaCategorie) {
        this.manutentore = manutentore;
        this.listaCategorie = listaCategorie;
    }

    /**
     * Getter
     *
     * @return manutentore
     */
    public Manutentore getManutentore() {
        return manutentore;
    }

    /**
     * Setter
     *
     * @param manutentore da modificare
     */
    public void setManutentore(Manutentore manutentore) {
        this.manutentore = manutentore;
    }

    /**
     * Getter
     *
     * @return listaCategorie
     */
    public ListaCategorie getListaCategorie() {
        return listaCategorie;
    }

    /**
     * Setter
     *
     * @param listaCategorie da modificare
     */
    public void setListaCategorie(ListaCategorie listaCategorie) {
        this.listaCategorie = listaCategorie;
    }
}
