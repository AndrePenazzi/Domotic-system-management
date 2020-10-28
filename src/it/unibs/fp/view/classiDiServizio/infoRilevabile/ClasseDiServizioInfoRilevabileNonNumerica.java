package it.unibs.fp.view.classiDiServizio.infoRilevabile;

import it.unibs.fp.model.infoRilevabile.InfoRilevabileNonNumerica;

import java.util.List;

public class ClasseDiServizioInfoRilevabileNonNumerica {

    public static String visualizzaValoreRilevato(InfoRilevabileNonNumerica infoRilevabile) {
        StringBuilder tmp = new StringBuilder();

        int i = 1;
        tmp.append("\nValore attuale:\n");
        tmp.append(i + " " + infoRilevabile.rilevaVariabile()).append("\n");
        return tmp.toString();
    }


    public static String visualizzaValoriNumerato(InfoRilevabileNonNumerica infoRilevabile) {
        List<String> valori = infoRilevabile.getValori();
        StringBuilder tmp = new StringBuilder();

        if (!valori.isEmpty()) {
            int i = 1;
            tmp.append("\nValori:\n");
            for (String s : valori) {
                tmp.append(i + " " + s).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora valori associati");
        return tmp.toString();
    }

    /**
     * Visualizza i valori non numerati
     * @param infoRilevabile non numerica
     * @return i valori non numerici
     */
    public static String visualizzaValoriNonNumerato(InfoRilevabileNonNumerica infoRilevabile) {
        List<String> valori = infoRilevabile.getValori();
        StringBuilder tmp = new StringBuilder();

        if (!valori.isEmpty()) {
            tmp.append("\nValori:\n");
            for (String s : valori) {
                tmp.append("--" + s).append("\n");
            }
        } else
            tmp.append("\nNon ci sono ancora valori associati");
        return tmp.toString();
    }

    /**
     * toStringInfoRilevabileNonNumerica
     * @param infoRilevabile non numerica
     * @return infoRilevabileNonNumerica
     */
    public static String toString(InfoRilevabileNonNumerica infoRilevabile) {
        String nome = infoRilevabile.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append(nome);
        tmp.append(visualizzaValoriNonNumerato(infoRilevabile));
        return tmp.toString();
    }

}
