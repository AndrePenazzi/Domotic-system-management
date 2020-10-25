package it.unibs.fp.view.classiDiServizio.regola.antecedente;

import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.operatori.OperatoriBooleani;
import it.unibs.fp.model.regola.antecedente.Antecedente;
import it.unibs.fp.model.regola.antecedente.AntecedenteFactory;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogico;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.operatori.ClasseDiServizioOperatoriBooleani;
import it.unibs.fp.view.classiDiServizio.regola.antecedente.costituenteLogico.ClasseDiServizioCostituenteLogico;

import java.io.Serializable;

public class ClasseDiServizioAntecedente implements Serializable {


    public static Antecedente creaAntecedenteEnnesimo(UnitaImmobiliare unitaImmobiliare) {
        CostituenteLogico costituenteLogico;
        OperatoriBooleani opBooleano;
        costituenteLogico = ClasseDiServizioCostituenteLogico.menuCreaCostituenteLogico( unitaImmobiliare);
        opBooleano = ClasseDiServizioOperatoriBooleani.sceltaOperatoreBooleano();

        return AntecedenteFactory.creaAntecedente(opBooleano, costituenteLogico);
    }

    public static Antecedente creaAntecedenteSingolo(UnitaImmobiliare unitaImmobiliare) {
        CostituenteLogico costituenteLogico;
        costituenteLogico = ClasseDiServizioCostituenteLogico.menuCreaCostituenteLogico( unitaImmobiliare);

        return AntecedenteFactory.creaAntecedente(costituenteLogico);
    }

    public static String visualizzaAntecedenteSingolo(Antecedente antecedente) {
        StringBuilder str = new StringBuilder();
        str.append(" " + ClasseDiServizioCostituenteLogico.visualizzaCostituenteLogico(antecedente.getCostituenteLogico()));
        return str.toString();
    }

    public static String visualizzaAntecedenteEnnesimo(Antecedente antecedente) {
        StringBuilder str = new StringBuilder();
        str.append(" " + antecedente.getOpBooleano());
        str.append(" " + ClasseDiServizioCostituenteLogico.visualizzaCostituenteLogico(antecedente.getCostituenteLogico()));
        return str.toString();
    }
}
