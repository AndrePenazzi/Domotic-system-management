package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.unitaImmobiliare.Stanze;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiSerivizioStanze {

    public static Stanze creaArtefatti() {
        Stanze stanze = new Stanze();

        do {
            stanze.inserisciStanza(ClasseDiServizioStanza.creaStanza());
        } while (InputDati.yesOrNo("Vuoi continuare ad inserire una nuova stanza?"));

        return stanze;
    }
}
