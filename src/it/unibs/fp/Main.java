package it.unibs.fp;

import it.unibs.fp.mylib.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final String[] s = {"Accedi come manutentore", "Accedi come fruitore"};

    public static void main(String args[]) {

        Manutentore manutentore;
        UnitaImmobiliare unitaImmobiliare;
        Fruitore fruitore;
        ListaCategorie listaCategorie;

        File fM = new File("datiManutentore.txt");
        File fLC = new File("datiListaCategorie.txt");
        File fUI = new File("datiUnitaImmobiliare.txt");
        File fF = new File("datiFruitore.txt");

        if (fM.exists() && fLC.exists() && fUI.exists() && fF.exists()) {
            System.out.println("File caricati correttamente");
            manutentore = (Manutentore) ServizioFile.caricaSingoloOggetto(new File("datiManutentore.txt"));
            unitaImmobiliare = (UnitaImmobiliare) ServizioFile.caricaSingoloOggetto(new File("datiUnitaImmobiliare.txt"));
            fruitore = (Fruitore) ServizioFile.caricaSingoloOggetto(new File("datiFruitore.txt"));
            listaCategorie = (ListaCategorie) ServizioFile.caricaSingoloOggetto(new File("datiListaCategorie.txt"));
        }

        else {
            manutentore = new Manutentore();
            unitaImmobiliare = new UnitaImmobiliare("Casa di pav");
            fruitore = new Fruitore();
            listaCategorie = new ListaCategorie();
            ServizioFile.salvaSingoloOggetto(new File("datiManutentore.txt"), manutentore);
            ServizioFile.salvaSingoloOggetto(new File("datiUnitaImmobiliare.txt"), unitaImmobiliare);
            ServizioFile.salvaSingoloOggetto(new File("datiFruitore.txt"), fruitore);
            ServizioFile.salvaSingoloOggetto(new File("datiListaCategorie.txt"), listaCategorie);
        }



        System.out.println(BelleStringhe.incornicia("Benvenuto"));
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
                    stampaMenuManutentore(manutentore, unitaImmobiliare,listaCategorie);
                }
                break;

                case 2:{
                    stampaMenuVisualizzazione(listaCategorie,unitaImmobiliare);
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
                    stampaMenuVisualizzazione(listaCategorie,unitaImmobiliare);
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
                    do {
                        String nome = InputDati.leggiStringaNonVuota("Inserisci nome categoria sensori: ");
                        manutentore.inserisciESalvaCategoriaSensori(listaCategorie, new CategoriaSensori(nome));
                        ServizioFile.salvaSingoloOggetto(new File("datiListaCategorie.txt"), listaCategorie);
                    } while (InputDati.yesOrNo("Vuoi inserire un'altra categoria sensori?"));
                    listaCategorie = (ListaCategorie) ServizioFile.caricaSingoloOggetto(new File("datiListaCategorie.txt"));
                }
                break;
                //TODO fai nome categoria senza spazi univoco+testo libero con lunghezza predefinita+cosa misura
                case 2: {
                    do {
                        String nome = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome categoria attuatori: ");
                        manutentore.inserisciESalvaCategoriaAttuatori(listaCategorie, new CategoriaAttuatori(nome));
                        ServizioFile.salvaSingoloOggetto(new File("datiListaCategorie.txt"), listaCategorie);
                    } while (InputDati.yesOrNo("Vuoi inserire un'altra categoria attuatori?"));
                }
                break;

                case 3: {
                    do {
                        String nome = InputDati.leggiStringaNonVuota("Inserisci nome nuova stanza: ");
                        manutentore.inserisciStanza(new Stanza(nome), unitaImmobiliare);
                        ServizioFile.salvaSingoloOggetto(new File("datiUnitaImmobiliare.txt"), unitaImmobiliare);
                    } while (InputDati.yesOrNo("Vuoi inserire un'altra stanza?"));
                }
                break;

                case 4: {
                    do {
                        String nome = InputDati.leggiStringaNonVuota("Inserisci nome nuovo artefatto: ");
                        manutentore.inserisciArtefatto(new Artefatto(nome), unitaImmobiliare);
                        ServizioFile.salvaSingoloOggetto(new File("datiUnitaImmobiliare.txt"), unitaImmobiliare);
                    } while (InputDati.yesOrNo("Vuoi inserire un'altro artefatto?"));
                }
                break;

                case 5: {
                    do {
                        Sensore nuovoSensore = creaSensore(listaCategorie);
                        ArrayList<Stanza> stanze = scegliStanze(unitaImmobiliare);
                        unitaImmobiliare.associaSensoreAStanze(nuovoSensore, stanze);
                        ServizioFile.salvaSingoloOggetto(new File("datiUnitaImmobiliare.txt"), unitaImmobiliare);
                    } while (InputDati.yesOrNo("Vuoi associare un'altro sensore a una stanza?"));
                }
                break;

                case 6: {
                    do {
                        Attuatore nuovoAttuatore = creaAttuatore(listaCategorie);
                        ArrayList<Stanza> stanze = scegliStanze(unitaImmobiliare);
                        unitaImmobiliare.associaAttuatoreAStanze(nuovoAttuatore, stanze);
                        ServizioFile.salvaSingoloOggetto(new File("datiUnitaImmobiliare.txt"), unitaImmobiliare);
                    } while (InputDati.yesOrNo("Vuoi associare un'altro sensore a stanze?"));
                }
                break;

                case 7: {
                    do {
                        Sensore nuovoSensore = creaSensore(listaCategorie);
                        ArrayList<Artefatto> artefatti = scegliArtefatti(unitaImmobiliare);
                        unitaImmobiliare.associaSensoreAdArtefatti(nuovoSensore, artefatti);
                        ServizioFile.salvaSingoloOggetto(new File("datiUnitaImmobiliare.txt"), unitaImmobiliare);
                    } while (InputDati.yesOrNo("Vuoi associare un'altro sensore ad artefatti?"));
                }
                break;

                case 8: {
                    do {
                        Attuatore nuovoAttuatore = creaAttuatore(listaCategorie);
                        ArrayList<Artefatto> artefatti = scegliArtefatti(unitaImmobiliare);
                        unitaImmobiliare.associaAttuatoreAdArtefatti(nuovoAttuatore, artefatti);
                        ServizioFile.salvaSingoloOggetto(new File("datiUnitaImmobiliare.txt"), unitaImmobiliare);
                    } while (InputDati.yesOrNo("Vuoi associare un'altro attuatore ad artefatti?"));
                }
                break;
            }
        } while (!finito);

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

    /*
    Fine Scelta di artefatti e stanze -----------------------------------------------------------------------------
     */

    /*
    Inizio creazione attuatore e sensore -----------------------------------------------------------------------------
     */

    private static Attuatore creaAttuatore(ListaCategorie listaCategorie) {
        System.out.println(listaCategorie.visualizzaCategorieAttuatori());
        int categoria = InputDati.leggiIntero("Scegli categoria : ", 1, listaCategorie.getSizeCategorieAttuatori());
        categoria--;
        String nome = InputDati.leggiStringaNonVuota("Inserisci nome attuatori : ");
        nome += "_" + listaCategorie.getCategorieAttuatori().get(categoria);
        System.out.println("Si è creato l'attuatore " + nome);
        Attuatore nuovoAttuatore = new Attuatore(nome);
        return nuovoAttuatore;
    }

    private static Sensore creaSensore(ListaCategorie listaCategorie) {
        System.out.println(listaCategorie.visualizzaCategorieSensori());
        int categoria = InputDati.leggiIntero("Scegli categoria : ", 1, listaCategorie.getSizeCategorieSensori());
        categoria--;
        String nome = InputDati.leggiStringaNonVuota("Inserisci nome sensore : ");
        nome += "_" + listaCategorie.getCategorieSensori().get(categoria);
        System.out.println("Si è creato il sensore " + nome);
        Sensore nuovoSensore = new Sensore(nome);
        return nuovoSensore;
    }

    /*
    Fine creazione attuatore e sensore -----------------------------------------------------------------------------
     */

    /*
    Fine Manutentore-----------------------------------------------------------------------------------------------------
     */

}
