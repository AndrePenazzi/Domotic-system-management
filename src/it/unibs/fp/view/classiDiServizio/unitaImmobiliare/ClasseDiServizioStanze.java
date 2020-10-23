package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.unitaImmobiliare.Stanza;
import it.unibs.fp.model.unitaImmobiliare.Stanze;
import it.unibs.fp.view.mylib.InputDati;

import java.util.List;

public class ClasseDiServizioStanze {

    public static Stanze creaArtefatti() {
        Stanze stanze = new Stanze();

        do {
            stanze.inserisciStanza(ClasseDiServizioStanza.creaStanza());
        } while (InputDati.yesOrNo("Vuoi continuare ad inserire una nuova stanza?"));

        return stanze;
    }

    public static String visualizzaAttuatori(List<Stanza> stanze) {
        StringBuilder tmp = new StringBuilder();
        for (Stanza s : stanze) {
            tmp.append(ClasseDiServizioStanza.visualizzaAttuatori(s));
        }
        return tmp.toString();
    }

    public static String toString(List<Stanza> stanze) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("\nLe stanze sono: \n");

        if (!stanze.isEmpty()) {
            int i = 1;
            tmp.append("\nLe stanze sono:\n");
            for (Stanza s : stanze) {
                tmp.append(i + " " + ClasseDiServizioStanza.toString(s)).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora stanze nella unita immobiliare");

        return tmp.toString();
    }

}
