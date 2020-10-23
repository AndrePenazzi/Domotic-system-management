package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.model.unitaImmobiliare.Stanza;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.mylib.InputDati;

import java.util.ArrayList;
import java.util.List;

public class ClasseDiServizioUnitaImmobiliare {
    public static UnitaImmobiliare creaUnitaImmobiliare() {
        String nome;
        nome = InputDati.leggiStringaNonVuota("Inserisci nome nuova unita immobiliare: ");
        return new UnitaImmobiliare(nome);
    }

    public static Stanza scegliStanza(UnitaImmobiliare unitaImmobiliare) {
        System.out.println(ClasseDiServizioStanze.toString(unitaImmobiliare.getStanze()));
        int i = InputDati.leggiIntero("Scegli la stanza: ", 1, unitaImmobiliare.getSizeStanze()) - 1;

        return unitaImmobiliare.getStanze().get(i);
    }

    public static List<Stanza> scegliStanze(UnitaImmobiliare unitaImmobiliare) {
        System.out.println("Si scelga ora le stanze");
        List<Stanza> stanze = new ArrayList<>();
        do {
            stanze.add(scegliStanza(unitaImmobiliare));
        } while (InputDati.yesOrNo("Vuoi scegliere un'altra stanza?"));
        return stanze;
    }

    public static Artefatto scegliArtefatto(UnitaImmobiliare unitaImmobiliare) {
        System.out.println(ClasseDiServizioArtefatti.toString(unitaImmobiliare.getArtefatti()));
        int i = InputDati.leggiIntero("Scegli l'artefatto: ", 1, unitaImmobiliare.getSizeArtefatti()) - 1;

        return unitaImmobiliare.getArtefatti().get(i);
    }

    public static List<Artefatto> scegliArtefatti(UnitaImmobiliare unitaImmobiliare) {
        System.out.println("Si scelgano ora gli artefatti");
        List<Artefatto> artefatti = new ArrayList<>();
        do {
            artefatti.add(scegliArtefatto(unitaImmobiliare));
        } while (InputDati.yesOrNo("Vuoi scegliere un'altro artefatto?"));
        return artefatti;
    }
    //TODO DA FARE
    public static Attuatore scegliAttuatore(UnitaImmobiliare unitaImmobiliare){

    }
    public static String visualizzaAttuatori(UnitaImmobiliare unitaImmobiliare){
        StringBuilder tmp = new StringBuilder();
        tmp.append(ClasseDiServizioStanze.visualizzaAttuatori(unitaImmobiliare.getStanze()));
        tmp.append(ClasseDiServizioArtefatti.visualizzaAttuatori(unitaImmobiliare.getArtefatti()));
        return tmp.toString();
    }

    public static String toString(UnitaImmobiliare unitaImmobiliare) {
        String nome = unitaImmobiliare.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n");
        tmp.append(nome);
        tmp.append(ClasseDiServizioStanze.toString(unitaImmobiliare.getStanze()));
        tmp.append(ClasseDiServizioArtefatti.toString(unitaImmobiliare.getArtefatti()));
        return tmp.toString();
    }
}
