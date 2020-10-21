package it.unibs.fp.view.classiDiServizio;

import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNonNumerica;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNumerica;
import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import it.unibs.fp.model.modalitaOperativa.ModOperativaNonParamentrica;
import it.unibs.fp.model.modalitaOperativa.ModOperativaParamentrica;
import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.regola.antecedente.Antecedenti;
import it.unibs.fp.model.regola.conseguente.Conseguenti;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioAttuatore;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioSensore;
import it.unibs.fp.view.classiDiServizio.infoRilevabile.ClasseDiServizioInfoRilevabile;
import it.unibs.fp.view.classiDiServizio.modalitaOperativa.ClasseDiServizioModOperativa;
import it.unibs.fp.view.classiDiServizio.operatori.ClasseDiServizioOperatoriRelazionali;
import it.unibs.fp.view.classiDiServizio.regola.ClasseDiServizioRegola;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioArtefatto;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioStanza;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.ServizioFile;
import it.unibs.fp.model.operatori.OperatoriBooleani;
import it.unibs.fp.model.operatori.OperatoriRelazionali;
import it.unibs.fp.model.regola.Orologio;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.model.unitaImmobiliare.Stanza;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.model.utenti.Manutentore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClasseDiServizioInserimenti {
    //-----------------------------INSERISCI-----------------------------------------------------

    /**
     * Inseriesci e salva una o piu categoria di attuatori
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void inserisciESalvaCategioriaAttuatori(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        do {
            boolean testoLiberoOK = false;
            List<ModOperativa> modalitaOperative = new ArrayList<>();
            String nome = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome categoria attuatori: ");
            do {
                try {
                    String testoLibero = InputDati.leggiStringaNonVuota("Inserisci un testo libero di lunghezza massima " + CategoriaAttuatori.getLunghezzaMassima() + " caratteri: ");
                    do {
                        modalitaOperative.add(inserisciModalitaOperativa(listaCategorie));
                    } while (InputDati.yesOrNo("Vuoi inserire un'altra modalita operativa?"));
                    manutentore.inserisciESalvaCategoriaAttuatori(listaCategorie, new CategoriaAttuatori(nome, testoLibero, modalitaOperative));
                    testoLiberoOK = true;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!testoLiberoOK);
            contenitore.setListaCategorie(listaCategorie);
            contenitore.setManutentore(manutentore);
            ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);


        } while (InputDati.yesOrNo("Vuoi inserire un'altra categoria attuatori?"));
        ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
    }

    /**
     * Inserisci e salva uno o piu categorie di sensori
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void inserisciESalvaCategioriaSensori(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        do {
            boolean testoLiberoOK = false;
            List<InfoRilevabile> informazioniRilevabili = new ArrayList<>();
            String nome = InputDati.leggiStringaNonVuota("Inserisci nome categoria sensori: ");
            do {
                try {
                    String testoLibero = InputDati.leggiStringaNonVuota("Inserisci un testo libero di lunghezza massima " + CategoriaSensori.getLunghezzaMassima() + " caratteri: ");
                    do {
                        informazioniRilevabili.add(inserisciInfoRilevabili(listaCategorie));
                    } while (InputDati.yesOrNo("Vuoi inserire un'altra informazione rilevabile?"));
                    manutentore.inserisciESalvaCategoriaSensori(listaCategorie, new CategoriaSensori(nome, testoLibero, informazioniRilevabili));
                    testoLiberoOK = true;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!testoLiberoOK);

            contenitore.setListaCategorie(listaCategorie);
            contenitore.setManutentore(manutentore);
            ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);

        } while (InputDati.yesOrNo("Vuoi inserire un'altra categoria sensori?"));
    }

    /**
     * Inserisci uno o piu nuovi artefatti
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void inserisciNuovoArtefatto(Contenitore contenitore) {
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(manutentore);
        do {
            manutentore.inserisciArtefatto(ClasseDiServizioArtefatto.creaArtefatto(), unitaImmobiliare);

            contenitore.setManutentore(manutentore);
            ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
        } while (InputDati.yesOrNo("Vuoi inserire un'altro artefatto?"));

    }

    /**
     * Inserisci una o piu nuove stanze
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void inserisciNuovaStanza(Contenitore contenitore) {
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(manutentore);
        do {
            manutentore.inserisciStanza(ClasseDiServizioStanza.creaStanza(), unitaImmobiliare);
            contenitore.setManutentore(manutentore);
            ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
        } while (InputDati.yesOrNo("Vuoi inserire un'altra stanza?"));
    }

    /**
     * Inserisci le informazioni rilevabili
     *
     * @return l'informazione rilevabile con scelta se numerica o non
     */
    private static InfoRilevabile inserisciInfoRilevabili(ListaCategorie listaCategorie) {
        return ClasseDiServizioInfoRilevabile.menuCreaInfoRilevabile(listaCategorie);
    }

    /**
     * Inserisci una modalità operativa con scelta
     *
     * @return la modalità operativa
     */
    public static ModOperativa inserisciModalitaOperativa(ListaCategorie listaCategorie) {
        return ClasseDiServizioModOperativa.menuCreaModOperativa(listaCategorie);
    }

    public static Fruitore inserisciNuovaRegola(Contenitore contenitore, int unitaImmobiliareIndex, Regola regola) {
        Fruitore fruitore = contenitore.getManutentore().getFruitore();
        fruitore.inserisciRegola(unitaImmobiliareIndex, regola);
        return fruitore;
    }

    public static Fruitore inserisciNuovaRegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, Regola regola) {
        Fruitore fruitore = contenitore.getManutentore().getFruitore();
        fruitore.inserisciRegola(unitaImmobiliare, regola);
        return fruitore;
    }

    /**
     * Scegli la regola
     *
     * @param unitaImmobiliare scelta
     * @return indice della regola
     */
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
    static UnitaImmobiliare scegliUnitaImmobiliare(Manutentore manutentore) {
        List<UnitaImmobiliare> unitaImmobiliari = manutentore.getUnitaImmobiliari();
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
    static List<Artefatto> scegliArtefatti(UnitaImmobiliare unitaImmobiliare) {
        System.out.println("Si scelgano ora gli artefatti");
        List<Artefatto> artefatti = new ArrayList<>();
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
    static Artefatto scegliArtefatto(UnitaImmobiliare unitaImmobiliare) {
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
    static List<Stanza> scegliStanze(UnitaImmobiliare unitaImmobiliare) {
        System.out.println("Si scelga ora le stanze");
        List<Stanza> stanze = new ArrayList<>();
        do {
            System.out.println(unitaImmobiliare.visualizzaStanze());
            int stanzaIndex = InputDati.leggiIntero("Scegli stanza : ", 1, unitaImmobiliare.getSizeStanze());
            stanze.add(unitaImmobiliare.getStanze().get(--stanzaIndex));
        } while (InputDati.yesOrNo("Vuoi scegliere un'altra stanza?"));
        return stanze;
    }

    //-----------------------------CREA------------------------------------------------------------

    /**
     * Crea un nuovo attuatore
     *
     * @param listaCategorie per scegliere la tipologia di attuatori da creare
     * @return un nuovo attuatore
     */
    static Attuatore creaAttuatore(ListaCategorie listaCategorie) {
        return ClasseDiServizioAttuatore.creaAttuatore(listaCategorie);
    }

    /**
     * Crea un nuovo sensore
     *
     * @param listaCategorie per sceglie la tipologia di sensori da creare
     * @return un nuovo sensore
     */
    static Sensore creaSensore(ListaCategorie listaCategorie) {
        return ClasseDiServizioSensore.creaSensore(listaCategorie);
    }

    /**
     * Scegli un parametro con cui confrontare
     *
     * @param infoRilevabileNonNumerica informazione rilevabile non numerica
     * @return una stringa confrontata
     */
    static String scegliParametroConCuiConfrontare(InfoRilevabileNonNumerica infoRilevabileNonNumerica) { //TODO è per la creazione della regola, CONFRONTA DIVERSE COSE IN STANZE DIVERSE O ALTRO?
        int i = 1;
        for (String valore : infoRilevabileNonNumerica.getValori()) {
            System.out.println(i + " " + valore);
        }
        int scelta = InputDati.leggiIntero("Scegliere parametro con cui confrontare");
        return infoRilevabileNonNumerica.getValori().get(scelta);
    }
    //-----------------------------FINE CREA-----------------------------------------------------


    /**
     * Crea l'antecedente di una regola
     *
     * @param contenitore per gli oggetti e salvataggio
     * @param unitaImm    scelta
     * @param fruitore    scelto
     */
    static void creaAntecedente(Contenitore contenitore, int unitaImm, Fruitore fruitore) {
        do {
            //in stanza
            System.out.println("Creazione di un antecedente");
            if (InputDati.yesOrNo("Si vuole scegliere un sensore di una stanza?")) {
                System.out.println(fruitore.getUnitaImmobiliari().get(unitaImm).visualizzaStanze());
                int stanzaScelta = InputDati.leggiIntero("Scegliere stanza :", 1, fruitore.getUnitaImmobiliari().get(unitaImm).getSizeStanze()) - 1;
                Stanza stanza = fruitore.getUnitaImmobiliari().get(unitaImm).getStanze().get(stanzaScelta);

                //in artefatto di stanza
                if (InputDati.yesOrNo("Si vuole scegliere il sensore di un artefatto ?")) {
                    System.out.println(stanza.visualizzaArtefatti());
                    int artefattoScelto = InputDati.leggiIntero("Scegliere artefatto :", 1, fruitore.getUnitaImmobiliari().get(unitaImm).getStanze().get(--stanzaScelta).getArtefatti().size()) - 1;
                    Artefatto artefatto = fruitore.getUnitaImmobiliari().get(unitaImm).getArtefatti().get(artefattoScelto);
                    System.out.println(artefatto.visualizzaSensori());

                    int sensoreScelto = InputDati.leggiIntero("Scegliere sensore :", 1, artefatto.getSensori().size()) - 1;
                    Sensore sensore = artefatto.getSensori().get(sensoreScelto);
                    System.out.println(sensore.getCategoriaSensori().toString());

                    if (InputDati.yesOrNo("Si vuole creare antecedente con orario o info rilevabile (generico)")) {
                        unitaImm = contenitore.getManutentore().getFruitore().getUnitaImmobiliari().size() - 1;
                        contenitore.getManutentore().getFruitore().getUnitaImmobiliari().get(unitaImm).inserisciRegola(ClasseDiServizioRegola.creaRegola(contenitore.getListaCategorie()));
                    }
                }
                //in sensore di stanza
                else if (InputDati.yesOrNo("Si vuole scegliere un sensore della stanza?")) {
                    int sensoreScelto = InputDati.leggiIntero("Scegliere sensore :", 1, stanza.getSensori().size()) - 1;
                    Sensore sensore = stanza.getSensori().get(sensoreScelto);
                    System.out.println(sensore.getCategoriaSensori().toString());

                    if (InputDati.yesOrNo("Si vuole creare antecedente con orario")) {
                        System.out.println("Si farà quindi un confronto con l'orario");
                        fruitore.getUnitaImmobiliari().get(unitaImm).inserisciRegola(ClasseDiServizioRegola.creaRegola(contenitore.getListaCategorie()));
                    } else {

                        int infoRilevabileScelta = InputDati.leggiIntero("Scegliere informazione rilevabile :", 1, sensore.getCategoriaSensori().getInformazioniRilevabili().size()) - 1;
                        InfoRilevabile iTMP = sensore.getCategoriaSensori().getInformazioniRilevabili().get(infoRilevabileScelta);
                        //numerico o un'altro sensore

                        if (iTMP.getType() == 1) {
                            //numerico

                            unitaImm = contenitore.getManutentore().getFruitore().getUnitaImmobiliari().size() - 1;
                            contenitore.getManutentore().getFruitore().getUnitaImmobiliari().get(unitaImm).inserisciRegola(ClasseDiServizioRegola.creaRegola(contenitore.getListaCategorie()));
                        }

                    }
                }
                //in unità immobilare in un artefatto
                else if (InputDati.yesOrNo("Si vuole scegliere un sensore in un artefatto della unità immobiliare?")) {
                    System.out.println(fruitore.getUnitaImmobiliari().get(unitaImm).visualizzaArtefatti());
                    int artefattoScelto = InputDati.leggiIntero("Scegliere artefatto :", 1, fruitore.getUnitaImmobiliari().get(unitaImm).getArtefatti().size()) - 1;
                    Artefatto artefatto = fruitore.getUnitaImmobiliari().get(unitaImm).getArtefatti().get(artefattoScelto);
                    System.out.println(artefatto.visualizzaSensori());

                    int sensoreScelto = InputDati.leggiIntero("Scegliere sensore :", 1, artefatto.getSensori().size()) - 1;
                    Sensore sensore = artefatto.getSensori().get(sensoreScelto);
                    System.out.println(sensore.getCategoriaSensori().toString());


                    if (InputDati.yesOrNo("Si vuole creare antecedente con orario")) {
                        System.out.println("Si farà quindi un confronto con l'orario");
                        fruitore.getUnitaImmobiliari().get(unitaImm).inserisciRegola(ClasseDiServizioRegola.creaRegola(contenitore.getListaCategorie()));
                    } else {
                        int infoRilevabileScelta = InputDati.leggiIntero("Scegliere informazione rilevabile :", 1, sensore.getCategoriaSensori().getInformazioniRilevabili().size()) - 1;
                        InfoRilevabile iTMP = sensore.getCategoriaSensori().getInformazioniRilevabili().get(infoRilevabileScelta);
                        //numerico o un'altro sensore

                        if (iTMP.getType() == 1) {
                            //numerico
                            if (InputDati.yesOrNo("Vuoi confrontare con una costante?")) {
                                fruitore.getUnitaImmobiliari().get(unitaImm).inserisciRegola(ClasseDiServizioRegola.creaRegola(contenitore.getListaCategorie()));
                            }
                            //con un'altro sensore
                            else {
                                int sensoreScelto2 = InputDati.leggiIntero("Scegliere sensore :", 1, artefatto.getSensori().size()) - 1;
                                Sensore sensore2 = artefatto.getSensori().get(sensoreScelto2);
                                System.out.println(sensore2.getCategoriaSensori().toString());
                                fruitore.getUnitaImmobiliari().get(unitaImm).inserisciRegola(ClasseDiServizioRegola.creaRegola(contenitore.getListaCategorie()));
                            }

                        }
                        //parametrico
                        else {
                            System.out.println("L'operatore logico predefinito è =");
                            fruitore.getUnitaImmobiliari().get(unitaImm).inserisciRegola(ClasseDiServizioRegola.creaRegola(contenitore.getListaCategorie()));
                        }
                    }
                }
            }
        } while (InputDati.yesOrNo("Vuoi continuare a inserire antecedenti?"));
    }

    /**
     * Crea le conseguenze delle regole
     *
     * @param contenitore dal quale prendere gli oggetti necessari
     * @param unitaImm    scelta
     * @param fruitore    scelto
     */
    static void creaConseguenze(Contenitore contenitore, int unitaImm, Fruitore fruitore) {
        do {
            //in stanza
            if (InputDati.yesOrNo("Si vuole scegliere un attuatore di una stanza ?")) {
                //SCELTA STANZA
                System.out.println(fruitore.getUnitaImmobiliari().get(unitaImm).visualizzaStanze());
                int stanzaScelta = InputDati.leggiIntero("Scegliere stanza :", 1, fruitore.getUnitaImmobiliari().get(unitaImm).getSizeStanze()) - 1;
                Stanza stanza = fruitore.getUnitaImmobiliari().get(unitaImm).getStanze().get(stanzaScelta);

                //in artefatto della stanza
                if (InputDati.yesOrNo("Si vuole scegliere l'attuatore di un artefatto ?")) {
                    //SCELTA ARTEFATTO
                    System.out.println(stanza.visualizzaArtefatti());
                    int artefattoScelto = InputDati.leggiIntero("Scegliere artefatto :", 1, fruitore.getUnitaImmobiliari().get(unitaImm).getSizeArtefatti()) - 1;
                    Artefatto artefatto = fruitore.getUnitaImmobiliari().get(unitaImm).getArtefatti().get(artefattoScelto);

                    //SCELTA ATTUATORI
                    System.out.println(artefatto.visualizzaAttuatori());
                    int attuatoreScelto = InputDati.leggiIntero("Scegliere attuatore :", 1, artefatto.getAttuatori().size()) - 1;
                    Attuatore attuatore = artefatto.getAttuatori().get(attuatoreScelto);
                    System.out.println(attuatore.getCategoriaAttuatori().toString());

                    int modalitaOperativaScelta = InputDati.leggiIntero("Scegliere modalità operativa :", 1, attuatore.getCategoriaAttuatori().getModalitaOperative().size()) - 1;
                    ModOperativa mTMP = attuatore.getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta);

                    if (mTMP.getType() == 1) {
                        double valore = InputDati.leggiDouble("Inserisci valore : ");
                        ((ModOperativaNonParamentrica) fruitore.getUnitaImmobiliari().get(unitaImm).getStanze().get(stanzaScelta).getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setValore(valore);
                    } else {
                        ModOperativaParamentrica modOperativaParamentrica = (ModOperativaParamentrica) mTMP;
                        System.out.println(modOperativaParamentrica.toString());
                        int paremetroScelto = InputDati.leggiIntero("Scegliere parametro modalità operativa", 1, modOperativaParamentrica.getParamentri().size()) - 1;
                        ((ModOperativaParamentrica) fruitore.getUnitaImmobiliari().get(unitaImm).getStanze().get(stanzaScelta).getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setParametroAttuale(modOperativaParamentrica.getParamentri().get(paremetroScelto));
                    }

                    if (InputDati.yesOrNo("Si vuole creare una conseguenza con orario ?")) {
                        fruitore.getUnitaImmobiliari().get(unitaImm).inserisciRegola(ClasseDiServizioRegola.creaRegola(contenitore.getListaCategorie()));
                        Manutentore manutentore = contenitore.getManutentore();
                        manutentore.setFruitore(fruitore);
                        contenitore.setManutentore(manutentore);
                        ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
                    } else {
                        fruitore.getUnitaImmobiliari().get(unitaImm).inserisciRegola(ClasseDiServizioRegola.creaRegola(contenitore.getListaCategorie()));
                        Manutentore manutentore = contenitore.getManutentore();
                        manutentore.setFruitore(fruitore);
                        contenitore.setManutentore(manutentore);
                        ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
                    }
                }
                //attuatore di stanza
                else {
                    int attuatoreScelto = InputDati.leggiIntero("Scegliere attuatore :", 1, stanza.getAttuatori().size()) - 1;
                    Attuatore attuatore = stanza.getAttuatori().get(attuatoreScelto);
                    System.out.println(attuatore.getCategoriaAttuatori().toString());

                    int modalitaOperativaScelta = InputDati.leggiIntero("Scegliere modalità operativa :", 1, attuatore.getCategoriaAttuatori().getModalitaOperative().size()) - 1;
                    ModOperativa mTMP = attuatore.getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta);

                    if (mTMP.getType() == 1) {
                        double valore = InputDati.leggiDouble("Inserisci valore : ");
                        ((ModOperativaNonParamentrica) fruitore.getUnitaImmobiliari().get(unitaImm).getStanze().get(stanzaScelta).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setValore(valore);
                    } else {
                        ModOperativaParamentrica modOperativaParamentrica = (ModOperativaParamentrica) mTMP;
                        System.out.println(modOperativaParamentrica.toString());
                        int paremetroScelto = InputDati.leggiIntero("Scegliere parametro modalità operativa", 1, modOperativaParamentrica.getParamentri().size()) - 1;
                        ((ModOperativaParamentrica) fruitore.getUnitaImmobiliari().get(unitaImm).getStanze().get(stanzaScelta).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setParametroAttuale(modOperativaParamentrica.getParamentri().get(paremetroScelto));
                    }
                    if (InputDati.yesOrNo("Si vuole creare una conseguenza con orario ?")) {
                        fruitore.getUnitaImmobiliari().get(unitaImm).inserisciRegola(ClasseDiServizioRegola.creaRegola(contenitore.getListaCategorie()));
                        Manutentore manutentore = contenitore.getManutentore();
                        manutentore.setFruitore(fruitore);
                        contenitore.setManutentore(manutentore);
                        ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
                    } else {
                        fruitore.getUnitaImmobiliari().get(unitaImm).inserisciRegola(ClasseDiServizioRegola.creaRegola(contenitore.getListaCategorie()));
                        Manutentore manutentore = contenitore.getManutentore();
                        manutentore.setFruitore(fruitore);
                        contenitore.setManutentore(manutentore);
                        ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
                    }
                }
            }
            //attuatore di artefatto in unità immobiliari
            else if (InputDati.yesOrNo("Si vuole scegliere un attuatore di un artefatto ?")) {
                System.out.println(fruitore.getUnitaImmobiliari().get(unitaImm).visualizzaArtefatti());
                int artefattoScelto = InputDati.leggiIntero("Scegliere artefatto :", 1, fruitore.getUnitaImmobiliari().get(unitaImm).getSizeArtefatti()) - 1;
                Artefatto artefatto = fruitore.getUnitaImmobiliari().get(unitaImm).getArtefatti().get(artefattoScelto);
                System.out.println(artefatto.visualizzaAttuatori());

                int attuatoreScelto = InputDati.leggiIntero("Scegliere attuatore :", 1, artefatto.getAttuatori().size()) - 1;
                Attuatore attuatore = artefatto.getAttuatori().get(attuatoreScelto);
                System.out.println(attuatore.getCategoriaAttuatori().toString());

                int modalitaOperativaScelta = InputDati.leggiIntero("Scegliere modalità operativa :", 1, attuatore.getCategoriaAttuatori().getModalitaOperative().size()) - 1;
                ModOperativa mTMP = attuatore.getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta);

                if (mTMP.getType() == 1) {
                    double valore = InputDati.leggiDouble("Inserisci valore : ");
                    ((ModOperativaNonParamentrica) fruitore.getUnitaImmobiliari().get(unitaImm).getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setValore(valore);
                } else {
                    ModOperativaParamentrica modOperativaParamentrica = (ModOperativaParamentrica) mTMP;
                    System.out.println(modOperativaParamentrica.toString());
                    int parametroScelto = InputDati.leggiIntero("Scegliere parametro modalità operativa", 1, modOperativaParamentrica.getParamentri().size()) - 1;
                    ((ModOperativaParamentrica) fruitore.getUnitaImmobiliari().get(unitaImm).getArtefatti().get(artefattoScelto).getAttuatori().get(attuatoreScelto).getCategoriaAttuatori().getModalitaOperative().get(modalitaOperativaScelta)).setParametroAttuale(modOperativaParamentrica.getParamentri().get(parametroScelto));
                }
                if (InputDati.yesOrNo("Si vuole creare una conseguenza con orario ?")) {
                    fruitore.getUnitaImmobiliari().get(unitaImm).inserisciRegola(ClasseDiServizioRegola.creaRegola(contenitore.getListaCategorie()));
                    Manutentore manutentore = contenitore.getManutentore();
                    manutentore.setFruitore(fruitore);
                    contenitore.setManutentore(manutentore);
                    ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
                } else {
                    fruitore.getUnitaImmobiliari().get(unitaImm).inserisciRegola(ClasseDiServizioRegola.creaRegola(contenitore.getListaCategorie()));
                    Manutentore manutentore = contenitore.getManutentore();
                    manutentore.setFruitore(fruitore);
                    contenitore.setManutentore(manutentore);
                    ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
                }
            }
        } while (InputDati.yesOrNo("Vuoi continuare a creare conseguenze?"));

    }


    //-----------------------------FINE SCEGLI-----------------------------------------------------


    /**
     * Cambia lo stato di una regola scelta dall'utente
     *
     * @param unitaImm scelta
     * @param fruitore per il salvataggio
     * @return il fruitore
     */
    static Fruitore cambiaStatoRegola(int unitaImm, Fruitore fruitore) {
        UnitaImmobiliare unitaImmobiliare = fruitore.getUnitaImmobiliari().get(unitaImm);
        do {
            System.out.println(unitaImmobiliare.visualizzaStatoRegole());
            int indexRegola = InputDati.leggiIntero("Scegli la regola a cui vuoi cambiare stato: ", 1, unitaImmobiliare.getRegole().size());
            unitaImmobiliare.cambiaRegolaAttivaDisattiva(unitaImmobiliare.getRegole().get(--indexRegola));
        } while (InputDati.yesOrNo("Vuoi modificare altre regole?"));
        return fruitore;
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
        ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
    }

}
