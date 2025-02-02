package it.unibs.fp.view.classiDiServizio.regola;

import it.unibs.fp.model.regola.Orologio;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioOrologio {

    /**
     * Crea nuovo orologio
     *
     * @return Orologio
     */
    public static Orologio creaOrologio() {
        int ora = InputDati.leggiIntero("Inserisci l'ora: ", 0, 23);
        int minuti = InputDati.leggiIntero("Inserisci minuti: ", 0, 59);
        return new Orologio(ora, minuti);
    }

    /**
     * Crea ora attuale
     *
     * @return ora attuale
     */
    public static Orologio creaOraAttuale() {
        return new Orologio();
    }

    /**
     * toString
     *
     * @param orologio da visualizzare
     * @return descrizione dell'orologio
     */
    public static String toString(Orologio orologio) {
        return orologio.getOra() + ":" + orologio.getMinuti();
    }

}
