package it.unibs.fp.view.classiDiServizio.modalitaOperativa;

import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import it.unibs.fp.model.modalitaOperativa.ModOperativaNonParametrica;
import it.unibs.fp.model.modalitaOperativa.ModOperativaParametrica;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.MyMenu;

import java.util.ArrayList;
import java.util.List;

public class ClasseDiServizioModOperativa {

    /**
     * MenuCreaModOperativa
     * @return ModOperativa creata
     */
    public static ModOperativa menuCreaModOperativa() {
        ModOperativa modOperativa = null;

        String[] azione = {"Parametrica", "Non parametrica"};
        MyMenu menu = new MyMenu("Menu creazione Mod Operativa", azione);

        int scelta = menu.scegliPerMenuSenzaUscita();
        switch (scelta) {
            case 1: {
                modOperativa = creaModOperativaParametrica();
                System.out.println("USCITA MENU Mod Operativa");
            }
            break;

            case 2: {
                modOperativa = creaModOperativaNonParametrica();
                System.out.println("USCITA MENU Mod Operativa");
            }
            break;
        }
        return modOperativa;
    }

    /**
     * CreaModOperativaNonParametrica
     *
     * @return ModOperativaNonParametrica
     */
    public static ModOperativa creaModOperativaNonParametrica() {
        String nome;
        double valore;
        nome = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome Mod Operativa Non Parametrica: ");
        if (InputDati.yesOrNo("Vuoi inserire il valore?")) {
            valore = InputDati.leggiDouble("Inserisci valore Mod Operativa Non Parametrica: ");
            return new ModOperativaNonParametrica(nome, valore);
        }
        return new ModOperativaNonParametrica(nome);
    }

    /**
     * CreaModOperativaParametrica
     *
     * @return ModOperativaParametrica
     */
    public static ModOperativa creaModOperativaParametrica() {
        String nome;
        List<String> valori = new ArrayList<>();
        nome = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome Mod Operativa Parametrica: ");
        do {
            valori.add(InputDati.leggiStringaNonVuota("Inserisci valore Mod Operativa Parametrica: "));
        } while (InputDati.yesOrNo("Vuoi inserire un'altro parametro nella modalità operativa?"));
        return new ModOperativaParametrica(nome, valori);
    }

    public static void modificaModOperativa(ModOperativa modOperativa) {
        if (modOperativa.getType() == 1)
            ClasseDiServizioModOperativaNonParametrica.modificaValoreModOperativaAttuale((ModOperativaNonParametrica) modOperativa);
        else if (modOperativa.getType() == 2)
            ClasseDiServizioModOperativaParametrica.modificaValoreModOperativaAttuale((ModOperativaParametrica) modOperativa);

    }

    /**
     * toStringModOperativa
     *
     * @param modOperativa da visualizzare
     * @return Descrizione modOperativa
     */
    public static String toString(ModOperativa modOperativa) {
        StringBuilder tmp = new StringBuilder();
        if (modOperativa.getType() == 1)
            tmp.append(ClasseDiServizioModOperativaNonParametrica.toString((ModOperativaNonParametrica) modOperativa));
        else if (modOperativa.getType() == 2)
            tmp.append(ClasseDiServizioModOperativaParametrica.toString((ModOperativaParametrica) modOperativa));

        return tmp.toString();
    }

}
