package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.unitaImmobiliare.Artefatti;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.model.unitaImmobiliare.Stanza;
import it.unibs.fp.model.unitaImmobiliare.Stanze;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioSensori;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioStanze {

    public static Stanze creaStanza() {
        Stanze stanze = new Stanze();
        do {
            stanze.inserisciStanza(ClasseDiServizioStanza.creaStanza());
        } while (InputDati.yesOrNo("Vuoi continuare ad inserire una nuova stanza?"));

        return stanze;
    }
    public static String visualizzaAttuatori(Stanze stanze) {
        StringBuilder tmp = new StringBuilder();
        for (Stanza s : stanze.getStanze()) {
            tmp.append(ClasseDiServizioStanza.visualizzaAttuatoriEAttuatoriAssociatiAdArtefatti(s));
        }
        return tmp.toString();
    }
    public static String visualizzaSensori(Stanze stanze) {
        StringBuilder tmp = new StringBuilder();
        for (Stanza s : stanze.getStanze()) {
            tmp.append(ClasseDiServizioStanza.visualizzaSensoriESensoriAssociatiAdArtefatti(s));
        }
        return tmp.toString();
    }
    public static String visualizzaValoriRilevati(Stanze stanze) {
        StringBuilder tmp = new StringBuilder();
        for (Stanza s : stanze.getStanze()) {
            tmp.append(ClasseDiServizioStanza.visualizzaValoriRilevati(s));
        }
        return tmp.toString();
    }

    public static String toString(Stanze stanze) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("\nLe stanze sono: \n");

        if (!stanze.getStanze().isEmpty()) {
            int i = 1;
            tmp.append("\nLe stanze sono:\n");
            for (Stanza s : stanze.getStanze()) {
                tmp.append(i + " " + ClasseDiServizioStanza.toString(s)).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora stanze nella unita immobiliare");

        return tmp.toString();
    }

}
