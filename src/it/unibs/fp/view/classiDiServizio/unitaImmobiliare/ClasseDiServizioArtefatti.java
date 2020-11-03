package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.unitaImmobiliare.Artefatti;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.mylib.InputDati;


public class ClasseDiServizioArtefatti {

    /**
     * CreaEdInserisciArtefatti
     *
     * @param unitaImmobiliare nella quale creare ed inserire artefatti
     * @return gli Artefatti creati
     */
    public static Artefatti creaEInserisciArtefatti(UnitaImmobiliare unitaImmobiliare) {
        Artefatti artefatti = unitaImmobiliare.getArtefattiInUnitaImmobiliare();
        do {
            artefatti.inserisciArtefatto(ClasseDiServizioArtefatto.creaArtefatto());
        } while (InputDati.yesOrNo("Vuoi continuare ad inserire un nuovo artefatto?"));
        return artefatti;
    }

    public static String visualizzaAttuatori(Artefatti artefatti) {
        StringBuilder tmp = new StringBuilder();
        for (Artefatto a : artefatti.getArtefatti()) {
            tmp.append(ClasseDiServizioArtefatto.visualizzaAttuatori(a));
        }
        return tmp.toString();
    }

    public static String visualizzaSensori(Artefatti artefatti) {
        StringBuilder tmp = new StringBuilder();
        for (Artefatto a : artefatti.getArtefatti()) {
            tmp.append(ClasseDiServizioArtefatto.visualizzaSensori(a));
        }
        return tmp.toString();
    }

    public static String visualizzaValoriRilevati(Artefatti artefatti) {
        StringBuilder tmp = new StringBuilder();
        for (Artefatto a : artefatti.getArtefatti()) {
            tmp.append(ClasseDiServizioArtefatto.visualizzaValoriRilevati(a));
        }
        return tmp.toString();
    }

    public static void modificaModOperative(Artefatti artefatti) {
        for (Artefatto a : artefatti.getArtefatti()) {
            ClasseDiServizioArtefatto.visualizzaValoriRilevati(a);
        }
    }

    /**
     * Descrizione dei nomi degli artefatti
     *
     * @param artefatti da visualizzare
     * @return il nome degli artefatti
     */
    public static String descrizioneNomeArtefatti(Artefatti artefatti) {
        StringBuilder tmp = new StringBuilder();

        if (!artefatti.getArtefatti().isEmpty()) {
            int i = 1;
            tmp.append("Gli artefatti sono:\n");
            for (Artefatto a : artefatti.getArtefatti()) {
                tmp.append(i + ") " + a.getNome()).append("\n");
                i++;
            }
        } else
            tmp.append("Non ci sono ancora artefatti nella stanza o nella unita immobiliare");

        return tmp.toString();
    }

    /**
     * toString
     *
     * @param artefatti da visualizzare
     * @return la descrizione degli artefatti
     */
    public static String toString(Artefatti artefatti) {
        StringBuilder tmp = new StringBuilder();

        if (!artefatti.getArtefatti().isEmpty()) {
            int i = 1;
            tmp.append("Gli artefatti sono:\n");
            for (Artefatto a : artefatti.getArtefatti()) {
                tmp.append(i + ") " + ClasseDiServizioArtefatto.toString(a)).append("\n");
                i++;
            }
        } else
            tmp.append("Non ci sono ancora artefatti nella stanza o nella unita immobiliare");

        return tmp.toString();
    }


}
