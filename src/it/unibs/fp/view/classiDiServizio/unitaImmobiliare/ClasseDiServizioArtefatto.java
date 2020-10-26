package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioAttuatori;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioSensori;
import it.unibs.fp.view.mylib.InputDati;


public class ClasseDiServizioArtefatto {

    public static Artefatto creaArtefatto() {
        String nome;
        nome = InputDati.leggiStringaNonVuota("Inserisci nome nuovo artefatto: ");
        return new Artefatto(nome);
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


    public static String toString(Artefatto artefatto) {
        String nome = artefatto.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n" + nome);
        tmp.append(ClasseDiServizioSensori.toString(artefatto.getSensoriInArtefatto()));

        tmp.append(ClasseDiServizioAttuatori.toString(artefatto.getAttuatoriInArtefatto()));
        return tmp.toString();
    }

    public static Attuatore scegliAttuatoreNellArtefatto(Artefatto artefatto) {
        System.out.println(ClasseDiServizioAttuatori.toString(artefatto.getAttuatoriInArtefatto()));
        int i = InputDati.leggiIntero("Scegli l'attuatore: ", 1, artefatto.getAttuatoriInArtefatto().getSize()) - 1;
        return artefatto.getAttuatoriInArtefatto().getAttuatore(i);
    }
    public static Sensore scegliSensoreNellArtefatto(Artefatto artefatto) {
        System.out.println(ClasseDiServizioSensori.toString(artefatto.getSensoriInArtefatto()));
        int i = InputDati.leggiIntero("Scegli il sensore: ", 1, artefatto.getSensoriInArtefatto().getSize()) - 1;
        return artefatto.getSensoriInArtefatto().getSensore(i);
    }
}
