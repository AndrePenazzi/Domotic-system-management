package it.unibs.fp.view.classiDiServizio.modalitaOperativa;

import it.unibs.fp.model.modalitaOperativa.ModOperativaNonParametrica;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioModOperativaNonParametrica {
    /**
     * toString ModOperativaNonParametrica
     *
     * @param modOperativa non parametrica
     * @return DescrizioneModOperativaNonParametrica
     */
    public static String toString(ModOperativaNonParametrica modOperativa) {
        String nome = modOperativa.getNome();
        double valore = modOperativa.getValore();
        StringBuilder tmp = new StringBuilder();

        tmp.append("-" + nome + "\n");
        tmp.append("--Valore: " + modOperativa.getDf2().format(valore) + "\n");
        return tmp.toString();
    }

    public static void modificaValoreModOperativaAttuale(ModOperativaNonParametrica modOperativa) {
        modOperativa.setValore(InputDati.leggiDouble("Modifica il valore della modOperativa"));
    }

}
