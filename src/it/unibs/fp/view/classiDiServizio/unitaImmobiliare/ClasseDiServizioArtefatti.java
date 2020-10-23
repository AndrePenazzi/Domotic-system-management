package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.unitaImmobiliare.Artefatti;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.model.unitaImmobiliare.Stanza;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioAttuatori;
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
    public static String visualizzaAttuatori(List<Artefatto> artefatti) {
        StringBuilder tmp = new StringBuilder();
        for (Artefatto a : artefatti) {
            tmp.append(ClasseDiServizioArtefatto.visualizzaAttuatori(a));
        }
        return tmp.toString();
    }

    public static String toString(List<Artefatto> artefatti) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("\nGli artefatti sono: \n");

        if (!artefatti.isEmpty()) {
            int i = 1;
            tmp.append("\nGli artefatti sono:\n");
            for (Artefatto a : artefatti) {
                tmp.append(i + " " + ClasseDiServizioArtefatto.toString(a)).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora artefatti nella stanza o nella unita immobiliare");

        return tmp.toString();
    }


}
