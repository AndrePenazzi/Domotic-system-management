package it.unibs.fp;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.ServizioFile;

import java.io.File;
import java.util.ArrayList;

public class ClasseDiServizio {


    public static void menuPrincipale(Manutentore manutentore, UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
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
                    stampaMenuManutentore(manutentore, unitaImmobiliare, listaCategorie);
                }
                break;

                case 2: {
                    stampaMenuVisualizzazione(listaCategorie, unitaImmobiliare);
                }
                break;
            }
        } while (!finito);
    }

    /*
    Inizio Manutentore-----------------------------------------------------------------------------------------------------
     */

    private static void stampaMenuManutentore(Manutentore manutentore, UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
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
                    stampaMenuManutentoreInserisciEAssocia(manutentore, unitaImmobiliare, listaCategorie);
                }
                break;

                case 2: {
                    stampaMenuVisualizzazione(listaCategorie, unitaImmobiliare);
                }
                break;
            }
        } while (!finito);
    }

    /*
    Visualizzazione
     */
    private static void stampaMenuVisualizzazione(ListaCategorie listaCategorie, UnitaImmobiliare unitaImmobiliare) {
        boolean finito = false;
        String[] azione = {"Visualizza categorie sensori", "Visualizza categorie attuatori", "Visualizza stanze", "Visualizza artefatti"};
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
                    System.out.println(listaCategorie.visualizzaCategorieSensori());
                }
                break;

                case 2: {
                    System.out.println(listaCategorie.visualizzaCategorieAttuatori());
                }
                break;

                case 3: {
                    System.out.println(unitaImmobiliare.visualizzaStanze());
                }
                break;

                case 4: {
                    System.out.println(unitaImmobiliare.visualizzaArtefatti());
                }
                break;
            }
        } while (!finito);
    }

    private static void stampaMenuManutentoreInserisciEAssocia(Manutentore manutentore, UnitaImmobiliare unitaImmobiliare, ListaCategorie listaCategorie) {
        boolean finito = false;
        String[] azione = {"Inserisci e salva categoria sensori", "Inserisci e salva categoria attuatori", "Inserisci nuova stanza", "Inserisci nuovo artefatto", "Associa sensore a stanze", "Associa attuatore a stanze", "Associa sensore ad artefatto", "Associa attuatore ad artefatto"};
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
                    listaCategorie = inserisciESalvaCategioriaSensori(manutentore, listaCategorie);
                }
                break;
                case 2: {
                    listaCategorie = inserisciESalvaCategioriaAttuatori(manutentore, listaCategorie);
                }
                break;


                case 3: {
                    inserisciNuovaStanza(manutentore, unitaImmobiliare);
                }
                break;

                case 4: {
                    inserisciNuovoArtefatto(manutentore, unitaImmobiliare);
                }
                break;

                case 5: {
                    associaSensoreAStanze(listaCategorie, unitaImmobiliare);
                }
                break;

                case 6: {
                    associaAttuatoreAStanze(listaCategorie, unitaImmobiliare);
                }
                break;

                case 7: {
                    associaSensoreAdArtefatti(listaCategorie, unitaImmobiliare);
                }
                break;

                case 8: {
                    associaAttuatoreAdArtefatti(listaCategorie, unitaImmobiliare);
                }
                break;
            }
        } while (!finito);

    }


    private static void associaSensoreAStanze(ListaCategorie listaCategorie, UnitaImmobiliare unitaImmobiliare) {
        do {
            Sensore nuovoSensore = creaSensore(listaCategorie);
            ArrayList<Stanza> stanze = scegliStanze(unitaImmobiliare);
            unitaImmobiliare.associaSensoreAStanze(nuovoSensore, stanze);
            ServizioFile.salvaSingoloOggetto(new File("datiUnitaImmobiliare.txt"), unitaImmobiliare);
        } while (InputDati.yesOrNo("Vuoi associare un'altro sensore a una stanza?"));

    }


    private static void associaAttuatoreAStanze(ListaCategorie listaCategorie, UnitaImmobiliare unitaImmobiliare) {
        do {
            Attuatore nuovoAttuatore = creaAttuatore(listaCategorie);
            ArrayList<Stanza> stanze = scegliStanze(unitaImmobiliare);
            unitaImmobiliare.associaAttuatoreAStanze(nuovoAttuatore, stanze);
            ServizioFile.salvaSingoloOggetto(new File("datiUnitaImmobiliare.txt"), unitaImmobiliare);
        } while (InputDati.yesOrNo("Vuoi associare un'altro sensore a stanze?"));

    }

    private static void associaSensoreAdArtefatti(ListaCategorie listaCategorie, UnitaImmobiliare unitaImmobiliare) {
        do {
            Sensore nuovoSensore = creaSensore(listaCategorie);
            ArrayList<Artefatto> artefatti = scegliArtefatti(unitaImmobiliare);
            unitaImmobiliare.associaSensoreAdArtefatti(nuovoSensore, artefatti);
            ServizioFile.salvaSingoloOggetto(new File("datiUnitaImmobiliare.txt"), unitaImmobiliare);
        } while (InputDati.yesOrNo("Vuoi associare un'altro sensore ad artefatti?"));
    }

    private static void associaAttuatoreAdArtefatti(ListaCategorie listaCategorie, UnitaImmobiliare unitaImmobiliare) {
        do {
            Attuatore nuovoAttuatore = creaAttuatore(listaCategorie);
            ArrayList<Artefatto> artefatti = scegliArtefatti(unitaImmobiliare);
            unitaImmobiliare.associaAttuatoreAdArtefatti(nuovoAttuatore, artefatti);
            ServizioFile.salvaSingoloOggetto(new File("datiUnitaImmobiliare.txt"), unitaImmobiliare);
        } while (InputDati.yesOrNo("Vuoi associare un'altro attuatore ad artefatti?"));
    }


    private static void inserisciNuovoArtefatto(Manutentore manutentore, UnitaImmobiliare unitaImmobiliare) {
        do {
            String nome = InputDati.leggiStringaNonVuota("Inserisci nome nuovo artefatto: ");
            manutentore.inserisciArtefatto(new Artefatto(nome), unitaImmobiliare);
            ServizioFile.salvaSingoloOggetto(new File("datiUnitaImmobiliare.txt"), unitaImmobiliare);
        } while (InputDati.yesOrNo("Vuoi inserire un'altro artefatto?"));

    }


    private static void inserisciNuovaStanza(Manutentore manutentore, UnitaImmobiliare unitaImmobiliare) {
        do {
            String nome = InputDati.leggiStringaNonVuota("Inserisci nome nuova stanza: ");
            manutentore.inserisciStanza(new Stanza(nome), unitaImmobiliare);
            ServizioFile.salvaSingoloOggetto(new File("datiUnitaImmobiliare.txt"), unitaImmobiliare);
        } while (InputDati.yesOrNo("Vuoi inserire un'altra stanza?"));
    }


    /*
   Inizio Scelta di artefatti e stanze -----------------------------------------------------------------------------
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

    private static Attuatore creaAttuatore(ListaCategorie listaCategorie) {
        System.out.println(listaCategorie.visualizzaCategorieAttuatori());
        int categoria = InputDati.leggiIntero("Scegli categoria : ", 1, listaCategorie.getSizeCategorieAttuatori());
        categoria--;
        String nome = InputDati.leggiStringaNonVuota("Inserisci nome attuatori : ");
        nome += "_" + listaCategorie.getCategorieAttuatori().get(categoria);
        System.out.println("Si è creato l'attuatore " + nome);
        return new Attuatore(nome);
    }

    private static Sensore creaSensore(ListaCategorie listaCategorie) {
        System.out.println(listaCategorie.visualizzaCategorieSensori());
        int categoria = InputDati.leggiIntero("Scegli categoria : ", 1, listaCategorie.getSizeCategorieSensori());
        categoria--;
        String nome = InputDati.leggiStringaNonVuota("Inserisci nome sensore : ");
        nome += "_" + listaCategorie.getCategorieSensori().get(categoria);
        System.out.println("Si è creato il sensore " + nome);
        return new Sensore(nome);
    }

    private static ListaCategorie inserisciESalvaCategioriaSensori(Manutentore manutentore, ListaCategorie listaCategorie) {
        do {
            boolean testoLiberoOK = false;
            ArrayList<InformazioneRilevabile> informazioniRilevabili = new ArrayList<>();
            String nome = InputDati.leggiStringaNonVuota("Inserisci nome categoria sensori: ");
            do {
                boolean infoRilevabileOK = false;
                try {
                    String testoLibero = InputDati.leggiStringaNonVuota("Inserisci un testo libero di lunghezza massima 50 caratteri: ");
                    do {
                        String nomeInfo = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome di informazione rilevabile: ");
                        do {
                            try {
                                double min = InputDati.leggiDouble("Inserisci il valore minimo rilevabile");
                                double max = InputDati.leggiDouble("Inserisci il valore massimo rilevabile");

                                informazioniRilevabili.add(new InformazioneRilevabile(nomeInfo, min, max));
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
            ServizioFile.salvaSingoloOggetto(new File("datiListaCategorie.txt"), listaCategorie);
        } while (InputDati.yesOrNo("Vuoi inserire un'altra categoria sensori?"));
        listaCategorie = (ListaCategorie) ServizioFile.caricaSingoloOggetto(new File("datiListaCategorie.txt"));
        return listaCategorie;
    }

    private static ListaCategorie inserisciESalvaCategioriaAttuatori(Manutentore manutentore, ListaCategorie listaCategorie) {
        do {
            boolean testoLiberoOK = false;
            ArrayList<ModalitaOperativa> modalitaOperative = new ArrayList<>();
            String nome = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome categoria attuatori: ");
            do {
                try {
                    String testoLibero = InputDati.leggiStringaNonVuota("Inserisci un testo libero di lunghezza massima " + CategoriaAttuatori.getLunghezzaMassima() + " caratteri: ");
                    do {
                        String nomeModalitaOperativa = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome della modalita operativa: ");

                        if (InputDati.yesOrNo("Vuoi inserire una modalita operativa con valore?")) {
                            double valore = InputDati.leggiDouble("Inserisci il valore:");
                            modalitaOperative.add(new ModalitaOperativa(nomeModalitaOperativa, valore));
                        } else {
                            modalitaOperative.add(new ModalitaOperativa(nomeModalitaOperativa));
                        }
                    } while (InputDati.yesOrNo("Vuoi inserire un'altra modalita operativa?"));
                    manutentore.inserisciESalvaCategoriaAttuatori(listaCategorie, new CategoriaAttuatori(nome, testoLibero, modalitaOperative));
                    testoLiberoOK = true;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!testoLiberoOK);
            ServizioFile.salvaSingoloOggetto(new File("datiListaCategorie.txt"), listaCategorie);


        } while (InputDati.yesOrNo("Vuoi inserire un'altra categoria attuatori?"));
        listaCategorie = (ListaCategorie) ServizioFile.caricaSingoloOggetto(new File("datiListaCategorie.txt"));
        return listaCategorie;
    }


}