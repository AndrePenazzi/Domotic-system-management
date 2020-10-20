package it.unibs.fp.view.classiDiServizio.regola;

import it.unibs.fp.model.regola.Orologio;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioOrologio {
    public static Orologio creaOrologio() {
        int ora = InputDati.leggiIntero("Inserisci l'ora", 0, 23);
        int minuti = InputDati.leggiIntero("Inserisci minuti", 0, 59);
        return new Orologio(ora, minuti);
    }


}
