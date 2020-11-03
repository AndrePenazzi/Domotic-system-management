package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.model.unitaImmobiliare.Stanza;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioAttuatori;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioSensori;
import it.unibs.fp.view.mylib.InputDati;


public class ClasseDiServizioStanza {
    /**
     * Costruttore Stanza
     *
     * @return crea una nuova stanza
     */
    public static Stanza creaStanza() {
        String nome;
        nome = InputDati.leggiStringaNonVuota("Inserisci nome nuova stanza: ");
        return new Stanza(nome);
    }

    public static String visualizzaSensori(Stanza stanza) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(ClasseDiServizioSensori.toString(stanza.getSensori()));
        return tmp.toString();
    }


    public static String visualizzaAttuatoriEAttuatoriAssociatiAdArtefatti(Stanza stanza) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(ClasseDiServizioAttuatori.toString(stanza.getAttuatoriInStanza()));

        for (Artefatto a : stanza.getArtefattiInStanza().getArtefatti()) {
            tmp.append(ClasseDiServizioArtefatto.visualizzaAttuatori(a));
        }
        return tmp.toString();
    }

    public static String visualizzaSensoriESensoriAssociatiAdArtefatti(Stanza stanza) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(visualizzaSensori(stanza));

        for (Artefatto a : stanza.getArtefattiInStanza().getArtefatti()) {
            tmp.append(ClasseDiServizioArtefatto.visualizzaSensori(a));
        }
        return tmp.toString();
    }

    public static Artefatto scegliArtefattoNellaStanza(Stanza stanza) {
        System.out.println(ClasseDiServizioArtefatti.toString(stanza.getArtefatti()));
        int i = InputDati.leggiIntero("Scegli l'artefatto: ", 1, stanza.getSizeArtefatti()) - 1;

        return stanza.getArtefatto(i);
    }


    public static Attuatore scegliAttuatoreNellArtefatto(Artefatto artefatto) {
        return ClasseDiServizioArtefatto.scegliAttuatoreNellArtefatto(artefatto);
    }


    public static Attuatore scegliAttuatoreNellaStanza(Stanza stanza) {
        System.out.println(ClasseDiServizioAttuatori.toString(stanza.getAttuatoriInStanza()));
        int i = InputDati.leggiIntero("Scegli l'attuatore: ", 1, stanza.getAttuatoriInStanza().getSize()) - 1;

        return stanza.getAttuatoriInStanza().getAttuatore(i);
    }

    public static Sensore scegliSensoreNellArtefatto(Artefatto artefatto) {
        return ClasseDiServizioArtefatto.scegliSensoreNellArtefatto(artefatto);
    }


    public static Sensore scegliSensoreNellaStanza(Stanza stanza) {
        System.out.println(ClasseDiServizioSensori.toString(stanza.getSensori()));
        int i = InputDati.leggiIntero("Scegli il sensore: ", 1, stanza.getSizeSensori()) - 1;

        return stanza.getSensore(i);
    }

    public static String visualizzaValoriRilevati(Stanza stanza) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(ClasseDiServizioSensori.visualizzaValoriRilevati(stanza.getSensori()));
        return tmp.toString();
    }

    public static void modificaModOperative(Stanza stanza) {
        ClasseDiServizioAttuatori.modificaModOperative(stanza.getAttuatoriInStanza());
    }

    public static String visualizzaValoriRilevatiEValoriRilevatiInArtefatti(Stanza stanza) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(visualizzaValoriRilevati(stanza));

        for (Artefatto a : stanza.getArtefattiInStanza().getArtefatti()) {
            tmp.append(ClasseDiServizioArtefatto.visualizzaValoriRilevati(a));
        }
        return tmp.toString();
    }

    public static void modificaModOperativeEModOperativeInArtefatti(Stanza stanza) {
        modificaModOperative(stanza);
        for (Artefatto a : stanza.getArtefattiInStanza().getArtefatti()) {
            ClasseDiServizioArtefatto.modificaModOperativa(a);
        }
    }

    /**
     * toString
     *
     * @param stanza da visualizzare
     * @return descrizione della stanza
     */
    public static String toString(Stanza stanza) {
        String nome = stanza.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append(nome + "\n");

        tmp.append(ClasseDiServizioArtefatti.toString(stanza.getArtefatti()));
        tmp.append(ClasseDiServizioSensori.toString(stanza.getSensori()));
        tmp.append(ClasseDiServizioAttuatori.toString(stanza.getAttuatoriInStanza()) + "\n");

        return tmp.toString();
    }
}
