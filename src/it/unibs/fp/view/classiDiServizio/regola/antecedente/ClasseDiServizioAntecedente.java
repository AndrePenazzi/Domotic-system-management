package it.unibs.fp.view.classiDiServizio.regola.antecedente;

import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.operatori.OperatoriBooleani;
import it.unibs.fp.model.regola.antecedente.Antecedente;
import it.unibs.fp.model.regola.antecedente.AntecedenteFactory;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogico;
import it.unibs.fp.view.classiDiServizio.operatori.ClasseDiServizioOperatoriBooleani;
import it.unibs.fp.view.classiDiServizio.regola.antecedente.costituenteLogico.ClasseDiServizioCostituenteLogico;

import java.io.Serializable;

public class ClasseDiServizioAntecedente implements Serializable {


    public static Antecedente creaAntecedenteEnnesimo(CategoriaSensori categoriaS) {
        CostituenteLogico costituenteLogico;
        OperatoriBooleani opBooleano;
        costituenteLogico = ClasseDiServizioCostituenteLogico.menuCreaCostituenteLogico(categoriaS);
        opBooleano = ClasseDiServizioOperatoriBooleani.sceltaOperatoreBooleano();

        return AntecedenteFactory.creaAntecedente(opBooleano, costituenteLogico);
    }

    public static Antecedente creaAntecedenteSingolo(CategoriaSensori categoriaS) {
        CostituenteLogico costituenteLogico;
        costituenteLogico = ClasseDiServizioCostituenteLogico.menuCreaCostituenteLogico(categoriaS);

        return AntecedenteFactory.creaAntecedente(costituenteLogico);
    }

    public static String visualizzaAntecedenteSingolo(Antecedente antecedente){
        StringBuilder str = new StringBuilder();
        str.append(" " + ClasseDiServizioCostituenteLogico.visualizzaCostituenteLogico(antecedente.getCostituenteLogico()));
        return str.toString();
    }
    public static String visualizzaAntecedenteEnnesimo(Antecedente antecedente){
        StringBuilder str = new StringBuilder();
            str.append(" " + antecedente.getOpBooleano());
            str.append(" " + ClasseDiServizioCostituenteLogico.visualizzaCostituenteLogico(antecedente.getCostituenteLogico()));
        return str.toString();
    }
}
