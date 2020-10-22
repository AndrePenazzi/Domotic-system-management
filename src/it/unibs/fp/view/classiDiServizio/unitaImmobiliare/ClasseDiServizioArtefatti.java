package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.unitaImmobiliare.Artefatti;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioArtefatti {
    public static Artefatti creaArtefatti() {
        Artefatti artefatti = new Artefatti();

        do {
            artefatti.inserisciArtefatto(ClasseDiServizioArtefatto.creaArtefatto());
        } while (InputDati.yesOrNo("Vuoi continuare ad inserire un nuovo artefatto?"));

        return artefatti;
    }
}
