package it.unibs.fp.model.regola.antecedente.costituenteLogico;

import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.operatori.OperatoriRelazionali;

import java.io.Serializable;

public class CostituenteLogicoInfoRilevabile extends CostituenteLogico implements Serializable {
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
