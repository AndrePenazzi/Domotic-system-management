package it.unibs.fp.model.regola.antecedente;

import it.unibs.fp.model.operatori.OperatoriBooleani;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogico;

import java.io.Serializable;

public class AntecedenteFactory implements Serializable {
    /**
     * Crea antecedente singolo
     *
     * @param costituenteLogico per la creazione dell'antecedente
     * @return antecedente
     */
    public static Antecedente creaAntecedente(CostituenteLogico costituenteLogico) {
        return new AntecedenteSingolo(costituenteLogico);

    }

    /**
     * Crea ennesimo antecedente
     *
     * @param opBooleano        per il confronto
     * @param costituenteLogico per la creazione dell'antecedente
     * @return antecedente
     */
    public static Antecedente creaAntecedente(OperatoriBooleani opBooleano, CostituenteLogico costituenteLogico) {
        return new EnnesimoAntecedente(opBooleano, costituenteLogico);

    }
}
