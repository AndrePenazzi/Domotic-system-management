package it.unibs.fp.view.classiDiServizio.modalitaOperativa;

import it.unibs.fp.model.modalitaOperativa.ModOperativaNonParamentrica;

public class ClasseDiServizioModOperativaNonParametrica {
    public static String toString(ModOperativaNonParamentrica modOperativa) {
        String nome = modOperativa.getNome();
        double valore=modOperativa.getValore();
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n");
        tmp.append(nome + "\n");
        tmp.append("Valore: " + modOperativa.getDf2().format(valore));
        return tmp.toString();
    }
}
