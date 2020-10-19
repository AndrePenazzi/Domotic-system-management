package it.unibs.fp.regola;

import it.unibs.fp.operatori.OperatoriBooleani;

public class EnnesimoAntecedente extends Antecedente {
    public EnnesimoAntecedente(OperatoriBooleani operatoreBooleano,CostituenteLogico costituenteLogico ) {
        setCostituenteLogico(costituenteLogico);
        setOpBooleano(operatoreBooleano);
    }
}
