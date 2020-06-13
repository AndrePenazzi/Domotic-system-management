package it.unibs.fp;

import java.io.Serializable;

public class Contenitore implements Serializable {
    private UnitaImmobiliare unitaImmobiliare;
    private Manutentore manutentore;
    private Fruitore fruitore;
    private ListaCategorie listaCategorie;

    /**
     * Costruttore del contenitore degli oggetti importanti da salvare
     *
     * @param unitaImmobiliare da salvare
     * @param manutentore      da salvare
     * @param fruitore         da salvare
     * @param listaCategorie   da salvare
     */
    public Contenitore(UnitaImmobiliare unitaImmobiliare, Manutentore manutentore, Fruitore fruitore, ListaCategorie listaCategorie) {
        this.unitaImmobiliare = unitaImmobiliare;
        this.manutentore = manutentore;
        this.fruitore = fruitore;
        this.listaCategorie = listaCategorie;
    }

    /**
     * Getter
     *
     * @return unità immobiliare
     */
    public UnitaImmobiliare getUnitaImmobiliare() {
        return unitaImmobiliare;
    }

    /**
     * Setter
     *
     * @param unitaImmobiliare da modificare
     */
    public void setUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) {
        this.unitaImmobiliare = unitaImmobiliare;
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
     * @return fruitore
     */
    public Fruitore getFruitore() {
        return fruitore;
    }

    /**
     * Setter
     *
     * @param fruitore da modificare
     */
    public void setFruitore(Fruitore fruitore) {
        this.fruitore = fruitore;
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
