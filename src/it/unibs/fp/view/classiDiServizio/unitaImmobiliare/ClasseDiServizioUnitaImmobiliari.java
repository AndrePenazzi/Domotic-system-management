package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliari;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.view.mylib.InputDati;

import java.util.List;

public class ClasseDiServizioUnitaImmobiliari {

    public static UnitaImmobiliari creaUnitaImmobiliari() {
        UnitaImmobiliari unitaImmobiliari = new UnitaImmobiliari();

        do {
            unitaImmobiliari.inserisciUnitaImmobiliare(ClasseDiServizioUnitaImmobiliare.creaUnitaImmobiliare());
        } while (InputDati.yesOrNo("Vuoi continuare ad inserire una nuova unitaImmobiliare?"));

        return unitaImmobiliari;
    }

    public static UnitaImmobiliare scegliUnitaImmobiliare(UnitaImmobiliari unitaImmobiliari) {
        for (int i=0; i<unitaImmobiliari.getUnitaImmobiliari().size();i++) {
            System.out.println(ClasseDiServizioUnitaImmobiliare.toString(unitaImmobiliari.getUnitaImmobiliari().get(i)));
        }
        int i=InputDati.leggiIntero("Scegli l'unità immobiliare: ",1, unitaImmobiliari.getUnitaImmobiliari().size())-1;
        return unitaImmobiliari.getUnitaImmobiliari().get(i);
    }

    public static String visualizzaUnitaImmobiliari(List<UnitaImmobiliare> unitaImmobiliari) {
        StringBuilder tmp = new StringBuilder();
        for (UnitaImmobiliare u : unitaImmobiliari) {
            tmp.append(ClasseDiServizioUnitaImmobiliare.toString(u));
        }
        return tmp.toString();
    }
    static void cambiaStatoRegola(UnitaImmobiliari unitaImmobiliari) {
        UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(unitaImmobiliari);
        do {
            int regola=ClasseDiServizioUnitaImmobiliare.scegliIndexRegola(unitaImmobiliare);
            unitaImmobiliare.cambiaRegolaAttivaDisattiva(regola);
        } while (InputDati.yesOrNo("Vuoi modificare altre regole?"));
    }

    public static String toString(List<UnitaImmobiliare> unitaImmobiliari) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("\nLe unitaImmobiliari" + " sono: \n");

        if (!unitaImmobiliari.isEmpty()) {
            int i = 1;
            tmp.append("\nLe unitaImmobiliari" + " sono:\n");
            for (UnitaImmobiliare u : unitaImmobiliari) {
                tmp.append(i + " " + ClasseDiServizioUnitaImmobiliare.toString(u)).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora unitaImmobiliari" + " nella stanza o nella unita immobiliare");

        return tmp.toString();
    }

}
