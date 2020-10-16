package it.unibs.fp.regola;

import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.operatori.OperatoriRelazionali;

public class CostituenteLogicoValoreNumerico extends CostituenteLogico{
    public CostituenteLogicoValoreNumerico(InfoRilevabile primoOperatoreLogico, double secondoOperatoreCostante, OperatoriRelazionali operatoreRelazionale) {
        super(primoOperatoreLogico, secondoOperatoreCostante, operatoreRelazionale);
    }
}
