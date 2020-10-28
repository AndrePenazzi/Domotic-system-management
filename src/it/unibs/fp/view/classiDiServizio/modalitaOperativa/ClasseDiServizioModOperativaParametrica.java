package it.unibs.fp.view.classiDiServizio.modalitaOperativa;

import it.unibs.fp.model.modalitaOperativa.ModOperativaParametrica;
import it.unibs.fp.view.mylib.InputDati;

import java.util.List;

public class ClasseDiServizioModOperativaParametrica {
    public static void modificaValoreModOperativaAttuale(ModOperativaParametrica modOperativa) {
        System.out.println(visualizzaParametriNumerati(modOperativa));
        int i = InputDati.leggiIntero("Scegli la modalità operativa: ", 1, modOperativa.getSizeParamentri()) - 1;
        modOperativa.setParametroAttuale(modOperativa.getParametro(i));
    }

    public static String visualizzaParametriNumerati(ModOperativaParametrica modOperativa) {
        List<String> paramentri = modOperativa.getParamentri();
        StringBuilder tmp = new StringBuilder();
        if (!paramentri.isEmpty()) {
            int i = 1;
            tmp.append("\nParametri:\n");
            for (String s : paramentri) {
                tmp.append(i).append(" ").append(s).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora parametri associati");
        return tmp.toString();
    }

    /**
     * VisualizzaParametriNonNumerati
     *
     * @param modOperativa con i parametri
     * @return Descrizione parametri
     */
    public static String visualizzaParametriNonNumerati(ModOperativaParametrica modOperativa) {
        List<String> paramentri = modOperativa.getParamentri();
        StringBuilder tmp = new StringBuilder();
        if (!paramentri.isEmpty()) {
            tmp.append("-Parametri:\n");
            for (String s : paramentri) {
                tmp.append("--").append(s).append("\n");
            }
        } else
            tmp.append("\nNon ci sono ancora parametri associati");
        return tmp.toString();
    }

    /**
     * toString ModOperativaParametrica
     *
     * @param modOperativa parametrica
     * @return DescrizioneModOperativaParametrica
     */
    public static String toString(ModOperativaParametrica modOperativa) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(visualizzaParametriNonNumerati(modOperativa));
        return tmp.toString();
    }

    public static String toStringConParametroAttuale(ModOperativaParametrica modOperativa) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(visualizzaParametriNonNumerati(modOperativa));
        tmp.append("\nParametro attuale: ").append(modOperativa.getParametroAttuale());
        return tmp.toString();
    }
}
