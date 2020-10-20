package it.unibs.fp.model.regola.antecedente;

import it.unibs.fp.model.operatori.OperatoriBooleani;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogico;

import java.io.Serializable;

public abstract class Antecedente implements Serializable {
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
