package it.unibs.fp.regola;

import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.operatori.OperatoriBooleani;
import it.unibs.fp.operatori.OperatoriRelazionali;

public class AntecedenteSingolo extends Antecedente {

    public AntecedenteSingolo(CostituenteLogico costituenteLogico) {
        setCostituenteLogico(costituenteLogico);
        setOpBooleano(null);
    }

}
