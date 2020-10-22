package it.unibs.fp.view.classiDiServizio.dispositiviPeriferici;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.dispositiviPeriferici.Sensori;
import it.unibs.fp.view.mylib.InputDati;

import java.util.List;

public class ClasseDiServizioSensori {

    public static Sensori creaSensori(ListaCategorie listaCategorie) {
        Sensori sensori = new Sensori();

        do {
            sensori.inserisciSensore(ClasseDiServizioSensore.creaSensore(listaCategorie));
        } while (InputDati.yesOrNo("Vuoi continuare ad inserire un nuovo sensore?"));

        return sensori;
    }

    public static String toString(List<Sensore> sensori) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("\nI sensori sono: \n");

        if (!sensori.isEmpty()) {
            int i = 1;
            tmp.append("\nGli sensori sono:\n");
            for (Sensore s : sensori) {
                tmp.append(i + " " + ClasseDiServizioSensore.toString(s)).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora sensori associati");
        return tmp.toString();
    }
}
