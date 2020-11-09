package it.unibs.fp.model.operatori;

import java.io.Serializable;

public enum OperatoriRelazionali implements Serializable {
    MAGGIORE(">"),
    MINORE("<"),
    MAGGIORE_UGUALE("≥"),
    MINORE_UGUALE("≤"),
    UGUALE("=");

    private final String value;

    /**
     * Costruttore operatori relazionali
     *
     * @param value dell'operatore relazionale
     */
    OperatoriRelazionali(String value) {
        this.value = value;
    }

    /**
     * Getter
     *
     * @return value
     */
    public String getValue() {
        return value;
    }
}
