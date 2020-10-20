package it.unibs.fp.view.classiDiServizio.infoRilevabile;

import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNonNumerica;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNumerica;

import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.MyMenu;

import java.util.ArrayList;
import java.util.List;

public class ClasseDiServizioInfoRilevabile {

    public static InfoRilevabile menuCreaInfoRilevabile() {
        InfoRilevabile infoRilevabile = null;

        boolean finito = false;
        String[] azione = {"Numerica", "Non numerica"};
        MyMenu menu = new MyMenu("Menu creazione Info Rilevabile", azione);

        int scelta = menu.scegli();
        switch (scelta) {
            case 0: {
            }
            break;
            case 1: {
                infoRilevabile = creaInfoRilevabileNumerica();
                System.out.println("USCITA MENU Info Rilevabile");
            }
            break;

            case 2: {
                infoRilevabile = creaInfoRilevabileNonNumerica();
                System.out.println("USCITA MENU Info Rilevabile");
            }
            break;
        }
        return infoRilevabile;
    }

    //TODO FORSE MANCA IL TRY CATCH PER MIN MAX
    public static InfoRilevabile creaInfoRilevabileNumerica() {
        String nome;
        double min;
        double max;
        nome = InputDati.leggiStringaNonVuota("Inserisci nome Informazione Rilevabile Numerica: ");
        min = InputDati.leggiDouble("Inserisci minimo Informazione Rilevabile Numerica: ");
        max = InputDati.leggiDouble("Inserisci massimo Informazione Rilevabile Numerica: ");
        return new InfoRilevabileNumerica(nome, min, max);
    }

    public static InfoRilevabile creaInfoRilevabileNonNumerica() {
        String nome;
        List<String> valori = new ArrayList<>();
        nome = InputDati.leggiStringaNonVuota("Inserisci nome Informazione Rilevabile Numerica: ");
        do {
            valori.add(InputDati.leggiStringaNonVuota("Inserisci valore Informazione Rilevabile Non Numerica: "));
        } while (InputDati.yesOrNo("Vuoi inserire un'altro valore?"));
        return new InfoRilevabileNonNumerica(nome, valori);
    }


}
