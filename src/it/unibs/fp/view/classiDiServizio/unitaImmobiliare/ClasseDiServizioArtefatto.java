package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
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
        tmp.append(ClasseDiServizioAttuatori.toString(artefatto.getAttuatori()));
        return tmp.toString();
    }


    public static String toString(Artefatto artefatto) {
        String nome = artefatto.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n" + nome);
        tmp.append(ClasseDiServizioSensori.toString(artefatto.getSensori()));

        tmp.append(ClasseDiServizioAttuatori.toString(artefatto.getAttuatori()));
        return tmp.toString();
    }

    public static Attuatore scegliAttuatoreNellArtefatto(Artefatto artefatto) {
        System.out.println(ClasseDiServizioAttuatori.toString(artefatto.getAttuatori()));
        int i = InputDati.leggiIntero("Scegli l'attuatore: ", 1, artefatto.getAttuatori().size()) - 1;
        return artefatto.getAttuatori().get(i);
    }
}
