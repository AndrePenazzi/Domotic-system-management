package it.unibs.fp.view.classiDiServizio.regola.antecedente;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.operatori.OperatoriBooleani;
import it.unibs.fp.model.regola.antecedente.Antecedente;
import it.unibs.fp.model.regola.antecedente.AntecedenteFactory;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogico;
import it.unibs.fp.view.classiDiServizio.operatori.ClasseDiServizioOperatoriBooleani;
import it.unibs.fp.view.classiDiServizio.regola.antecedente.costituenteLogico.ClasseDiServizioCostituenteLogico;

import java.io.Serializable;

public class ClasseDiServizioAntecedente implements Serializable {


    public static Antecedente creaAntecedenteEnnesimo(ListaCategorie listaCategorie) {
        CostituenteLogico costituenteLogico;
        OperatoriBooleani opBooleano;
        costituenteLogico = ClasseDiServizioCostituenteLogico.menuCreaCostituenteLogico(listaCategorie);
        opBooleano = ClasseDiServizioOperatoriBooleani.sceltaOperatoreBooleano();

        return AntecedenteFactory.creaAntecedente(opBooleano, costituenteLogico);
    }

    public static Antecedente creaAntecedenteSingolo(ListaCategorie listaCategorie) {
        CostituenteLogico costituenteLogico;
        costituenteLogico = ClasseDiServizioCostituenteLogico.menuCreaCostituenteLogico(listaCategorie);

        return AntecedenteFactory.creaAntecedente(costituenteLogico);
    }
}
