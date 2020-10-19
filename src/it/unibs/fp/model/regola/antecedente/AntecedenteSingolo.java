package it.unibs.fp.model.regola.antecedente;

import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogico;

public class AntecedenteSingolo extends Antecedente {

    public AntecedenteSingolo(CostituenteLogico costituenteLogico) {
        setCostituenteLogico(costituenteLogico);
        setOpBooleano(null);
    }

}
