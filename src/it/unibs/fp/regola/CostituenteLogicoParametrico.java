package it.unibs.fp.regola;

import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.operatori.OperatoriRelazionali;

public class CostituenteLogicoParametrico extends CostituenteLogico{
    public CostituenteLogicoParametrico(InfoRilevabile primoOperatoreLogico, String secondoOperatoreScalare, OperatoriRelazionali operatoreRelazionale) {
        super(primoOperatoreLogico, secondoOperatoreScalare, operatoreRelazionale);
    }
}
