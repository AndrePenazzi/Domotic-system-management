package it.unibs.fp.view.classiDiServizio.regola.antecedente;

import it.unibs.fp.model.operatori.OperatoriBooleani;
import it.unibs.fp.model.regola.antecedente.Antecedente;
import it.unibs.fp.model.regola.antecedente.AntecedenteFactory;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogico;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.operatori.ClasseDiServizioOperatoriBooleani;
import it.unibs.fp.view.classiDiServizio.regola.antecedente.costituenteLogico.ClasseDiServizioCostituenteLogico;

import java.io.Serializable;

public class ClasseDiServizioAntecedente implements Serializable {

    /**
     * Crea antecedente ennesimo
     *
     * @param unitaImmobiliare per la creazione dell'antecedente
     * @return Antecedente
     */
    public static Antecedente creaAntecedenteEnnesimo(UnitaImmobiliare unitaImmobiliare) {
        CostituenteLogico costituenteLogico;
        OperatoriBooleani opBooleano;
        opBooleano = ClasseDiServizioOperatoriBooleani.sceltaOperatoreBooleano();
        costituenteLogico = ClasseDiServizioCostituenteLogico.menuCreaCostituenteLogico(unitaImmobiliare);

        return AntecedenteFactory.creaAntecedente(opBooleano, costituenteLogico);
    }

    /**
     * Crea Antecedente singolo
     *
     * @param unitaImmobiliare per la creazione di un antecedente singolo
     * @return Antecedente
     */
    public static Antecedente creaAntecedenteSingolo(UnitaImmobiliare unitaImmobiliare) {
        CostituenteLogico costituenteLogico;
        costituenteLogico = ClasseDiServizioCostituenteLogico.menuCreaCostituenteLogico(unitaImmobiliare);

        return AntecedenteFactory.creaAntecedente(costituenteLogico);
    }

    /**
     * Descrivi antecedente singolo
     *
     * @param antecedente da visualizzare
     * @return descrizione antecedente
     */
    public static String descriviAntecedenteSingolo(Antecedente antecedente) {
        StringBuilder str = new StringBuilder();
        str.append(" " + ClasseDiServizioCostituenteLogico.descriviCostituenteLogico(antecedente.getCostituenteLogico()));
        return str.toString();
    }

    /**
     * Descrivi antecedente ennesimo
     *
     * @param antecedente da visualizzare
     * @return descrizione antecedente
     */
    public static String descriviAntecedenteEnnesimo(Antecedente antecedente) {
        StringBuilder str = new StringBuilder();
        str.append(" " + antecedente.getOpBooleano());
        str.append(" " + ClasseDiServizioCostituenteLogico.descriviCostituenteLogico(antecedente.getCostituenteLogico()));
        return str.toString();
    }
}
