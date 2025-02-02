package it.unibs.fp.view.classiDiServizio.regola.conseguente;

import it.unibs.fp.model.regola.conseguente.Conseguenti;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioConseguenti {

    /**
     * Crea Conseguenti
     *
     * @param unitaImmobiliare per la creazione di conseguenti
     * @return conseguenti
     */
    public static Conseguenti creaConseguenti(UnitaImmobiliare unitaImmobiliare) {
        Conseguenti conseguenti = new Conseguenti();

        do {
            conseguenti.inserisciConseguente(ClasseDiServizioConseguente.creaConseguente(unitaImmobiliare));
        } while (InputDati.yesOrNo("Vuoi continuare ad inserire un nuovo conseguente?"));

        return conseguenti;
    }

    /**
     * Descrivi conseguenti
     *
     * @param conseguenti visualizza conseguenti
     * @return descrizione conseguenti
     */
    public static String descriviConseguenti(Conseguenti conseguenti) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < conseguenti.getConseguentiSize(); i++) {
            str.append(ClasseDiServizioConseguente.descriviConseguente(conseguenti.getConseguente(i)));
        }
        return str.toString();
    }
}
