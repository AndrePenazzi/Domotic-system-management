package it.unibs.fp;

public enum OperazioniRelazionale {
    MAGGIORE(">"),
    MINORE("<"),
    MAGGIORE_UGUALE("≥"),
    MINORE_UGUALE("≤"),
    UGUALE("=");
    private String value;
    private OperazioniRelazionale(String value)
    {
        this.value = value;
    }

    public String toString()
    {
        return this.value;
    }

}
