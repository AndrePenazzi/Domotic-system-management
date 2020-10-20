package it.unibs.fp.view.classiDiServizio.operatori;

import it.unibs.fp.model.operatori.OperatoriRelazionali;
import it.unibs.fp.view.mylib.MyMenu;

import java.io.Serializable;

import static it.unibs.fp.model.operatori.OperatoriRelazionali.*;

public class ClasseDiServizioOperatoriRelazionali implements Serializable {
    /**
     * scelta dell'operatore relazionale
     *
     * @return l'operatore relazionale scelto
     */
    public static OperatoriRelazionali sceltaOperatoreRelazionale() {
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
}
