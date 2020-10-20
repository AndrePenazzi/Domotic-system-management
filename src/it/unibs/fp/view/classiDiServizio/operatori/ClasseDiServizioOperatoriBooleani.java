package it.unibs.fp.view.classiDiServizio.operatori;

import it.unibs.fp.model.operatori.OperatoriBooleani;
import it.unibs.fp.view.mylib.MyMenu;

import java.io.Serializable;

import static it.unibs.fp.model.operatori.OperatoriBooleani.*;

public class ClasseDiServizioOperatoriBooleani implements Serializable {

    /**
     * Scelta dell'operatore booleano
     *
     * @return AND o OR
     */
    public static OperatoriBooleani sceltaOperatoreBooleano() {
        String[] azione = {"and", "or"};
        MyMenu menu = new MyMenu("Menu scelta operatore booleano", azione);
        int scelta = menu.scegli();
        switch (scelta) {

            case 1: {
                return AND;
            }

            case 2: {
                return OR;
            }
        }
        return null;
    }
}
