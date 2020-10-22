package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.unitaImmobiliare.Stanza;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioAttuatori;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioSensori;
import it.unibs.fp.view.mylib.InputDati;


public class ClasseDiServizioStanza {
    public static Stanza creaStanza() {
        String nome;
        nome = InputDati.leggiStringaNonVuota("Inserisci nome nuova stanza: ");
        return new Stanza(nome);
    }

    public static String toString(Stanza stanza) {
        String nome = stanza.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append(nome);

        tmp.append(ClasseDiServizioArtefatti.toString(stanza.getArtefatti()));
        tmp.append(ClasseDiServizioSensori.toString(stanza.getSensori()));
        tmp.append(ClasseDiServizioAttuatori.toString(stanza.getAttuatori()));

        return tmp.toString();
    }


}
