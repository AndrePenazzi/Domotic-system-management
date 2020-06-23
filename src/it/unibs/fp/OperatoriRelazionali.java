package it.unibs.fp;

public enum OperatoriRelazionali {
    MAGGIORE(">"),
    MINORE("<"),
    MAGGIORE_UGUALE("≥"),
    MINORE_UGUALE("≤"),
    UGUALE("=");

    private String value;

    private OperatoriRelazionali(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }

}
