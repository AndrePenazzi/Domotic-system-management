package it.unibs.fp.view.classiDiServizio.infoRilevabile;

import it.unibs.fp.model.infoRilevabile.InfoRilevabileNumerica;

public class ClasseDiServizioInfoRilevabileNumerica {
    public static String visualizzaValoreRilevato(InfoRilevabileNumerica infoRilevabile) {
        String nome=infoRilevabile.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append(nome);
        tmp.append(infoRilevabile.rilevaVariabile());
        return tmp.toString();
    }

    /**
     * toStringInfoRilevabileNumerica
     * @param infoRilevabile numerica
     * @return infoRilevabileNumerica
     */
    public static String toString(InfoRilevabileNumerica infoRilevabile) {
        String nome=infoRilevabile.getNome();
        double min=infoRilevabile.getMin();
        double max=infoRilevabile.getMax();
        StringBuilder tmp = new StringBuilder();
        tmp.append(nome);
        tmp.append("\nMin: " + min);
        tmp.append("\nMax: " + max);
        return tmp.toString();
    }

}
