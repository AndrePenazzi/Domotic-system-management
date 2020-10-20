package it.unibs.fp.view.classiDiServizio.regola.antecedente;

import it.unibs.fp.model.operatori.OperatoriBooleani;
import it.unibs.fp.model.regola.antecedente.Antecedente;
import it.unibs.fp.model.regola.antecedente.AntecedenteFactory;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogico;
import it.unibs.fp.view.classiDiServizio.operatori.ClasseDiServizioOperatoriBooleani;
import it.unibs.fp.view.classiDiServizio.regola.antecedente.costituenteLogico.ClasseDiServizioCostituenteLogico;

import java.io.Serializable;

public class ClasseDiServizioAntecedente implements Serializable {


    public static Antecedente creaAntecedenteEnnesimo() {
        CostituenteLogico costituenteLogico;
        OperatoriBooleani opBooleano;
        costituenteLogico = ClasseDiServizioCostituenteLogico.menuCreaCostituenteLogico();
        opBooleano = ClasseDiServizioOperatoriBooleani.sceltaOperatoreBooleano();

        return AntecedenteFactory.creaAntecedente(opBooleano, costituenteLogico);
    }

    public static Antecedente creaAntecedenteSingolo() {
        CostituenteLogico costituenteLogico;
        costituenteLogico = ClasseDiServizioCostituenteLogico.menuCreaCostituenteLogico();

        return AntecedenteFactory.creaAntecedente(costituenteLogico);
    }
}
