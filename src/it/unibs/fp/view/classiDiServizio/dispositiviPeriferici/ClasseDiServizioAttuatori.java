package it.unibs.fp.view.classiDiServizio.dispositiviPeriferici;

import it.unibs.fp.model.categoria.ListaCategorie;
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
}
