package it.unibs.fp.regola;

import it.unibs.fp.operatori.OperatoriBooleani;

public class EnnesimoAntecedente extends Antecedente {
    public EnnesimoAntecedente(CostituenteLogico costituenteLogico, OperatoriBooleani operatoreBooleano) {
        setCostituenteLogico(costituenteLogico);
        setOpBooleano(operatoreBooleano);
    }
}
