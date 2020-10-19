package it.unibs.fp.regola;

import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.operatori.OperatoriRelazionali;

public class CostituenteLogicoOrologio extends CostituenteLogico{
    /**
     * Costruttore con orologio
     *
     * @param secondoOperatoreLogico orologio
     * @param operatoreRelazionale   per il confronto
     */
    public CostituenteLogicoOrologio(Orologio secondoOperatoreLogico, OperatoriRelazionali operatoreRelazionale) {
        setSecondoOperatoreOrologio(secondoOperatoreLogico);
        setOperatoreRelazionale(operatoreRelazionale);
    }
}
