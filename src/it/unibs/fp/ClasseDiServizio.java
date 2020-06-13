package it.unibs.fp;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.ServizioFile;

import java.io.File;
import java.util.ArrayList;

public class ClasseDiServizio {

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
        UnitaImmobiliare unitaImmobiliare = contenitore.getUnitaImmobiliare();
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
    private static void stampaMenuFruitore(Contenitore contenitore) {
        boolean finito = false;
        String[] azione = {"Visualizza categorie sensori", "Visualizza categorie attuatori", "Visualizza stanze", "Visualizza artefatti", "Visualizza valore rilevato da un sensore"};
        MyMenu menu = new MyMenu("Menu fruitore", azione);
        Fruitore fruitore = contenitore.getFruitore();
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        UnitaImmobiliare unitaImmobiliare = contenitore.getUnitaImmobiliare();
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
        UnitaImmobiliare unitaImmobiliare = contenitore.getUnitaImmobiliare();
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        if (!unitaImmobiliare.getArtefatti().isEmpty())
            do {
                Artefatto artefatto = scegliArtefatto(unitaImmobiliare);
                ArrayList<Stanza> stanze = scegliStanze(unitaImmobiliare);
                manutentore.associaArtefattoAStanze(artefatto, stanze, unitaImmobiliare);
                contenitore.setListaCategorie(listaCategorie);
                contenitore.setUnitaImmobiliare(unitaImmobiliare);
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
        UnitaImmobiliare unitaImmobiliare = contenitore.getUnitaImmobiliare();
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();

        if (!listaCategorie.getCategorieSensori().isEmpty())
            do {
                Sensore nuovoSensore = creaSensore(listaCategorie);
                ArrayList<Stanza> stanze = scegliStanze(unitaImmobiliare);
                manutentore.associaSensoreAStanze(nuovoSensore, stanze, unitaImmobiliare);
                contenitore.setListaCategorie(listaCategorie);
                contenitore.setUnitaImmobiliare(unitaImmobiliare);
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
        UnitaImmobiliare unitaImmobiliare = contenitore.getUnitaImmobiliare();
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        if (!listaCategorie.getCategorieAttuatori().isEmpty())
            do {
                Attuatore nuovoAttuatore = creaAttuatore(listaCategorie);
                ArrayList<Stanza> stanze = scegliStanze(unitaImmobiliare);
                manutentore.associaAttuatoreAStanze(nuovoAttuatore, stanze, unitaImmobiliare);
                contenitore.setListaCategorie(listaCategorie);
                contenitore.setUnitaImmobiliare(unitaImmobiliare);
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
        UnitaImmobiliare unitaImmobiliare = contenitore.getUnitaImmobiliare();
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();

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
                contenitore.setUnitaImmobiliare(unitaImmobiliare);
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
        UnitaImmobiliare unitaImmobiliare = contenitore.getUnitaImmobiliare();
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        if (!listaCategorie.getCategorieAttuatori().isEmpty())
            do {
                Attuatore nuovoAttuatore = creaAttuatore(listaCategorie);
                ArrayList<Artefatto> artefatti = scegliArtefatti(unitaImmobiliare);
                manutentore.associaAttuatoreAdArtefatti(nuovoAttuatore, artefatti, unitaImmobiliare);

                contenitore.setListaCategorie(listaCategorie);
                contenitore.setUnitaImmobiliare(unitaImmobiliare);
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
    private static void inserisciESalvaCategioriaSensori(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        do {
            boolean testoLiberoOK = false;
            ArrayList<InfoRilevabile> informazioniRilevabili = new ArrayList<>();
            String nome = InputDati.leggiStringaNonVuota("Inserisci nome categoria sensori: ");
            do {
                boolean infoRilevabileOK = false;
                try {
                    String testoLibero = InputDati.leggiStringaNonVuota("Inserisci un testo libero di lunghezza massima " + CategoriaSensori.getLunghezzaMassima() + " caratteri: ");
                    do {
                        String nomeInfo = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome di informazione rilevabile: ");
                        do {
                            try {
                                double min = InputDati.leggiDouble("Inserisci il valore minimo rilevabile");
                                double max = InputDati.leggiDouble("Inserisci il valore massimo rilevabile");

                                informazioniRilevabili.add(new InfoRilevabile(nomeInfo, min, max));
                                infoRilevabileOK = true;
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        } while (!infoRilevabileOK);
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

    /**
     * Inseriesci e salva una o piu categoria di attuatori
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
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
                        String nomeModalitaOperativa = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome della modalita operativa: ");

                        if (InputDati.yesOrNo("Vuoi inserire una modalita operativa con valore?")) {
                            double valore = InputDati.leggiDouble("Inserisci il valore:");
                            modalitaOperative.add(new ModOperativa(nomeModalitaOperativa, valore));
                        } else {
                            modalitaOperative.add(new ModOperativa(nomeModalitaOperativa));
                        }
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

    /**
     * Inserisci uno o piu nuovi artefatti
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    private static void inserisciNuovoArtefatto(Contenitore contenitore) {
        UnitaImmobiliare unitaImmobiliare = contenitore.getUnitaImmobiliare();
        Manutentore manutentore = contenitore.getManutentore();
        do {
            String nome = InputDati.leggiStringaNonVuota("Inserisci nome nuovo artefatto: ");
            manutentore.inserisciArtefatto(new Artefatto(nome), unitaImmobiliare);

            contenitore.setManutentore(manutentore);
            contenitore.setUnitaImmobiliare(unitaImmobiliare);
            ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);
        } while (InputDati.yesOrNo("Vuoi inserire un'altro artefatto?"));

    }

    /**
     * Inserisci una o piu nuove stanze
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    private static void inserisciNuovaStanza(Contenitore contenitore) {
        UnitaImmobiliare unitaImmobiliare = contenitore.getUnitaImmobiliare();
        Manutentore manutentore = contenitore.getManutentore();

        do {
            String nome = InputDati.leggiStringaNonVuota("Inserisci nome nuova stanza: ");
            manutentore.inserisciStanza(new Stanza(nome), unitaImmobiliare);

            contenitore.setManutentore(manutentore);
            contenitore.setUnitaImmobiliare(unitaImmobiliare);
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


}