package it.unibs.fp.model.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Attuatori;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.regola.Regole;

import java.io.Serializable;

public class UnitaImmobiliare implements Serializable {
    private final Stanze stanze;
    private final Artefatti artefatti;
    private String nome;
    private Regole regole;


    /**
     * Costruttore unita' immobiliare
     *
     * @param nome dell'unita' immobiliare
     */
    public UnitaImmobiliare(String nome) {
        this.nome = nome;
        this.stanze = new Stanze();
        this.artefatti = new Artefatti();
        this.regole = new Regole();
    }

    /**
     * Cambia lo stato delle regole da attiva a disattiva o viceversa in automatico
     *
     * @param regola scelta
     */
    public void cambiaRegolaAttivaDisattiva(int regola) {
        regole.attivaDsattivaRegola(regola);
    }

    /**
     * Inserisci una nuova regola nell'unita immobiliare
     *
     * @param regola da inserire
     */
    public void inserisciRegola(Regola regola) {
        regole.inserisciRegola(regola);
    }


    /**
     * Trova la regola se esistente restituisce -1 altrimenti
     *
     * @param regola da trovare
     * @return indice della regola
     */
    public int trovaRegola(Regola regola) {
        for (int i = 0; i < regole.getSizeRegole(); i++) {
            if (regole.getRegola(i).equals(regola))
                return i;
        }
        return -1;
    }

    /**
     * Inserisci una nuova stanza.
     *
     * @param stanza inserita
     */
    public void inserisciStanza(Stanza stanza) {
        stanze.inserisciStanza(stanza);
    }

    /**
     * Inserisci un nuovo artefatto
     *
     * @param artefatto inserito
     */
    public void inserisciArtefatto(Artefatto artefatto) {
        artefatti.inserisciArtefatto(artefatto);
    }

    /**
     * Associa sensore ad una o più stanze
     *
     * @param sensoreAss sensore da associare alle stanze
     * @param stanzeAss  stanze scelte
     */
    public void associaSensoreAStanze(Sensore sensoreAss, Stanze stanzeAss) {
        for (Stanza s : stanzeAss.getStanze()) {
            s.inserisciSensore(sensoreAss);
        }
    }

    /**
     * Associa attuatore ad una o più stanze
     *
     * @param attuatoreAss attuatore da associare
     * @param stanzeAss    stanze scelte
     */
    public void associaAttuatoreAStanze(Attuatore attuatoreAss, Stanze stanzeAss) {
        for (Stanza s : stanzeAss.getStanze()) {
            s.inserisciAttuatore(attuatoreAss);
        }
    }

    /**
     * Associa sensore ad uno o più artefatti
     *
     * @param sensoreAss   sensore da associare
     * @param artefattoAss artefatto scelto
     */
    public void associaSensoreAdArtefatti(Sensore sensoreAss, Artefatti artefattoAss) {
        for (Artefatto a : artefattoAss.getArtefatti()) {
            a.inserisciSensore(sensoreAss);
        }
    }

    /**
     * Associa attuatore ad uno o più artefatti
     *
     * @param attuatoreAss attuatore da associare
     * @param artefattoAss artefatti scelti
     */
    public void associaAttuatoreAdArtefatti(Attuatore attuatoreAss, Artefatti artefattoAss) {
        for (Artefatto a : artefattoAss.getArtefatti()) {
            a.inserisciAttuatore(attuatoreAss);
        }
    }

    /**
     * Associa artefatto ad uno o più stanze
     *
     * @param artefattoAss artefatto da associare
     * @param stanzeAss    stanze scelte
     */
    public void associaArtefattoAStanze(Artefatto artefattoAss, Stanze stanzeAss) {
        for (Stanza s : stanzeAss.getStanze()) {
            s.inserisciArtefatto(artefattoAss);
        }
    }

    /**
     * Getter.
     *
     * @return le stanze.
     */
    public Stanze getStanze() {
        return stanze;
    }

    /**
     * Checks if stanze is Empty
     *
     * @return true se è vuoto false altrimenti
     */
    public boolean stanzeIsEmpty() {
        return stanze.isEmpty();
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return la stanza alla posizione i
     */
    public Stanza getStanza(int i) {
        return stanze.getStanza(i);
    }

    /**
     * Getter
     *
     * @return degli artefatti.
     */
    public Artefatti getArtefattiInUnitaImmobiliare() {
        return artefatti;
    }

    /**
     * Check if artefattiInUnitaImmobiliare is empty
     *
     * @return true se è vuoto
     */
    public boolean artefattiInUnitaImmobiliareIsEmpty() {
        return artefatti.isEmpty();
    }

    /**
     * Getter
     *
     * @param i la posizione dell'artefatto
     * @return l'artefatto alla posizione i
     */
    public Artefatto getArtefatto(int i) {
        return artefatti.getArtefatto(i);
    }

    /**
     * Getter
     *
     * @return il numero delle stanze.
     */
    public int getSizeStanze() {
        return stanze.getSizeStanze();
    }

    /**
     * Getter
     *
     * @return il numero degli artefatti.
     */
    public int getSizeArtefatti() {
        return artefatti.getSizeArtefatti();
    }

    /**
     * Getter
     *
     * @return nome dell'unita' immobiliare.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter.
     *
     * @param nome modificato.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    /**
     * Getter
     *
     * @return il numero delle stanze.
     */
    public int getSizeRegole() {
        return regole.getSizeRegole();
    }

    /**
     * Getter
     *
     * @return regole
     */
    public Regole getRegole() {
        return regole;
    }

    /**
     * Setter
     *
     * @param regole scelte
     */
    public void setRegole(Regole regole) {
        this.regole = regole;
    }

    //FORSE SBAGLIATO
    public Attuatori getAttuatori() {
        Attuatori attuatori = new Attuatori();
        attuatori.getAttuatori().addAll(stanze.getAttuatoriInStanze().getAttuatori());
        attuatori.getAttuatori().addAll(artefatti.getAttuatoriInArtefatti().getAttuatori());
        return attuatori;
    }


}
