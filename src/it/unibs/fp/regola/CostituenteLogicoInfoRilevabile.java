package it.unibs.fp.regola;

import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.operatori.OperatoriRelazionali;

public class CostituenteLogicoInfoRilevabile extends CostituenteLogico {
    /**
     * Costruttore con valori
     *
     * @param primoOperatoreLogico   Informazione rilevabile 1
     * @param secondoOperatoreLogico Informazione rilevabile 2
     * @param operatoreRelazionale   per il confronto
     */
    public CostituenteLogicoInfoRilevabile(InfoRilevabile primoOperatoreLogico, InfoRilevabile secondoOperatoreLogico, OperatoriRelazionali operatoreRelazionale) {
        setPrimoOperatoreLogico(primoOperatoreLogico);
        setSecondoOperatoreLogico(secondoOperatoreLogico);
        setOperatoreRelazionale(operatoreRelazionale);

    }
}
