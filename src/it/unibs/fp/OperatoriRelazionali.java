package it.unibs.fp;

import it.unibs.fp.mylib.MyMenu;

import java.io.Serializable;

public enum OperatoriRelazionali implements Serializable {
    MAGGIORE(">"),
    MINORE("<"),
    MAGGIORE_UGUALE("≥"),
    MINORE_UGUALE("≤"),
    UGUALE("=");

    private String value;

    private OperatoriRelazionali(String value) {
        this.value = value;
    }

    public static OperatoriRelazionali sceltaOperatoreRelazionale() {
        boolean finito = false;
        String[] azione = {">", "<", "≥", "≤", "="};
        MyMenu menu = new MyMenu("Menu scelta operatore relazionale", azione);
        int scelta = menu.scegli();
        switch (scelta) {

            case 1: {
                return MAGGIORE;
            }

            case 2: {
                return MINORE;
            }

            case 3: {
                return MAGGIORE_UGUALE;
            }

            case 4: {
                return MINORE_UGUALE;
            }

            case 5: {
                return UGUALE;
            }
        }
        return null;
    }

    public String toString() {
        return this.value;
    }

}
