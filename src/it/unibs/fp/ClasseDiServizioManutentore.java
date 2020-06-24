package it.unibs.fp;

import it.unibs.fp.mylib.MyMenu;

public class ClasseDiServizioManutentore {

    /**
     * Menu scelta manutentore con le varie possibilità
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void stampaMenuManutentore(Contenitore contenitore) {
        boolean finito = false;
        String[] azione = {"Operazioni su un'unità immobiliare", "Inserisci unità immobiliare", "Inserisci categorie sensori/attuatori", "Visualizza categorie di sensori/attuatori"};
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
        UnitaImmobiliare unitaImmobiliare = ClasseDiServizioInserimenti.scegliUnitaImmobiliare(manutentore);
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


}
