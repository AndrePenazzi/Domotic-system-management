package it.unibs.fp.model.regola.antecedente.costituenteLogico;

import it.unibs.fp.model.operatori.OperatoriRelazionali;
import it.unibs.fp.model.regola.Orologio;

import java.io.Serializable;

public class CostituenteLogicoOrologio extends CostituenteLogico implements Serializable {
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
