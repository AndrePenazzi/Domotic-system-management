package it.unibs.fp.view.classiDiServizio.dispositiviPeriferici;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.dispositiviPeriferici.Sensori;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioSensori {

    public static Sensori creaSensori(ListaCategorie listaCategorie) {
        Sensori sensori = new Sensori();
        if (!listaCategorie.categorieSensoriIsEmpty()) {
            do {
                sensori.inserisciSensore(ClasseDiServizioSensore.creaSensore(listaCategorie));
            } while (InputDati.yesOrNo("Vuoi continuare ad inserire un nuovo sensore?"));
        } else
            System.out.println("Mancano le categorieSensori, bisogna prima crearle");
        return sensori;
    }

    public static String visualizzaInfoRilevabili(Sensori sensori) {
        StringBuilder tmp = new StringBuilder();

        if (!sensori.isEmpty()) {
            int i = 1;
            tmp.append("\nI sensori sono:\n");
            for (Sensore s : sensori.getSensori()) {
                tmp.append(i + " " + ClasseDiServizioSensore.visualizzaInfoRilevabili(s)).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora sensori associati");
        return tmp.toString();
    }

    public static String visualizzaValoriRilevati(Sensori sensori) {
        StringBuilder tmp = new StringBuilder();
        if (!sensori.isEmpty()) {
            int i = 1;
            tmp.append("\nI sensori sono:\n");
            for (Sensore s : sensori.getSensori()) {
                tmp.append(i + " " + ClasseDiServizioSensore.visualizzaValoreRilevati(s)).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora sensori associati");
        return tmp.toString();
    }

    /**
     * Descrivi i nomi dei sensori
     *
     * @param sensori da visualizzare
     * @return visualizza i nomi dei sensori
     */
    public static String visualizzaNomiSensori(Sensori sensori) {
        StringBuilder tmp = new StringBuilder();

        if (!sensori.isEmpty()) {
            int i = 1;
            tmp.append("\nI sensori sono:\n");
            for (Sensore s : sensori.getSensori()) {
                tmp.append(i + ") " + s.getNome()).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora sensori associati");
        return tmp.toString();
    }

    /**
     * toString
     *
     * @param sensori da visualizzare
     * @return descrizione di sensori
     */
    public static String toString(Sensori sensori) {
        StringBuilder tmp = new StringBuilder();

        if (!sensori.isEmpty()) {
            int i = 1;
            tmp.append("\nI sensori sono:\n");
            for (Sensore s : sensori.getSensori()) {
                tmp.append(i + ") " + ClasseDiServizioSensore.toString(s)).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora sensori associati");
        return tmp.toString();
    }
}
