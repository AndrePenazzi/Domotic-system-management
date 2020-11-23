package it.unibs.fp.model.regola.antecedente;

import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogico;

import java.io.Serializable;

public class AntecedenteSingolo extends Antecedente implements Serializable {

    /**
     * Costruttore antecedente singolo
     *
     * @param costituenteLogico per la creazione dell'antecedente singolo
     */
    public AntecedenteSingolo(CostituenteLogico costituenteLogico) {
        setCostituenteLogico(costituenteLogico);
        setOpBooleano(null);
    }

}
