package it.unibs.fp.regola;

import it.unibs.fp.operatori.OperatoriBooleani;

public abstract class Antecedente {
    private CostituenteLogico costituenteLogico;
    private OperatoriBooleani opBooleano;

    public CostituenteLogico getCostituenteLogico() {
        return costituenteLogico;
    }

    public void setCostituenteLogico(CostituenteLogico costituenteLogico) {
        this.costituenteLogico = costituenteLogico;
    }

    public OperatoriBooleani getOpBooleano() {
        return opBooleano;
    }

    public void setOpBooleano(OperatoriBooleani opBooleano) {
        this.opBooleano = opBooleano;
    }
}
