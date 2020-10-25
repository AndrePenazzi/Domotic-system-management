package it.unibs.fp.view.classiDiServizio.regola;

import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.regola.Regole;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.mylib.InputDati;

import java.util.List;

public class ClasseDiServizioRegole {
    public static Regole creaRegole( UnitaImmobiliare unitaImmobiliare) {
        Regole regole = new Regole();
        do {
            regole.inserisciRegola(ClasseDiServizioRegola.creaRegola( unitaImmobiliare));
        } while (InputDati.yesOrNo("Vuoi continuare ad inserire una nuova regola?"));

        return regole;
    }
    public static Regola scegliRegola(Regole regole) {
        visualizzaRegole(regole);
        int i=InputDati.leggiIntero("Scegli la regola: ",1, regole.getRegole().size())-1;
        return regole.getRegole().get(i);
    }
    public static int scegliIndexRegola(Regole regole) {
        visualizzaRegole(regole);
        return InputDati.leggiIntero("Scegli la regola: ",1, regole.getRegole().size())-1;
    }

    public static String visualizzaRegole(Regole regole) {
        StringBuilder str = new StringBuilder();
        if (!regole.getRegole().isEmpty())
            for (int i=1; i<=regole.getRegole().size();i++) {
                str.append(i + ClasseDiServizioRegola.toString(regole.getRegole().get(i-1)));
            }
        else
            str.append("Non ci sono ancora regole in questa unità immobiliare");
        return str.toString();
    }
}
