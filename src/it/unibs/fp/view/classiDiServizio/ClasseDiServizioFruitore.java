package it.unibs.fp.view.classiDiServizio;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import it.unibs.fp.model.modalitaOperativa.ModOperativaNonParamentrica;
import it.unibs.fp.model.modalitaOperativa.ModOperativaParamentrica;
import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliari;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioArtefatto;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioUnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioUnitaImmobiliari;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.MyMenu;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.model.unitaImmobiliare.Stanza;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.model.utenti.Manutentore;

public class ClasseDiServizioFruitore {


    static void stampaMenuFruitore(Fruitore fruitore, UnitaImmobiliari unitaImmobiliari, ListaCategorie listaCategorie) {
        boolean finito = false;
        String[] azione = {"Operazioni di visualizzazione", "Operazioni su un'unità immobiliare"};
        MyMenu menu = new MyMenu("Menu fruitore", azione);
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
                    stampaMenuFruitoreVisualizzazione(fruitore, unitaImmobiliari, listaCategorie);
                }
                break;


                case 2: {
                    ClasseDiServizioFruitore.stampaMenuOperazioniFruitore(fruitore, unitaImmobiliari, listaCategorie);
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
    static void stampaMenuFruitoreVisualizzazione(Fruitore fruitore, UnitaImmobiliari unitaImmobiliari, ListaCategorie listaCategorie) {
        boolean finito = false;
        String[] azione = {"Visualizza categorie sensori", "Visualizza categorie attuatori", "Visualizza stanze", "Visualizza artefatti", "Visualizza valore rilevato da un sensore"};
        MyMenu menu = new MyMenu("Menu fruitore", azione);
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
    public static void stampaMenuOperazioniFruitore(Fruitore fruitore, UnitaImmobiliari unitaImmobiliari, ListaCategorie listaCategorie) {

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
                            System.out.println(ClasseDiServizioArtefatto.visualizzaAttuatori(artefatto));

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
                        System.out.println(ClasseDiServizioArtefatto.visualizzaAttuatori(artefatto));

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

                    ClasseDiServizioFruitore.cambiaStatoRegola(unitaImm, fruitore);
                }
                break;
            }
        } while (!finito);
    }

    static Fruitore cambiaStatoRegola(UnitaImmobiliari unitaImmobiliari, Fruitore fruitore) {
        UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(unitaImmobiliari);
        do {
            int regola=ClasseDiServizioUnitaImmobiliare.scegliIndexRegola(unitaImmobiliare);
            unitaImmobiliare.cambiaRegolaAttivaDisattiva(regola);
        } while (InputDati.yesOrNo("Vuoi modificare altre regole?"));
        return fruitore;
    }
}
