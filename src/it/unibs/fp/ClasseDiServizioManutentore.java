package it.unibs.fp;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.ServizioFile;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class ClasseDiServizioManutentore {

    /**
     * Menu scelta manutentore con le varie possibilità
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void stampaMenuManutentore(Contenitore contenitore) {
        boolean finito = false;
        String[] azione = {"Operazioni su un'unità immobiliare", "Inserisci unità immobiliare", "Inserisci categorie sensori/attuatori", "Visualizza categorie di sensori/attuatori", "Operazioni di import"};
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
                    stampaMenuManutentoreOperazioniSuUnitaImmobiliare(contenitore);
                }
                break;

                case 2: {
                    ClasseDiServizioInserimenti.inserisciUnitaImmobiliare(contenitore);
                }
                break;

                case 3: {
                    stampaMenuInserisciCategorie(contenitore);
                }
                break;

                case 4: {
                    stampaMenuVisualizzazioneCategorie(contenitore);
                }

                case 5: {
                    stampaMenuSalvataggiLibrerie(contenitore);
                }

                case 6: {
                    stampaMenuImportLibrerie(contenitore);
                }
            }
        } while (!finito);
    }


    /**
     * Menu del manutentore per inserire ed assciare
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    private static void stampaMenuManutentoreOperazioniSuUnitaImmobiliare(Contenitore contenitore) {
        boolean finito = false;
        String[] azione = {"Inserisci e salva categoria sensori", "Inserisci e salva categoria attuatori", "Inserisci nuova stanza", "Inserisci nuovo artefatto", "Associa sensore a stanze", "Associa attuatore a stanze", "Associa sensore ad artefatto", "Associa attuatore ad artefatto", "Associa artefatto a stanze", "Visualizza caratteristiche unità immobiliare"};
        MyMenu menu = new MyMenu("Menu manutentore", azione);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu principale");
                }
                break;


                case 3: {
                    ClasseDiServizioInserimenti.inserisciNuovaStanza(contenitore);
                }
                break;

                case 4: {
                    ClasseDiServizioInserimenti.inserisciNuovoArtefatto(contenitore);
                }
                break;

                case 5: {
                    ClasseDiServizioAssociazioni.associaSensoreAStanze(contenitore);
                }
                break;

                case 6: {
                    ClasseDiServizioAssociazioni.associaAttuatoreAStanze(contenitore);
                }
                break;

                case 7: {
                    ClasseDiServizioAssociazioni.associaSensoreAdArtefatti(contenitore);
                }
                break;

                case 8: {
                    ClasseDiServizioAssociazioni.associaAttuatoreAdArtefatti(contenitore);
                }
                break;

                case 9: {
                    ClasseDiServizioAssociazioni.associaArtefattoAStanze(contenitore);
                }
                break;

                case 10: {
                    stampaMenuVisualizzazioneCaratteristicheUnitaImmobiliare(contenitore);
                }
            }
        } while (!finito);

    }

    /**
     * Menu di visualizzazione delle descrizioni da parte del manutentore
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    private static void stampaMenuVisualizzazioneCaratteristicheUnitaImmobiliare(Contenitore contenitore) {
        boolean finito = false;
        String[] azione = {"Visualizza stanze", "Visualizza artefatti", "Visualizza valore rilevato da un sensore"};
        MyMenu menu = new MyMenu("Menu fruitore", azione);
        Manutentore manutentore = contenitore.getManutentore();
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        UnitaImmobiliare unitaImmobiliare = ClasseDiServizioInserimenti.scegliUnitaImmobiliare(manutentore);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu principale");
                }
                break;


                case 3: {
                    System.out.println(manutentore.visualizzaStanze(unitaImmobiliare));
                }
                break;

                case 4: {
                    System.out.println(manutentore.visualizzaArtefatti(unitaImmobiliare));
                }
                break;

            }
        } while (!finito);
    }


    private static void stampaMenuInserisciCategorie(Contenitore contenitore) {
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
                    ClasseDiServizioInserimenti.inserisciESalvaCategioriaSensori(contenitore);
                }
                break;
                case 2: {
                    ClasseDiServizioInserimenti.inserisciESalvaCategioriaAttuatori(contenitore);
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
        Manutentore manutentore = contenitore.getManutentore();
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
                    System.out.println(manutentore.visualizzaDescrizioneCatergorieSensori(listaCategorie));
                }
                break;

                case 2: {
                    System.out.println(manutentore.visualizzaDescrizioneCatergorieAttuatori(listaCategorie));
                }
                break;

            }
        } while (!finito);
    }

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
                    UnitaImmobiliare unitaImmobiliare = ClasseDiServizioInserimenti.scegliUnitaImmobiliare(manutentore);
                    ServizioFile.salvaSingoloOggetto(new File(nomeLibreria + ".dat"), unitaImmobiliare);
                }
                break;

                //TODO Ancora da costruire
                case 4: {
                    String nomeLibreria = InputDati.leggiStringaNonVuota("Inserire nome della libreria di regole da salvare: ");

                    ServizioFile.salvaSingoloOggetto(new File(nomeLibreria + ".dat"), contenitore.getListaCategorie().getCategorieSensori());
                }
                break;
            }
        } while (!finito);
    }

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
                    String nomeLibreria = InputDati.leggiStringaNonVuota("Inserire nome della libreria di sensori da importare: ");
                    File categorieSensoriFile = new File(nomeLibreria + ".dat");

                    ArrayList<CategoriaSensori> categorieSensori = (ArrayList<CategoriaSensori>) ServizioFile.caricaSingoloOggetto(categorieSensoriFile);
                    if (categorieSensori != null) {
                        for (CategoriaSensori c : categorieSensori)
                            contenitore.getListaCategorie().inserisciESalvaCategoriaSensori(c);
                        ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
                    }
                }
                break;

                case 2: {
                    String nomeLibreria = InputDati.leggiStringaNonVuota("Inserire nome della libreria di attuatori da importare: ");
                    File categorieAttuatoriFile = new File(nomeLibreria + ".dat");

                    ArrayList<CategoriaAttuatori> categorieAttuatori = (ArrayList<CategoriaAttuatori>) ServizioFile.caricaSingoloOggetto(categorieAttuatoriFile);
                    if (categorieAttuatori != null) {
                        for (CategoriaAttuatori c : categorieAttuatori)
                            contenitore.getListaCategorie().inserisciESalvaCategoriaAttuatori(c);
                        ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
                    }
                }
                break;

                case 3: {
                    String nomeLibreria = InputDati.leggiStringaNonVuota("Inserire nome della libreria di unità immobiliari da importare: ");
                    File unitaImmobiliareFile = new File(nomeLibreria + ".dat");
                    ArrayList<CategoriaSensori> categorieSensoriCompatibilita = new ArrayList<>();
                    ArrayList<CategoriaAttuatori> categorieAttuatoriCompatibilita = new ArrayList<>();

                    UnitaImmobiliare unitaImmobiliare = (UnitaImmobiliare) ServizioFile.caricaSingoloOggetto(unitaImmobiliareFile);


                    if (unitaImmobiliare != null) {
                        //Categorie sensori in stanze
                        for (int i = 0; i < unitaImmobiliare.getSizeStanze(); i++) {
                            for (int j = 0; j < unitaImmobiliare.getStanze().get(i).getSensori().size(); j++) {
                                categorieSensoriCompatibilita.add(unitaImmobiliare.getStanze().get(i).getSensori().get(j).getCategoriaSensori());
                            }
                        }
                        //Categorie sensori in artefatti nelle stanze
                        for (int i = 0; i < unitaImmobiliare.getSizeStanze(); i++) {
                            for (int j = 0; j < unitaImmobiliare.getStanze().get(i).getArtefatti().size(); j++) {
                                for (int l = 0; l < unitaImmobiliare.getStanze().get(i).getArtefatti().get(j).getSensori().size(); l++) {
                                    categorieSensoriCompatibilita.add(unitaImmobiliare.getStanze().get(i).getArtefatti().get(j).getSensori().get(l).getCategoriaSensori());
                                }
                            }
                        }
                        //Categorie sensori in artefatti
                        for (int i = 0; i < unitaImmobiliare.getSizeArtefatti(); i++) {
                            for (int j = 0; j < unitaImmobiliare.getArtefatti().get(i).getSensori().size(); j++) {
                                categorieSensoriCompatibilita.add(unitaImmobiliare.getArtefatti().get(i).getSensori().get(j).getCategoriaSensori());
                            }
                        }
                        //Categorie attuatori in stanze
                        for (int i = 0; i < unitaImmobiliare.getSizeStanze(); i++) {
                            for (int j = 0; j < unitaImmobiliare.getStanze().get(i).getSensori().size(); j++) {
                                categorieAttuatoriCompatibilita.add(unitaImmobiliare.getStanze().get(i).getAttuatori().get(j).getCategoriaAttuatori());
                            }
                        }
                        //Categorie attuatori in artefatti nelle stanze
                        for (int i = 0; i < unitaImmobiliare.getSizeStanze(); i++) {
                            for (int j = 0; j < unitaImmobiliare.getStanze().get(i).getArtefatti().size(); j++) {
                                for (int l = 0; l < unitaImmobiliare.getStanze().get(i).getArtefatti().get(j).getSensori().size(); l++) {
                                    categorieAttuatoriCompatibilita.add(unitaImmobiliare.getStanze().get(i).getArtefatti().get(j).getAttuatori().get(l).getCategoriaAttuatori());
                                }
                            }
                        }
                        //Categorie attuatori in artefatti
                        for (int i = 0; i < unitaImmobiliare.getSizeArtefatti(); i++) {
                            for (int j = 0; j < unitaImmobiliare.getArtefatti().get(i).getSensori().size(); j++) {
                                categorieAttuatoriCompatibilita.add(unitaImmobiliare.getArtefatti().get(i).getAttuatori().get(j).getCategoriaAttuatori());
                            }
                        }
                    }
                    for (int i = 0; i < contenitore.getListaCategorie().getCategorieSensori().size(); i++) {
                        if (!contenitore.getListaCategorie().getCategorieSensori().contains(categorieSensoriCompatibilita.get(i))) {
                            System.out.println("C'è un errore di compatibilità con la categoria sensori");
                            break;
                        }
                    }
                    for (int i = 0; i < contenitore.getListaCategorie().getCategorieAttuatori().size(); i++) {
                        if (!contenitore.getListaCategorie().getCategorieAttuatori().contains(categorieAttuatoriCompatibilita.get(i))) {
                            System.out.println("C'è un errore di compatibilità con la categoria attuatori");
                            break;
                        }
                    }
                    contenitore.getManutentore().getFruitore().aggiungiUnitaImmobiliare(unitaImmobiliare);
                    ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
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

}
