package it.unibs.fp.regola;

import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.operatori.OperatoriRelazionali;

public class CostituenteLogicoParametrico extends CostituenteLogico{
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
