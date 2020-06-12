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

    public UnitaImmobiliare getUnitaImmobiliare() {
        return unitaImmobiliare;
    }

    public void setUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) {
        this.unitaImmobiliare = unitaImmobiliare;
    }

    public Manutentore getManutentore() {
        return manutentore;
    }

    public void setManutentore(Manutentore manutentore) {
        this.manutentore = manutentore;
    }

    public Fruitore getFruitore() {
        return fruitore;
    }

    public void setFruitore(Fruitore fruitore) {
        this.fruitore = fruitore;
    }

    public ListaCategorie getListaCategorie() {
        return listaCategorie;
    }

    public void setListaCategorie(ListaCategorie listaCategorie) {
        this.listaCategorie = listaCategorie;
    }
}
