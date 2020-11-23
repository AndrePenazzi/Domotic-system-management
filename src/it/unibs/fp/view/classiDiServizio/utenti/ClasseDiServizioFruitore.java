package it.unibs.fp.view.classiDiServizio.utenti;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliari;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioListaCategorie;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioUnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioUnitaImmobiliari;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.MyMenu;

public class ClasseDiServizioFruitore {
    public static Fruitore creaFruitore() {
        String nome = InputDati.leggiStringaNonVuota("Inserisci il nome del fruitore:\n");
        return new Fruitore(nome);
    }

    public static void stampaMenuFruitore(UnitaImmobiliari unitaImmobiliari, ListaCategorie listaCategorie) {
        boolean finito = false;
        String[] azione = {"Operazioni di visualizzazione su un'unità immobiliare", "Operazioni su un'unità immobiliare", "Visualizza categorie"};
        MyMenu menu = new MyMenu("Menu fruitore", azione);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu principale");
                }
                break;

                case 1: {
                    stampaMenuFruitoreVisualizzazione(unitaImmobiliari);
                }
                break;

                case 2: {
                    stampaMenuOperazioniUnitaImmobiliare(unitaImmobiliari);
                }
                break;

                case 3: {
                    stampaMenuVisualizzazioneCategorie(listaCategorie);
                }
                break;
            }
        }
        while (!finito);
    }

    public static void stampaMenuFruitoreVisualizzazione(UnitaImmobiliari unitaImmobiliari) {
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(unitaImmobiliari);
        boolean finito = false;
        String[] azione = {"Visualizza stanze", "Visualizza artefatti", "Visualizza valore rilevato da un sensore"};
        MyMenu menu = new MyMenu("Menu fruitore", azione);

        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu fruitore");
                }
                break;

                case 1: {
                    descrizioneStanze(unitaImmobiliare);
                }
                break;

                case 2: {
                    descrizioneArtefatti(unitaImmobiliare);
                }
                break;

                case 3: {
                    visualizzaValoriRilevati(unitaImmobiliare);
                }
                break;

            }
        }
        while (!finito);
    }

    public static void stampaMenuOperazioniUnitaImmobiliare(UnitaImmobiliari unitaImmobiliari) {
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(unitaImmobiliari);
        boolean finito = false;
        String[] azione = {"Modifica modalità operativa di un attuatore in una stanza", "Modifica modalità operativa di un attuatore in un artefatto", "Aggiungi nuova regola", "Visualizza regole", "Modifica stato regola"};
        MyMenu menu = new MyMenu("Menu fruitore operazioni:", azione);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu fruitore");

                }
                break;

                case 1: {
                    if (InputDati.yesOrNo("Si vuole cambiare modalità operativa di un attautore in una stanza ?")) {
                        ClasseDiServizioUnitaImmobiliare.modificaModOperativeInUnaStanza(unitaImmobiliare);
                    }
                }
                break;
                case 2: {
                    if (InputDati.yesOrNo("Si vuole cambiare modalità operativa di un attautore in un artefatto ?")) {
                        ClasseDiServizioUnitaImmobiliare.modificaModOperativeInUnArtefatto(unitaImmobiliare);
                    }
                }
                break;

                case 3: {
                    creaEInserisciRegole(unitaImmobiliare);
                }
                break;

                case 4: {
                    descriviRegole(unitaImmobiliare);
                }
                break;

                case 5: {

                    cambiaStatoRegole(unitaImmobiliare);
                }
                break;
            }
        } while (!finito);
    }

    /**
     * Stampa il menu di visualizzazione di categorie
     *
     * @param listaCategorie da visualizzare
     */
    private static void stampaMenuVisualizzazioneCategorie(ListaCategorie listaCategorie) {
        boolean finito = false;
        String[] azione = {"Visualizza categorie sensori", "Visualizza categorie attuatori"};
        MyMenu menu = new MyMenu("Menu fruitore", azione);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu manutentore");

                }
                break;

                case 1: {
                    System.out.println(visualizzaDescrizioneCatergorieSensori(listaCategorie));
                }
                break;

                case 2: {
                    System.out.println(visualizzaDescrizioneCatergorieAttuatori(listaCategorie));
                }
                break;

            }
        } while (!finito);
    }

    /**
     * Crea e inserisci regole
     *
     * @param unitaImmobiliare nella quale inserire regole
     */
    public static void creaEInserisciRegole(UnitaImmobiliare unitaImmobiliare) {
        ClasseDiServizioUnitaImmobiliare.creaEInserisciRegole(unitaImmobiliare);
    }

    /**
     * Descrivi regole
     *
     * @param unitaImmobiliare per prendere le regole
     */
    public static void descriviRegole(UnitaImmobiliare unitaImmobiliare) {
        System.out.println(ClasseDiServizioUnitaImmobiliare.descriviRegole(unitaImmobiliare));
    }


    /**
     * Cambia lo stato di una o più regole
     *
     * @param unitaImmobiliare per la scelta di regole da modificare
     */
    public static void cambiaStatoRegole(UnitaImmobiliare unitaImmobiliare) {
        do {
            int regola = ClasseDiServizioUnitaImmobiliare.scegliIndexRegola(unitaImmobiliare);
            unitaImmobiliare.cambiaRegolaAttivaDisattiva(regola);
        } while (InputDati.yesOrNo("Vuoi modificare altre regole?"));
    }

    /**
     * Visualizza le categorie di sensori
     *
     * @param listaCategorie per visualizzare le categorie sensori
     * @return descrizione categorie sensori
     */
    public static String visualizzaDescrizioneCatergorieSensori(ListaCategorie listaCategorie) {
        return ClasseDiServizioListaCategorie.descrizioneCategorieSensori(listaCategorie);
    }

    /**
     * Visualizza le categorie di attuatori
     *
     * @param listaCategorie per visualizzare le categorie attuatori
     * @return descrizione categorie attuatori
     */
    public static String visualizzaDescrizioneCatergorieAttuatori(ListaCategorie listaCategorie) {
        return ClasseDiServizioListaCategorie.descrizioneCategorieAttuatori(listaCategorie);
    }

    /**
     * Descrizione delle stanze
     *
     * @param unitaImmobiliare scelta
     */
    public static void descrizioneStanze(UnitaImmobiliare unitaImmobiliare) {
        ClasseDiServizioUnitaImmobiliare.descrizioneStanze(unitaImmobiliare);
    }

    /**
     * Descrizione degli artefatti
     *
     * @param unitaImmobiliare scelta
     */
    public static void descrizioneArtefatti(UnitaImmobiliare unitaImmobiliare) {
        ClasseDiServizioUnitaImmobiliare.descrizioneArtefatti(unitaImmobiliare);
    }

    public static void visualizzaValoriRilevati(UnitaImmobiliare unitaImmobiliare) {
        ClasseDiServizioUnitaImmobiliare.visualizzaValoriRilevati(unitaImmobiliare);
    }

    /**
     * Scegli l'unita immobiliare
     *
     * @param unitaImmobiliari tra le quali scegliere
     * @return l'unita immobiliare scelta
     */
    public static UnitaImmobiliare scegliUnitaImmobiliare(UnitaImmobiliari unitaImmobiliari) {
        return ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(unitaImmobiliari);
    }
}
