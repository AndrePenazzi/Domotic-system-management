package it.unibs.fp.view.classiDiServizio.dispositiviPeriferici;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Attuatori;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioAttuatori {

    public static Attuatori creaAttuatori(ListaCategorie listaCategorie) {
        Attuatori attuatori = new Attuatori();

        do {
            attuatori.inserisciAttuatore(ClasseDiServizioAttuatore.creaAttuatore(listaCategorie));
        } while (InputDati.yesOrNo("Vuoi continuare ad inserire un nuovo attuatore?"));

        return attuatori;
    }

    public static String toString(Attuatori attuatori) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("\nGli attuatori sono: \n");

        if (!attuatori.getAttuatori().isEmpty()) {
            int i = 1;
            tmp.append("\nGli attuatori sono:\n");
            for (Attuatore a : attuatori.getAttuatori()) {
                tmp.append(i + " " + ClasseDiServizioAttuatore.toString(a)).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora attuatori associati");
        return tmp.toString();
    }
}
