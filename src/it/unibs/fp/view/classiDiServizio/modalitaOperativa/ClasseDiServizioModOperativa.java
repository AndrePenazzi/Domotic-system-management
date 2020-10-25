package it.unibs.fp.view.classiDiServizio.modalitaOperativa;

import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNonNumerica;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNumerica;
import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import it.unibs.fp.model.modalitaOperativa.ModOperativaNonParamentrica;
import it.unibs.fp.model.modalitaOperativa.ModOperativaParamentrica;
import it.unibs.fp.view.classiDiServizio.infoRilevabile.ClasseDiServizioInfoRilevabileNonNumerica;
import it.unibs.fp.view.classiDiServizio.infoRilevabile.ClasseDiServizioInfoRilevabileNumerica;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.MyMenu;

import java.util.ArrayList;
import java.util.List;

public class ClasseDiServizioModOperativa {

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

    public static ModOperativa creaModOperativaNonParametrica() {
        String nome;
        double valore;
        nome = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome Mod Operativa Non Parametrica: ");
        if (InputDati.yesOrNo("Vuoi inserire il valore?")) {
            valore = InputDati.leggiDouble("Inserisci valore Mod Operativa Non Parametrica: ");
            return new ModOperativaNonParamentrica(nome, valore);
        }
        return new ModOperativaNonParamentrica(nome);
    }

    public static ModOperativa creaModOperativaParametrica() {
        String nome;
        List<String> valori = new ArrayList<>();
        nome = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome Mod Operativa Parametrica: ");
        do {
            valori.add(InputDati.leggiStringaNonVuota("Inserisci valore Mod Operativa Parametrica: "));
        } while (InputDati.yesOrNo("Vuoi inserire un'altro parametro nella modalità operativa?"));
        return new ModOperativaParamentrica(nome, valori);
    }

    public static String toString(ModOperativa modOperativa){
        StringBuilder tmp = new StringBuilder();
        if(modOperativa.getType()==1)
            tmp.append(ClasseDiServizioModOperativaNonParametrica.toString((ModOperativaNonParamentrica)modOperativa));
        else if(modOperativa.getType()==2)
            tmp.append(ClasseDiServizioModOperativaParametrica.toString((ModOperativaParamentrica)modOperativa));

        return tmp.toString();
    }

}
