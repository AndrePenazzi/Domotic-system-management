package it.unibs.fp.view.classiDiServizio.regola;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.regola.antecedente.Antecedenti;
import it.unibs.fp.model.regola.conseguente.Conseguenti;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.regola.antecedente.ClasseDiServizioAntecedenti;
import it.unibs.fp.view.classiDiServizio.regola.conseguente.ClasseDiServizioConseguenti;

public class ClasseDiServizioRegola {

    public static Regola creaRegola(ListaCategorie listaCategorie, UnitaImmobiliare unitaImmobiliare){
        Regola regola= new Regola();
        Antecedenti antecedenti= ClasseDiServizioAntecedenti.creaAntecedenti(listaCategorie.getCategorieSensori().get(BOH DOBBIAMO VEDERE));
        regola.inserisciAntecedenti(antecedenti);

        Conseguenti conseguenti= ClasseDiServizioConseguenti.creaConseguenti(listaCategorie.getCategorieAttuatori().get(BOH DOBBIAMO VEDERE),unitaImmobiliare);
        regola.inserisciConseguenti(conseguenti);

        return regola;
    }


}
