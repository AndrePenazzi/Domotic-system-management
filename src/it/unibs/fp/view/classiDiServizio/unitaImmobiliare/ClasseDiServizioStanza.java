package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.unitaImmobiliare.Stanza;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioStanza {
    public static Stanza creaStanza() {
        String nome;
        nome = InputDati.leggiStringaNonVuota("Inserisci nome nuova stanza: ");
        return new Stanza(nome);
    }
}
