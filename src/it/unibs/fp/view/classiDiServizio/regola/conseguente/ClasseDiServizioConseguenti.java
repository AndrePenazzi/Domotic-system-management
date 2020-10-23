package it.unibs.fp.view.classiDiServizio.regola.conseguente;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.regola.conseguente.Conseguenti;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioConseguenti {
    public static Conseguenti creaConseguenti(ListaCategorie listaCategorie, UnitaImmobiliare unitaImmobiliare) {
        Conseguenti conseguenti = new Conseguenti();

        do {
            conseguenti.inserisciConseguente(ClasseDiServizioConseguente.creaConseguente(listaCategorie, unitaImmobiliare));
        } while (InputDati.yesOrNo("Vuoi continuare ad inserire un nuovo conseguente?"));

        return conseguenti;
    }
}
