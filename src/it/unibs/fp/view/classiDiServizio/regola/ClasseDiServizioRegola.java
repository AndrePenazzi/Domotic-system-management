package it.unibs.fp.view.classiDiServizio.regola;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.regola.antecedente.Antecedenti;
import it.unibs.fp.model.regola.conseguente.Conseguenti;
import it.unibs.fp.view.classiDiServizio.regola.antecedente.ClasseDiServizioAntecedenti;
import it.unibs.fp.view.classiDiServizio.regola.conseguente.ClasseDiServizioConseguenti;

public class ClasseDiServizioRegola {

    public static Regola creaRegola(ListaCategorie listaCategorie){
        Regola regola= new Regola();
        Antecedenti antecedenti= ClasseDiServizioAntecedenti.creaAntecedenti();
        regola.inserisciAntecedenti(antecedenti);

        Conseguenti conseguenti= ClasseDiServizioConseguenti.creaConseguenti(listaCategorie);
        regola.inserisciConseguenti(conseguenti);

        return regola;
    }
}
