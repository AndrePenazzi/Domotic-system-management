package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
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

    public static String visualizzaAttuatori(Stanza stanza) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(ClasseDiServizioAttuatori.toString(stanza.getAttuatori()));
        return tmp.toString();
    }
    public static String visualizzaSensori(Stanza stanza) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(ClasseDiServizioSensori.toString(stanza.getSensori()));
        return tmp.toString();
    }

    public static String visualizzaAttuatoriEAttuatoriAssociatiAdArtefatti(Stanza stanza) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(visualizzaAttuatori(stanza));

        for (Artefatto a : stanza.getArtefatti()) {
            tmp.append(ClasseDiServizioArtefatto.visualizzaAttuatori(a));
        }
        return tmp.toString();
    }
    public static String visualizzaSensoriESensoriAssociatiAdArtefatti(Stanza stanza) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(visualizzaSensori(stanza));

        for (Artefatto a : stanza.getArtefatti()) {
            tmp.append(ClasseDiServizioArtefatto.visualizzaSensori(a));
        }
        return tmp.toString();
    }

    public static Artefatto scegliArtefattoNellaStanza(Stanza stanza) {
        System.out.println(ClasseDiServizioArtefatti.toString(stanza.getArtefatti()));
        int i = InputDati.leggiIntero("Scegli l'artefatto: ", 1, stanza.getArtefatti().size()) - 1;

        return stanza.getArtefatti().get(i);
    }

    public static String toString(Stanza stanza) {
        String nome = stanza.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append(nome);

        tmp.append(ClasseDiServizioArtefatti.toString(stanza.getArtefatti()));
        tmp.append(ClasseDiServizioSensori.toString(stanza.getSensori()));
        tmp.append(visualizzaAttuatori(stanza));

        return tmp.toString();
    }

    public static Attuatore scegliAttuatoreNellArtefatto(Artefatto artefatto) {
        return ClasseDiServizioArtefatto.scegliAttuatoreNellArtefatto(artefatto);
    }


    public static Attuatore scegliAttuatoreNellaStanza(Stanza stanza) {
        System.out.println(ClasseDiServizioAttuatori.toString(stanza.getAttuatori()));
        int i = InputDati.leggiIntero("Scegli l'attuatore: ", 1, stanza.getAttuatori().size()) - 1;

        return stanza.getAttuatori().get(i);
    }

    public static Sensore scegliSensoreNellArtefatto(Artefatto artefatto) {
        return ClasseDiServizioArtefatto.scegliSensoreNellArtefatto(artefatto);
    }


    public static Sensore scegliSensoreNellaStanza(Stanza stanza) {
        System.out.println(ClasseDiServizioSensori.toString(stanza.getSensori()));
        int i = InputDati.leggiIntero("Scegli il sensore: ", 1, stanza.getSensori().size()) - 1;

        return stanza.getSensori().get(i);
    }
}
