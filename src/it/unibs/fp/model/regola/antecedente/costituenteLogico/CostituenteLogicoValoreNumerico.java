package it.unibs.fp.model.regola.antecedente.costituenteLogico;

import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.operatori.OperatoriRelazionali;

import java.io.Serializable;

public class CostituenteLogicoValoreNumerico extends CostituenteLogico implements Serializable {
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
