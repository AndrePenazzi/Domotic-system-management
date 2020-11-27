package it.unibs.fp.view.classiDiServizio.infoRilevabile;

import it.unibs.fp.model.infoRilevabile.InfoRilevabileNumerica;

public class ClasseDiServizioInfoRilevabileNumerica {

    /**
     * Descrivi il valore rilevato con nome infoRilevabile
     *
     * @param infoRilevabile dal quale prendere la variabile da rilevare
     * @return descrizione valore rilevato e nome infoRilevabile
     */
    public static String descriviValoreRilevato(InfoRilevabileNumerica infoRilevabile) {
        String nome = infoRilevabile.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append(nome+": ");
        tmp.append(infoRilevabile.rilevaVariabile()+"\n");
        return tmp.toString();
    }

    /**
     * Descrivi solo il valore rilevato
     *
     * @param infoRilevabile dal quale prendere la variabile da rilevare
     * @return descrizione valore rilevato
     */
    public static String descriviSoloValoreRilevato(InfoRilevabileNumerica infoRilevabile) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(infoRilevabile.rilevaVariabile());
        return tmp.toString();
    }

    /**
     * toStringInfoRilevabileNumerica
     *
     * @param infoRilevabile numerica
     * @return infoRilevabileNumerica
     */
    public static String toString(InfoRilevabileNumerica infoRilevabile) {
        String nome = infoRilevabile.getNome();
        double min = infoRilevabile.getMin();
        double max = infoRilevabile.getMax();
        StringBuilder tmp = new StringBuilder();
        tmp.append(nome);
        tmp.append("\nMin: " + min);
        tmp.append("\nMax: " + max);
        return tmp.toString();
    }

}
