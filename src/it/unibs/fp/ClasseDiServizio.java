package it.unibs.fp;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.ServizioFile;

import java.io.File;
import java.util.ArrayList;

public class ClasseDiServizio {
    //TODO SISTEMARE TUTTO PERCHE HO AGGIUNTO METODI NUOVI IN MANUTENTORE E FRUITORE (BISOGNA AMALGAMARE)

    /**
     * Menu di scelta utente (manutentore o fruitore)
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    public static void menuPrincipale(Contenitore contenitore) {

        boolean finito = false;
        String[] azione = {"Accedi come manutentore", "Accedi come fruitore"};
        MyMenu menu = new MyMenu("Menu principal amigo", azione);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Grazie per aver usato DomoticSystemManagement");
                }
                break;

                case 1: {
                    stampaMenuManutentore(contenitore);
                }
                break;

                case 2: {
                    stampaMenuFruitore(contenitore);
                }
                break;
            }
        } while (!finito);
    }

    /**
     * Menu scelta manutentore con le varie possibilità
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    private static void stampaMenuManutentore(Contenitore contenitore) {
        boolean finito = false;
        String[] azione = {"Inserisci e associa", "Visualizza categorie e valori rilevati"};
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
                    stampaMenuManutentoreInserisciEAssocia(contenitore);
                }
                break;

                case 2: {
                    stampaMenuVisualizzazioneManutentore(contenitore);
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
    private static void stampaMenuVisualizzazioneManutentore(Contenitore contenitore) {
        boolean finito = false;
        String[] azione = {"Visualizza categorie sensori", "Visualizza categorie attuatori", "Visualizza stanze", "Visualizza artefatti", "Visualizza valore rilevato da un sensore"};
        MyMenu menu = new MyMenu("Menu fruitore", azione);
        Manutentore manutentore = contenitore.getManutentore();
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(manutentore);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu principale");

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
     * Menu di visualizzazione delle descrizioni da parte del fruitore
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    //TODO CAMBIATO
    private static void stampaMenuFruitore(Contenitore contenitore) {
        boolean finito = false;
        String[] azione = {"Visualizza categorie sensori", "Visualizza categorie attuatori", "Visualizza stanze", "Visualizza artefatti", "Visualizza valore rilevato da un sensore", "Operazioni su un'unità immobiliare"};
        MyMenu menu = new MyMenu("Menu fruitore", azione);
        Manutentore manutentore = contenitore.getManutentore();
        Fruitore fruitore = manutentore.getFruitore();
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(manutentore);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu principale");

                }
                break;

                case 1: {
                    System.out.println(fruitore.visualizzaDescrizioneCatergorieSensori(listaCategorie));
                }
                break;

                case 2: {
                    System.out.println(fruitore.visualizzaDescrizioneCatergorieAttuatori(listaCategorie));
                }
                break;

                case 3: {
                    System.out.println(fruitore.visualizzaStanze(unitaImmobiliare));
                }
                break;

                case 4: {
                    System.out.println(fruitore.visualizzaArtefatti(unitaImmobiliare));
                }
                break;

                case 5: {
                    System.out.println(fruitore.valoriRilevati(unitaImmobiliare));
                }
                break;

                case 6: {
                    System.out.println(fruitore.visualizzaUnitaImmobiliari());
                    int unitaImm = InputDati.leggiIntero("Scegli l'unità immobiliare su cui fare le operazioni", 0, fruitore.getUnitaImmobiliari().size());
                    stampaMenuOperazioniFruitore(contenitore, fruitore.getUnitaImmobiliari().get(unitaImm));
                }
                break;
            }
        } while (!finito);
    }

    //TODO CREATO
    public static void stampaMenuOperazioniFruitore(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare) {
        boolean finito = false;
        String[] azione = {"Scegli modalità operativa di un attuatore"};
        MyMenu menu = new MyMenu("Menu fruitore operazioni su " + unitaImmobiliare, azione);
        Manutentore manutentore = contenitore.getManutentore();
        Fruitore fruitore = manutentore.getFruitore();
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
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
                        System.out.println(unitaImmobiliare.visualizzaStanze());
                        int stanzaScelta = InputDati.leggiIntero("Scegliere stanza :", 0, unitaImmobiliare.getSizeStanze());
                        Stanza stanza = unitaImmobiliare.getStanze().get(stanzaScelta);
                        if (InputDati.yesOrNo("Si vuole cambiare modalità operativa di un attautore di un artefatto ?")) {
                            System.out.println(stanza.visualizzaArtefatti());
                            int artefattoScelto = InputDati.leggiIntero("Scegliere artefatto :", 0, unitaImmobiliare.getSizeArtefatti());
                            Artefatto artefatto = unitaImmobiliare.getArtefatti().get(artefattoScelto);
                            System.out.println(artefatto.visualizzaAttuatori());

                            int attuatoreScelto = InputDati.leggiIntero("Scegliere attuatore :", 0, artefatto.getAttuatori().size());
                            Attuatore attuatore = artefatto.getAttuatori().get(attuatoreScelto);
                            System.out.println(attuatore.getCategoriaAttuatori().toString());

                            int modalitaOperativaScelta = InputDati.leggiIntero("Scegliere modalità operativa :", 0, attuatore.getCategoriaAttuatori().getModalitaOperative().size());
                            ModOperativa modOperativa = attuatore.getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta);

                            if (modOperativa.getType() == 1) {
                                double valore = InputDati.leggiDouble("Inserisci valore : ");
                                ((ModOperativaNonParamentrica) unitaImmobiliare.getStanze().get(stanzaScelta).getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setValore(valore);
                            } else {
                                ModOperativaParamentrica modOperativaParamentrica = (ModOperativaParamentrica) modOperativa;
                                System.out.println(modOperativaParamentrica.toString());
                                int paremetroScelto = InputDati.leggiIntero("Scegliere parametro modalità operativa", 0, modOperativaParamentrica.getParamentri().size());
                                ((ModOperativaParamentrica) unitaImmobiliare.getStanze().get(stanzaScelta).getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setParemetroAttuale(modOperativaParamentrica.getParamentri().get(paremetroScelto));
                            }

                        } else {
                            int attuatoreScelto = InputDati.leggiIntero("Scegliere attuatore :", 0, stanza.getAttuatori().size());
                            Attuatore attuatore = stanza.getAttuatori().get(attuatoreScelto);
                            System.out.println(attuatore.getCategoriaAttuatori().toString());

                            int modalitaOperativaScelta = InputDati.leggiIntero("Scegliere modalità operativa :", 0, attuatore.getCategoriaAttuatori().getModalitaOperative().size());
                            ModOperativa modOperativa = attuatore.getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta);

                            if (modOperativa.getType() == 1) {
                                double valore = InputDati.leggiDouble("Inserisci valore : ");
                                ((ModOperativaNonParamentrica) unitaImmobiliare.getStanze().get(stanzaScelta).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setValore(valore);
                            } else {
                                ModOperativaParamentrica modOperativaParamentrica = (ModOperativaParamentrica) modOperativa;
                                System.out.println(modOperativaParamentrica.toString());
                                int paremetroScelto = InputDati.leggiIntero("Scegliere parametro modalità operativa", 0, modOperativaParamentrica.getParamentri().size());
                                ((ModOperativaParamentrica) unitaImmobiliare.getStanze().get(stanzaScelta).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setParemetroAttuale(modOperativaParamentrica.getParamentri().get(paremetroScelto));
                            }
                        }
                    } else {
                        System.out.println(unitaImmobiliare.visualizzaArtefatti());
                        int artefattoScelto = InputDati.leggiIntero("Scegliere artefatto :", 0, unitaImmobiliare.getSizeArtefatti());
                        Artefatto artefatto = unitaImmobiliare.getArtefatti().get(artefattoScelto);
                        System.out.println(artefatto.visualizzaAttuatori());

                        int attuatoreScelto = InputDati.leggiIntero("Scegliere attuatore :", 0, artefatto.getAttuatori().size());
                        Attuatore attuatore = artefatto.getAttuatori().get(attuatoreScelto);
                        System.out.println(attuatore.getCategoriaAttuatori().toString());

                        int modalitaOperativaScelta = InputDati.leggiIntero("Scegliere modalità operativa :", 0, attuatore.getCategoriaAttuatori().getModalitaOperative().size());
                        ModOperativa modOperativa = attuatore.getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta);

                        if (modOperativa.getType() == 1) {
                            ModOperativaNonParamentrica modOperativaNonParamentrica = (ModOperativaNonParamentrica) modOperativa;
                            double valore = InputDati.leggiDouble("Inserisci valore : ");
                            ((ModOperativaNonParamentrica) unitaImmobiliare.getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setValore(valore);
                        } else {
                            ModOperativaParamentrica modOperativaParamentrica = (ModOperativaParamentrica) modOperativa;
                            System.out.println(modOperativaParamentrica.toString());
                            int paremetroScelto = InputDati.leggiIntero("Scegliere parametro modalità operativa", 0, modOperativaParamentrica.getParamentri().size());
                            ((ModOperativaParamentrica) unitaImmobiliare.getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setParemetroAttuale(modOperativaParamentrica.getParamentri().get(paremetroScelto));
                        }
                    }
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
    private static void stampaMenuManutentoreInserisciEAssocia(Contenitore contenitore) {
        boolean finito = false;
        String[] azione = {"Inserisci e salva categoria sensori", "Inserisci e salva categoria attuatori", "Inserisci nuova stanza", "Inserisci nuovo artefatto", "Associa sensore a stanze", "Associa attuatore a stanze", "Associa sensore ad artefatto", "Associa attuatore ad artefatto", "Associa artefatto a stanze"};
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
                    inserisciESalvaCategioriaSensori(contenitore);
                }
                break;
                case 2: {
                    inserisciESalvaCategioriaAttuatori(contenitore);
                }
                break;


                case 3: {
                    inserisciNuovaStanza(contenitore);
                }
                break;

                case 4: {
                    inserisciNuovoArtefatto(contenitore);
                }
                break;

                case 5: {
                    associaSensoreAStanze(contenitore);
                }
                break;

                case 6: {
                    associaAttuatoreAStanze(contenitore);
                }
                break;

                case 7: {
                    associaSensoreAdArtefatti(contenitore);
                }
                break;

                case 8: {
                    associaAttuatoreAdArtefatti(contenitore);
                }
                break;

                case 9: {
                    associaArtefattoAStanze(contenitore);
                }
                break;
            }
        } while (!finito);

    }

    /**
     * Associa un artefatto ad una o più stanze
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    private static void associaArtefattoAStanze(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(manutentore);//TODO DA SPOSTARE ALL'ESTERNO fallo scegliere prima
        if (!unitaImmobiliare.getArtefatti().isEmpty())
            do {
                Artefatto artefatto = scegliArtefatto(unitaImmobiliare);
                ArrayList<Stanza> stanze = scegliStanze(unitaImmobiliare);
                manutentore.associaArtefattoAStanze(artefatto, stanze, unitaImmobiliare);
                contenitore.setListaCategorie(listaCategorie);
                contenitore.setManutentore(manutentore);
                ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);
            } while (InputDati.yesOrNo("Vuoi associare un'altro artefatto a stanze?"));
        else
            System.out.println("Bisogna prima creare un artefatto");

    }

    /**
     * Associa un sensore ad una o più stanze
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    private static void associaSensoreAStanze(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(manutentore);//TODO DA SPOSTARE ALL'ESTERNO fallo scegliere prima

        if (!listaCategorie.getCategorieSensori().isEmpty())
            do {
                Sensore nuovoSensore = creaSensore(listaCategorie);
                ArrayList<Stanza> stanze = scegliStanze(unitaImmobiliare);
                manutentore.associaSensoreAStanze(nuovoSensore, stanze, unitaImmobiliare);
                contenitore.setListaCategorie(listaCategorie);
                contenitore.setManutentore(manutentore);
                ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);
            } while (InputDati.yesOrNo("Vuoi associare un'altro sensore a una stanza?"));
        else
            System.out.println("Bisogna prima creare una categoria sensori");
    }

    /**
     * Associa un attuatore a una o piu stanze
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    private static void associaAttuatoreAStanze(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(manutentore);//TODO DA SPOSTARE ALL'ESTERNO fallo scegliere prima
        if (!listaCategorie.getCategorieAttuatori().isEmpty())
            do {
                Attuatore nuovoAttuatore = creaAttuatore(listaCategorie);
                ArrayList<Stanza> stanze = scegliStanze(unitaImmobiliare);
                manutentore.associaAttuatoreAStanze(nuovoAttuatore, stanze, unitaImmobiliare);
                contenitore.setListaCategorie(listaCategorie);
                contenitore.setManutentore(manutentore);
                ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);
            } while (InputDati.yesOrNo("Vuoi associare un'altro sensore a stanze?"));
        else
            System.out.println("Bisogna prima creare una categoria attuatori");
    }

    /**
     * Associa un sensore ad uno o piu artefatti
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    private static void associaSensoreAdArtefatti(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(manutentore);//TODO DA SPOSTARE ALL'ESTERNO fallo scegliere prima

        if (!listaCategorie.getCategorieAttuatori().isEmpty())
            do {
                Sensore nuovoSensore = creaSensore(listaCategorie);
                ArrayList<Artefatto> artefatti = scegliArtefatti(unitaImmobiliare);
                for (Artefatto a : artefatti)
                    for (Sensore s : a.getSensori())
                        if (nuovoSensore.getCategoriaSensori() == s.getCategoriaSensori())
                            System.out.println("Esite già un sensore con la stessa categoria in uno degli artefatti");

                manutentore.associaSensoreAdArtefatti(nuovoSensore, artefatti, unitaImmobiliare);

                contenitore.setListaCategorie(listaCategorie);
                contenitore.setManutentore(manutentore);
                ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);
            } while (InputDati.yesOrNo("Vuoi associare un'altro sensore ad artefatti?"));
        else
            System.out.println("Bisogna prima creare una categoria sensori");
    }

    /**
     * Associa un attuatore ad uno o piu artefatti
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    private static void associaAttuatoreAdArtefatti(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(manutentore);//TODO DA SPOSTARE ALL'ESTERNO fallo scegliere prima
        if (!listaCategorie.getCategorieAttuatori().isEmpty())
            do {
                Attuatore nuovoAttuatore = creaAttuatore(listaCategorie);
                ArrayList<Artefatto> artefatti = scegliArtefatti(unitaImmobiliare);
                manutentore.associaAttuatoreAdArtefatti(nuovoAttuatore, artefatti, unitaImmobiliare);

                contenitore.setListaCategorie(listaCategorie);
                contenitore.setManutentore(manutentore);
                ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);
            } while (InputDati.yesOrNo("Vuoi associare un'altro attuatore ad artefatti?"));
        else
            System.out.println("Bisogna prima creare una categoria attuatori");
    }

    /**
     * Inserisci e salva uno o piu categorie di sensori
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
//TODO CAMBIATO
    private static void inserisciESalvaCategioriaSensori(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        do {
            boolean testoLiberoOK = false;
            ArrayList<InfoRilevabile> informazioniRilevabili = new ArrayList<>();
            String nome = InputDati.leggiStringaNonVuota("Inserisci nome categoria sensori: ");
            do {
                try {
                    String testoLibero = InputDati.leggiStringaNonVuota("Inserisci un testo libero di lunghezza massima " + CategoriaSensori.getLunghezzaMassima() + " caratteri: ");
                    do {
                        informazioniRilevabili.add(inserisciInfoRilevabili());
                    } while (InputDati.yesOrNo("Vuoi inserire un'altra informazione rilevabile?"));
                    manutentore.inserisciESalvaCategoriaSensori(listaCategorie, new CategoriaSensori(nome, testoLibero, informazioniRilevabili));
                    testoLiberoOK = true;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!testoLiberoOK);

            contenitore.setListaCategorie(listaCategorie);
            contenitore.setManutentore(manutentore);
            ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);

        } while (InputDati.yesOrNo("Vuoi inserire un'altra categoria sensori?"));
    }

    //TODO CREATO
    private static InfoRilevabile inserisciInfoRilevabili() {
        InfoRilevabile infoRilevabile;
        int scelta = InputDati.leggiIntero("Premere 1 per inserire informazioni rilevabili con valore numerico e 2 informazioni rilevabili con valore non numerico", 1, 2);
        if (scelta == 1)
            infoRilevabile = inserisciInfoRilevabileNumerica();
        else
            infoRilevabile = inserisciInfoRilevabileNonNumerica();

        return infoRilevabile;

    }

    //TODO CREATO
    private static InfoRilevabile inserisciInfoRilevabileNumerica() {
        InfoRilevabile informazioneRilevabile = null;
        boolean infoRilevabileOK = false;
        String nomeInfo = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome di informazione rilevabile: ");
        do {
            try {
                double min = InputDati.leggiDouble("Inserisci il valore minimo rilevabile");
                double max = InputDati.leggiDouble("Inserisci il valore massimo rilevabile");

                informazioneRilevabile = new InfoRilevabileNumerica(nomeInfo, min, max);
                infoRilevabileOK = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!infoRilevabileOK);


        return informazioneRilevabile;
    }

    //TODO CREATO
    private static InfoRilevabile inserisciInfoRilevabileNonNumerica() {
        InfoRilevabile informazioneRilevabile = null;
        boolean infoRilevabileOK = false;

        String nomeInfo = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome di informazione rilevabile: ");
        do {
            try {
                ArrayList<String> valoriNonNumerici = new ArrayList<>();
                do {
                    valoriNonNumerici.add(InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci un valore rilevabile non numerico :"));

                } while (InputDati.yesOrNo("Vuoi inserire un'altro valore non numerico ?"));

                informazioneRilevabile = new InfoRilevabileNonNumerica(nomeInfo, valoriNonNumerici);
                infoRilevabileOK = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!infoRilevabileOK);


        return informazioneRilevabile;
    }


    /**
     * Inseriesci e salva una o piu categoria di attuatori
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
//TODO CAMBIATO
    private static void inserisciESalvaCategioriaAttuatori(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        do {
            boolean testoLiberoOK = false;
            ArrayList<ModOperativa> modalitaOperative = new ArrayList<>();
            String nome = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome categoria attuatori: ");
            do {
                try {
                    String testoLibero = InputDati.leggiStringaNonVuota("Inserisci un testo libero di lunghezza massima " + CategoriaAttuatori.getLunghezzaMassima() + " caratteri: ");
                    do {
                        modalitaOperative.add(inserisciModalitaOperativa());
                    } while (InputDati.yesOrNo("Vuoi inserire un'altra modalita operativa?"));
                    manutentore.inserisciESalvaCategoriaAttuatori(listaCategorie, new CategoriaAttuatori(nome, testoLibero, modalitaOperative));
                    testoLiberoOK = true;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!testoLiberoOK);
            contenitore.setListaCategorie(listaCategorie);
            contenitore.setManutentore(manutentore);
            ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);


        } while (InputDati.yesOrNo("Vuoi inserire un'altra categoria attuatori?"));
        ServizioFile.caricaSingoloOggetto(new File("datiListaCategorie.txt"));
    }

    //TODO CREATO
    public static ModOperativa inserisciModalitaOperativa() {
        ModOperativa modOperative = null;
        int scelta = InputDati.leggiIntero("Premere 1 per inserire modalità operative non parametriche e 2 per modalità operative parametriche", 1, 2);
        if (scelta == 1)
            modOperative = inserisciModalitaOperativaNonParametrica();
        else
            modOperative = inserisciModalitaOperativaParametrica();

        return modOperative;
    }

    //TODO CREATO
    public static ModOperativa inserisciModalitaOperativaNonParametrica() {
        ModOperativa modOperative = null;
        String nomeModalitaOperativa = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome della modalita operativa: ");
        if (InputDati.yesOrNo("Vuoi inserire una modalita operativa con valore?")) {
            double valore = InputDati.leggiDouble("Inserisci il valore:");
            modOperative = new ModOperativaNonParamentrica(nomeModalitaOperativa, valore);
        } else {
            modOperative = new ModOperativaNonParamentrica(nomeModalitaOperativa);
        }
        return modOperative;
    }

    //TODO CREATO
    public static ModOperativa inserisciModalitaOperativaParametrica() {
        ModOperativa modOperative = null;
        ArrayList<String> parametri = new ArrayList<>();
        String nomeModalitaOperativa = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome della modalita operativa: ");
        do {
            parametri.add(InputDati.leggiStringaNonVuota("Inserisci parametro :"));
        } while (InputDati.yesOrNo("Vuoi inserire un'altro parametro nella modalità operativa?"));
        modOperative = new ModOperativaParamentrica(nomeModalitaOperativa, parametri);
        return modOperative;
    }

    /**
     * Inserisci uno o piu nuovi artefatti
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    private static void inserisciNuovoArtefatto(Contenitore contenitore) {
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(manutentore);//TODO DA SPOSTARE ALL'ESTERNO fallo scegliere prima
        do {
            String nome = InputDati.leggiStringaNonVuota("Inserisci nome nuovo artefatto: ");
            manutentore.inserisciArtefatto(new Artefatto(nome), unitaImmobiliare);

            contenitore.setManutentore(manutentore);
            ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);
        } while (InputDati.yesOrNo("Vuoi inserire un'altro artefatto?"));

    }

    /**
     * Inserisci una o piu nuove stanze
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    private static void inserisciNuovaStanza(Contenitore contenitore) {
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(manutentore);//TODO DA SPOSTARE ALL'ESTERNO fallo scegliere prima
        do {
            String nome = InputDati.leggiStringaNonVuota("Inserisci nome nuova stanza: ");
            manutentore.inserisciStanza(new Stanza(nome), unitaImmobiliare);

            contenitore.setManutentore(manutentore);
            ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);
        } while (InputDati.yesOrNo("Vuoi inserire un'altra stanza?"));
    }


    /**
     * Scegli uno o più nuovi artefatti
     *
     * @param unitaImmobiliare dal quale prendere gli artefatti
     * @return artefatti scelti
     */
    private static ArrayList<Artefatto> scegliArtefatti(UnitaImmobiliare unitaImmobiliare) {
        System.out.println("Si scelgano ora gli artefatti");
        ArrayList<Artefatto> artefatti = new ArrayList<>();
        do {
            System.out.println(unitaImmobiliare.visualizzaArtefatti());
            int artefattoIndex = InputDati.leggiIntero("Scegli artefatto : ", 1, unitaImmobiliare.getSizeStanze());
            artefatti.add(unitaImmobiliare.getArtefatti().get(--artefattoIndex));
        } while (InputDati.yesOrNo("Vuoi scegliere un'altro artefatto?"));
        return artefatti;
    }

    /**
     * Scegli un artefatto
     *
     * @param unitaImmobiliare dal quale prendere gli artefatti
     * @return artefatti scelti
     */
    private static Artefatto scegliArtefatto(UnitaImmobiliare unitaImmobiliare) {
        System.out.println("Si scelga ora l'artefatto");
        Artefatto artefatto;
        System.out.println(unitaImmobiliare.visualizzaArtefatti());
        int artefattoIndex = InputDati.leggiIntero("Scegli artefatto : ", 1, unitaImmobiliare.getSizeStanze());
        artefatto = unitaImmobiliare.getArtefatti().get(--artefattoIndex);
        return artefatto;
    }

    /**
     * Scegli una o più stanze
     *
     * @param unitaImmobiliare dal quale prendere le stanze
     * @return stanze scelte
     */
    private static ArrayList<Stanza> scegliStanze(UnitaImmobiliare unitaImmobiliare) {
        System.out.println("Si scelga ora le stanze");
        ArrayList<Stanza> stanze = new ArrayList<>();
        do {
            System.out.println(unitaImmobiliare.visualizzaStanze());
            int stanzaIndex = InputDati.leggiIntero("Scegli stanza : ", 1, unitaImmobiliare.getSizeStanze());
            stanze.add(unitaImmobiliare.getStanze().get(--stanzaIndex));
        } while (InputDati.yesOrNo("Vuoi scegliere un'altra stanza?"));
        return stanze;
    }


    /**
     * Crea un nuovo attuatore
     *
     * @param listaCategorie per scegliere la tipologia di attuatori da creare
     * @return un nuovo attuatore
     */
    private static Attuatore creaAttuatore(ListaCategorie listaCategorie) {
        System.out.println(listaCategorie.visualizzaCategorieAttuatori());
        int categoria = InputDati.leggiIntero("Scegli categoria : ", 1, listaCategorie.getSizeCategorieAttuatori());
        categoria--;
        String nome = InputDati.leggiStringaNonVuota("Inserisci nome attuatori : ");
        nome += "_" + listaCategorie.getCategorieAttuatori().get(categoria).getNome();
        System.out.println("Si è creato l'attuatore " + nome);
        return new Attuatore(nome, listaCategorie.getCategorieAttuatori().get(categoria));
    }

    /**
     * Crea un nuovo sensore
     *
     * @param listaCategorie per sceglie la tipologia di sensori da creare
     * @return un nuovo sensore
     */
    private static Sensore creaSensore(ListaCategorie listaCategorie) {
        System.out.println(listaCategorie.visualizzaCategorieSensori());
        int categoria = InputDati.leggiIntero("Scegli categoria : ", 1, listaCategorie.getSizeCategorieSensori());
        categoria--;
        String nome = InputDati.leggiStringaNonVuota("Inserisci nome sensore : ");
        nome += "_" + listaCategorie.getCategorieSensori().get(categoria).getNome();
        System.out.println("Si è creato il sensore " + nome);
        return new Sensore(nome, listaCategorie.getCategorieSensori().get(categoria));
    }


    //TODO
    private static UnitaImmobiliare scegliUnitaImmobiliare(Manutentore manutentore) {
        System.out.println("Si scelga ora l' unita immobiliare");
        ArrayList<UnitaImmobiliare> unitaImmobiliari = manutentore.getUnitaImmobiliari();
        System.out.println(manutentore.visualizzaListaUnitaImmobiliari());
        int artefattoIndex = InputDati.leggiIntero("Scegli artefatto : ", 1, manutentore.getSizeUnitaImmobiliari());
        return unitaImmobiliari.get(--artefattoIndex);

    }


}