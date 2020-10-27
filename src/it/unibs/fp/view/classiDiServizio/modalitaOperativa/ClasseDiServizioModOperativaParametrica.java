package it.unibs.fp.view.classiDiServizio.modalitaOperativa;

import it.unibs.fp.model.modalitaOperativa.ModOperativaParametrica;
import it.unibs.fp.view.mylib.InputDati;

import java.util.List;

public class ClasseDiServizioModOperativaParametrica {
    public static void modificaValoreModOperativaAttuale(ModOperativaParametrica modOperativa) {
        visualizzaParametri(modOperativa);
        int i = InputDati.leggiIntero("Scegli la modalità operativa: ", 1, modOperativa.getSizeParamentri()) - 1;
        modOperativa.setParametroAttuale(modOperativa.getParametro(i));
    }

    public static String visualizzaParametri(ModOperativaParametrica modOperativa) {
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

    public static String toString(ModOperativaParametrica modOperativa) {
        StringBuilder tmp = new StringBuilder();
        visualizzaParametri(modOperativa);
        tmp.append("\nParametro attuale: ").append(modOperativa.getParametroAttuale());
        return tmp.toString();
    }
}
