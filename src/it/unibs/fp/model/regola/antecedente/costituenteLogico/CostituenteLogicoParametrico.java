package it.unibs.fp.model.regola.antecedente.costituenteLogico;

import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.operatori.OperatoriRelazionali;

import java.io.Serializable;

public class CostituenteLogicoParametrico extends CostituenteLogico implements Serializable {
    /**
     * Costruttore costituente logico
     *
     * @param primoOperatoreLogico    da confrontare
     * @param secondoOperatoreScalare String
     * @param operatoreRelazionale    per il confronto
     */
    public CostituenteLogicoParametrico(InfoRilevabile primoOperatoreLogico, String secondoOperatoreScalare, OperatoriRelazionali operatoreRelazionale) {
        setPrimoOperatoreLogico(primoOperatoreLogico);
        setSecondoOperatoreScalare(secondoOperatoreScalare);
        setOperatoreRelazionale(operatoreRelazionale);
    }
}
