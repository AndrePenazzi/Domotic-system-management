package it.unibs.fp.view.classiDiServizio.unitaImmobiliare;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.regola.Regole;
import it.unibs.fp.model.unitaImmobiliare.*;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioAttuatore;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioSensore;
import it.unibs.fp.view.classiDiServizio.regola.ClasseDiServizioRegole;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.MyMenu;

public class ClasseDiServizioUnitaImmobiliare {
    ////////////////////////////////////INIZIA CREA/////////////////////////////////////////////////

    /**
     * Costruttore UnitaImmobiliare
     *
     * @return unitaImmobiliare creata
     */
    public static UnitaImmobiliare creaUnitaImmobiliare() {
        String nome;
        nome = InputDati.leggiStringaNonVuota("Inserisci nome nuova unita immobiliare: ");
        return new UnitaImmobiliare(nome);
    }


    public static Regole creaRegole(UnitaImmobiliare unitaImmobiliare) {
        return ClasseDiServizioRegole.creaRegole(unitaImmobiliare);
    }

    /**
     * CreaEInserisciStanze nell'unita immobiliare
     *
     * @param unitaImmobiliare nella quale creare ed inserire stanze
     */
    public static void creaEInserisciStanze(UnitaImmobiliare unitaImmobiliare) {
        ClasseDiServizioStanze.creaEInserisciStanze(unitaImmobiliare);
    }

    /**
     * CreaEInserisciArtefatti nell'unita immobiliare
     *
     * @param unitaImmobiliare nella quale creare ed inserire artefatti
     */
    public static void creaEInserisciArtefatti(UnitaImmobiliare unitaImmobiliare) {
        ClasseDiServizioArtefatti.creaEInserisciArtefatti(unitaImmobiliare);
    }
    ////////////////////////////////////FINE CREA/////////////////////////////////////////////////

    ////////////////////////////////////INIZIA SCELTA/////////////////////////////////////////////////
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

    public static Regola scegliRegola(UnitaImmobiliare unitaImmobiliare) {
        return ClasseDiServizioRegole.scegliRegola(unitaImmobiliare.getRegole());
    }

    public static int scegliIndexRegola(UnitaImmobiliare unitaImmobiliare) {
        return ClasseDiServizioRegole.scegliIndexRegola(unitaImmobiliare.getRegole());
    }

    public static Stanza scegliStanza(UnitaImmobiliare unitaImmobiliare) {
        System.out.println(ClasseDiServizioStanze.toString(unitaImmobiliare.getStanze()));
        int i = InputDati.leggiIntero("Scegli la stanza: ", 1, unitaImmobiliare.getSizeStanze()) - 1;

        return unitaImmobiliare.getStanza(i);
    }

    public static Stanze scegliStanze(UnitaImmobiliare unitaImmobiliare) {
        System.out.println("Si scelga ora le stanze");
        Stanze stanze = new Stanze();
        do {
            stanze.getStanze().add(scegliStanza(unitaImmobiliare));
        } while (InputDati.yesOrNo("Vuoi scegliere un'altra stanza?"));
        return stanze;
    }

    public static Artefatto scegliArtefatto(UnitaImmobiliare unitaImmobiliare) {
        System.out.println(ClasseDiServizioArtefatti.toString(unitaImmobiliare.getArtefattiInUnitaImmobiliare()));
        int i = InputDati.leggiIntero("Scegli l'artefatto: ", 1, unitaImmobiliare.getSizeArtefatti()) - 1;

        return unitaImmobiliare.getArtefatto(i);
    }

    public static Artefatti scegliArtefatti(UnitaImmobiliare unitaImmobiliare) {
        System.out.println("Si scelgano ora gli artefatti");
        Artefatti artefatti = new Artefatti();
        do {
            artefatti.getArtefatti().add(scegliArtefatto(unitaImmobiliare));
        } while (InputDati.yesOrNo("Vuoi scegliere un'altro artefatto?"));
        return artefatti;
    }

    public static Artefatto scegliArtefattoNellaStanza(UnitaImmobiliare unitaImmobiliare) {
        Stanza stanza = scegliStanza(unitaImmobiliare);
        return ClasseDiServizioStanza.scegliArtefattoNellaStanza(stanza);
    }

    ////////////////////////////////////FINE SCELTA/////////////////////////////////////////////////

    ////////////////////////////////////INIZIO VISUALIZZA/////////////////////////////////////////////////

    public static String visualizzaAttuatori(UnitaImmobiliare unitaImmobiliare) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(ClasseDiServizioStanze.visualizzaAttuatori(unitaImmobiliare.getStanze()));
        tmp.append(ClasseDiServizioArtefatti.visualizzaAttuatori(unitaImmobiliare.getArtefattiInUnitaImmobiliare()));
        return tmp.toString();
    }

    public static String visualizzaSensori(UnitaImmobiliare unitaImmobiliare) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(ClasseDiServizioStanze.visualizzaSensori(unitaImmobiliare.getStanze()));
        tmp.append(ClasseDiServizioArtefatti.visualizzaSensori(unitaImmobiliare.getArtefattiInUnitaImmobiliare()));
        return tmp.toString();
    }

    public static void visualizzaValoriRilevati(UnitaImmobiliare unitaImmobiliare) {
        System.out.println(ClasseDiServizioStanze.visualizzaValoriRilevati(unitaImmobiliare.getStanze()));
        System.out.println(ClasseDiServizioArtefatti.visualizzaValoriRilevati(unitaImmobiliare.getArtefattiInUnitaImmobiliare()));
    }


    public static String visualizzaRegole(UnitaImmobiliare unitaImmobiliare) {
        Regole regole = unitaImmobiliare.getRegole();
        StringBuilder str = new StringBuilder();
        str.append(ClasseDiServizioRegole.visualizzaRegole(regole));

        return str.toString();
    }

    public static void visualizzaStanze(UnitaImmobiliare unitaImmobiliare) {
        System.out.println(ClasseDiServizioStanze.descrizioneNomeStanze(unitaImmobiliare.getStanze()));
    }

    public static void visualizzaArtefatti(UnitaImmobiliare unitaImmobiliare) {
        System.out.println(ClasseDiServizioArtefatti.descrizioneNomeArtefatti(unitaImmobiliare.getArtefattiInUnitaImmobiliare()));
    }

    /**
     * Descrivi il nome dell'unità immobiliare
     *
     * @param unitaImmobiliare dal quale prendere il nome
     * @return il nome dell'unità immobiliare
     */
    public static String descrizioneNomeUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) {
        return unitaImmobiliare.getNome();
    }

    public static String toString(UnitaImmobiliare unitaImmobiliare) {
        String nome = unitaImmobiliare.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n");
        tmp.append(nome);
        tmp.append(ClasseDiServizioStanze.toString(unitaImmobiliare.getStanze()));
        tmp.append(ClasseDiServizioArtefatti.toString(unitaImmobiliare.getArtefattiInUnitaImmobiliare()));
        return tmp.toString();
    }

    ////////////////////////////////////FINE VISUALIZZA/////////////////////////////////////////////////
    ////////////////////////////////////INIZIO ASSOCIA/////////////////////////////////////////////////

    public static void associaArtefattoAStanze(UnitaImmobiliare unitaImmobiliare) {
        if (!unitaImmobiliare.getArtefattiInUnitaImmobiliare().getArtefatti().isEmpty())
            do {
                Artefatto artefatto = ClasseDiServizioUnitaImmobiliare.scegliArtefatto(unitaImmobiliare);
                Stanze stanze = ClasseDiServizioUnitaImmobiliare.scegliStanze(unitaImmobiliare);
                unitaImmobiliare.associaArtefattoAStanze(artefatto, stanze);
            } while (InputDati.yesOrNo("Vuoi associare un'altro artefatto a stanze?"));
        else
            System.out.println("Bisogna prima creare un artefatto");

    }

    public static void associaSensoreAStanze(UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
        if (!listaCategorie.getCategorieSensori().isEmpty() && !unitaImmobiliare.getStanze().isEmpty()) {
            do {
                Sensore nuovoSensore = ClasseDiServizioSensore.creaSensore(listaCategorie);
                Stanze stanze = ClasseDiServizioUnitaImmobiliare.scegliStanze(unitaImmobiliare);
                unitaImmobiliare.associaSensoreAStanze(nuovoSensore, stanze);
            } while (InputDati.yesOrNo("Vuoi associare un'altro sensore a una stanza?"));
        } else {
            if (listaCategorie.categorieAttuatoriIsEmpty())
                System.out.println("Bisogna prima creare una categoria sensori");
            if (unitaImmobiliare.stanzeIsEmpty())
                System.out.println("Bisogna prima avere una stanza nell'unità immobiliare");
        }
    }

    public static void associaAttuatoreAStanze(UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
        if (!listaCategorie.getCategorieAttuatori().isEmpty() && !unitaImmobiliare.getStanze().isEmpty()) {
            do {
                Attuatore nuovoAttuatore = ClasseDiServizioAttuatore.creaAttuatore(listaCategorie);
                Stanze stanze = ClasseDiServizioUnitaImmobiliare.scegliStanze(unitaImmobiliare);
                unitaImmobiliare.associaAttuatoreAStanze(nuovoAttuatore, stanze);
            } while (InputDati.yesOrNo("Vuoi associare un'altro sensore a stanze?"));
        } else {
            if (listaCategorie.categorieAttuatoriIsEmpty())
                System.out.println("Bisogna prima creare una categoria attuatori");
            if (unitaImmobiliare.stanzeIsEmpty())
                System.out.println("Bisogna prima avere una stanza nell'unità immobiliare");
        }
    }

    public static void associaSensoreAdArtefatti(UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
        if (!unitaImmobiliare.getArtefattiInUnitaImmobiliare().getArtefatti().isEmpty() && !listaCategorie.getCategorieSensori().isEmpty()) {
            do {
                Sensore nuovoSensore = ClasseDiServizioSensore.creaSensore(listaCategorie);
                Artefatti artefatti = ClasseDiServizioUnitaImmobiliare.scegliArtefatti(unitaImmobiliare);
                for (Artefatto a : artefatti.getArtefatti())
                    for (Sensore s : a.getSensoriInArtefatto().getSensori())
                        if (nuovoSensore.getCategoriaSensori() == s.getCategoriaSensori())
                            System.out.println("Esite già un sensore con la stessa categoria in uno degli artefatti");

                unitaImmobiliare.associaSensoreAdArtefatti(nuovoSensore, artefatti);
            } while (InputDati.yesOrNo("Vuoi associare un'altro sensore ad artefatti?"));
        } else {
            if (listaCategorie.getCategorieSensori().isEmpty())
                System.out.println("Bisogna prima creare una categoria sensori");
            if (unitaImmobiliare.getArtefattiInUnitaImmobiliare().getArtefatti().isEmpty())
                System.out.println("Bisogna prima avere un artefatto nell'unità immobiliare");
        }
    }

    public static void associaAttuatoreAdArtefatti(UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
        if (!unitaImmobiliare.getArtefattiInUnitaImmobiliare().getArtefatti().isEmpty() && !listaCategorie.getCategorieAttuatori().isEmpty()) {
            do {
                Attuatore nuovoAttuatore = ClasseDiServizioAttuatore.creaAttuatore(listaCategorie);
                Artefatti artefatti = ClasseDiServizioUnitaImmobiliare.scegliArtefatti(unitaImmobiliare);
                unitaImmobiliare.associaAttuatoreAdArtefatti(nuovoAttuatore, artefatti);

            } while (InputDati.yesOrNo("Vuoi associare un'altro attuatore ad artefatti?"));
        } else {
            if (listaCategorie.getCategorieAttuatori().isEmpty())
                System.out.println("Bisogna prima creare una categoria attuatori");
            if (unitaImmobiliare.getArtefattiInUnitaImmobiliare().getArtefatti().isEmpty())
                System.out.println("Bisogna prima avere un artefatto nell'unità immobiliare");
        }
    }

    ////////////////////////////////////FINE ASSOCIA/////////////////////////////////////////////////
    public static void modificaModOperativeInUnaStanza(UnitaImmobiliare unitaImmobiliare) {
        ClasseDiServizioStanze.modModOperative(unitaImmobiliare.getStanze());
    }

    public static void modificaModOperativeInUnArtefatto(UnitaImmobiliare unitaImmobiliare) {
        ClasseDiServizioArtefatti.modificaModOperative(unitaImmobiliare.getArtefattiInUnitaImmobiliare());
    }


}