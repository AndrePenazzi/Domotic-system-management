package it.unibs.fp.model.regola.antecedente;

import it.unibs.fp.model.operatori.OperatoriBooleani;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogico;

import java.io.Serializable;

public abstract class Antecedente implements Serializable {
    private CostituenteLogico costituenteLogico;
    private OperatoriBooleani opBooleano;

    /**
     * Getter
     *
     * @return costituente logico
     */
    public CostituenteLogico getCostituenteLogico() {
        return costituenteLogico;
    }

    /**
     * Setter
     *
     * @param costituenteLogico da settare
     */
    public void setCostituenteLogico(CostituenteLogico costituenteLogico) {
        this.costituenteLogico = costituenteLogico;
    }

    /**
     * Getter
     *
     * @return opBooleano
     */
    public OperatoriBooleani getOpBooleano() {
        return opBooleano;
    }

    /**
     * Setter
     *
     * @param opBooleano da settare
     */
    public void setOpBooleano(OperatoriBooleani opBooleano) {
        this.opBooleano = opBooleano;
    }
}
