package it.unibs.fp.view.classiDiServizio.utenti;

import it.unibs.fp.dao.file.Contenitore;
import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliari;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.view.classiDiServizio.ClasseDiServizio;
import it.unibs.fp.view.classiDiServizio.ClasseDiServizioAssociazioni;
import it.unibs.fp.view.classiDiServizio.ClasseDiServizioInserimenti;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioCategoriaSensori;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioListaCategorie;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioStanze;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioUnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioUnitaImmobiliari;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.MyMenu;
import it.unibs.fp.view.mylib.ServizioFile;
import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.model.utenti.Manutentore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClasseDiServizioManutentore {
    public static Manutentore creaManutentore(){
        String nome=InputDati.leggiStringaNonVuota("Inserisci il nome del manutentore:\n");
        return new Manutentore(nome);
    }

    public static void stampaMenuManutentore(Manutentore manutentore) {
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
                    //stampaMenuManutentoreOperazioniSuUnitaImmobiliare(contenitore);
                }
                break;

                case 2: {
                    //ClasseDiServizioInserimenti.inserisciUnitaImmobiliare(contenitore);
                }
                break;

                case 3: {
                   // stampaMenuInserisciCategorie(contenitore.getListaCategorie());
                }
                break;

                case 4: {
                   // stampaMenuVisualizzazioneCategorie(contenitore);
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

/*
    private static void stampaMenuManutentoreOperazioniSuUnitaImmobiliare(Contenitore contenitore) {
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
                    ClasseDiServizioManutentore.inserisciNuovaStanza(contenitore);
                }
                break;

                case 2: {
                    ClasseDiServizioInserimenti.inserisciNuovoArtefatto(contenitore);
                }
                break;

                case 3: {
                    ClasseDiServizioAssociazioni.associaSensoreAStanze(contenitore);
                }
                break;

                case 4: {
                    ClasseDiServizioAssociazioni.associaAttuatoreAStanze(contenitore);
                }
                break;

                case 5: {
                    ClasseDiServizioAssociazioni.associaSensoreAdArtefatti(contenitore);
                }
                break;

                case 6: {
                    ClasseDiServizioAssociazioni.associaAttuatoreAdArtefatti(contenitore);
                }
                break;

                case 7: {
                    ClasseDiServizioAssociazioni.associaArtefattoAStanze(contenitore);
                }
                break;

                case 8: {
                    stampaMenuVisualizzazioneCaratteristicheUnitaImmobiliare(contenitore);
                }
            }
        } while (!finito);

    }
*/
    private static void stampaMenuVisualizzazioneCaratteristicheUnitaImmobiliare(Manutentore manutentore) {
        boolean finito = false;
        String[] azione = {"Visualizza stanze", "Visualizza artefatti", "Visualizza valore rilevato da un sensore"};
        MyMenu menu = new MyMenu("Menu fruitore", azione);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu principale");
                }
                break;


                case 3: {
                    visualizzaStanze(manutentore);
                }
                break;

                case 4: {
                    visualizzaArtefatti(manutentore);
                }
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

    /**
     * Menu di visualizzazione delle descrizioni da parte del manutentore
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    private static void stampaMenuVisualizzazioneCategorie(Contenitore contenitore) {
        boolean finito = false;
        String[] azione = {"Visualizza categorie sensori", "Visualizza categorie attuatori"};
        MyMenu menu = new MyMenu("Menu fruitore", azione);
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
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
     * Menu salvataggi librerie
     *
     * @param contenitore per gli oggetti necessari
     */
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
    }


    //TODO PENSACI TU
    /**
     * Menu importa librerie
     *
     * @param contenitore per gli oggetti necessari
     */
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


    /**
     * Visualizza la descrizione dei sensori delle categorie sensori
     *
     * @param listaCategorie scelta
     * @return la descrizione delle categorie sensori
     */
    public static String visualizzaDescrizioneCatergorieSensori(ListaCategorie listaCategorie) {
        return ClasseDiServizioListaCategorie.visualizzaCategorieSensori(listaCategorie);
    }

    /**
     * Visualizza la descrizione degli attuatori delle categorie attuatori
     *
     * @param listaCategorie scelta
     * @return la descrizione delle categorie attuatori
     */
    public static String visualizzaDescrizioneCatergorieAttuatori(ListaCategorie listaCategorie) {
        return ClasseDiServizioListaCategorie.visualizzaCategorieAttuatori(listaCategorie);
    }


    public static void visualizzaStanze(Manutentore manutentore) {
        Fruitore fruitore = manutentore.getFruitore();
        UnitaImmobiliari unitaImmobiliari = fruitore.getUnitaImmobiliariInFruitore();
        do {
            UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(unitaImmobiliari);
            ClasseDiServizioUnitaImmobiliare.visualizzaStanze(unitaImmobiliare);
        } while (InputDati.yesOrNo("Vuoi visualizzare le stanze di un'altra unita immobiliare?"));
    }

    public static void visualizzaArtefatti(Manutentore manutentore) {
        Fruitore fruitore = manutentore.getFruitore();
        UnitaImmobiliari unitaImmobiliari = fruitore.getUnitaImmobiliariInFruitore();
        do {
            UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(unitaImmobiliari);
            ClasseDiServizioUnitaImmobiliare.visualizzaArtefatti(unitaImmobiliare);
        } while (InputDati.yesOrNo("Vuoi visualizzare gli artefatti di un'altra unita immobiliare?"));
    }


    public static String visualizzaListaUnitaImmobiliari(Manutentore manutentore) {
        return ClasseDiServizioFruitore.visualizzaUnitaImmobiliari(manutentore.getFruitore());
    }
    //TODO salvataggio su File
    public static void inserisciESalvaNuovaCategoriaDiSensori(ListaCategorie listaCategorie) {
        CategoriaSensori categoriaSensori= ClasseDiServizioListaCategorie.creaCategoriaSensori();
        listaCategorie.inserisciESalvaCategoriaSensori(categoriaSensori);
    }

    public static void inserisciESalvaNuovaCategoriaDiAttuatori(ListaCategorie listaCategorie) {
        CategoriaAttuatori categoriaAttuatori= ClasseDiServizioListaCategorie.creaCategoriaAttuatori();
        listaCategorie.inserisciESalvaCategoriaAttuatori(categoriaAttuatori);
    }
}
