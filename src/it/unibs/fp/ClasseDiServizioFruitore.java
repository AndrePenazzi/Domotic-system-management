package it.unibs.fp;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class ClasseDiServizioFruitore {

    /**
     * Menu di visualizzazione delle descrizioni da parte del fruitore
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void stampaMenuFruitore(Contenitore contenitore) {
        boolean finito = false;
        String[] azione = {"Operazioni di visualizzazione", "Operazioni su un'unità immobiliare"};
        MyMenu menu = new MyMenu("Menu fruitore", azione);
        Manutentore manutentore = contenitore.getManutentore();
        Fruitore fruitore = manutentore.getFruitore();
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        System.out.println(fruitore.visualizzaUnitaImmobiliari());
        int unitaImm = InputDati.leggiIntero("Scegli l'unità immobiliare su cui fare le operazioni: ", 1, fruitore.getUnitaImmobiliari().size()) - 1;
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu principale");
                }
                break;

                case 1: {
                    stampaMenuFruitoreVisualizzazione(contenitore);
                }
                break;


                case 2: {
                    ClasseDiServizioFruitore.stampaMenuOperazioniFruitore(contenitore, fruitore, unitaImm);
                }
                break;
            }
        }
        while (!finito);
    }


    /**
     * Menu di visualizzazione delle descrizioni da parte del fruitore
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void stampaMenuFruitoreVisualizzazione(Contenitore contenitore) {
        boolean finito = false;
        String[] azione = {"Visualizza categorie sensori", "Visualizza categorie attuatori", "Visualizza stanze", "Visualizza artefatti", "Visualizza valore rilevato da un sensore"};
        MyMenu menu = new MyMenu("Menu fruitore", azione);
        Manutentore manutentore = contenitore.getManutentore();
        Fruitore fruitore = manutentore.getFruitore();
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        System.out.println(fruitore.visualizzaUnitaImmobiliari());
        int unitaImm = InputDati.leggiIntero("Scegli l'unità immobiliare su cui fare le operazioni: ", 1, fruitore.getUnitaImmobiliari().size()) - 1;
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu fruitore");
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
                    System.out.println(fruitore.visualizzaStanze(fruitore.getUnitaImmobiliari().get(unitaImm)));
                }
                break;

                case 4: {
                    System.out.println(fruitore.visualizzaArtefatti(fruitore.getUnitaImmobiliari().get(unitaImm)));
                }
                break;

                case 5: {
                    System.out.println(fruitore.valoriRilevati(fruitore.getUnitaImmobiliari().get(unitaImm)));
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
     * @param unitaImm    scelta
     */
    public static void stampaMenuOperazioniFruitore(Contenitore contenitore, Fruitore fruitore, int unitaImm) {

        boolean finito = false;
        String[] azione = {"Modifica modalità operativa di un attuatore in una stanza", "Modifica modalità operativa di un attuatore in un artefatto", "Aggiungi nuova regola", "Visualizza regole", "Modifica stato regola"};
        MyMenu menu = new MyMenu("Menu fruitore operazioni su " + fruitore.getUnitaImmobiliari().get(unitaImm).getNome(), azione);
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
                        System.out.println(fruitore.getUnitaImmobiliari().get(unitaImm).visualizzaStanze());
                        int stanzaScelta = InputDati.leggiIntero("Scegliere stanza :", 1, fruitore.getUnitaImmobiliari().get(--unitaImm).getSizeStanze());
                        Stanza stanza = fruitore.getUnitaImmobiliari().get(unitaImm).getStanze().get(--stanzaScelta);
                        if (InputDati.yesOrNo("Si vuole cambiare modalità operativa di un attautore di un artefatto ?")) {
                            System.out.println(stanza.visualizzaArtefatti());
                            int artefattoScelto = InputDati.leggiIntero("Scegliere artefatto :", 1, fruitore.getUnitaImmobiliari().get(--unitaImm).getSizeArtefatti());
                            Artefatto artefatto = fruitore.getUnitaImmobiliari().get(unitaImm).getArtefatti().get(--artefattoScelto);
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
                    ClasseDiServizioInserimenti.creaConseguenze(contenitore, unitaImm, fruitore);

                    ClasseDiServizioInserimenti.creaAntecedente(contenitore, unitaImm, fruitore);
                }
                break;

                case 4: {
                    System.out.println(fruitore.getUnitaImmobiliari().get(unitaImm).visualizzaRegole());
                }
                break;
                case 5: {
                    ClasseDiServizioInserimenti.cambiaStatoRegola(unitaImm, fruitore);
                }
                break;
            }
        } while (!finito);
    }
}
