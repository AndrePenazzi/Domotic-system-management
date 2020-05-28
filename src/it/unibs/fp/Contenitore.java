package it.unibs.fp;

public class Contenitore {
    private UnitaImmobiliare unitaImmobiliare;
    private Manutentore manutentore;

    public Contenitore(UnitaImmobiliare unitaImmobiliare, Manutentore manutentore, Fruitore fruitore) {
        this.unitaImmobiliare = unitaImmobiliare;
        this.manutentore = manutentore;
        this.fruitore = fruitore;
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

    private Fruitore fruitore;
}
