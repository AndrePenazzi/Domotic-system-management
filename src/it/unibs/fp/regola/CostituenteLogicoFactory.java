package it.unibs.fp.regola;

import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.operatori.OperatoriRelazionali;

public class CostituenteLogicoFactory {

    public static CostituenteLogico creaCostituenteLogico(InfoRilevabile primoOperatoreLogico, InfoRilevabile secondoOperatoreLogico, OperatoriRelazionali operatoreRelazionale){
        return new CostituenteLogicoInfoRilevabile(primoOperatoreLogico,secondoOperatoreLogico,operatoreRelazionale);
    }
    public static CostituenteLogico creaCostituenteLogico(InfoRilevabile primoOperatoreLogico, String secondoOperatoreLogico, OperatoriRelazionali operatoreRelazionale){
        return new CostituenteLogicoParametrico(primoOperatoreLogico,secondoOperatoreLogico,operatoreRelazionale);
    }
    public static CostituenteLogico creaCostituenteLogico(InfoRilevabile primoOperatoreLogico, double secondoOperatoreLogico, OperatoriRelazionali operatoreRelazionale){
        return new CostituenteLogicoValoreNumerico(primoOperatoreLogico,secondoOperatoreLogico,operatoreRelazionale);
    }
    public static CostituenteLogico creaCostituenteLogico(Orologio secondoOperatoreLogico, OperatoriRelazionali operatoreRelazionale){
        return new CostituenteLogicoOrologio(secondoOperatoreLogico,operatoreRelazionale);
    }
}
