package it.unibs.fp.model.regola.antecedente.costituenteLogico;

import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.operatori.OperatoriRelazionali;
import it.unibs.fp.model.regola.Orologio;

import java.io.Serializable;

public class CostituenteLogicoFactory implements Serializable {

    public static CostituenteLogico creaCostituenteLogico(InfoRilevabile primoOperatoreLogico, InfoRilevabile secondoOperatoreLogico, OperatoriRelazionali operatoreRelazionale) {
        return new CostituenteLogicoInfoRilevabile(primoOperatoreLogico, secondoOperatoreLogico, operatoreRelazionale);
    }

    public static CostituenteLogico creaCostituenteLogico(InfoRilevabile primoOperatoreLogico, String secondoOperatoreLogico, OperatoriRelazionali operatoreRelazionale) {
        return new CostituenteLogicoParametrico(primoOperatoreLogico, secondoOperatoreLogico, operatoreRelazionale);
    }

    /**
     * Crea il costituente logico valore numerico
     *
     * @param primoOperatoreLogico   infoRilevabile
     * @param secondoOperatoreLogico double
     * @param operatoreRelazionale   per il paragone
     * @return il costituente logico
     */
    public static CostituenteLogico creaCostituenteLogico(InfoRilevabile primoOperatoreLogico, double secondoOperatoreLogico, OperatoriRelazionali operatoreRelazionale) {
        return new CostituenteLogicoValoreNumerico(primoOperatoreLogico, secondoOperatoreLogico, operatoreRelazionale);
    }

    /**
     * Crea il costituente logico orologio
     *
     * @param secondoOperatoreLogico l'orologio
     * @param operatoreRelazionale   per il paragone
     * @return il costituente logico
     */
    public static CostituenteLogico creaCostituenteLogico(Orologio secondoOperatoreLogico, OperatoriRelazionali operatoreRelazionale) {
        return new CostituenteLogicoOrologio(secondoOperatoreLogico, operatoreRelazionale);
    }
}
