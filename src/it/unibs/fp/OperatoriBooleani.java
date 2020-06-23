package it.unibs.fp;

import it.unibs.fp.mylib.MyMenu;

public enum OperatoriBooleani {
    AND,
    OR;

    public static OperatoriBooleani sceltaOperatoreBooleano(){
        boolean finito = false;
        String[] azione = {"and","or"};
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
