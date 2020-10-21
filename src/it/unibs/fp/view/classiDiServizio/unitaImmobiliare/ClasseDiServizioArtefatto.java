package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioArtefatto {

    public static Artefatto creaArtefatto() {
        String nome;
        nome = InputDati.leggiStringaNonVuota("Inserisci nome nuovo artefatto: ");
        return new Artefatto(nome);
    }
}
