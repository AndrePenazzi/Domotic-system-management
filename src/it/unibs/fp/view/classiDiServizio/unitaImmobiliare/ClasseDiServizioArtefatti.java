package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.unitaImmobiliare.Artefatti;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioSensori;
import it.unibs.fp.view.mylib.InputDati;

import java.util.List;

public class ClasseDiServizioArtefatti {

    public static Artefatti creaArtefatti() {
        Artefatti artefatti = new Artefatti();

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

    public static String toString(Artefatti artefatti) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("\nGli artefatti sono: \n");

        if (!artefatti.getArtefatti().isEmpty()) {
            int i = 1;
            tmp.append("\nGli artefatti sono:\n");
            for (Artefatto a : artefatti.getArtefatti()) {
                tmp.append(i + " " + ClasseDiServizioArtefatto.toString(a)).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora artefatti nella stanza o nella unita immobiliare");

        return tmp.toString();
    }


}
