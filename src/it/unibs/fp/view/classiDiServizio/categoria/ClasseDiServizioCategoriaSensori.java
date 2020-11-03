package it.unibs.fp.view.classiDiServizio.categoria;

import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.view.classiDiServizio.infoRilevabile.ClasseDiServizioInfoRilevabile;
import it.unibs.fp.view.mylib.InputDati;

import java.util.ArrayList;
import java.util.List;

public class ClasseDiServizioCategoriaSensori {
    /**
     * CreaCategoriaSensori
     *
     * @return una CategoriaSensori
     */
    public static CategoriaSensori creaCategoriaSensori() {
        String testoLibero;
        boolean testoLiberoOK = false;
        boolean infoRilevabiliOK = false;
        List<InfoRilevabile> informazioniRilevabili = new ArrayList<>();
        String nome = InputDati.leggiStringaNonVuota("Inserisci nome categoria sensori: ");
        CategoriaSensori categoriaSensori = null;

        do {
            try {
                testoLibero = InputDati.leggiStringaNonVuota("Inserisci un testo libero: ");
                if (!infoRilevabiliOK) {
                    do {
                        informazioniRilevabili.add(ClasseDiServizioInfoRilevabile.menuCreaInfoRilevabile());
                    } while (InputDati.yesOrNo("Vuoi inserire un'altra informazione rilevabile?"));
                    infoRilevabiliOK = true;
                }

                categoriaSensori = new CategoriaSensori(nome, testoLibero, informazioniRilevabili);
                testoLiberoOK = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!testoLiberoOK);

        return categoriaSensori;
    }

    public static InfoRilevabile scegliInfoRilevabile(CategoriaSensori categoriaSensori) {
        System.out.println(descrizioneInfoRilevabiliNumerate(categoriaSensori));
        int i = InputDati.leggiIntero("Scegli la infoRilevabile: ", 1, categoriaSensori.getSizeInformazioniRilevabili()) - 1;

        return categoriaSensori.getInformazioneRilevabile(i);
    }

    /**
     * Visualizza la descrizione delle infoRilevabili numerate
     *
     * @param categoriaSensori da visualizzare
     * @return descrizione infoRilevabiliNumerate
     */
    public static String descrizioneInfoRilevabiliNumerate(CategoriaSensori categoriaSensori) {
        StringBuilder tmp = new StringBuilder();
        List<InfoRilevabile> informazioniRilevabili = categoriaSensori.getInformazioniRilevabili();

        if (!informazioniRilevabili.isEmpty()) {
            int i = 1;
            tmp.append("\nInformazioni rilevabili:\n");
            for (InfoRilevabile infoRilevabile : informazioniRilevabili) {
                tmp.append(i + " " + ClasseDiServizioInfoRilevabile.toString(infoRilevabile));
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora informazioni rilevabili associate\n");
        return tmp.toString();
    }

    /**
     * Visualizza le InfoRilvabili non numerate
     *
     * @param categoriaSensori da visualizzare
     * @return la String di infoRilevabili
     */
    public static String descrizioneInfoRilevabiliNonNumerate(CategoriaSensori categoriaSensori) {
        StringBuilder tmp = new StringBuilder();
        List<InfoRilevabile> informazioniRilevabili = categoriaSensori.getInformazioniRilevabili();

        if (!informazioniRilevabili.isEmpty()) {
            tmp.append("\n le informazioni rilevabili sono:");
            for (InfoRilevabile infoRilevabile : informazioniRilevabili) {
                tmp.append("\n-" + ClasseDiServizioInfoRilevabile.toString(infoRilevabile) + "\n");
            }
        } else
            tmp.append(", Non ci sono ancora informazioni rilevabili associate");
        return tmp.toString();
    }

    public static String visualizzaValoreRilevato(CategoriaSensori categoriaSensori) {
        StringBuilder tmp = new StringBuilder();
        List<InfoRilevabile> informazioniRilevabili = categoriaSensori.getInformazioniRilevabili();

        if (!informazioniRilevabili.isEmpty()) {
            int i = 1;
            tmp.append("\nInformazioni rilevabili:\n");
            for (InfoRilevabile infoRilevabile : informazioniRilevabili) {
                tmp.append(i + " " + ClasseDiServizioInfoRilevabile.visualizzaValoreRilevato(infoRilevabile));
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora informazioni rilevabili associate\n");
        return tmp.toString();
    }


    /**
     * toString della categoria sensori
     *
     * @param categoriaSensori da visualizzare
     * @return nome, testo libero e infoRilevabili
     */
    public static String toString(CategoriaSensori categoriaSensori) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(categoriaSensori.getNome() + ": ");
        tmp.append(categoriaSensori.getTestoLibero());
        tmp.append(descrizioneInfoRilevabiliNumerate(categoriaSensori));
        return tmp.toString();
    }

    /**
     * toString della categoria sensori
     *
     * @param categoriaSensori da visualizzare
     * @return nome, testo libero e infoRilevabili
     */
    public static String toStringVisualizzazione(CategoriaSensori categoriaSensori) {
        String nome = categoriaSensori.getNome();
        String testoLibero = categoriaSensori.getTestoLibero();
        StringBuilder tmp = new StringBuilder();
        tmp.append(nome + ": ");
        tmp.append(testoLibero);
        tmp.append(descrizioneInfoRilevabiliNonNumerate(categoriaSensori));
        return tmp.toString();
    }

}
