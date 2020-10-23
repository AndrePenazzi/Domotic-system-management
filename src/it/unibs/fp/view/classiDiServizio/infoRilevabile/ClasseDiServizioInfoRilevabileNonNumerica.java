package it.unibs.fp.view.classiDiServizio.infoRilevabile;

import it.unibs.fp.model.infoRilevabile.InfoRilevabileNonNumerica;

import java.util.List;

public class ClasseDiServizioInfoRilevabileNonNumerica {

    public static String visualizzaValori(InfoRilevabileNonNumerica infoRilevabile) {
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

    public static String toString(InfoRilevabileNonNumerica infoRilevabile) {
        String nome = infoRilevabile.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n" + nome);
        tmp.append(visualizzaValori(infoRilevabile));
        return tmp.toString();
    }

}
