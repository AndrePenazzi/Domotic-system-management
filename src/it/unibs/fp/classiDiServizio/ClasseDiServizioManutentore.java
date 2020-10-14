package it.unibs.fp.classiDiServizio;

import it.unibs.fp.categoria.CategoriaAttuatori;
import it.unibs.fp.categoria.CategoriaSensori;
import it.unibs.fp.categoria.ListaCategorie;
import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.modalitaOperativa.ModOperativa;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.ServizioFile;
import it.unibs.fp.regola.Regola;
import it.unibs.fp.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.utenti.Manutentore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClasseDiServizioManutentore {

    /**
     * Menu scelta manutentore con le varie possibilità
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void stampaMenuManutentore(Contenitore contenitore) {
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
                break;
                case 5: {
                    stampaMenuSalvataggiLibrerie(contenitore);
                }

                case 6: {
                    stampaMenuImportLibrerie(contenitore);
                }
                break;
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
                    ClasseDiServizioInserimenti.inserisciNuovaStanza(contenitore);
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

    /**
     * Menu inserisci categorie
     *
     * @param contenitore per gli oggetti necessari
     */
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
                    UnitaImmobiliare unitaImmobiliare = ClasseDiServizioInserimenti.scegliUnitaImmobiliare(manutentore);
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
                    String nomeLibreria = InputDati.leggiStringaNonVuota("Inserire nome della libreria di sensori da importare: ");
                    File categorieSensoriFile = new File(nomeLibreria + ".dat");

                    List<CategoriaSensori> categorieSensori = (ArrayList<CategoriaSensori>) ServizioFile.caricaSingoloOggetto(categorieSensoriFile);
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

                    List<CategoriaAttuatori> categorieAttuatori = (ArrayList<CategoriaAttuatori>) ServizioFile.caricaSingoloOggetto(categorieAttuatoriFile);
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
                    List<CategoriaSensori> categorieSensoriCompatibilita = new ArrayList<>();
                    List<CategoriaAttuatori> categorieAttuatoriCompatibilita = new ArrayList<>();

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

                    List<CategoriaSensori> categoriaSensori = contenitore.getListaCategorie().getCategorieSensori();
                    List<CategoriaAttuatori> categoriaAttuatori = contenitore.getListaCategorie().getCategorieAttuatori();


                    File regoleFile = new File(nomeLibreria + ".dat");

                    List<Regola> regole = (ArrayList<Regola>) ServizioFile.caricaSingoloOggetto(regoleFile);


                    List<InfoRilevabile> categorieAntecedentiCompatibilita = new ArrayList<>();

                    List<ModOperativa> categorieConseguentiCompatibilita = new ArrayList<>();


                    if (!regole.isEmpty()) {
                        //InfoRilvabili in antecedenti
                        for (int i = 0; i < regole.size(); i++) {
                            for (int j = 0; j < regole.get(i).getAntecedente().size(); j++) {
                                categorieAntecedentiCompatibilita.add(regole.get(i).getAntecedente().get(j).getPrimoOperatoreLogico());
                                if (regole.get(i).getAntecedente().get(j).getSecondoOperatoreLogico() != null) {
                                    categorieAntecedentiCompatibilita.add(regole.get(i).getAntecedente().get(j).getSecondoOperatoreLogico());
                                }
                            }
                        }


                        //ModOperativa in conseguenti
                        for (int i = 0; i < regole.size(); i++) {
                            for (int j = 0; j < regole.get(i).getConseguente().size(); j++) {
                                categorieConseguentiCompatibilita.add(regole.get(i).getConseguente().get(j).getModOperativa());
                                if (regole.get(i).getConseguente().get(j).getModOperativa() != null) {
                                    categorieConseguentiCompatibilita.add(regole.get(i).getConseguente().get(j).getModOperativa());
                                }
                            }
                        }
                    }

                    for (int i = 0; i < categoriaSensori.size(); i++) {
                        boolean flag = false;
                        for (int j = 0; j < categorieAntecedentiCompatibilita.size(); j++) {
                            if (!categoriaSensori.get(i).getInformazioniRilevabili().contains(categorieAntecedentiCompatibilita.get(j))) {
                                flag = true;
                            }
                            if (!flag) {
                                System.out.println("C'è un errore di compatibilità con la categoria sensori");
                                break;
                            }
                        }
                    }

                    for (int i = 0; i < categoriaAttuatori.size(); i++) {
                        boolean flag = false;
                        for (int j = 0; j < categorieConseguentiCompatibilita.size(); j++) {
                            if (!categoriaAttuatori.get(i).getModalitaOperative().contains(categorieConseguentiCompatibilita.get(j))) {
                                flag = true;
                            }
                            if (!flag) {
                                System.out.println("C'è un errore di compatibilità con la categoria attuatori");
                                break;
                            }
                        }
                    }
                }
                break;
            }
        }
        while (!finito);
    }
}
