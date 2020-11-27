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

    /**
     * Crea e inserisci nuove regole
     *
     * @param unitaImmobiliare nella quale inserire regole
     */
    public static void creaEInserisciRegole(UnitaImmobiliare unitaImmobiliare) {
        ClasseDiServizioRegole.creaEInserisciRegole(unitaImmobiliare);
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

    /**
     * Menu scelta attuatore
     *
     * @param unitaImmobiliare per la scelta del sensore
     * @return attuatore scelto
     */
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

    /**
     * Menu scelta sensore
     *
     * @param unitaImmobiliare per la scelta del sensore
     * @return sensore scelto
     */
    public static Sensore scegliSensore(UnitaImmobiliare unitaImmobiliare) {
        Sensore sensore = null;
        String[] sensore_menu = {"Scegli sensore nella stanza", "Scegli sensore nell'artefatto di una stanza", "Scegli sensore nell'artefatto"};
        MyMenu menu = new MyMenu("Menu scelta SENSORE", sensore_menu);

        int scelta = menu.scegliPerMenuSenzaUscita();
        switch (scelta) {

            case 1: {
                Stanza stanza = scegliStanza(unitaImmobiliare);
                sensore = ClasseDiServizioStanza.scegliSensoreNellaStanza(stanza);
            }
            break;

            case 2: {
                Stanza stanza = scegliStanza(unitaImmobiliare);
                sensore = scegliSensoreNellArtefattoNellaStanza(stanza);
            }
            break;

            case 3: {
                Artefatto artefatto = scegliArtefatto(unitaImmobiliare);
                sensore = ClasseDiServizioArtefatto.scegliSensoreNellArtefatto(artefatto);
            }
            break;
        }
        return sensore;
    }

    /**
     * Scegli un attuatore nella stanza
     *
     * @param stanza nella quale scegliere un attuatore
     * @return l'attuatore scelto
     */
    public static Attuatore scegliAttuatoreNellaStanza(Stanza stanza) {
        return ClasseDiServizioStanza.scegliAttuatoreNellaStanza(stanza);
    }

    /**
     * Scegli l'attuatore nell'artefatto nella stanza
     *
     * @param stanza nel quale sceglie l'attuatore in un artefatto
     * @return l'attuatore scelto
     */
    public static Attuatore scegliAttuatoreNellArtefattoNellaStanza(Stanza stanza) {
        Artefatto artefatto = ClasseDiServizioStanza.scegliArtefattoNellaStanza(stanza);
        return ClasseDiServizioStanza.scegliAttuatoreNellArtefatto(artefatto);
    }

    /**
     * Scegli un attuatore nell'artefatto
     *
     * @param artefatto nel quale scegliere un attuatore
     * @return l'attuatore da scegliere
     */
    public static Attuatore scegliAttuatoreNellArtefatto(Artefatto artefatto) {
        return ClasseDiServizioArtefatto.scegliAttuatoreNellArtefatto(artefatto);
    }

    /**
     * Scegli il sensore nell' artefatto nella stanza
     *
     * @param stanza per la scelta del sensore nell'artefatto
     * @return sensore
     */
    public static Sensore scegliSensoreNellArtefattoNellaStanza(Stanza stanza) {
        Artefatto artefatto = ClasseDiServizioStanza.scegliArtefattoNellaStanza(stanza);
        return ClasseDiServizioStanza.scegliSensoreNellArtefatto(artefatto);
    }

    public static Regola scegliRegola(UnitaImmobiliare unitaImmobiliare) {
        return ClasseDiServizioRegole.scegliRegola(unitaImmobiliare.getRegole());
    }

    /**
     * Scegli indice regola
     *
     * @param unitaImmobiliare per la scelta dell'unita immobiliare
     * @return l'indice dell'unità immobiliare
     */
    public static int scegliIndexRegola(UnitaImmobiliare unitaImmobiliare) {
        return ClasseDiServizioRegole.scegliIndexRegola(unitaImmobiliare.getRegole());
    }

    /**
     * Scegli la stanza
     *
     * @param unitaImmobiliare nella quale scegliere la stanza
     * @return la stanza scelta
     */
    public static Stanza scegliStanza(UnitaImmobiliare unitaImmobiliare) {
        System.out.println(ClasseDiServizioStanze.descrizioneNomeStanze(unitaImmobiliare.getStanze()));
        int i = InputDati.leggiIntero("Scegli la stanza: ", 1, unitaImmobiliare.getSizeStanze()) - 1;

        return unitaImmobiliare.getStanza(i);
    }

    /**
     * Scegli le stanze
     *
     * @param unitaImmobiliare dalla quale scegliere le stanze
     * @return le stanze scelte
     */
    public static Stanze scegliStanze(UnitaImmobiliare unitaImmobiliare) {
        Stanze stanze = new Stanze();
        do {
            stanze.inserisciStanza(scegliStanza(unitaImmobiliare));
        } while (InputDati.yesOrNo("Vuoi scegliere un'altra stanza?"));
        return stanze;
    }

    /**
     * Scegli un artefatto
     *
     * @param unitaImmobiliare nella quale scegliere un artefatto
     * @return l'artefatto scelto
     */
    public static Artefatto scegliArtefatto(UnitaImmobiliare unitaImmobiliare) {
        System.out.println(ClasseDiServizioArtefatti.visualizzaNomeArtefatti(unitaImmobiliare.getArtefattiInUnitaImmobiliare()));
        int i = InputDati.leggiIntero("Scegli l'artefatto: ", 1, unitaImmobiliare.getSizeArtefatti()) - 1;

        return unitaImmobiliare.getArtefatto(i);
    }

    /**
     * Scegli gli artefatti
     *
     * @param unitaImmobiliare dal quale scegliere artefatti
     * @return artefatti scelti
     */
    public static Artefatti scegliArtefatti(UnitaImmobiliare unitaImmobiliare) {
        System.out.println("Si scelgano ora gli artefatti");
        Artefatti artefatti = new Artefatti();
        do {
            artefatti.inserisciArtefatto(scegliArtefatto(unitaImmobiliare));
        } while (InputDati.yesOrNo("Vuoi scegliere un'altro artefatto?"));
        return artefatti;
    }

    public static Artefatto scegliArtefattoNellaStanza(UnitaImmobiliare unitaImmobiliare) {
        Stanza stanza = scegliStanza(unitaImmobiliare);
        return ClasseDiServizioStanza.scegliArtefattoNellaStanza(stanza);
    }

    ////////////////////////////////////FINE SCELTA/////////////////////////////////////////////////

    ////////////////////////////////////INIZIO VISUALIZZA/////////////////////////////////////////////////

    public static String descriviValoreRilevatoDaUnSensore(UnitaImmobiliare unitaImmobiliare) {
        Sensore sensore = scegliSensore(unitaImmobiliare);
        return ClasseDiServizioSensore.visualizzaValoreRilevati(sensore);
    }

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

    /**
     * Descrivi regole in unita immobiliare
     *
     * @param unitaImmobiliare per prendere le regole
     * @return descrizione regole
     */
    public static String descriviRegole(UnitaImmobiliare unitaImmobiliare) {
        Regole regole = unitaImmobiliare.getRegole();
        StringBuilder str = new StringBuilder();
        str.append(ClasseDiServizioRegole.descriviRegole(regole));
        return str.toString();
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

    /**
     * Descrizione degli artefatti
     *
     * @param unitaImmobiliare per descrivere gli artefatti
     */
    public static void descrizioneArtefatti(UnitaImmobiliare unitaImmobiliare) {
        System.out.println(ClasseDiServizioArtefatti.toString(unitaImmobiliare.getArtefattiInUnitaImmobiliare()));
    }

    /**
     * Descrizione stanze
     *
     * @param unitaImmobiliare di cui visualizzare le stanze
     */
    public static void descrizioneStanze(UnitaImmobiliare unitaImmobiliare) {
        System.out.println(ClasseDiServizioStanze.toString(unitaImmobiliare.getStanze()));
    }

    public static String toString(UnitaImmobiliare unitaImmobiliare) {
        String nome = unitaImmobiliare.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n");
        tmp.append(nome);
        tmp.append("\n" + ClasseDiServizioStanze.toString(unitaImmobiliare.getStanze()));
        tmp.append("\n" + ClasseDiServizioArtefatti.toString(unitaImmobiliare.getArtefattiInUnitaImmobiliare()));
        return tmp.toString();
    }

    ////////////////////////////////////FINE VISUALIZZA/////////////////////////////////////////////////
    ////////////////////////////////////INIZIO ASSOCIA/////////////////////////////////////////////////

    /**
     * Associa un artefatto ad una o più stanze
     *
     * @param unitaImmobiliare nella quale scegliere l'artefatto e le stanze
     */
    public static void associaArtefattoAStanze(UnitaImmobiliare unitaImmobiliare) {
        if (!unitaImmobiliare.artefattiInUnitaImmobiliareIsEmpty())
            do {
                Artefatto artefatto = ClasseDiServizioUnitaImmobiliare.scegliArtefatto(unitaImmobiliare);
                Stanze stanze = ClasseDiServizioUnitaImmobiliare.scegliStanze(unitaImmobiliare);
                unitaImmobiliare.associaArtefattoAStanze(artefatto, stanze);
            } while (InputDati.yesOrNo("Vuoi associare un'altro artefatto a stanze?"));
        else
            System.out.println("Bisogna prima creare un artefatto");

    }

    /**
     * Associa un nuovo sensore ad una o più stanze
     *
     * @param unitaImmobiliare nella quale scegliere le stanze
     * @param listaCategorie   per la creazione di sensori
     */
    public static void associaSensoreAStanze(UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
        if (!listaCategorie.categorieSensoriIsEmpty() && !unitaImmobiliare.stanzeIsEmpty()) {
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

    /**
     * Associa un nuovo attuatore ad una o più stanze
     *
     * @param unitaImmobiliare nella quale scegliere le stanze
     * @param listaCategorie   per la creazione di sensori
     */
    public static void associaAttuatoreAStanze(UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
        if (!listaCategorie.categorieAttuatoriIsEmpty() && !unitaImmobiliare.stanzeIsEmpty()) {
            do {
                Attuatore nuovoAttuatore = ClasseDiServizioAttuatore.creaAttuatore(listaCategorie);
                Stanze stanze = ClasseDiServizioUnitaImmobiliare.scegliStanze(unitaImmobiliare);
                unitaImmobiliare.associaAttuatoreAStanze(nuovoAttuatore, stanze);
            } while (InputDati.yesOrNo("Vuoi associare un'altro attuatore a stanze?"));
        } else {
            if (listaCategorie.categorieAttuatoriIsEmpty())
                System.out.println("Bisogna prima creare una categoria attuatori");
            if (unitaImmobiliare.stanzeIsEmpty())
                System.out.println("Bisogna prima avere una stanza nell'unità immobiliare");
        }
    }

    /**
     * Associa Sensore ad artefatti
     *
     * @param unitaImmobiliare nel quale scegliere gli artefatti
     * @param listaCategorie   per la creazione di sensori
     */
    public static void associaSensoreAdArtefatti(UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
        if (!unitaImmobiliare.artefattiInUnitaImmobiliareIsEmpty() && !listaCategorie.categorieSensoriIsEmpty()) {
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
            if (listaCategorie.categorieSensoriIsEmpty())
                System.out.println("Bisogna prima creare una categoria sensori");
            if (unitaImmobiliare.artefattiInUnitaImmobiliareIsEmpty())
                System.out.println("Bisogna prima avere un artefatto nell'unità immobiliare");
        }
    }

    /**
     * Associa Attuatore ad Artefatti
     *
     * @param unitaImmobiliare nel quale scegliere gli artefatti
     * @param listaCategorie   per la creazione di attuatori
     */
    public static void associaAttuatoreAdArtefatti(UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
        if (!unitaImmobiliare.artefattiInUnitaImmobiliareIsEmpty() && !listaCategorie.categorieAttuatoriIsEmpty()) {
            do {
                Attuatore nuovoAttuatore = ClasseDiServizioAttuatore.creaAttuatore(listaCategorie);
                Artefatti artefatti = ClasseDiServizioUnitaImmobiliare.scegliArtefatti(unitaImmobiliare);
                unitaImmobiliare.associaAttuatoreAdArtefatti(nuovoAttuatore, artefatti);

            } while (InputDati.yesOrNo("Vuoi associare un'altro attuatore ad artefatti?"));
        } else {
            if (listaCategorie.categorieAttuatoriIsEmpty())
                System.out.println("Bisogna prima creare una categoria attuatori");
            if (unitaImmobiliare.artefattiInUnitaImmobiliareIsEmpty())
                System.out.println("Bisogna prima avere un artefatto nell'unità immobiliare");
        }
    }

    ////////////////////////////////////FINE ASSOCIA/////////////////////////////////////////////////
    public static void modificaModOperativeInUnaStanza(UnitaImmobiliare unitaImmobiliare) {
        ClasseDiServizioStanze.modificaModOperative(unitaImmobiliare.getStanze());
    }

    public static void modificaModOperativeInUnArtefatto(UnitaImmobiliare unitaImmobiliare) {
        ClasseDiServizioArtefatti.modificaModOperative(unitaImmobiliare.getArtefattiInUnitaImmobiliare());
    }


}