package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.unitaImmobiliare.*;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioStanze {
    /**
     * CreaEInserisciStanze
     *
     * @param unitaImmobiliare nella quale creare ed inserire stanze
     * @return le stanze create
     */
    public static Stanze creaEInserisciStanze(UnitaImmobiliare unitaImmobiliare) {
        Stanze stanze = unitaImmobiliare.getStanze();
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
            tmp.append(ClasseDiServizioStanza.visualizzaValoriRilevatiEValoriRilevatiInArtefatti(s));
        }
        return tmp.toString();
    }

    public static void modModOperative(Stanze stanze) {
        for (Stanza s : stanze.getStanze()) {
            ClasseDiServizioStanza.modificaModOperativeEModOperativeInArtefatti(s);
        }
    }

    public static String descrizioneNomeStanze(Stanze stanze) {
        StringBuilder tmp = new StringBuilder();

        if (!stanze.isEmpty()) {
            int i = 1;
            tmp.append("Le Stanze sono:\n");
            for (Stanza s : stanze.getStanze()) {
                tmp.append(i + ") " + s.getNome()).append("\n");
                i++;
            }
        } else
            tmp.append("Non ci sono ancora stanze");

        return tmp.toString();
    }

    public static String toString(Stanze stanze) {
        StringBuilder tmp = new StringBuilder();

        if (!stanze.getStanze().isEmpty()) {
            int i = 1;
            tmp.append("Le stanze sono:\n");
            for (Stanza s : stanze.getStanze()) {
                tmp.append(i + " " + ClasseDiServizioStanza.toString(s)).append("\n");
                i++;
            }
        } else
            tmp.append("Non ci sono ancora stanze nella unita immobiliare");

        return tmp.toString();
    }

}
