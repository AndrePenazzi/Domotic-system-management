package it.unibs.fp.model.regola.antecedente;

import it.unibs.fp.model.operatori.OperatoriBooleani;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogico;

import java.io.Serializable;

public class AntecedenteFactory implements Serializable {
    public static Antecedente creaAntecedente(CostituenteLogico costituenteLogico){
            return new AntecedenteSingolo(costituenteLogico);

    }
    public static Antecedente creaAntecedente(OperatoriBooleani opBooleano, CostituenteLogico costituenteLogico){
            return new EnnesimoAntecedente(opBooleano,costituenteLogico);

    }
}
