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
            String nome = InputDati.leggiStringaNonVuota("Inserisci nome nuovo artefatto: ");
            manutentore.inserisciArtefatto(new Artefatto(nome), unitaImmobiliare);

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
            String nome = InputDati.leggiStringaNonVuota("Inserisci nome nuova stanza: ");
            manutentore.inserisciStanza(new Stanza(nome), unitaImmobiliare);
            contenitore.setManutentore(manutentore);
            ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
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
                List<String> valoriNonNumerici = new ArrayList<>();
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
        List<String> parametri = new ArrayList<>();
        String nomeModalitaOperativa = InputDati.leggiStringaNonVuotaSenzaSpazi("Inserisci nome della modalita operativa: ");
        do {
            parametri.add(InputDati.leggiStringaNonVuota("Inserisci parametro: "));
        } while (InputDati.yesOrNo("Vuoi inserire un'altro parametro nella modalità operativa?"));
        modOperative = new ModOperativaParamentrica(nomeModalitaOperativa, parametri);
        return modOperative;
    }

    /**
     * Inserisci una nuova regola
     *
     * @param contenitore           dal quale prendere gli oggetti necessari
     * @param unitaImmobiliareIndex indice dell'unità immobiliare scelta
     * @param attuatore             scelto
     * @param modOperativa          da impostare
     * @return il fruitore
     */
    public static Fruitore inserisciNuovaRegola(Contenitore contenitore, int unitaImmobiliareIndex, Attuatore attuatore, ModOperativa modOperativa) {
        Fruitore fruitore = contenitore.getManutentore().getFruitore();
        fruitore.inserisciRegola(unitaImmobiliareIndex, attuatore, modOperativa);
        return fruitore;
    }

    /**
     * Inserisci una nuova regola con orologio
     *
     * @param contenitore      dal quale prendere gli oggetti necessari
     * @param unitaImmobiliare scelta
     * @param attuatore        scelto
     * @param modOperativa     da impostare
     * @param start            tempo di assegnamento
     * @return il fruitore
     */
    public static Fruitore inserisciNuovaRegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, Attuatore attuatore, ModOperativa modOperativa, Orologio start) {
        Fruitore fruitore = contenitore.getManutentore().getFruitore();
        fruitore.inserisciRegola(unitaImmobiliare, attuatore, modOperativa, start);
        return fruitore;
    }

    /**
     * Aggiungi un'azione alla conseguenza
     *
     * @param contenitore      per gli oggetti necessari
     * @param unitaImmobiliare scelta
     * @param attuatore        scelto
     * @param modOperativa     da impostare
     * @return il fruitore
     */
    public static Fruitore aggiungiAzione(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, Attuatore attuatore, ModOperativa modOperativa) {
        Fruitore fruitore = contenitore.getManutentore().getFruitore();
        int i = scegliRegola(unitaImmobiliare);
        fruitore.aggiungiAzione(unitaImmobiliare, unitaImmobiliare.getRegole().get(i), attuatore, modOperativa);
        return fruitore;
    }

    /**
     * Aggiungi un costituente logico alla regola
     *
     * @param contenitore      per gli ogetti necessari
     * @param unitaImmobiliare scelta
     * @param primoOpLogico    da confrontare
     * @param secondoOpLogico  info rilevabile
     * @param opRelazionale    per il confronto
     * @return il fruitore
     */
    public static Fruitore aggiungiCostituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, InfoRilevabile secondoOpLogico, OperatoriRelazionali opRelazionale) {
        Fruitore fruitore;
        int size = unitaImmobiliare.getRegole().size();
        if (unitaImmobiliare.getRegole().get(size - 1).getAntecedente().get(0).isTrue())
            fruitore = aggiungiPrimoCosituenteLogicoARegola(contenitore, unitaImmobiliare, primoOpLogico, secondoOpLogico, opRelazionale);
        else {
            OperatoriBooleani operatoreBooleano = OperatoriBooleani.sceltaOperatoreBooleano();
            fruitore = aggiungiEnnesimoCosituenteLogicoARegola(contenitore, unitaImmobiliare, primoOpLogico, secondoOpLogico, opRelazionale, operatoreBooleano);
        }
        return fruitore;
    }

    /**
     * Aggiungi un costituente logico alla regola
     *
     * @param contenitore      per gli ogetti necessari
     * @param unitaImmobiliare scelta
     * @param primoOpLogico    da confrontare
     * @param secondoOpLogico  costante
     * @param opRelazionale    per il confronto
     * @return il fruitore
     */
    public static Fruitore aggiungiCostituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, Double secondoOpLogico, OperatoriRelazionali opRelazionale) {
        Fruitore fruitore;
        int size = unitaImmobiliare.getRegole().size();
        System.err.println(unitaImmobiliare.getRegole().get(size - 1).getAntecedente().size());
        if (unitaImmobiliare.getRegole().get(size - 1).getAntecedente().get(0).isTrue())
            fruitore = aggiungiPrimoCosituenteLogicoARegola(contenitore, unitaImmobiliare, primoOpLogico, secondoOpLogico, opRelazionale);
        else {
            OperatoriBooleani operatoreBooleano = OperatoriBooleani.sceltaOperatoreBooleano();
            fruitore = aggiungiEnnesimoCosituenteLogicoARegola(contenitore, unitaImmobiliare, primoOpLogico, secondoOpLogico, opRelazionale, operatoreBooleano);
        }
        return fruitore;
    }

    /**
     * Aggiungi un costituente logico alla regola
     *
     * @param contenitore      per gli ogetti necessari
     * @param unitaImmobiliare scelta
     * @param primoOpLogico    da confrontare
     * @param secondoOpLogico  String
     * @param opRelazionale    per il confronto
     * @return il fruitore
     */
    public static Fruitore aggiungiCostituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, String secondoOpLogico, OperatoriRelazionali opRelazionale) {
        Fruitore fruitore;
        int size = unitaImmobiliare.getRegole().size();
        System.err.println(unitaImmobiliare.getRegole().get(size - 1).getAntecedente().size());
        if (unitaImmobiliare.getRegole().get(size - 1).getAntecedente().get(0).isTrue())
            fruitore = aggiungiPrimoCosituenteLogicoARegola(contenitore, unitaImmobiliare, primoOpLogico, secondoOpLogico, opRelazionale);
        else {
            OperatoriBooleani operatoreBooleano = OperatoriBooleani.sceltaOperatoreBooleano();
            fruitore = aggiungiEnnesimoCosituenteLogicoARegola(contenitore, unitaImmobiliare, primoOpLogico, secondoOpLogico, opRelazionale, operatoreBooleano);
        }
        return fruitore;
    }

    /**
     * Aggiungi un costituente logico alla regola con orologio
     *
     * @param contenitore      per gli ogetti necessari
     * @param unitaImmobiliare scelta
     * @param opRelazionale    per il confronto
     * @param orologio         orologio con cui confrontare
     * @return il fruitore
     */
    public static Fruitore aggiungiCostituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, OperatoriRelazionali opRelazionale, Orologio orologio) {
        Fruitore fruitore;
        int size = unitaImmobiliare.getRegole().size();
        System.err.println(unitaImmobiliare.getRegole().get(size - 1).getAntecedente().size());
        if (unitaImmobiliare.getRegole().get(size - 1).getAntecedente().get(0).isTrue())
            fruitore = aggiungiPrimoCosituenteLogicoARegola(contenitore, unitaImmobiliare, opRelazionale, orologio);
        else {
            OperatoriBooleani operatoreBooleano = OperatoriBooleani.sceltaOperatoreBooleano();
            fruitore = aggiungiEnnesimoCosituenteLogicoARegola(contenitore, unitaImmobiliare, opRelazionale, operatoreBooleano, orologio);
        }
        return fruitore;
    }

    /**
     * Aggiungi il primo costituente logico alla regola
     *
     * @param contenitore      per gli ogetti necessari
     * @param unitaImmobiliare scelta
     * @param primoOpLogico    da confrontare
     * @param secondoOpLogico  infoRilevabile
     * @param opRelazionale    per il confronto
     * @return il fruitore
     */
    public static Fruitore aggiungiPrimoCosituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, InfoRilevabile secondoOpLogico, OperatoriRelazionali opRelazionale) {
        Fruitore fruitore = contenitore.getManutentore().getFruitore();
        int i = scegliRegola(unitaImmobiliare);
        fruitore.aggiungiPrimoCosituenteLogicoARegola(unitaImmobiliare, unitaImmobiliare.getRegole().get(i), primoOpLogico, secondoOpLogico, opRelazionale);
        return fruitore;
    }

    /**
     * Aggiungi il primo costituente logico alla regola con orologio
     *
     * @param contenitore      per gli ogetti necessari
     * @param unitaImmobiliare scelta
     * @param opRelazionale    per il confronto
     * @param orologio         da confrontare
     * @return il fruitore
     */
    public static Fruitore aggiungiPrimoCosituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, OperatoriRelazionali opRelazionale, Orologio orologio) {
        Fruitore fruitore = contenitore.getManutentore().getFruitore();
        int i = scegliRegola(unitaImmobiliare);
        fruitore.aggiungiPrimoCosituenteLogicoARegola(unitaImmobiliare, unitaImmobiliare.getRegole().get(i), opRelazionale, orologio);
        return fruitore;
    }

    /**
     * Aggiungi il primo costituente logico alla regola
     *
     * @param contenitore      per gli ogetti necessari
     * @param unitaImmobiliare scelta
     * @param primoOpLogico    da confrontare
     * @param secondoOpLogico  double
     * @param opRelazionale    per il confronto
     * @return il fruitore
     */
    public static Fruitore aggiungiPrimoCosituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, double secondoOpLogico, OperatoriRelazionali opRelazionale) {
        Fruitore fruitore = contenitore.getManutentore().getFruitore();
        int i = scegliRegola(unitaImmobiliare);
        fruitore.aggiungiPrimoCosituenteLogicoARegola(unitaImmobiliare, unitaImmobiliare.getRegole().get(i), primoOpLogico, secondoOpLogico, opRelazionale);
        return fruitore;
    }

    /**
     * Aggiungi il primo costituente logico alla regola
     *
     * @param contenitore      per gli oggetti necessari
     * @param unitaImmobiliare scelta
     * @param primoOpLogico    da confrontare
     * @param secondoOpLogico  String
     * @param opRelazionale    per il confronto
     * @return il fruitore
     */
    public static Fruitore aggiungiPrimoCosituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, String secondoOpLogico, OperatoriRelazionali opRelazionale) {
        Fruitore fruitore = contenitore.getManutentore().getFruitore();
        int i = scegliRegola(unitaImmobiliare);
        fruitore.aggiungiPrimoCosituenteLogicoARegola(unitaImmobiliare, unitaImmobiliare.getRegole().get(i), primoOpLogico, secondoOpLogico, opRelazionale);
        return fruitore;
    }

    /**
     * Aggiungi l'ennesimo costituente logico a regola
     *
     * @param contenitore      per gli oggetti necessari
     * @param unitaImmobiliare scelta
     * @param primoOpLogico    da confrontare
     * @param secondoOpLogico  info rilevabile
     * @param opRelazionale    per il confronto
     * @param opBooleano       per confronto tra costituenti logici
     * @return il fruitore
     */
    public static Fruitore aggiungiEnnesimoCosituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, InfoRilevabile secondoOpLogico, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano) {
        Fruitore fruitore = contenitore.getManutentore().getFruitore();
        int i = scegliRegola(unitaImmobiliare);
        fruitore.aggiungiEnnesimoCosituenteLogicoARegola(unitaImmobiliare, unitaImmobiliare.getRegole().get(i), primoOpLogico, secondoOpLogico, opRelazionale, opBooleano);
        return fruitore;
    }

    /**
     * Aggiungi l'ennesimo costituente logico a regola
     *
     * @param contenitore      per gli oggetti necessari
     * @param unitaImmobiliare scelta
     * @param primoOpLogico    da confrontare
     * @param secondoOpLogico  double
     * @param opRelazionale    per il confronto
     * @param opBooleano       per confronto tra costituenti logici
     * @return il fruitore
     */
    public static Fruitore aggiungiEnnesimoCosituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, double secondoOpLogico, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano) {
        Fruitore fruitore = contenitore.getManutentore().getFruitore();
        int i = scegliRegola(unitaImmobiliare);
        fruitore.aggiungiEnnesimoCosituenteLogicoARegola(unitaImmobiliare, unitaImmobiliare.getRegole().get(i), primoOpLogico, secondoOpLogico, opRelazionale, opBooleano);
        return fruitore;
    }

    /**
     * Aggiungi l'ennesimo costituente logico a regola
     *
     * @param contenitore      per gli oggetti necessari
     * @param unitaImmobiliare scelta
     * @param primoOpLogico    da confrontare
     * @param secondoOpLogico  String
     * @param opRelazionale    per il confronto
     * @param opBooleano       per confronto tra costituenti logici
     * @return il fruitore
     */
    public static Fruitore aggiungiEnnesimoCosituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, InfoRilevabile primoOpLogico, String secondoOpLogico, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano) {
        Fruitore fruitore = contenitore.getManutentore().getFruitore();
        int i = scegliRegola(unitaImmobiliare);
        fruitore.aggiungiEnnesimoCosituenteLogicoARegola(unitaImmobiliare, unitaImmobiliare.getRegole().get(i), primoOpLogico, secondoOpLogico, opRelazionale, opBooleano);
        return fruitore;
    }

    /**
     * Aggiungi l'ennesimo costituente logico a regola con orologio
     *
     * @param contenitore      per gli oggetti necessari
     * @param unitaImmobiliare scelta
     * @param opRelazionale    per il confronto
     * @param opBooleano       per confronto tra costituenti logici
     * @param orologio         scelto
     * @return il fruitore
     */
    public static Fruitore aggiungiEnnesimoCosituenteLogicoARegola(Contenitore contenitore, UnitaImmobiliare unitaImmobiliare, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano, Orologio orologio) {
        Fruitore fruitore = contenitore.getManutentore().getFruitore();
        int i = scegliRegola(unitaImmobiliare);
        fruitore.aggiungiEnnesimoCosituenteLogicoARegola(unitaImmobiliare, unitaImmobiliare.getRegole().get(i), opRelazionale, opBooleano, orologio);
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

    /**
     * Crea un nuovo attuatore
     *
     * @param listaCategorie per scegliere la tipologia di attuatori da creare
     * @return un nuovo attuatore
     */
    static Attuatore creaAttuatore(ListaCategorie listaCategorie) {
        System.out.println(listaCategorie.visualizzaCategorieAttuatori());
        int categoria = InputDati.leggiIntero("Scegli categoria : ", 1, listaCategorie.getSizeCategorieAttuatori());
        categoria--;
        String nome = InputDati.leggiStringaNonVuota("Inserisci nome attuatori : ");
        nome += "_" + listaCategorie.getCategorieAttuatori().get(categoria).getNome();
        System.out.println("Si è creato l'attuatore " + nome);
        return new Attuatore(nome, listaCategorie.getCategorieAttuatori().get(categoria));
    }

    //-----------------------------CREA------------------------------------------------------------

    /**
     * Crea un nuovo sensore
     *
     * @param listaCategorie per sceglie la tipologia di sensori da creare
     * @return un nuovo sensore
     */
    static Sensore creaSensore(ListaCategorie listaCategorie) {
        System.out.println(listaCategorie.visualizzaCategorieSensori());
        int categoria = InputDati.leggiIntero("Scegli categoria : ", 1, listaCategorie.getSizeCategorieSensori());
        categoria--;
        String nome = InputDati.leggiStringaNonVuota("Inserisci nome sensore : ");
        nome += "_" + listaCategorie.getCategorieSensori().get(categoria).getNome();
        System.out.println("Si è creato il sensore " + nome);
        return new Sensore(nome, listaCategorie.getCategorieSensori().get(categoria));
    }

    /**
     * Scegli un parametro con cui confrontare
     *
     * @param infoRilevabileNonNumerica informazione rilevabile non numerica
     * @return una stringa confrontata
     */
    static String scegliParametroConCuiConfrontare(InfoRilevabileNonNumerica infoRilevabileNonNumerica) {
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

                    if (InputDati.yesOrNo("Si vuole creare antecedente con orario")) {
                        System.out.println("Si farà quindi un confronto con l'orario");
                        OperatoriRelazionali operatoriRelazionali = OperatoriRelazionali.sceltaOperatoreRelazionale();
                        Orologio orologio = inserisciOrologio();
                        unitaImm = contenitore.getManutentore().getFruitore().getUnitaImmobiliari().size() - 1;
                        ClasseDiServizioInserimenti.aggiungiCostituenteLogicoARegola(contenitore, contenitore.getManutentore().getFruitore().getUnitaImmobiliari().get(unitaImm), operatoriRelazionali, orologio);
                    } else {
                        int infoRilevabileScelta = InputDati.leggiIntero("Scegliere informazione rilevabile :", 1, sensore.getCategoriaSensori().getInformazioniRilevabili().size()) - 1;
                        InfoRilevabile iTMP = sensore.getCategoriaSensori().getInformazioniRilevabili().get(infoRilevabileScelta);
                        //numerico o un'altro sensore
                        if (iTMP.getType() == 1) {
                            //numerico
                            if (InputDati.yesOrNo("Vuoi confrontare con una costante?")) {
                                InfoRilevabileNumerica iNTMP = (InfoRilevabileNumerica) iTMP;
                                OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.sceltaOperatoreRelazionale();
                                double costante = InputDati.leggiDouble("Inserire la costante con cui confrontare: ", iNTMP.getMin(), iNTMP.getMax());
                                unitaImm = contenitore.getManutentore().getFruitore().getUnitaImmobiliari().size() - 1;
                                ClasseDiServizioInserimenti.aggiungiCostituenteLogicoARegola(contenitore, contenitore.getManutentore().getFruitore().getUnitaImmobiliari().get(unitaImm), iNTMP, costante, operatoreRelazionale);
                            }
                            //con un'altro sensore
                            else {
                                InfoRilevabileNumerica iNTMP = (InfoRilevabileNumerica) iTMP;
                                OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.sceltaOperatoreRelazionale();

                                int sensoreScelto2 = InputDati.leggiIntero("Scegliere sensore :", 1, artefatto.getSensori().size()) - 1;
                                Sensore sensore2 = artefatto.getSensori().get(sensoreScelto2);
                                System.out.println(sensore.getCategoriaSensori().toString());
                                int infoRilevabileScelta2 = InputDati.leggiIntero("Scegliere informazione rilevabile :", 1, sensore2.getCategoriaSensori().getInformazioniRilevabili().size()) - 1;
                                InfoRilevabile iTMP2 = sensore.getCategoriaSensori().getInformazioniRilevabili().get(infoRilevabileScelta2);
                                InfoRilevabileNumerica iNTMP2 = (InfoRilevabileNumerica) iTMP2;
                                unitaImm = contenitore.getManutentore().getFruitore().getUnitaImmobiliari().size() - 1;
                                ClasseDiServizioInserimenti.aggiungiCostituenteLogicoARegola(contenitore, contenitore.getManutentore().getFruitore().getUnitaImmobiliari().get(unitaImm), iNTMP, iNTMP2, operatoreRelazionale);
                            }

                        }
                        //parametrico
                        else {
                            InfoRilevabileNonNumerica iNNTMP = (InfoRilevabileNonNumerica) iTMP;
                            System.out.println("L'operatore logico predefinito è =");
                            String parametro = ClasseDiServizioInserimenti.scegliParametroConCuiConfrontare(iNNTMP);
                            OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.sceltaOperatoreRelazionale();
                            unitaImm = contenitore.getManutentore().getFruitore().getUnitaImmobiliari().size() - 1;
                            ClasseDiServizioInserimenti.aggiungiCostituenteLogicoARegola(contenitore, contenitore.getManutentore().getFruitore().getUnitaImmobiliari().get(unitaImm), iNNTMP, parametro, operatoreRelazionale);
                        }
                    }
                }
                //in sensore di stanza
                else if (InputDati.yesOrNo("Si vuole scegliere un sensore della stanza?")) {
                    int sensoreScelto = InputDati.leggiIntero("Scegliere sensore :", 1, stanza.getSensori().size()) - 1;
                    Sensore sensore = stanza.getSensori().get(sensoreScelto);
                    System.out.println(sensore.getCategoriaSensori().toString());

                    if (InputDati.yesOrNo("Si vuole creare antecedente con orario")) {
                        System.out.println("Si farà quindi un confronto con l'orario");
                        OperatoriRelazionali operatoriRelazionali = OperatoriRelazionali.sceltaOperatoreRelazionale();
                        Orologio orologio = inserisciOrologio();
                        ClasseDiServizioInserimenti.aggiungiCostituenteLogicoARegola(contenitore, fruitore.getUnitaImmobiliari().get(unitaImm), operatoriRelazionali, orologio);
                    } else {

                        int infoRilevabileScelta = InputDati.leggiIntero("Scegliere informazione rilevabile :", 1, sensore.getCategoriaSensori().getInformazioniRilevabili().size()) - 1;
                        InfoRilevabile iTMP = sensore.getCategoriaSensori().getInformazioniRilevabili().get(infoRilevabileScelta);
                        //numerico o un'altro sensore

                        if (iTMP.getType() == 1) {
                            //numerico
                            if (InputDati.yesOrNo("Vuoi confrontare con una costante?")) {
                                InfoRilevabileNumerica iNTMP = (InfoRilevabileNumerica) iTMP;
                                OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.sceltaOperatoreRelazionale();
                                double costante = InputDati.leggiDouble("Inserire la costante con cui confrontare: ", iNTMP.getMin(), iNTMP.getMax());
                                unitaImm = contenitore.getManutentore().getFruitore().getUnitaImmobiliari().size() - 1;
                                ClasseDiServizioInserimenti.aggiungiCostituenteLogicoARegola(contenitore, contenitore.getManutentore().getFruitore().getUnitaImmobiliari().get(unitaImm), iNTMP, costante, operatoreRelazionale);
                            }
                            //con un'altro sensore
                            else {
                                InfoRilevabileNumerica iNTMP = (InfoRilevabileNumerica) iTMP;
                                OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.sceltaOperatoreRelazionale();

                                int sensoreScelto2 = InputDati.leggiIntero("Scegliere sensore :", 1, stanza.getSensori().size()) - 1;
                                Sensore sensore2 = stanza.getSensori().get(sensoreScelto2);
                                System.out.println(sensore.getCategoriaSensori().toString());
                                int infoRilevabileScelta2 = InputDati.leggiIntero("Scegliere informazione rilevabile :", 1, sensore2.getCategoriaSensori().getInformazioniRilevabili().size()) - 1;
                                InfoRilevabile iTMP2 = sensore.getCategoriaSensori().getInformazioniRilevabili().get(infoRilevabileScelta2);
                                InfoRilevabileNumerica iNTMP2 = (InfoRilevabileNumerica) iTMP2;
                                unitaImm = contenitore.getManutentore().getFruitore().getUnitaImmobiliari().size() - 1;
                                ClasseDiServizioInserimenti.aggiungiCostituenteLogicoARegola(contenitore, contenitore.getManutentore().getFruitore().getUnitaImmobiliari().get(unitaImm), iNTMP, iNTMP2, operatoreRelazionale);
                            }
                        }
                        //parametrico
                        else {
                            InfoRilevabileNonNumerica iNNTMP = (InfoRilevabileNonNumerica) iTMP;
                            System.out.println("L'operatore logico predefinito è =");
                            String parametro = ClasseDiServizioInserimenti.scegliParametroConCuiConfrontare(iNNTMP);
                            OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.sceltaOperatoreRelazionale();
                            unitaImm = contenitore.getManutentore().getFruitore().getUnitaImmobiliari().size() - 1;
                            ClasseDiServizioInserimenti.aggiungiCostituenteLogicoARegola(contenitore, contenitore.getManutentore().getFruitore().getUnitaImmobiliari().get(unitaImm), iNNTMP, parametro, operatoreRelazionale);
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
                        OperatoriRelazionali operatoriRelazionali = OperatoriRelazionali.sceltaOperatoreRelazionale();
                        Orologio orologio = inserisciOrologio();
                        ClasseDiServizioInserimenti.aggiungiCostituenteLogicoARegola(contenitore, fruitore.getUnitaImmobiliari().get(unitaImm), operatoriRelazionali, orologio);
                    } else {
                        int infoRilevabileScelta = InputDati.leggiIntero("Scegliere informazione rilevabile :", 1, sensore.getCategoriaSensori().getInformazioniRilevabili().size()) - 1;
                        InfoRilevabile iTMP = sensore.getCategoriaSensori().getInformazioniRilevabili().get(infoRilevabileScelta);
                        //numerico o un'altro sensore

                        if (iTMP.getType() == 1) {
                            //numerico
                            if (InputDati.yesOrNo("Vuoi confrontare con una costante?")) {
                                InfoRilevabileNumerica iNTMP = (InfoRilevabileNumerica) iTMP;
                                OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.sceltaOperatoreRelazionale();
                                double costante = InputDati.leggiDouble("Inserire la costante con cui confrontare: ", iNTMP.getMin(), iNTMP.getMax());
                                aggiungiCostituenteLogicoARegola(contenitore, fruitore.getUnitaImmobiliari().get(unitaImm), iNTMP, costante, operatoreRelazionale);
                            }
                            //con un'altro sensore
                            else {
                                InfoRilevabileNumerica iNTMP = (InfoRilevabileNumerica) iTMP;
                                OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.sceltaOperatoreRelazionale();

                                int sensoreScelto2 = InputDati.leggiIntero("Scegliere sensore :", 1, artefatto.getSensori().size()) - 1;
                                Sensore sensore2 = artefatto.getSensori().get(sensoreScelto2);
                                System.out.println(sensore2.getCategoriaSensori().toString());
                                int infoRilevabileScelta2 = InputDati.leggiIntero("Scegliere informazione rilevabile :", 1, sensore2.getCategoriaSensori().getInformazioniRilevabili().size()) - 1;
                                InfoRilevabile iTMP2 = sensore.getCategoriaSensori().getInformazioniRilevabili().get(infoRilevabileScelta2);
                                InfoRilevabileNumerica iNTMP2 = (InfoRilevabileNumerica) iTMP2;
                                ClasseDiServizioInserimenti.aggiungiCostituenteLogicoARegola(contenitore, fruitore.getUnitaImmobiliari().get(unitaImm), iNTMP, iNTMP2, operatoreRelazionale);
                            }

                        }
                        //parametrico
                        else {
                            InfoRilevabileNonNumerica iNNTMP = (InfoRilevabileNonNumerica) iTMP;
                            System.out.println("L'operatore logico predefinito è =");
                            String parametro = ClasseDiServizioInserimenti.scegliParametroConCuiConfrontare(iNNTMP);
                            OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.sceltaOperatoreRelazionale();
                            ClasseDiServizioInserimenti.aggiungiCostituenteLogicoARegola(contenitore, fruitore.getUnitaImmobiliari().get(unitaImm), iNNTMP, parametro, operatoreRelazionale);
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
                        Orologio start = inserisciOrologio();
                        fruitore = ClasseDiServizioInserimenti.inserisciNuovaRegola(contenitore, fruitore.getUnitaImmobiliari().get(unitaImm), attuatore, mTMP, start);
                        Manutentore manutentore = contenitore.getManutentore();
                        manutentore.setFruitore(fruitore);
                        contenitore.setManutentore(manutentore);
                        ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
                    } else {
                        fruitore = ClasseDiServizioInserimenti.inserisciNuovaRegola(contenitore, unitaImm, attuatore, mTMP);
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
                        Orologio start = inserisciOrologio();
                        fruitore = ClasseDiServizioInserimenti.inserisciNuovaRegola(contenitore, fruitore.getUnitaImmobiliari().get(unitaImm), attuatore, mTMP, start);
                        Manutentore manutentore = contenitore.getManutentore();
                        manutentore.setFruitore(fruitore);
                        contenitore.setManutentore(manutentore);
                        ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
                    } else {
                        fruitore = ClasseDiServizioInserimenti.inserisciNuovaRegola(contenitore, unitaImm, attuatore, mTMP);
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
                    Orologio start = inserisciOrologio();
                    fruitore = ClasseDiServizioInserimenti.inserisciNuovaRegola(contenitore, fruitore.getUnitaImmobiliari().get(unitaImm), attuatore, mTMP, start);
                    Manutentore manutentore = contenitore.getManutentore();
                    manutentore.setFruitore(fruitore);
                    contenitore.setManutentore(manutentore);
                    ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
                } else {
                    fruitore = ClasseDiServizioInserimenti.inserisciNuovaRegola(contenitore, unitaImm, attuatore, mTMP);
                    Manutentore manutentore = contenitore.getManutentore();
                    manutentore.setFruitore(fruitore);
                    contenitore.setManutentore(manutentore);
                    ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
                }
            }
        } while (InputDati.yesOrNo("Vuoi continuare a creare conseguenze?"));

    }

    /**
     * Inserisci l'orologio
     *
     * @return l'ora scelta
     */
    private static Orologio inserisciOrologio() {
        int ora = InputDati.leggiIntero("Inserire ora: ", 0, 23);
        int minuti = InputDati.leggiIntero("Inserire minuti: ", 0, 59);
        return new Orologio(ora, minuti);
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
