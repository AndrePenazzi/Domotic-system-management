package it.unibs.fp.view.classiDiServizio.utenti;


import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliari;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioListaCategorie;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioUnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioUnitaImmobiliari;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.MyMenu;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.model.utenti.Manutentore;


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
                    //   stampaMenuSalvataggiLibrerie(contenitore);
                }

                case 6: {
                    //stampaMenuImportLibrerie(contenitore);
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
                    stampaMenuVisualizzazioneCaratteristicheUnitaImmobiliare(unitaImmobiliari);
                }
            }
        } while (!finito);

    }


    private static void stampaMenuVisualizzazioneCaratteristicheUnitaImmobiliare(UnitaImmobiliari unitaImmobiliari) {
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
                    visualizzaStanze(unitaImmobiliari);
                }
                break;

                case 2: {
                    visualizzaArtefatti(unitaImmobiliari);
                }
                break;
                //TODO TODO TODO
                case 3:
                    break;

            }
        } while (!finito);
    }

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

    /**
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


    public static void visualizzaStanze(UnitaImmobiliari unitaImmobiliari) {
        do {
            UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(unitaImmobiliari);
            ClasseDiServizioUnitaImmobiliare.visualizzaStanze(unitaImmobiliare);
        } while (InputDati.yesOrNo("Vuoi visualizzare le stanze di un'altra unita immobiliare?"));
    }

    public static void visualizzaArtefatti(UnitaImmobiliari unitaImmobiliari) {
        do {
            UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(unitaImmobiliari);
            ClasseDiServizioUnitaImmobiliare.visualizzaArtefatti(unitaImmobiliare);
        } while (InputDati.yesOrNo("Vuoi visualizzare gli artefatti di un'altra unita immobiliare?"));
    }


    public static String visualizzaListaUnitaImmobiliari(UnitaImmobiliari unitaImmobiliari) {
        return ClasseDiServizioUnitaImmobiliari.visualizzaUnitaImmobiliari( unitaImmobiliari);
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

    private static void associaSensoreAstanze(UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
        ClasseDiServizioUnitaImmobiliare.associaAttuatoreAStanze(unitaImmobiliare, listaCategorie);
    }

    private static void associaAttuatoreAstanze(UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
        ClasseDiServizioUnitaImmobiliare.associaAttuatoreAStanze(unitaImmobiliare, listaCategorie);
    }

    private static void associaSensoreAdArtefatti(UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
        ClasseDiServizioUnitaImmobiliare.associaSensoreAdArtefatti(unitaImmobiliare, listaCategorie);
    }

    private static void associaAttuatoreAdArtefatti(UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
        ClasseDiServizioUnitaImmobiliare.associaAttuatoreAdArtefatti(unitaImmobiliare, listaCategorie);
    }

    private static void associaArtefattoAStanze(UnitaImmobiliare unitaImmobiliare) {
        ClasseDiServizioUnitaImmobiliare.associaArtefattoAStanze(unitaImmobiliare);
    }

    public static UnitaImmobiliare scegliUnitaImmobiliare(UnitaImmobiliari unitaImmobiliari) {
        return ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(unitaImmobiliari);
    }
}
