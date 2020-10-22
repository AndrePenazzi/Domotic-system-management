package it.unibs.fp.view.classiDiServizio.modalitaOperativa;

import it.unibs.fp.model.modalitaOperativa.ModOperativaParamentrica;

import java.util.List;

public class ClasseDiServizioModOperativaParametrica {
    public static String toString(ModOperativaParamentrica modOperativa) {
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
        tmp.append("\nParametro attuale: ").append(modOperativa.getParametroAttuale());
        return tmp.toString();

    }
}
