package it.unibs.fp.view.classiDiServizio.regola.antecedente;

import it.unibs.fp.model.regola.antecedente.Antecedenti;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.mylib.InputDati;

import java.io.Serializable;

public class ClasseDiServizioAntecedenti implements Serializable {

    /**
     * Crea antecedenti
     *
     * @param unitaImmobiliare per la creazione degli antecedenti
     * @return Antecedenti
     */
    public static Antecedenti creaAntecedenti(UnitaImmobiliare unitaImmobiliare) {
        Antecedenti antecedenti = new Antecedenti();
        antecedenti.inserisciAntecedente(ClasseDiServizioAntecedente.creaAntecedenteSingolo(unitaImmobiliare));

        while (InputDati.yesOrNo("vuoi continuare ad inserire un nuovo antecedente?")) {
            antecedenti.inserisciAntecedente(ClasseDiServizioAntecedente.creaAntecedenteEnnesimo(unitaImmobiliare));
        }
        return antecedenti;
    }

    /**
     * Descrivi antecedenti
     *
     * @param antecedenti da visualizzare
     * @return descrizione antecedenti
     */
    public static String descriviAntecedenti(Antecedenti antecedenti) {
        StringBuilder str = new StringBuilder();
        str.append(ClasseDiServizioAntecedente.descriviAntecedenteSingolo(antecedenti.getAntecendente(0)));
        for (int i = 1; i < antecedenti.getAntecendentiSize(); i++) {
            str.append(ClasseDiServizioAntecedente.descriviAntecedenteEnnesimo(antecedenti.getAntecendente(i)));
        }
        return str.toString();
    }
}
