package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioAttuatori;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioSensori;
import it.unibs.fp.view.mylib.InputDati;


public class ClasseDiServizioArtefatto {

    /**
     * Costruttore Artefatto
     *
     * @return l'artefatto creato
     */
    public static Artefatto creaArtefatto() {
        String nome;
        nome = InputDati.leggiStringaNonVuota("Inserisci nome nuovo artefatto: ");
        return new Artefatto(nome);
    }

    /**
     * Scegli l'attuatore nell'artefatto
     *
     * @param artefatto nel quale sceglie l'attuatore
     * @return l'attuatore scelto
     */
    public static Attuatore scegliAttuatoreNellArtefatto(Artefatto artefatto) {
        System.out.println(ClasseDiServizioAttuatori.visualizzaNomeAttuatori(artefatto.getAttuatoriInArtefatto()));
        int i = InputDati.leggiIntero("Scegli l'attuatore: ", 1, artefatto.getSizeAttuatoriInArtefatto()) - 1;
        return artefatto.getAttuatoreInArtefatto(i);
    }

    /**
     * Scegli un sensore nell'artefatto
     *
     * @param artefatto nel quale scegliere un sensore
     * @return sensore
     */
    public static Sensore scegliSensoreNellArtefatto(Artefatto artefatto) {
        System.out.println(ClasseDiServizioSensori.visualizzaNomiSensori(artefatto.getSensoriInArtefatto()));
        int i = InputDati.leggiIntero("Scegli il sensore: ", 1, artefatto.getSizeSensoriInArtefatto()) - 1;
        return artefatto.getSensoreInArtefatto(i);
    }

    public static String visualizzaAttuatori(Artefatto artefatto) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(ClasseDiServizioAttuatori.toString(artefatto.getAttuatoriInArtefatto()));
        return tmp.toString();
    }

    public static String visualizzaSensori(Artefatto artefatto) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(ClasseDiServizioSensori.toString(artefatto.getSensoriInArtefatto()));
        return tmp.toString();
    }

    public static String visualizzaValoriRilevati(Artefatto artefatto) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(ClasseDiServizioSensori.visualizzaValoriRilevati(artefatto.getSensoriInArtefatto()));
        return tmp.toString();
    }

    public static void modificaModOperativa(Artefatto artefatto) {
        ClasseDiServizioAttuatori.modificaModOperative(artefatto.getAttuatoriInArtefatto());
    }


    /**
     * toString Artefatto
     *
     * @param artefatto da visualizzare
     * @return la descrizione dell'artefatto
     */
    public static String toString(Artefatto artefatto) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(artefatto.getNome());

        tmp.append(ClasseDiServizioSensori.toString(artefatto.getSensoriInArtefatto()));
        tmp.append(ClasseDiServizioAttuatori.toString(artefatto.getAttuatoriInArtefatto()));
        return tmp.toString();
    }
}
