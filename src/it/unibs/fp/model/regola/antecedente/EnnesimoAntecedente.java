package it.unibs.fp.model.regola.antecedente;

import it.unibs.fp.model.operatori.OperatoriBooleani;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogico;

import java.io.Serializable;

public class EnnesimoAntecedente extends Antecedente implements Serializable {
    /**
     * Costruttore
     *
     * @param operatoreBooleano per il confronto
     * @param costituenteLogico per la creazione dell'antecedente
     */
    public EnnesimoAntecedente(OperatoriBooleani operatoreBooleano, CostituenteLogico costituenteLogico) {
        setCostituenteLogico(costituenteLogico);
        setOpBooleano(operatoreBooleano);
    }
}
