package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.regola.Regole;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.model.unitaImmobiliare.Stanza;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.regola.ClasseDiServizioRegole;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.MyMenu;

import java.util.ArrayList;
import java.util.List;

public class ClasseDiServizioUnitaImmobiliare {
    public static UnitaImmobiliare creaUnitaImmobiliare() {
        String nome;
        nome = InputDati.leggiStringaNonVuota("Inserisci nome nuova unita immobiliare: ");
        return new UnitaImmobiliare(nome);
    }

    //TODO MANCANO I VISUALIZZA
    public static Attuatore scegliAttuatore(UnitaImmobiliare unitaImmobiliare) {
        Attuatore attuatore = null;
        String[] attuatore_menu = {"Scegli attuatore nella stanza", "Scegli attuatore nell'artefatto di una stanza", "Scegli attuatore nell'artefatto"};
        MyMenu menu = new MyMenu("Menu scelta ATTUATORE", attuatore_menu);

        int scelta = menu.scegliPerMenuSenzaUscita();
        switch (scelta) {

            case 1: {
                Stanza stanza = scegliStanza(unitaImmobiliare);
                attuatore = scegliAttuatoreNellaStanza(stanza);
            }
            break;

            case 2: {
                Stanza stanza = scegliStanza(unitaImmobiliare);
                attuatore = scegliAttuatoreNellArtefattoNellaStanza(stanza);
            }
            break;

            case 3: {
                Artefatto artefatto = scegliArtefatto(unitaImmobiliare);
                attuatore = scegliAttuatoreNellArtefatto(artefatto);
            }
            break;
        }

        return attuatore;
    }

    public static Attuatore scegliAttuatoreNellaStanza(Stanza stanza) {
        return ClasseDiServizioStanza.scegliAttuatoreNellaStanza(stanza);
    }

    public static Attuatore scegliAttuatoreNellArtefattoNellaStanza(Stanza stanza) {
        Artefatto artefatto = ClasseDiServizioStanza.scegliArtefattoNellaStanza(stanza);
        return ClasseDiServizioStanza.scegliAttuatoreNellArtefatto(artefatto);
    }

    public static Attuatore scegliAttuatoreNellArtefatto(Artefatto artefatto) {
        return ClasseDiServizioArtefatto.scegliAttuatoreNellArtefatto(artefatto);
    }


    public static String visualizzaAttuatori(UnitaImmobiliare unitaImmobiliare) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(ClasseDiServizioStanze.visualizzaAttuatori(unitaImmobiliare.getStanze()));
        tmp.append(ClasseDiServizioArtefatti.visualizzaAttuatori(unitaImmobiliare.getArtefatti()));
        return tmp.toString();
    }

    public static Sensore scegliSensore(UnitaImmobiliare unitaImmobiliare) {
        Sensore sensore = null;
        String[] sensore_menu = {"Scegli sensore nella stanza", "Scegli sensore nell'artefatto di una stanza", "Scegli sensore nell'artefatto"};
        MyMenu menu = new MyMenu("Menu scelta SENSORE", sensore_menu);

        int scelta = menu.scegliPerMenuSenzaUscita();
        switch (scelta) {

            case 1: {
                Stanza stanza = scegliStanza(unitaImmobiliare);
                sensore = scegliSensoreNellaStanza(stanza);
            }
            break;

            case 2: {
                Stanza stanza = scegliStanza(unitaImmobiliare);
                sensore = scegliSensoreNellArtefattoNellaStanza(stanza);
            }
            break;

            case 3: {
                Artefatto artefatto = scegliArtefatto(unitaImmobiliare);
                sensore = scegliSensoreNellArtefatto(artefatto);
            }
            break;
        }

        return sensore;
    }

    public static Sensore scegliSensoreNellaStanza(Stanza stanza) {
        return ClasseDiServizioStanza.scegliSensoreNellaStanza(stanza);
    }

    public static Sensore scegliSensoreNellArtefattoNellaStanza(Stanza stanza) {
        Artefatto artefatto = ClasseDiServizioStanza.scegliArtefattoNellaStanza(stanza);
        return ClasseDiServizioStanza.scegliSensoreNellArtefatto(artefatto);
    }

    public static Sensore scegliSensoreNellArtefatto(Artefatto artefatto) {
        return ClasseDiServizioArtefatto.scegliSensoreNellArtefatto(artefatto);
    }


    public static String visualizzaSensori(UnitaImmobiliare unitaImmobiliare) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(ClasseDiServizioStanze.visualizzaSensori(unitaImmobiliare.getStanze()));
        tmp.append(ClasseDiServizioArtefatti.visualizzaSensori(unitaImmobiliare.getArtefatti()));
        return tmp.toString();
    }

    //////////////////////////////////////////////////////////////////////////////
    public static String toString(UnitaImmobiliare unitaImmobiliare) {
        String nome = unitaImmobiliare.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n");
        tmp.append(nome);
        tmp.append(ClasseDiServizioStanze.toString(unitaImmobiliare.getStanze()));
        tmp.append(ClasseDiServizioArtefatti.toString(unitaImmobiliare.getArtefatti()));
        return tmp.toString();
    }

    public static String visualizzaRegole(UnitaImmobiliare unitaImmobiliare) {
        Regole regole = unitaImmobiliare.getRegole();
        StringBuilder str = new StringBuilder();
        str.append(ClasseDiServizioRegole.visualizzaRegole(regole));

        return str.toString();
    }

    public static Regola scegliRegola(UnitaImmobiliare unitaImmobiliare) {
       return ClasseDiServizioRegole.scegliRegola(unitaImmobiliare.getRegole());
    }

    public static int scegliIndexRegola(UnitaImmobiliare unitaImmobiliare) {
        return ClasseDiServizioRegole.scegliIndexRegola(unitaImmobiliare.getRegole());
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

    public static Artefatto scegliArtefattoNellaStanza(UnitaImmobiliare unitaImmobiliare) {
        Stanza stanza = scegliStanza(unitaImmobiliare);
        return ClasseDiServizioStanza.scegliArtefattoNellaStanza(stanza);
    }

    public static Regole creaRegole(UnitaImmobiliare unitaImmobiliare) {
        return ClasseDiServizioRegole.creaRegole(unitaImmobiliare);
    }
}