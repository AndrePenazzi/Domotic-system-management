package it.unibs.fp.view.classiDiServizio.regola;

import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.regola.Regole;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.mylib.InputDati;


public class ClasseDiServizioRegole {
    /**
     * Crea ed inserisci delle nuove regole
     *
     * @param unitaImmobiliare nella quale inserire una o più regole
     */
    public static void creaEInserisciRegole(UnitaImmobiliare unitaImmobiliare) {
        do {
            unitaImmobiliare.inserisciRegola(ClasseDiServizioRegola.creaRegola(unitaImmobiliare));
        } while (InputDati.yesOrNo("Vuoi continuare ad inserire una nuova regola?"));
    }

    public static Regola scegliRegola(Regole regole) {
        descriviRegole(regole);
        int i = InputDati.leggiIntero("Scegli la regola: ", 1, regole.getSizeRegole()) - 1;
        return regole.getRegola(i);
    }

    /**
     * Scegli l'indice della regola
     *
     * @param regole per la scelta
     * @return l'indice della regola
     */
    public static int scegliIndexRegola(Regole regole) {
        descriviRegole(regole);
        return InputDati.leggiIntero("Scegli la regola: ", 1, regole.getSizeRegole()) - 1;
    }

    /**
     * Descrivi regole
     *
     * @param regole da visualizzare
     * @return descrizione regole
     */
    public static String descriviRegole(Regole regole) {
        StringBuilder str = new StringBuilder();
        if (!regole.isEmpty())
            for (int i = 1; i <= regole.getSizeRegole(); i++) {
                str.append(i + ") " + ClasseDiServizioRegola.toString(regole.getRegola(i - 1)));
            }
        else
            str.append("Non ci sono ancora regole in questa unità immobiliare");
        return str.toString();
    }
}
