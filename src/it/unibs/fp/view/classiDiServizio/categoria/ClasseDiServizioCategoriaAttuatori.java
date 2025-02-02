package it.unibs.fp.view.classiDiServizio.categoria;

import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import it.unibs.fp.view.classiDiServizio.modalitaOperativa.ClasseDiServizioModOperativa;
import it.unibs.fp.view.mylib.InputDati;

import java.util.ArrayList;
import java.util.List;

public class ClasseDiServizioCategoriaAttuatori {

    /**
     * CreaCategoriaAttuatori
     *
     * @return CategoriaAttuatori
     */
    public static CategoriaAttuatori creaCategoriaAttuatori() {
        String testoLibero;
        boolean testoLiberoOK = false;
        boolean modOperativeOK = false;
        List<ModOperativa> modOperative = new ArrayList<>();
        String nome = InputDati.leggiStringaNonVuota("Inserisci nome categoria attuatori: ");
        CategoriaAttuatori categoriaAttuatori = null;

        do {
            try {
                testoLibero = InputDati.leggiStringaNonVuota("Inserisci un testo libero: ");
                if (!modOperativeOK) {
                    do {
                        modOperative.add(ClasseDiServizioModOperativa.menuCreaModOperativa());
                    } while (InputDati.yesOrNo("Vuoi inserire un'altra modalita operativa?"));
                    modOperativeOK = true;
                }

                categoriaAttuatori = new CategoriaAttuatori(nome, testoLibero, modOperative);
                testoLiberoOK = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!testoLiberoOK);

        return categoriaAttuatori;
    }

    public static void modificaModOperativa(CategoriaAttuatori categoriaAttuatori) {
        List<ModOperativa> modalitaOperative = categoriaAttuatori.getModalitaOperative();
        if (!modalitaOperative.isEmpty()) {
            System.out.println("\nMod Operative:\n");
            for (ModOperativa modOperativa : modalitaOperative) {
                ClasseDiServizioModOperativa.modificaModOperativa(modOperativa);
            }
        } else
            System.out.println("\nNon ci sono ancora informazioni rilevabili associate\n");
    }

    /**
     * Scegli modOperativa
     *
     * @param categoriaAttuatori per la scelta della mod Operativa
     * @return modOperativa
     */
    public static ModOperativa scegliModOperativa(CategoriaAttuatori categoriaAttuatori) {
        System.out.println(visualizzaModOperativeNumerate(categoriaAttuatori));
        int i = InputDati.leggiIntero("Scegli la modOperativa: ", 1, categoriaAttuatori.getSizeModalitaOperative()) - 1;
        return categoriaAttuatori.getModalitaOperativa(i);
    }

    /**
     * Visualizza modOperative numerate
     *
     * @param categoriaAttuatori per la descrizione delle mod operative
     * @return descrizione Mod Operative
     */
    public static String visualizzaModOperativeNumerate(CategoriaAttuatori categoriaAttuatori) {
        StringBuilder tmp = new StringBuilder();
        List<ModOperativa> modalitaOperative = categoriaAttuatori.getModalitaOperative();

        if (!modalitaOperative.isEmpty()) {
            int i = 1;
            tmp.append("\nModalita Operative:\n");
            for (ModOperativa modOperativa : modalitaOperative) {
                tmp.append(i + ") " + modOperativa.getNome() + "\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora modalita operative associate\n");
        return tmp.toString();
    }

    /**
     * VisualizzaModOperativeNonNumerate
     *
     * @param categoriaAttuatori da visualizzare
     * @return Descrizione modOperative
     */
    public static String descrizioneModOperativeNonNumerate(CategoriaAttuatori categoriaAttuatori) {
        StringBuilder tmp = new StringBuilder();
        List<ModOperativa> modalitaOperative = categoriaAttuatori.getModalitaOperative();

        if (!modalitaOperative.isEmpty()) {
            tmp.append("\nle modalita operative sono:\n");
            for (ModOperativa modOperativa : modalitaOperative) {
                tmp.append(ClasseDiServizioModOperativa.toString(modOperativa));
            }
        } else
            tmp.append("\nNon ci sono ancora modalita operative associate");
        return tmp.toString();
    }

    /**
     * toStringCategoriaAttuatori
     *
     * @param categoriaAttuatori da visualizzare
     * @return categoriaAttuatori
     */
    public static String toString(CategoriaAttuatori categoriaAttuatori) {
        String nome = categoriaAttuatori.getNome();
        String testoLibero = categoriaAttuatori.getTestoLibero();

        StringBuilder tmp = new StringBuilder();
        tmp.append(nome + ": ");
        tmp.append(testoLibero);
        tmp.append(visualizzaModOperativeNumerate(categoriaAttuatori));

        return tmp.toString();
    }

    /**
     * toStringCategoriaAttuatori
     *
     * @param categoriaAttuatori da visualizzare
     * @return categoriaAttuatori
     */
    public static String toStringVisualizzazione(CategoriaAttuatori categoriaAttuatori) {
        String nome = categoriaAttuatori.getNome();
        String testoLibero = categoriaAttuatori.getTestoLibero();

        StringBuilder tmp = new StringBuilder();
        tmp.append(nome + ": ");
        tmp.append(testoLibero);
        tmp.append(descrizioneModOperativeNonNumerate(categoriaAttuatori));

        return tmp.toString();
    }

}
