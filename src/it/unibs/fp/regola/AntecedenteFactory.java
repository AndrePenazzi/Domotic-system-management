package it.unibs.fp.regola;

import it.unibs.fp.operatori.OperatoriBooleani;

public class AntecedenteFactory {
    public Antecedente creaAntecedente(CostituenteLogico costituenteLogico){
            return new AntecedenteSingolo(costituenteLogico);

    }
    public Antecedente creaAntecedente(CostituenteLogico costituenteLogico , OperatoriBooleani opBooleano){
            return new EnnesimoAntecedente(opBooleano,costituenteLogico);

    }
}
