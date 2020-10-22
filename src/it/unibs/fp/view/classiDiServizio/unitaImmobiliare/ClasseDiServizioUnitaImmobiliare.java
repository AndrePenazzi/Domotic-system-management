package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioUnitaImmobiliare {
    public static UnitaImmobiliare creaUnitaImmobiliare() {
        String nome;
        nome = InputDati.leggiStringaNonVuota("Inserisci nome nuova unita immobiliare: ");
        return new UnitaImmobiliare(nome);
    }
}
