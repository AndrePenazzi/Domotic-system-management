package it.unibs.fp.view.classiDiServizio.dispositiviPeriferici;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.dispositiviPeriferici.Sensori;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioSensori {

    public static Sensori creaSensori(ListaCategorie listaCategorie) {
        Sensori sensori = new Sensori();

        do {
            sensori.inserisciSensore(ClasseDiServizioSensore.creaSensore(listaCategorie));
        } while (InputDati.yesOrNo("Vuoi continuare ad inserire un nuovo sensore?"));

        return sensori;
    }
}
