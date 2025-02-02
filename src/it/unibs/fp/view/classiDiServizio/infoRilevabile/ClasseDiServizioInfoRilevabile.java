package it.unibs.fp.view.classiDiServizio.infoRilevabile;

import it.unibs.fp.model.infoRilevabile.*;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.MyMenu;

import java.util.ArrayList;
import java.util.List;

public class ClasseDiServizioInfoRilevabile {

    /**
     * MenuCreaInfoRilevabile
     *
     * @return una InfoRilevabile
     */
    public static InfoRilevabile menuCreaInfoRilevabile() {
        InfoRilevabile infoRilevabile = null;

        String[] azione = {"Numerica", "Non numerica"};
        MyMenu menu = new MyMenu("Menu creazione Info Rilevabile", azione);

        int scelta = menu.scegliPerMenuSenzaUscita();
        switch (scelta) {
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


    /**
     * CreaInfoRilevabileNumerica
     *
     * @return infoRilevabile numerica
     */
    public static InfoRilevabile creaInfoRilevabileNumerica() {
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

    /**
     * CreaInfoRilevabileNonNumerica
     *
     * @return infoRilevabile non numerica
     */
    public static InfoRilevabile creaInfoRilevabileNonNumerica() {
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

    /**
     * Descrivi il valore rilevato ed il nome dell'info rilevabile
     *
     * @param infoRilevabile per visualizzare il valore rilevato ed il nome dell'info rilevabile
     * @return descrizione del valore rilevato ed il nome delle info rilevabile
     */
    public static String descriviValoreRilevato(InfoRilevabile infoRilevabile) {
        RendererInfoRilevabile rendererInfoRilevabile = new CompositeRendererInfoRilevabile();
        return rendererInfoRilevabile.renderDescriviValoreRilevato(infoRilevabile);
    }

    /**
     * Descrivi solo il valore rilevato
     *
     * @param infoRilevabile per visualizzare solo il valore rilevato
     * @return descrizione solo valore rilevato
     */
    public static String descriviSoloValoreRilevato(InfoRilevabile infoRilevabile) {
        RendererInfoRilevabile rendererInfoRilevabile = new CompositeRendererInfoRilevabile();
        return rendererInfoRilevabile.renderDescriviSoloValoreRilevato(infoRilevabile);
    }

    /**
     * toStringInfoRilevabile
     *
     * @param infoRilevabile può essere sia numerica che non numerica
     * @return le infoRilevabili
     */
    public static String toString(InfoRilevabile infoRilevabile) {
        RendererInfoRilevabile rendererInfoRilevabile = new CompositeRendererInfoRilevabile();
        return rendererInfoRilevabile.renderToString(infoRilevabile);
    }


}
