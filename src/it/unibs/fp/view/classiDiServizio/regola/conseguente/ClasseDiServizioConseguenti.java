package it.unibs.fp.view.classiDiServizio.regola.conseguente;

import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.regola.conseguente.Conseguenti;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioConseguenti {
    public static Conseguenti creaConseguenti(CategoriaAttuatori categoriaAttuatori, UnitaImmobiliare unitaImmobiliare) {
        Conseguenti conseguenti = new Conseguenti();

        do {
            conseguenti.inserisciConseguente(ClasseDiServizioConseguente.creaConseguente(categoriaAttuatori, unitaImmobiliare));
        } while (InputDati.yesOrNo("Vuoi continuare ad inserire un nuovo conseguente?"));

        return conseguenti;
    }

    public static String visualizzaConseguenti(Conseguenti conseguenti){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < conseguenti.getConseguenti().size(); i++) {
            str.append(" " + ClasseDiServizioConseguente.visualizzaConseguente(conseguenti.getConseguenti().get(i)));
        }
        return str.toString();
    }
}
