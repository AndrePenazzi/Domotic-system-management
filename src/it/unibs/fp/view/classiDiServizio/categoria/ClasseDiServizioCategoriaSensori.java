package it.unibs.fp.view.classiDiServizio.categoria;

import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.view.classiDiServizio.infoRilevabile.ClasseDiServizioInfoRilevabile;
import it.unibs.fp.view.mylib.InputDati;

import java.util.ArrayList;
import java.util.List;

public class ClasseDiServizioCategoriaSensori {
    public static CategoriaSensori creaCategoriaSensori() {
        String testoLibero = "";
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
        System.out.println(visualizzaInfoRilevabili(categoriaSensori));
        int i = InputDati.leggiIntero("Scegli la infoRilevabile: ", 1, categoriaSensori.getInformazioniRilevabili().size()) - 1;

        return categoriaSensori.getInformazioniRilevabili().get(i);
    }

    public static String visualizzaInfoRilevabili(CategoriaSensori categoriaSensori) {
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

    public static String toString(CategoriaSensori categoriaSensori) {
        String nome = categoriaSensori.getNome();
        String testoLibero = categoriaSensori.getTestoLibero();

        StringBuilder tmp = new StringBuilder();
        tmp.append("\n" + nome);
        tmp.append("\n" + testoLibero);
        visualizzaInfoRilevabili(categoriaSensori);

        return tmp.toString();
    }

}
