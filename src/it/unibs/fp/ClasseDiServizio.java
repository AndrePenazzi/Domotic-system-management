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
        MyMenu menu = new MyMenu("Menu principale", azione);
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
        String[] azione = {"Inserisci unità immobiliare", "Inserisci e associa", "Visualizza categorie e valori rilevati", "Elimina salvataggi"};
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
                    inserisciUnitaImmobiliare(contenitore);
                }
                break;

                case 2: {
                    stampaMenuManutentoreInserisciEAssocia(contenitore);
                }
                break;

                case 3: {
                    stampaMenuVisualizzazioneManutentore(contenitore);
                }
                break;
                //TODO SE RIESCI FALLO SE NO BUTTA VIA
                case 4: {
                    System.out.println("Eliminazione");
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
                    stampaMenuOperazioniFruitore(contenitore, fruitore);
                }
                break;
            }
        }
        while (!finito);
    }

    /**
     * Stampa il menu con le operazioni del fruitore
     *
     * @param contenitore per ottenere gli oggetti necessari
     * @param fruitore    scelto
     */
    public static void stampaMenuOperazioniFruitore(Contenitore contenitore, Fruitore fruitore) {
        System.out.println(fruitore.visualizzaUnitaImmobiliari());
        int unitaImm = InputDati.leggiIntero("Scegli l'unità immobiliare su cui fare le operazioni", 1, fruitore.getUnitaImmobiliari().size());
        boolean finito = false;
        String[] azione = {"Modifica modalità operativa di un attuatore in una stanza", "Modifica modalità operativa di un attuatore in un artefatto", "Aggiungi nuova regola"};
        MyMenu menu = new MyMenu("Menu fruitore operazioni su " + fruitore.getUnitaImmobiliari().get(--unitaImm), azione);
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
                        System.out.println(fruitore.getUnitaImmobiliari().get(--unitaImm).visualizzaStanze());
                        int stanzaScelta = InputDati.leggiIntero("Scegliere stanza :", 1, fruitore.getUnitaImmobiliari().get(--unitaImm).getSizeStanze());
                        Stanza stanza = fruitore.getUnitaImmobiliari().get(--unitaImm).getStanze().get(--stanzaScelta);
                        if (InputDati.yesOrNo("Si vuole cambiare modalità operativa di un attautore di un artefatto ?")) {
                            System.out.println(stanza.visualizzaArtefatti());
                            int artefattoScelto = InputDati.leggiIntero("Scegliere artefatto :", 1, fruitore.getUnitaImmobiliari().get(--unitaImm).getSizeArtefatti());
                            Artefatto artefatto = fruitore.getUnitaImmobiliari().get(--unitaImm).getArtefatti().get(--artefattoScelto);
                            System.out.println(artefatto.visualizzaAttuatori());

                            int attuatoreScelto = InputDati.leggiIntero("Scegliere attuatore :", 1, artefatto.getAttuatori().size());
                            Attuatore attuatore = artefatto.getAttuatori().get(--attuatoreScelto);
                            System.out.println(attuatore.getCategoriaAttuatori().toString());

                            int modalitaOperativaScelta = InputDati.leggiIntero("Scegliere modalità operativa :", 1, attuatore.getCategoriaAttuatori().getModalitaOperative().size());
                            ModOperativa modOperativa = attuatore.getCategoriaAttuatori().getModalitaOperative().get(--modalitaOperativaScelta);

                            if (modOperativa.getType() == 1) {
                                double valore = InputDati.leggiDouble("Inserisci valore : ");
                                ((ModOperativaNonParamentrica) fruitore.getUnitaImmobiliari().get(--unitaImm).getStanze().get(stanzaScelta).getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setValore(valore);
                            } else {
                                ModOperativaParamentrica modOperativaParamentrica = (ModOperativaParamentrica) modOperativa;
                                System.out.println(modOperativaParamentrica.toString());
                                int paremetroScelto = InputDati.leggiIntero("Scegliere parametro modalità operativa", 1, modOperativaParamentrica.getParamentri().size());
                                ((ModOperativaParamentrica) fruitore.getUnitaImmobiliari().get(--unitaImm).getStanze().get(stanzaScelta).getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setParametroAttuale(modOperativaParamentrica.getParamentri().get(--paremetroScelto));
                            }
                        } else {
                            int attuatoreScelto = InputDati.leggiIntero("Scegliere attuatore :", 1, stanza.getAttuatori().size());
                            Attuatore attuatore = stanza.getAttuatori().get(--attuatoreScelto);
                            System.out.println(attuatore.getCategoriaAttuatori().toString());

                            int modalitaOperativaScelta = InputDati.leggiIntero("Scegliere modalità operativa :", 1, attuatore.getCategoriaAttuatori().getModalitaOperative().size());
                            ModOperativa modOperativa = attuatore.getCategoriaAttuatori().getModalitaOperative().get(--modalitaOperativaScelta);

                            if (modOperativa.getType() == 1) {
                                double valore = InputDati.leggiDouble("Inserisci valore : ");
                                ((ModOperativaNonParamentrica) fruitore.getUnitaImmobiliari().get(--unitaImm).getStanze().get(stanzaScelta).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setValore(valore);
                            } else {
                                ModOperativaParamentrica modOperativaParamentrica = (ModOperativaParamentrica) modOperativa;
                                System.out.println(modOperativaParamentrica.toString());
                                int paremetroScelto = InputDati.leggiIntero("Scegliere parametro modalità operativa", 1, modOperativaParamentrica.getParamentri().size());
                                ((ModOperativaParamentrica) fruitore.getUnitaImmobiliari().get(--unitaImm).getStanze().get(stanzaScelta).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setParametroAttuale(modOperativaParamentrica.getParamentri().get(--paremetroScelto));
                            }
                        }
                    }
                }
                break;
                case 2: {
                    if (InputDati.yesOrNo("Si vuole cambiare modalità operativa di un attautore in un artefatto ?")) {
                        System.out.println(fruitore.getUnitaImmobiliari().get(--unitaImm).visualizzaArtefatti());
                        int artefattoScelto = InputDati.leggiIntero("Scegliere artefatto :", 1, fruitore.getUnitaImmobiliari().get(--unitaImm).getSizeArtefatti());
                        Artefatto artefatto = fruitore.getUnitaImmobiliari().get(--unitaImm).getArtefatti().get(--artefattoScelto);
                        System.out.println(artefatto.visualizzaAttuatori());

                        int attuatoreScelto = InputDati.leggiIntero("Scegliere attuatore :", 1, artefatto.getAttuatori().size());
                        Attuatore attuatore = artefatto.getAttuatori().get(--attuatoreScelto);
                        System.out.println(attuatore.getCategoriaAttuatori().toString());

                        int modalitaOperativaScelta = InputDati.leggiIntero("Scegliere modalità operativa :", 1, attuatore.getCategoriaAttuatori().getModalitaOperative().size());
                        ModOperativa modOperativa = attuatore.getCategoriaAttuatori().getModalitaOperative().get(--modalitaOperativaScelta);

                        if (modOperativa.getType() == 1) {
                            double valore = InputDati.leggiDouble("Inserisci valore : ");
                            ((ModOperativaNonParamentrica) fruitore.getUnitaImmobiliari().get(--unitaImm).getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setValore(valore);
                        } else {
                            ModOperativaParamentrica modOperativaParamentrica = (ModOperativaParamentrica) modOperativa;
                            System.out.println(modOperativaParamentrica.toString());
                            int parametroScelto = InputDati.leggiIntero("Scegliere parametro modalità operativa", 1, modOperativaParamentrica.getParamentri().size());
                            ((ModOperativaParamentrica) fruitore.getUnitaImmobiliari().get(--unitaImm).getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setParametroAttuale(modOperativaParamentrica.getParamentri().get(--parametroScelto));
                        }
                    }
                }
                break;
                case 3: {
                    boolean flag;
                    do {
                        if (InputDati.yesOrNo("Si vuole scegliere un attuatore di una stanza ?")) {
                            System.out.println(fruitore.getUnitaImmobiliari().get(--unitaImm).visualizzaStanze());
                            int stanzaScelta = InputDati.leggiIntero("Scegliere stanza :", 1, fruitore.getUnitaImmobiliari().get(--unitaImm).getSizeStanze());
                            Stanza stanza = fruitore.getUnitaImmobiliari().get(--unitaImm).getStanze().get(--stanzaScelta);

                            if (InputDati.yesOrNo("Si vuole scegliere l'attautore di un artefatto ?")) {
                                System.out.println(stanza.visualizzaArtefatti());
                                int artefattoScelto = InputDati.leggiIntero("Scegliere artefatto :", 1, fruitore.getUnitaImmobiliari().get(--unitaImm).getSizeArtefatti());
                                Artefatto artefatto = fruitore.getUnitaImmobiliari().get(--unitaImm).getArtefatti().get(--artefattoScelto);
                                System.out.println(artefatto.visualizzaAttuatori());

                                int attuatoreScelto = InputDati.leggiIntero("Scegliere attuatore :", 1, artefatto.getAttuatori().size());
                                Attuatore attuatore = artefatto.getAttuatori().get(--attuatoreScelto);
                                System.out.println(attuatore.getCategoriaAttuatori().toString());

                                int modalitaOperativaScelta = InputDati.leggiIntero("Scegliere modalità operativa :", 1, attuatore.getCategoriaAttuatori().getModalitaOperative().size());
                                ModOperativa mTMP = attuatore.getCategoriaAttuatori().getModalitaOperative().get(--modalitaOperativaScelta);

                                if (mTMP.getType() == 1) {
                                    double valore = InputDati.leggiDouble("Inserisci valore : ");
                                    ((ModOperativaNonParamentrica) fruitore.getUnitaImmobiliari().get(--unitaImm).getStanze().get(stanzaScelta).getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setValore(valore);
                                } else {
                                    ModOperativaParamentrica modOperativaParamentrica = (ModOperativaParamentrica) mTMP;
                                    System.out.println(modOperativaParamentrica.toString());
                                    int paremetroScelto = InputDati.leggiIntero("Scegliere parametro modalità operativa", 1, modOperativaParamentrica.getParamentri().size());
                                    ((ModOperativaParamentrica) fruitore.getUnitaImmobiliari().get(--unitaImm).getStanze().get(stanzaScelta).getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setParametroAttuale(modOperativaParamentrica.getParamentri().get(--paremetroScelto));
                                }
                                inserisciNuovaRegola(contenitore, fruitore.getUnitaImmobiliari().get(--unitaImm), attuatore, mTMP);
                            } else {
                                int attuatoreScelto = InputDati.leggiIntero("Scegliere attuatore :", 1, stanza.getAttuatori().size());
                                Attuatore attuatore = stanza.getAttuatori().get(--attuatoreScelto);
                                System.out.println(attuatore.getCategoriaAttuatori().toString());

                                int modalitaOperativaScelta = InputDati.leggiIntero("Scegliere modalità operativa :", 1, attuatore.getCategoriaAttuatori().getModalitaOperative().size());
                                ModOperativa mTMP = attuatore.getCategoriaAttuatori().getModalitaOperative().get(--modalitaOperativaScelta);

                                if (mTMP.getType() == 1) {
                                    double valore = InputDati.leggiDouble("Inserisci valore : ");
                                    ((ModOperativaNonParamentrica) fruitore.getUnitaImmobiliari().get(--unitaImm).getStanze().get(stanzaScelta).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setValore(valore);
                                } else {
                                    ModOperativaParamentrica modOperativaParamentrica = (ModOperativaParamentrica) mTMP;
                                    System.out.println(modOperativaParamentrica.toString());
                                    int paremetroScelto = InputDati.leggiIntero("Scegliere parametro modalità operativa", 1, modOperativaParamentrica.getParamentri().size());
                                    ((ModOperativaParamentrica) fruitore.getUnitaImmobiliari().get(--unitaImm).getStanze().get(stanzaScelta).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setParametroAttuale(modOperativaParamentrica.getParamentri().get(--paremetroScelto));
                                }
                                inserisciNuovaRegola(contenitore, fruitore.getUnitaImmobiliari().get(--unitaImm), attuatore, mTMP);
                            }
                        } else if (InputDati.yesOrNo("Si vuole scegliere un attuatore di un artefatto ?")) {
                            System.out.println(fruitore.getUnitaImmobiliari().get(--unitaImm).visualizzaArtefatti());
                            int artefattoScelto = InputDati.leggiIntero("Scegliere artefatto :", 1, fruitore.getUnitaImmobiliari().get(--unitaImm).getSizeArtefatti());
                            Artefatto artefatto = fruitore.getUnitaImmobiliari().get(--unitaImm).getArtefatti().get(--artefattoScelto);
                            System.out.println(artefatto.visualizzaAttuatori());

                            int attuatoreScelto = InputDati.leggiIntero("Scegliere attuatore :", 1, artefatto.getAttuatori().size());
                            Attuatore attuatore = artefatto.getAttuatori().get(--attuatoreScelto);
                            System.out.println(attuatore.getCategoriaAttuatori().toString());

                            int modalitaOperativaScelta = InputDati.leggiIntero("Scegliere modalità operativa :", 1, attuatore.getCategoriaAttuatori().getModalitaOperative().size());
                            ModOperativa mTMP = attuatore.getCategoriaAttuatori().getModalitaOperative().get(--modalitaOperativaScelta);

                            if (mTMP.getType() == 1) {
                                double valore = InputDati.leggiDouble("Inserisci valore : ");
                                ((ModOperativaNonParamentrica) fruitore.getUnitaImmobiliari().get(--unitaImm).getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setValore(valore);
                            } else {
                                ModOperativaParamentrica modOperativaParamentrica = (ModOperativaParamentrica) mTMP;
                                System.out.println(modOperativaParamentrica.toString());
                                int parametroScelto = InputDati.leggiIntero("Scegliere parametro modalità operativa", 1, modOperativaParamentrica.getParamentri().size());
                                ((ModOperativaParamentrica) fruitore.getUnitaImmobiliari().get(--unitaImm).getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setParametroAttuale(modOperativaParamentrica.getParamentri().get(--parametroScelto));
                            }
                            inserisciNuovaRegola(contenitore, fruitore.getUnitaImmobiliari().get(--unitaImm), attuatore, mTMP);
                        }
                        flag = InputDati.yesOrNo("Vuoi continuare a creare conseguenze?");
                    } while (!flag);

//-------------------------------------------------------------------------------------------------------------------------------------------------
                    flag = false;
                    do {
                        if (InputDati.yesOrNo("Si vuole scegliere un sensore di una stanza?")) {
                            System.out.println(fruitore.getUnitaImmobiliari().get(--unitaImm).visualizzaStanze());
                            int stanzaScelta = InputDati.leggiIntero("Scegliere stanza :", 1, fruitore.getUnitaImmobiliari().get(--unitaImm).getSizeStanze());
                            Stanza stanza = fruitore.getUnitaImmobiliari().get(--unitaImm).getStanze().get(--stanzaScelta);
                            if (InputDati.yesOrNo("Si vuole scegliere l'attautore di un artefatto ?")) {
                                System.out.println(stanza.visualizzaArtefatti());
                                int artefattoScelto = InputDati.leggiIntero("Scegliere artefatto :", 1, fruitore.getUnitaImmobiliari().get(--unitaImm).getStanze().get(--stanzaScelta).getArtefatti().size());
                                Artefatto artefatto = fruitore.getUnitaImmobiliari().get(--unitaImm).getArtefatti().get(--artefattoScelto);
                                System.out.println(artefatto.visualizzaSensori());

                                int sensoreScelto = InputDati.leggiIntero("Scegliere sensore :", 1, artefatto.getSensori().size());
                                Sensore sensore = artefatto.getSensori().get(--sensoreScelto);
                                System.out.println(sensore.getCategoriaSensori().toString());

                                int infoRilevabileScelta = InputDati.leggiIntero("Scegliere informazione rilevabile :", 1, sensore.getCategoriaSensori().getInformazioniRilevabili().size());
                                InfoRilevabile iTMP = sensore.getCategoriaSensori().getInformazioniRilevabili().get(--infoRilevabileScelta);
                                //numerico
                                if (iTMP.getType() == 1) {
                                    if (InputDati.yesOrNo("Vuoi confrontare con una costante?")) {
                                        InfoRilevabileNumerica iNTMP = (InfoRilevabileNumerica) iTMP;
                                        OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.sceltaOperatoreRelazionale();
                                        double costante = InputDati.leggiDouble("Inserire la costante con cui confrontare: ", iNTMP.getMin(), iNTMP.getMax());
                                        aggiungiCostituenteLogicoAregola(contenitore, fruitore.getUnitaImmobiliari().get(--unitaImm), iNTMP, costante, operatoreRelazionale);
                                    } else {
                                        InfoRilevabileNumerica iNTMP = (InfoRilevabileNumerica) iTMP;
                                        OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.sceltaOperatoreRelazionale();

                                        int sensoreScelto2 = InputDati.leggiIntero("Scegliere sensore :", 1, artefatto.getSensori().size());
                                        Sensore sensore2 = artefatto.getSensori().get(--sensoreScelto);
                                        System.out.println(sensore.getCategoriaSensori().toString());
                                        int infoRilevabileScelta2 = InputDati.leggiIntero("Scegliere informazione rilevabile :", 1, sensore.getCategoriaSensori().getInformazioniRilevabili().size());
                                        InfoRilevabile iTMP2 = sensore.getCategoriaSensori().getInformazioniRilevabili().get(--infoRilevabileScelta);
                                        InfoRilevabileNumerica iNTMP2 = (InfoRilevabileNumerica) iTMP2;
                                        aggiungiCostituenteLogicoAregola(contenitore, fruitore.getUnitaImmobiliari().get(--unitaImm), iNTMP, iNTMP2, operatoreRelazionale);
                                    }

                                }
                                //parametrico
                                else {
                                    InfoRilevabileNonNumerica iNNTMP = (InfoRilevabileNonNumerica) iTMP;
                                    System.out.println("L'operatore logico predefinito è =");
                                    String parametro = scegliParametroConCuiConfrontare(iNNTMP);
                                    OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.sceltaOperatoreRelazionale();
                                    aggiungiCostituenteLogicoAregola(contenitore,fruitore.getUnitaImmobiliari().get(--unitaImm),iNNTMP,parametro,operatoreRelazionale);
                                }
                            } else {
                                int attuatoreScelto = InputDati.leggiIntero("Scegliere attuatore :", 1, stanza.getAttuatori().size());
                                Attuatore attuatore = stanza.getAttuatori().get(--attuatoreScelto);
                                System.out.println(attuatore.getCategoriaAttuatori().toString());

                                int modalitaOperativaScelta = InputDati.leggiIntero("Scegliere modalità operativa :", 1, attuatore.getCategoriaAttuatori().getModalitaOperative().size());
                                ModOperativa mTMP = attuatore.getCategoriaAttuatori().getModalitaOperative().get(--modalitaOperativaScelta);

                                if (mTMP.getType() == 1) {
                                    double valore = InputDati.leggiDouble("Inserisci valore : ");
                                    ((ModOperativaNonParamentrica) fruitore.getUnitaImmobiliari().get(--unitaImm).getStanze().get(stanzaScelta).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setValore(valore);
                                } else {
                                    ModOperativaParamentrica modOperativaParamentrica = (ModOperativaParamentrica) mTMP;
                                    System.out.println(modOperativaParamentrica.toString());
                                    int paremetroScelto = InputDati.leggiIntero("Scegliere parametro modalità operativa", 1, modOperativaParamentrica.getParamentri().size());
                                    ((ModOperativaParamentrica) fruitore.getUnitaImmobiliari().get(--unitaImm).getStanze().get(stanzaScelta).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setParametroAttuale(modOperativaParamentrica.getParamentri().get(--paremetroScelto));
                                }
                                inserisciNuovaRegola(contenitore, fruitore.getUnitaImmobiliari().get(--unitaImm), attuatore, mTMP);
                            }
                        } else if (InputDati.yesOrNo("Si vuole cambiare modalità operativa di un attautore in un artefatto ?")) {
                            System.out.println(fruitore.getUnitaImmobiliari().get(--unitaImm).visualizzaArtefatti());
                            int artefattoScelto = InputDati.leggiIntero("Scegliere artefatto :", 1, fruitore.getUnitaImmobiliari().get(--unitaImm).getSizeArtefatti());
                            Artefatto artefatto = fruitore.getUnitaImmobiliari().get(--unitaImm).getArtefatti().get(--artefattoScelto);
                            System.out.println(artefatto.visualizzaAttuatori());

                            int attuatoreScelto = InputDati.leggiIntero("Scegliere attuatore :", 1, artefatto.getAttuatori().size());
                            Attuatore attuatore = artefatto.getAttuatori().get(--attuatoreScelto);
                            System.out.println(attuatore.getCategoriaAttuatori().toString());

                            int modalitaOperativaScelta = InputDati.leggiIntero("Scegliere modalità operativa :", 1, attuatore.getCategoriaAttuatori().getModalitaOperative().size());
                            ModOperativa mTMP = attuatore.getCategoriaAttuatori().getModalitaOperative().get(--modalitaOperativaScelta);

                            if (mTMP.getType() == 1) {
                                double valore = InputDati.leggiDouble("Inserisci valore : ");
                                ((ModOperativaNonParamentrica) fruitore.getUnitaImmobiliari().get(--unitaImm).getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setValore(valore);
                            } else {
                                ModOperativaParamentrica modOperativaParamentrica = (ModOperativaParamentrica) mTMP;
                                System.out.println(modOperativaParamentrica.toString());
                                int parametroScelto = InputDati.leggiIntero("Scegliere parametro modalità operativa", 1, modOperativaParamentrica.getParamentri().size());
                                ((ModOperativaParamentrica) fruitore.getUnitaImmobiliari().get(--unitaImm).getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setParametroAttuale(modOperativaParamentrica.getParamentri().get(--parametroScelto));
                            }
                            inserisciNuovaRegola(contenitore, fruitore.getUnitaImmobiliari().get(--unitaImm), attuatore, mTMP);
                        }
                        flag = InputDati.yesOrNo("Vuoi continuare a creare nuove regole?");
                    } while (!flag);
                }

                break;
            }
        }while (!finito);
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
    //----------------------------------ASSOCIA-----------------------------------------------------

    /**
     * Associa un sensore ad una o più stanze
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    private static void associaSensoreAStanze(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(manutentore);

        if (!listaCategorie.getCategorieSensori().isEmpty() && !unitaImmobiliare.getStanze().isEmpty()) {
            do {
                Sensore nuovoSensore = creaSensore(listaCategorie);
                ArrayList<Stanza> stanze = scegliStanze(unitaImmobiliare);
                manutentore.associaSensoreAStanze(nuovoSensore, stanze, unitaImmobiliare);

                contenitore.setListaCategorie(listaCategorie);
                contenitore.setManutentore(manutentore);
                ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);
            } while (InputDati.yesOrNo("Vuoi associare un'altro sensore a una stanza?"));
        } else {
            if (listaCategorie.getCategorieSensori().isEmpty())
                System.out.println("Bisogna prima creare una categoria sensori");
            if (unitaImmobiliare.getStanze().isEmpty())
                System.out.println("Bisogna prima avere una stanza nell'unità immobiliare");
        }
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

        if (!listaCategorie.getCategorieAttuatori().isEmpty() && !unitaImmobiliare.getStanze().isEmpty()) {
            do {
                Attuatore nuovoAttuatore = creaAttuatore(listaCategorie);
                ArrayList<Stanza> stanze = scegliStanze(unitaImmobiliare);
                manutentore.associaAttuatoreAStanze(nuovoAttuatore, stanze, unitaImmobiliare);
                contenitore.setListaCategorie(listaCategorie);
                contenitore.setManutentore(manutentore);
                ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);
            } while (InputDati.yesOrNo("Vuoi associare un'altro sensore a stanze?"));
        } else {
            if (listaCategorie.getCategorieAttuatori().isEmpty())
                System.out.println("Bisogna prima creare una categoria attuatori");
            if (unitaImmobiliare.getStanze().isEmpty())
                System.out.println("Bisogna prima avere una stanza nell'unità immobiliare");
        }
    }

    /**
     * Associa un sensore ad uno o piu artefatti
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    private static void associaSensoreAdArtefatti(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(manutentore);
        if (!unitaImmobiliare.getArtefatti().isEmpty() && !listaCategorie.getCategorieSensori().isEmpty()) {
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
        } else {
            if (listaCategorie.getCategorieSensori().isEmpty())
                System.out.println("Bisogna prima creare una categoria sensori");
            if (unitaImmobiliare.getArtefatti().isEmpty())
                System.out.println("Bisogna prima avere un artefatto nell'unità immobiliare");
        }
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
        if (!unitaImmobiliare.getArtefatti().isEmpty() && !listaCategorie.getCategorieAttuatori().isEmpty()) {
            do {
                Attuatore nuovoAttuatore = creaAttuatore(listaCategorie);
                ArrayList<Artefatto> artefatti = scegliArtefatti(unitaImmobiliare);
                manutentore.associaAttuatoreAdArtefatti(nuovoAttuatore, artefatti, unitaImmobiliare);

                contenitore.setListaCategorie(listaCategorie);
                contenitore.setManutentore(manutentore);
                ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);
            } while (InputDati.yesOrNo("Vuoi associare un'altro attuatore ad artefatti?"));
        } else {
            if (listaCategorie.getCategorieAttuatori().isEmpty())
                System.out.println("Bisogna prima creare una categoria attuatori");
            if (unitaImmobiliare.getArtefatti().isEmpty())
                System.out.println("Bisogna prima avere un artefatto nell'unità immobiliare");
        }
    }

    /**
     * Inserisci una nuova unitàImmobiliare
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    public static void inserisciUnitaImmobiliare(Contenitore contenitore) {
        Manutentore manutentore = contenitore.getManutentore();
        String nomeUnitaImmobiliare = InputDati.leggiStringaNonVuota("Inserisci nome della unità immobiliare da inserire :");
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare(nomeUnitaImmobiliare);
        manutentore.aggiungiUnitaImmobiliare(unitaImmobiliare);
        contenitore.setManutentore(manutentore);
        ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);
    }
    //-----------------------------FINE ASSOCIA-----------------------------------------------------

    //-----------------------------INSERISCI-----------------------------------------------------

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
        ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);
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

    /**
     * Inserisci uno o piu nuovi artefatti
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    private static void inserisciNuovoArtefatto(Contenitore contenitore) {
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(manutentore);
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
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(manutentore);
        do {
            String nome = InputDati.leggiStringaNonVuota("Inserisci nome nuova stanza: ");
            manutentore.inserisciStanza(new Stanza(nome), unitaImmobiliare);

            contenitore.setManutentore(manutentore);
            ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);
        } while (InputDati.yesOrNo("Vuoi inserire un'altra stanza?"));
    }

    /**
     * Inserisci le informazioni rilevabili
     *
     * @return l'informazione rilevabile con scelta se numerica o non
     */
    private static InfoRilevabile inserisciInfoRilevabili() {
        InfoRilevabile infoRilevabile;
        int scelta = InputDati.leggiIntero("Premere 1 per inserire informazioni rilevabili con valore numerico e 2 informazioni rilevabili con valore non numerico: ", 1, 2);
        if (scelta == 1)
            infoRilevabile = inserisciInfoRilevabileNumerica();
        else
            infoRilevabile = inserisciInfoRilevabileNonNumerica();

        return infoRilevabile;

    }

    /**
     * Inserisci informazione rilevabile numerica
     *
     * @return l'informazione rilevabile
     */
    private static InfoRilevabile inserisciInfoRilevabileNumerica() {
        InfoRilevabile informazioneRilevabile = null;
        boolean infoRilevabileOK = false;
        String nomeInfo = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome di informazione rilevabile: ");
        do {
            try {
                double min = InputDati.leggiDouble("Inserisci il valore minimo rilevabile: ");
                double max = InputDati.leggiDouble("Inserisci il valore massimo rilevabile: ");

                informazioneRilevabile = new InfoRilevabileNumerica(nomeInfo, min, max);
                infoRilevabileOK = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!infoRilevabileOK);


        return informazioneRilevabile;
    }

    /**
     * Inserisci informazione rilevabile non numerica
     *
     * @return l'informazione rilevabile
     */
    private static InfoRilevabile inserisciInfoRilevabileNonNumerica() {
        InfoRilevabile informazioneRilevabile = null;
        boolean infoRilevabileOK = false;

        String nomeInfo = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome di informazione rilevabile: ");
        do {
            try {
                ArrayList<String> valoriNonNumerici = new ArrayList<>();
                do {
                    valoriNonNumerici.add(InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci un valore rilevabile non numerico:"));

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
     * Inserisci una modalità operativa con scelta
     *
     * @return la modalità operativa
     */
    public static ModOperativa inserisciModalitaOperativa() {
        ModOperativa modOperative;
        int scelta = InputDati.leggiIntero("Premere 1 per inserire modalità operative non parametriche e 2 per modalità operative parametriche: ", 1, 2);
        if (scelta == 1)
            modOperative = inserisciModalitaOperativaNonParametrica();
        else
            modOperative = inserisciModalitaOperativaParametrica();

        return modOperative;
    }

    /**
     * Inserisci una modalità operativa non parametrica
     *
     * @return la modalità operativa
     */
    public static ModOperativa inserisciModalitaOperativaNonParametrica() {
        ModOperativa modOperative;
        String nomeModalitaOperativa = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome della modalita operativa: ");
        if (InputDati.yesOrNo("Vuoi inserire una modalita operativa con valore?")) {
            double valore = InputDati.leggiDouble("Inserisci il valore: ");
            modOperative = new ModOperativaNonParamentrica(nomeModalitaOperativa, valore);
        } else {
            modOperative = new ModOperativaNonParamentrica(nomeModalitaOperativa);
        }
        return modOperative;
    }

    /**
     * Inserisci una modalità operativa parametrica
     *
     * @return la modalità operativa
     */
    public static ModOperativa inserisciModalitaOperativaParametrica() {
        ModOperativa modOperative;
        ArrayList<String> parametri = new ArrayList<>();
        String nomeModalitaOperativa = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome della modalita operativa: ");
        do {
            parametri.add(InputDati.leggiStringaNonVuota("Inserisci parametro: "));
        } while (InputDati.yesOrNo("Vuoi inserire un'altro parametro nella modalità operativa?"));
        modOperative = new ModOperativaParamentrica(nomeModalitaOperativa, parametri);
        return modOperative;
    }

    //TODO
    public static Fruitore inserisciNuovaRegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, Attuatore attuatore, ModOperativa modOperativa) {
        Fruitore fruitore = contenitore.getFruitore();
        fruitore.inserisciRegola(unitaImmobiliare, attuatore, modOperativa);
        return fruitore;
    }

    public static Fruitore aggiungiAzione(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, Attuatore attuatore, ModOperativa modOperativa) {
        Fruitore fruitore = contenitore.getFruitore();
        int i = scegliRegola(unitaImmobiliare);
        fruitore.aggiungiAzione(unitaImmobiliare, unitaImmobiliare.getRegole().get(i), attuatore, modOperativa);
        return fruitore;
    }

    public static Fruitore aggiungiCostituenteLogicoAregola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, InfoRilevabile secondoOpLogico, OperatoriRelazionali opRelazionale) {
        Fruitore fruitore = contenitore.getFruitore();
        if (unitaImmobiliare.getRegole().isEmpty())
            fruitore = aggiungiPrimoCosituenteLogicoARegola(contenitore, unitaImmobiliare, primoOpLogico, secondoOpLogico, opRelazionale);
        else {
            OperatoriBooleani operatoreBooleano = OperatoriBooleani.sceltaOperatoreBooleano();
            fruitore = aggiungiEnnesimoCosituenteLogicoARegola(contenitore, unitaImmobiliare, primoOpLogico, secondoOpLogico, opRelazionale, operatoreBooleano);
        }
        return fruitore;
    }

    public static Fruitore aggiungiCostituenteLogicoAregola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, Double secondoOpLogico, OperatoriRelazionali opRelazionale) {
        Fruitore fruitore = contenitore.getFruitore();
        if (unitaImmobiliare.getRegole().isEmpty())
            fruitore = aggiungiPrimoCosituenteLogicoARegola(contenitore, unitaImmobiliare, primoOpLogico, secondoOpLogico, opRelazionale);
        else {
            OperatoriBooleani operatoreBooleano = OperatoriBooleani.sceltaOperatoreBooleano();
            fruitore = aggiungiEnnesimoCosituenteLogicoARegola(contenitore, unitaImmobiliare, primoOpLogico, secondoOpLogico, opRelazionale, operatoreBooleano);
        }
        return fruitore;
    }

    public static Fruitore aggiungiCostituenteLogicoAregola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, String secondoOpLogico, OperatoriRelazionali opRelazionale) {
        Fruitore fruitore = contenitore.getFruitore();
        if (unitaImmobiliare.getRegole().isEmpty())
            fruitore = aggiungiPrimoCosituenteLogicoARegola(contenitore, unitaImmobiliare, primoOpLogico, secondoOpLogico, opRelazionale);
        else {
            OperatoriBooleani operatoreBooleano = OperatoriBooleani.sceltaOperatoreBooleano();
            fruitore = aggiungiEnnesimoCosituenteLogicoARegola(contenitore, unitaImmobiliare, primoOpLogico, secondoOpLogico, opRelazionale, operatoreBooleano);
        }
        return fruitore;
    }

    public static Fruitore aggiungiPrimoCosituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, InfoRilevabile secondoOpLogico, OperatoriRelazionali opRelazionale) {
        Fruitore fruitore = contenitore.getFruitore();
        int i = scegliRegola(unitaImmobiliare);
        fruitore.aggiungiPrimoCosituenteLogicoARegola(unitaImmobiliare, unitaImmobiliare.getRegole().get(i), primoOpLogico, secondoOpLogico, opRelazionale);
        return fruitore;
    }

    public static Fruitore aggiungiPrimoCosituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, double secondoOpLogico, OperatoriRelazionali opRelazionale) {
        Fruitore fruitore = contenitore.getFruitore();
        int i = scegliRegola(unitaImmobiliare);
        fruitore.aggiungiPrimoCosituenteLogicoARegola(unitaImmobiliare, unitaImmobiliare.getRegole().get(i), primoOpLogico, secondoOpLogico, opRelazionale);
        return fruitore;
    }

    public static Fruitore aggiungiPrimoCosituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, String secondoOpLogico, OperatoriRelazionali opRelazionale) {
        Fruitore fruitore = contenitore.getFruitore();
        int i = scegliRegola(unitaImmobiliare);
        fruitore.aggiungiPrimoCosituenteLogicoARegola(unitaImmobiliare, unitaImmobiliare.getRegole().get(i), primoOpLogico, secondoOpLogico, opRelazionale);
        return fruitore;
    }

    public static Fruitore aggiungiEnnesimoCosituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, InfoRilevabile secondoOpLogico, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano) {
        Fruitore fruitore = contenitore.getFruitore();
        int i = scegliRegola(unitaImmobiliare);
        fruitore.aggiungiEnnesimoCosituenteLogicoARegola(unitaImmobiliare, unitaImmobiliare.getRegole().get(i), primoOpLogico, secondoOpLogico, opRelazionale, opBooleano);
        return fruitore;
    }

    public static Fruitore aggiungiEnnesimoCosituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, double secondoOpLogico, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano) {
        Fruitore fruitore = contenitore.getFruitore();
        int i = scegliRegola(unitaImmobiliare);
        fruitore.aggiungiEnnesimoCosituenteLogicoARegola(unitaImmobiliare, unitaImmobiliare.getRegole().get(i), primoOpLogico, secondoOpLogico, opRelazionale, opBooleano);
        return fruitore;
    }

    public static Fruitore aggiungiEnnesimoCosituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, String secondoOpLogico, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano) {
        Fruitore fruitore = contenitore.getFruitore();
        int i = scegliRegola(unitaImmobiliare);
        fruitore.aggiungiEnnesimoCosituenteLogicoARegola(unitaImmobiliare, unitaImmobiliare.getRegole().get(i), primoOpLogico, secondoOpLogico, opRelazionale, opBooleano);
        return fruitore;
    }

    public static int scegliRegola(UnitaImmobiliare unitaImmobiliare) {
        System.out.println(unitaImmobiliare.visualizzaRegole());
        return InputDati.leggiIntero("Scegli la regola:", 1, unitaImmobiliare.getRegole().size()) - 1;
    }

    /**
     * Scegli un unità immobiliare
     *
     * @param manutentore che gestisce le unitaImmobiliari
     * @return unitaImmobiliare scelta
     */
    private static UnitaImmobiliare scegliUnitaImmobiliare(Manutentore manutentore) {
        ArrayList<UnitaImmobiliare> unitaImmobiliari = manutentore.getUnitaImmobiliari();
        System.out.println(manutentore.visualizzaListaUnitaImmobiliari());
        int unitaImmobiliareScelta = InputDati.leggiIntero("Scegli UnitaImmobiliare : ", 1, manutentore.getSizeUnitaImmobiliari());
        return unitaImmobiliari.get(--unitaImmobiliareScelta);
    }
    //-----------------------------FINE INSERISCI-----------------------------------------------

    //-----------------------------SCEGLI-------------------------------------------------------

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
            int artefattoIndex = InputDati.leggiIntero("Scegli artefatto : ", 1, unitaImmobiliare.getSizeArtefatti());
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
        int artefattoIndex = InputDati.leggiIntero("Scegli artefatto : ", 1, unitaImmobiliare.getSizeArtefatti());
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
    //-----------------------------FINE SCEGLI-----------------------------------------------------

    //-----------------------------CREA------------------------------------------------------------

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

    private static String scegliParametroConCuiConfrontare(InfoRilevabileNonNumerica infoRilevabileNonNumerica) {
        int i = 1;
        for(String valore: infoRilevabileNonNumerica.getValori()){
            System.out.println(i+" "+valore);
        }
        int scelta = InputDati.leggiIntero("Scegliere parametro con cui confrontare");
        return infoRilevabileNonNumerica.getValori().get(scelta);
    }
    //-----------------------------FINE CREA-----------------------------------------------------
}