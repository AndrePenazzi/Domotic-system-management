package it.unibs.fp.view.classiDiServizio.infoRilevabile;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNonNumerica;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNumerica;

import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.MyMenu;

import java.util.ArrayList;
import java.util.List;

public class ClasseDiServizioInfoRilevabile {

    public static InfoRilevabile menuCreaInfoRilevabile(ListaCategorie listaCategorie) {
        InfoRilevabile infoRilevabile = null;

        String[] azione = {"Numerica", "Non numerica"};
        MyMenu menu = new MyMenu("Menu creazione Info Rilevabile", azione);

        int scelta = menu.scegli();
        switch (scelta) {
            case 0: {
            }
            break;
            case 1: {
                infoRilevabile = creaInfoRilevabileNumerica(listaCategorie);
                System.out.println("USCITA MENU Info Rilevabile");
            }
            break;

            case 2: {
                infoRilevabile = creaInfoRilevabileNonNumerica(listaCategorie);
                System.out.println("USCITA MENU Info Rilevabile");
            }
            break;
        }
        return infoRilevabile;
    }

    //TODO FORSE MANCA IL TRY CATCH PER MIN MAX
    public static InfoRilevabile creaInfoRilevabileNumerica(ListaCategorie listaCategorie) {
        InfoRilevabile informazioneRilevabile = null;
        boolean infoRilevabileOK = false;
        String nomeInfo = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome di informazione rilevabile: ");
        do {
            try {
                double min = InputDati.leggiDouble("Inserisci il valore minimo rilevabile: ");
                double max = InputDati.leggiDouble("Inserisci il valore massimo rilevabile: ");

                informazioneRilevabile = new InfoRilevabileNumerica(nomeInfo, min, max);
                infoRilevabileOK = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!infoRilevabileOK);

        return informazioneRilevabile;
    }

    public static InfoRilevabile creaInfoRilevabileNonNumerica(ListaCategorie listaCategorie) {
        InfoRilevabile informazioneRilevabile = null;
        boolean infoRilevabileOK = false;
        String nomeInfo = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome di informazione rilevabile: ");
        do {
            try {
                List<String> valoriNonNumerici = new ArrayList<>();
                do {
                    valoriNonNumerici.add(InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci un valore rilevabile non numerico:"));

                } while (InputDati.yesOrNo("Vuoi inserire un'altro valore non numerico ?"));

                informazioneRilevabile = new InfoRilevabileNonNumerica(nomeInfo, valoriNonNumerici);
                infoRilevabileOK = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!infoRilevabileOK);

        return informazioneRilevabile;
    }


}
