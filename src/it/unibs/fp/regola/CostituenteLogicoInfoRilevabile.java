package it.unibs.fp.regola;

import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.operatori.OperatoriRelazionali;

public class CostituenteLogicoInfoRilevabile extends CostituenteLogico {
    public CostituenteLogicoInfoRilevabile(InfoRilevabile primoOperatoreLogico, InfoRilevabile secondoOperatoreLogico, OperatoriRelazionali operatoreRelazionale) {
        super(primoOperatoreLogico, secondoOperatoreLogico, operatoreRelazionale);
    }
}
