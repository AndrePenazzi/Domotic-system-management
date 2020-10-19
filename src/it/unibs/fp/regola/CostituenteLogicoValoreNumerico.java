package it.unibs.fp.regola;

import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.operatori.OperatoriRelazionali;

public class CostituenteLogicoValoreNumerico extends CostituenteLogico{
    /**
     * Costruttore con costante
     *
     * @param primoOperatoreLogico     da confrontare
     * @param secondoOperatoreCostante double
     * @param operatoreRelazionale     per il confronto
     */
    public CostituenteLogicoValoreNumerico(InfoRilevabile primoOperatoreLogico, double secondoOperatoreCostante, OperatoriRelazionali operatoreRelazionale) {
        setPrimoOperatoreLogico(primoOperatoreLogico);
        setSecondoOperatoreCostante(secondoOperatoreCostante);
        setOperatoreRelazionale(operatoreRelazionale);
    }
}
