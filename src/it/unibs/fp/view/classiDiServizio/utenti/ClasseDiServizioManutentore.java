package it.unibs.fp.view.classiDiServizio.utenti;

import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliari;
import it.unibs.fp.model.utenti.Manutentore;
import it.unibs.fp.view.classiDiServizio.ClasseDiServizioDAO;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioListaCategorie;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioUnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioUnitaImmobiliari;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.MyMenu;


public class ClasseDiServizioManutentore {
    public static Manutentore creaManutentore() {
        String nomeManutentore = InputDati.leggiStringaNonVuota("Inserisci il nome del manutentore:\n");
        return new Manutentore(nomeManutentore);
    }

    public static void stampaMenuManutentore(UnitaImmobiliari unitaImmobiliari, ListaCategorie listaCategorie) {
        boolean finito = false;
        String[] azione = {"Operazioni su un'unità immobiliare", "Inserisci unità immobiliare", "Inserisci categorie sensori/attuatori", "Visualizza categorie di sensori/attuatori", "Operazioni di import", "Operazioni di salvataggio"};
        MyMenu menu = new MyMenu("Menu manutentore", azione);
        do {
            int scelta = menu.scegli();
            switch (scelta) {
                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu principale");
                    //salvataggio
                    ClasseDiServizioDAO.salvaListaCategorie(listaCategorie);
                    //salvataggio
                    ClasseDiServizioDAO.salvaUnitaImmboliari(unitaImmobiliari);
                }
                break;

                case 1: {
                    stampaMenuManutentoreOperazioniSuUnitaImmobiliare(unitaImmobiliari, listaCategorie);
                }
                break;

                case 2: {
                    inserisciUnitaImmobiliare(unitaImmobiliari);
                }
                break;

                case 3: {
                    stampaMenuInserisciCategorie(listaCategorie);
                }
                break;

                case 4: {
                    stampaMenuVisualizzazioneCategorie(listaCategorie);
                }
                break;
                case 5: {
                    //stampaMenuImportLibrerie(contenitore);
                }

                case 6: {
                    //   stampaMenuSalvataggiLibrerie(contenitore);
                }
                break;
            }
        } while (!finito);
    }


    private static void stampaMenuManutentoreOperazioniSuUnitaImmobiliare(UnitaImmobiliari unitaImmobiliari, ListaCategorie listaCategorie) {
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(unitaImmobiliari);
        boolean finito = false;
        String[] azione = {"Inserisci nuova stanza", "Inserisci nuovo artefatto", "Associa sensore a stanze", "Associa attuatore a stanze", "Associa sensore ad artefatto", "Associa attuatore ad artefatto", "Associa artefatto a stanze", "Visualizza caratteristiche unità immobiliare"};
        MyMenu menu = new MyMenu("Menu manutentore", azione);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu principale");
                    //salvataggio
                    ClasseDiServizioDAO.salvaListaCategorie(listaCategorie);
                    //salvataggio
                    ClasseDiServizioDAO.salvaUnitaImmboliari(unitaImmobiliari);
                }
                break;


                case 1: {
                    creaNuoveStanze(unitaImmobiliare);
                }
                break;

                case 2: {
                    creaNuoviArtefatti(unitaImmobiliare);
                }
                break;

                case 3: {
                    associaSensoreAstanze(unitaImmobiliare, listaCategorie);
                }
                break;

                case 4: {
                    associaAttuatoreAstanze(unitaImmobiliare, listaCategorie);
                }
                break;

                case 5: {
                    associaSensoreAdArtefatti(unitaImmobiliare, listaCategorie);
                }
                break;

                case 6: {
                    associaAttuatoreAdArtefatti(unitaImmobiliare, listaCategorie);
                }
                break;

                case 7: {
                    associaArtefattoAStanze(unitaImmobiliare);
                }
                break;

                case 8: {
                    stampaMenuVisualizzazioneCaratteristicheUnitaImmobiliare(unitaImmobiliare);
                }
            }
        } while (!finito);

    }


    private static void stampaMenuVisualizzazioneCaratteristicheUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) {
        boolean finito = false;
        String[] azione = {"Visualizza stanze", "Visualizza artefatti", "Visualizza valore rilevato da un sensore"};
        MyMenu menu = new MyMenu("Menu manutentore", azione);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu principale");
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
                //TODO TODO TODO
                case 3:
                    break;

            }
        } while (!finito);
    }

    /**
     * Stampa il menu per inserire nuove categorie
     *
     * @param listaCategorie nella quale inserire nuove categorie
     */
    private static void stampaMenuInserisciCategorie(ListaCategorie listaCategorie) {
        boolean finito = false;
        String[] azione = {"Inserisci e salva categoria sensori", "Inserisci e salva categoria attuatori"};
        MyMenu menu = new MyMenu("Menu manutentore", azione);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu principale");
                }
                break;
                case 1: {
                    inserisciESalvaNuovaCategoriaDiSensori(listaCategorie);
                }
                break;
                case 2: {
                    inserisciESalvaNuovaCategoriaDiAttuatori(listaCategorie);
                }
                break;
            }

        } while (!finito);
    }

    /**
     * Stampa il menu per visualizzare le categorie
     *
     * @param listaCategorie contentente le categorie sensori ed attuatori
     */
    private static void stampaMenuVisualizzazioneCategorie(ListaCategorie listaCategorie) {
        boolean finito = false;
        String[] azione = {"Visualizza categorie sensori", "Visualizza categorie attuatori"};
        MyMenu menu = new MyMenu("Menu manutentore", azione);
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

    /*
    private static void stampaMenuSalvataggiLibrerie(Contenitore contenitore) {
        boolean finito = false;
        String[] azione = {"Salva categorie sensori", "Salva categorie attuatori", "Salva unità immobiliare", "Salva regole"};
        MyMenu menu = new MyMenu("Menu salvataggio librerie", azione);
        Manutentore manutentore = contenitore.getManutentore();
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu principlae");

                }
                break;

                case 1: {
                    String nomeLibreria = InputDati.leggiStringaNonVuota("Inserire nome della libreria di sensori da salvare: ");
                    ServizioFile.salvaSingoloOggetto(new File(nomeLibreria + ".dat"), contenitore.getListaCategorie().getCategorieSensori());
                }
                break;

                case 2: {
                    String nomeLibreria = InputDati.leggiStringaNonVuota("Inserire nome della libreria di attuatori da salvare: ");
                    ServizioFile.salvaSingoloOggetto(new File(nomeLibreria + ".dat"), contenitore.getListaCategorie().getCategorieAttuatori());
                }
                break;

                case 3: {
                    String nomeLibreria = InputDati.leggiStringaNonVuota("Inserire nome della libreria della unità immobiliare da salvare: ");
                    UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(manutentore.getUnitaImmobiliari());
                    ServizioFile.salvaSingoloOggetto(new File(nomeLibreria + ".dat"), unitaImmobiliare);
                }
                break;

                case 4: {
                    String nomeLibreria = InputDati.leggiStringaNonVuota("Inserire nome della libreria di regole da salvare: ");

                    ServizioFile.salvaSingoloOggetto(new File(nomeLibreria + ".dat"), contenitore.getListaCategorie().getCategorieSensori());
                }
                break;
            }
        } while (!finito);
    }*/


    //TODO PENSACI TU

    /*
     * Menu importa librerie
     *
     * @param contenitore per gli oggetti necessari
     */
    /*
    private static void stampaMenuImportLibrerie(Contenitore contenitore) {
        boolean finito = false;
        String[] azione = {"Importa categorie di sensori", "Importa categorie di attuatori", "Importa unità immobiliare", "Importa set di regole"};
        MyMenu menu = new MyMenu("Menu salvataggio librerie", azione);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu principlae");

                }
                break;

                case 1: {
                }
                break;

                case 2: {
                }
                break;

                case 3: {
                }
                break;

                case 4: {
                }
                break;
            }
        }
        while (!finito);
    }

*/

    /**
     * Visualizza la descrizione dei sensori delle categorie sensori
     *
     * @param listaCategorie scelta
     * @return la descrizione delle categorie sensori
     */
    public static String visualizzaDescrizioneCatergorieSensori(ListaCategorie listaCategorie) {
        return ClasseDiServizioListaCategorie.descrizioneCategorieSensori(listaCategorie);
    }

    /**
     * Visualizza la descrizione degli attuatori delle categorie attuatori
     *
     * @param listaCategorie scelta
     * @return la descrizione delle categorie attuatori
     */
    public static String visualizzaDescrizioneCatergorieAttuatori(ListaCategorie listaCategorie) {
        return ClasseDiServizioListaCategorie.descrizioneCategorieAttuatori(listaCategorie);
    }

    /**
     * Descrizione stanze
     *
     * @param unitaImmobiliare da cui prendere le stanze
     */
    public static void descrizioneStanze(UnitaImmobiliare unitaImmobiliare) {
        ClasseDiServizioUnitaImmobiliare.descrizioneStanze(unitaImmobiliare);
    }

    /**
     * Descrizione Artefatti
     *
     * @param unitaImmobiliare per visualizzare i suoi arteffati
     */
    public static void descrizioneArtefatti(UnitaImmobiliare unitaImmobiliare) {
        ClasseDiServizioUnitaImmobiliare.descrizioneArtefatti(unitaImmobiliare);
    }
    //TODO salvataggio su File

    /**
     * inserisciESalvaNuovaCategoriaDiSensori
     *
     * @param listaCategorie nel quale salvare
     */
    public static void inserisciESalvaNuovaCategoriaDiSensori(ListaCategorie listaCategorie) {
        CategoriaSensori categoriaSensori = ClasseDiServizioListaCategorie.creaCategoriaSensori();
        listaCategorie.inserisciESalvaCategoriaSensori(categoriaSensori);
    }

    /**
     * inserisciESalvaNuovaCategoriaDiAttuatori
     *
     * @param listaCategorie nel quale salvare
     */
    public static void inserisciESalvaNuovaCategoriaDiAttuatori(ListaCategorie listaCategorie) {
        CategoriaAttuatori categoriaAttuatori = ClasseDiServizioListaCategorie.creaCategoriaAttuatori();
        listaCategorie.inserisciESalvaCategoriaAttuatori(categoriaAttuatori);
    }

    /**
     * Inserisci una nuova unita immobiliare
     *
     * @param unitaImmobiliari nella quale aggiungere un'unita immobiliare
     */
    public static void inserisciUnitaImmobiliare(UnitaImmobiliari unitaImmobiliari) {
        UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliare.creaUnitaImmobiliare();
        unitaImmobiliari.inserisciUnitaImmobiliare(unitaImmobiliare);
    }

    /**
     * Inserisci nuove stanze in un'unita immobiliare
     *
     * @param unitaImmobiliare nella quale inserire le stanze
     */
    private static void creaNuoveStanze(UnitaImmobiliare unitaImmobiliare) {
        ClasseDiServizioUnitaImmobiliare.creaEInserisciStanze(unitaImmobiliare);
    }

    /**
     * Inserisci nuovi artefatti in un'unita immobiliare
     *
     * @param unitaImmobiliare nella quale inserire gli artefatti
     */
    private static void creaNuoviArtefatti(UnitaImmobiliare unitaImmobiliare) {
        ClasseDiServizioUnitaImmobiliare.creaEInserisciArtefatti(unitaImmobiliare);
    }

    /**
     * Associa un nuovo sensore ad una o più stanze
     *
     * @param unitaImmobiliare nella quale scegliere le stanze
     * @param listaCategorie   per la categoria di sensori
     */
    private static void associaSensoreAstanze(UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
        ClasseDiServizioUnitaImmobiliare.associaSensoreAStanze(unitaImmobiliare, listaCategorie);
    }

    /**
     * Associa un nuovo attuatore ad una o più stanze
     *
     * @param unitaImmobiliare nella quale scegliere le stanze
     * @param listaCategorie   per la categoria di attuatori
     */
    private static void associaAttuatoreAstanze(UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
        ClasseDiServizioUnitaImmobiliare.associaAttuatoreAStanze(unitaImmobiliare, listaCategorie);
    }

    /**
     * Associa sensore ad artefatti
     *
     * @param unitaImmobiliare nel quale scegliere gli artefatti
     * @param listaCategorie   per la creazione di sensori
     */
    private static void associaSensoreAdArtefatti(UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
        ClasseDiServizioUnitaImmobiliare.associaSensoreAdArtefatti(unitaImmobiliare, listaCategorie);
    }

    /**
     * Associa attuatore ad artefatti
     *
     * @param unitaImmobiliare nel quale scegliere gli artefatti
     * @param listaCategorie   per la creazione di attuatori
     */
    private static void associaAttuatoreAdArtefatti(UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
        ClasseDiServizioUnitaImmobiliare.associaAttuatoreAdArtefatti(unitaImmobiliare, listaCategorie);
    }

    /**
     * Associa un artefatto a una o più stanze
     *
     * @param unitaImmobiliare nella quale scegliere l'artefatto e le stanze
     */
    private static void associaArtefattoAStanze(UnitaImmobiliare unitaImmobiliare) {
        ClasseDiServizioUnitaImmobiliare.associaArtefattoAStanze(unitaImmobiliare);
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
