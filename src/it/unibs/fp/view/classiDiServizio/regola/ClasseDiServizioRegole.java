package it.unibs.fp.view.classiDiServizio.regola;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.regola.Regole;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioRegole {
    public static Regole creaRegole(ListaCategorie listaCategorie, UnitaImmobiliare unitaImmobiliare) {
        Regole regole = new Regole();

        do {
            regole.inserisciRegola(ClasseDiServizioRegola.creaRegola(listaCategorie, unitaImmobiliare));
        } while (InputDati.yesOrNo("Vuoi continuare ad inserire una nuova regola?"));

        return regole;
    }
}
