package it.unibs.fp.view.classiDiServizio.utenti;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliari;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioListaCategorie;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioUnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioUnitaImmobiliari;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.MyMenu;
import it.unibs.fp.model.utenti.Fruitore;

public class ClasseDiServizioFruitore {
    public static Fruitore creaFruitore() {
        String nome = InputDati.leggiStringaNonVuota("Inserisci il nome del fruitore:\n");
        return new Fruitore(nome);
    }

    public static void stampaMenuFruitore(UnitaImmobiliari unitaImmobiliari, ListaCategorie listaCategorie) {
        boolean finito = false;
        String[] azione = {"Operazioni di visualizzazione", "Operazioni su un'unità immobiliare"};
        MyMenu menu = new MyMenu("Menu fruitore", azione);
        System.out.println(ClasseDiServizioUnitaImmobiliari.visualizzaUnitaImmobiliari(unitaImmobiliari));
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu principale");
                }
                break;

                case 1: {
                    stampaMenuFruitoreVisualizzazione(unitaImmobiliari, listaCategorie);
                }
                break;


                case 2: {
                    ClasseDiServizioFruitore.stampaMenuOperazioniFruitore(unitaImmobiliari);
                }
                break;
            }
        }
        while (!finito);
    }

    public static void stampaMenuFruitoreVisualizzazione(UnitaImmobiliari unitaImmobiliari, ListaCategorie listaCategorie) {
        boolean finito = false;
        String[] azione = {"Visualizza categorie sensori", "Visualizza categorie attuatori", "Visualizza stanze", "Visualizza artefatti", "Visualizza valore rilevato da un sensore"};
        MyMenu menu = new MyMenu("Menu fruitore", azione);
        System.out.println(ClasseDiServizioUnitaImmobiliari.visualizzaUnitaImmobiliari(unitaImmobiliari));
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu fruitore");
                }
                break;

                case 1: {
                    visualizzaDescrizioneCatergorieSensori(listaCategorie);
                }
                break;

                case 2: {
                    visualizzaDescrizioneCatergorieAttuatori(listaCategorie);
                }
                break;

                case 3: {
                    visualizzaStanze(unitaImmobiliari);
                }
                break;

                case 4: {
                    visualizzaArtefatti(unitaImmobiliari);
                }
                break;

                case 5: {
                    visualizzaValoriRilevati(unitaImmobiliari);
                }
                break;

            }
        }
        while (!finito);
    }

    public static void stampaMenuOperazioniFruitore(UnitaImmobiliari unitaImmobiliari) {
        boolean finito = false;
        String[] azione = {"Modifica modalità operativa di un attuatore in una stanza", "Modifica modalità operativa di un attuatore in un artefatto", "Aggiungi nuova regola", "Visualizza regole", "Modifica stato regola"};
        MyMenu menu = new MyMenu("Menu fruitore operazioni:", azione);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Uscita verso menu fruitore");

                }
                break;

                case 1: {
                    UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(unitaImmobiliari);
                    if (InputDati.yesOrNo("Si vuole cambiare modalità operativa di un attautore in una stanza ?")) {
                        ClasseDiServizioUnitaImmobiliare.modificaModOperativeInUnaStanza(unitaImmobiliare);
                    }
                }
                break;
                case 2: {
                    UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(unitaImmobiliari);
                    if (InputDati.yesOrNo("Si vuole cambiare modalità operativa di un attautore in un artefatto ?")) {
                        ClasseDiServizioUnitaImmobiliare.modificaModOperativeInUnArtefatto(unitaImmobiliare);
                    }
                }
                break;

                case 3: {
                    creaRegole(unitaImmobiliari);
                }
                break;

                case 4: {
                    visualizzaRegole(unitaImmobiliari);
                }
                break;
                case 5: {

                    cambiaStatoRegola(unitaImmobiliari);
                }
                break;
            }
        } while (!finito);
    }

    public static UnitaImmobiliari creaRegole(UnitaImmobiliari unitaImmobiliari) {
        do {
            UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(unitaImmobiliari);
            do {
                ClasseDiServizioUnitaImmobiliare.creaRegole(unitaImmobiliare);
            } while (InputDati.yesOrNo("Vuoi creare un'altra regola di questa unità immobiliare?"));
        } while (InputDati.yesOrNo("Vuoi creare un'altra regola di un'altra unità immobiliare?"));
        return unitaImmobiliari;
    }

    public static UnitaImmobiliari visualizzaRegole(UnitaImmobiliari unitaImmobiliari) {
        do {
            UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(unitaImmobiliari);
            System.out.println(ClasseDiServizioUnitaImmobiliare.visualizzaRegole(unitaImmobiliare));
        } while (InputDati.yesOrNo("Vuoi visualizzare le regole di un'altra unità immobiliare?"));
        return unitaImmobiliari;
    }


    public static UnitaImmobiliari cambiaStatoRegola(UnitaImmobiliari unitaImmobiliari) {
        do {
            UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(unitaImmobiliari);
            do {
                int regola = ClasseDiServizioUnitaImmobiliare.scegliIndexRegola(unitaImmobiliare);
                unitaImmobiliare.cambiaRegolaAttivaDisattiva(regola);
            } while (InputDati.yesOrNo("Vuoi modificare altre regole?"));
        } while (InputDati.yesOrNo("Vuoi cambiare lo stato di un'altra regola di un'altra unità immobiliare?"));
        return unitaImmobiliari;
    }

    public static String visualizzaUnitaImmobiliari(UnitaImmobiliari unitaImmobiliari) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(ClasseDiServizioUnitaImmobiliari.visualizzaUnitaImmobiliari(unitaImmobiliari));
        return tmp.toString();
    }

    public static String visualizzaDescrizioneCatergorieSensori(ListaCategorie listaCategorie) {
        return ClasseDiServizioListaCategorie.descrizioneCategorieSensori(listaCategorie);
    }

    public static String visualizzaDescrizioneCatergorieAttuatori(ListaCategorie listaCategorie) {
        return ClasseDiServizioListaCategorie.descrizioneCategorieAttuatori(listaCategorie);
    }

    public static void visualizzaStanze(UnitaImmobiliari unitaImmobiliari) {
        do {
            UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(unitaImmobiliari);
            ClasseDiServizioUnitaImmobiliare.visualizzaStanze(unitaImmobiliare);
        } while (InputDati.yesOrNo("Vuoi visualizzare le stanze di un'altra unita immobiliare?"));
    }

    public static void visualizzaArtefatti(UnitaImmobiliari unitaImmobiliari) {
        do {
            UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(unitaImmobiliari);
            ClasseDiServizioUnitaImmobiliare.visualizzaArtefatti(unitaImmobiliare);
        } while (InputDati.yesOrNo("Vuoi visualizzare gli artefatti di un'altra unita immobiliare?"));
    }

    /**
     * Visualizza i valori rilevati dai sensori
     *
     * @return i valori rilevati
     */
    public static void visualizzaValoriRilevati(UnitaImmobiliari unitaImmobiliari) {
        do {
            UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliari.scegliUnitaImmobiliare(unitaImmobiliari);
            ClasseDiServizioUnitaImmobiliare.visualizzaValoriRilevati(unitaImmobiliare);
        } while (InputDati.yesOrNo("Vuoi visualizzare gli artefatti di un'altra unita immobiliare?"));
    }


}
