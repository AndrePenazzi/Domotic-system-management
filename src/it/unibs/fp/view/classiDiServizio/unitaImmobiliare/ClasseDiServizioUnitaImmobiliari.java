package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliari;
import it.unibs.fp.view.mylib.InputDati;


public class ClasseDiServizioUnitaImmobiliari {

    public static UnitaImmobiliari creaUnitaImmobiliari() {
        UnitaImmobiliari unitaImmobiliari = new UnitaImmobiliari();

        do {
            unitaImmobiliari.inserisciUnitaImmobiliare(ClasseDiServizioUnitaImmobiliare.creaUnitaImmobiliare());
        } while (InputDati.yesOrNo("Vuoi continuare ad inserire una nuova unitaImmobiliare?"));

        return unitaImmobiliari;
    }

    /**
     * Scegli un'unita immobiliare
     *
     * @param unitaImmobiliari dalle quali sceglierne una
     * @return l'unita immobiliare scelta
     */
    public static UnitaImmobiliare scegliUnitaImmobiliare(UnitaImmobiliari unitaImmobiliari) {
        for (int i = 0; i < unitaImmobiliari.getSizeUnitaImmobiliari(); i++) {
            System.out.println(i + 1 + ") " + ClasseDiServizioUnitaImmobiliare.descrizioneNomeUnitaImmobiliare(unitaImmobiliari.getUnitaImmobiliare(i)));
        }
        int i = InputDati.leggiIntero("Scegli l'unità immobiliare: ", 1, unitaImmobiliari.getSizeUnitaImmobiliari()) - 1;
        return unitaImmobiliari.getUnitaImmobiliari().get(i);
    }

    public static String visualizzaUnitaImmobiliari(UnitaImmobiliari unitaImmobiliari) {
        StringBuilder tmp = new StringBuilder();
        if (!unitaImmobiliari.isEmpty()) {
            int i = 1;
            for (UnitaImmobiliare unitaImmobiliare : unitaImmobiliari.getUnitaImmobiliari()) {
                tmp.append(i + " " + ClasseDiServizioUnitaImmobiliare.toString(unitaImmobiliare) + "\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora unità immobiliare che si possiedono");
        return tmp.toString();
    }

    static void cambiaStatoRegola(UnitaImmobiliari unitaImmobiliari) {
        UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(unitaImmobiliari);
        do {
            int regola = ClasseDiServizioUnitaImmobiliare.scegliIndexRegola(unitaImmobiliare);
            unitaImmobiliare.cambiaRegolaAttivaDisattiva(regola);
        } while (InputDati.yesOrNo("Vuoi modificare altre regole?"));
    }

    public static String toString(UnitaImmobiliari unitaImmobiliari) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("\nLe unitaImmobiliari" + " sono: \n");

        if (!unitaImmobiliari.getUnitaImmobiliari().isEmpty()) {
            int i = 1;
            tmp.append("\nLe unitaImmobiliari" + " sono:\n");
            for (UnitaImmobiliare u : unitaImmobiliari.getUnitaImmobiliari()) {
                tmp.append(i + " " + ClasseDiServizioUnitaImmobiliare.toString(u)).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora unitaImmobiliari" + " nella stanza o nella unita immobiliare");

        return tmp.toString();
    }

}
