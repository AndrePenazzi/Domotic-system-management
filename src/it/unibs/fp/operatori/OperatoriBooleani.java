package it.unibs.fp.operatori;

import it.unibs.fp.mylib.MyMenu;

import java.io.Serializable;
//TODO non si possono fare test perchè è un menu, quindi che faccio?? I dunno
public enum OperatoriBooleani implements Serializable {
    AND,
    OR;

    /**
     * Scelta dell'operatore booleano
     *
     * @return AND o OR
     */
    public static OperatoriBooleani sceltaOperatoreBooleano() {
        boolean finito = false;
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
