package it.unibs.fp.model.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.regola.Regole;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UnitaImmobiliare implements Serializable {
    private String nome;
    private Stanze stanze;
    private Artefatti artefatti;
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
    public void cambiaRegolaAttivaDisattiva(Regola regola) {
        int i = trovaRegola(regola);
        regole.getRegole().get(i).attivaDisattivaRegola();
    }

    /**
     * Visualizza le regole con il loro stato
     *
     * @return lo stato delle regole
     */
    public String visualizzaStatoRegole() {
        StringBuilder statoRegole = new StringBuilder();
        for (int i = 0; i < regole.getRegole().size(); i++) {
            statoRegole.append(regole.getRegole().get(i).visualizzaStatoRegola());
        }
        return statoRegole.toString();
    }

    public void inserisciRegola(Regola regola) {
        regole.getRegole().add(regola);
    }


    /**
     * Trova la regola se esistente restituisce -1 altrimenti
     *
     * @param regola da trovare
     * @return indice della regola
     */
    public int trovaRegola(Regola regola) {
        for (int i = 0; i < regole.getRegole().size(); i++) {
            if (regole.getRegole().get(i).equals(regola))
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
        stanze.getStanze().add(stanza);
    }

    /**
     * Inserisci un nuovo artefatto
     *
     * @param artefatto inserito
     */
    public void inserisciArtefatto(Artefatto artefatto) {
        artefatti.getArtefatti().add(artefatto);
    }

    /**
     * Associa sensore ad una o più stanze
     *
     * @param sensoreAss sensore da associare alle stanze
     * @param stanzeAss  stanze scelte
     */
    public void associaSensoreAStanze(Sensore sensoreAss, Iterable<Stanza> stanzeAss) {
        for (Stanza s : stanzeAss) {
            s.inserisciSensore(sensoreAss);
        }
    }

    /**
     * Associa attuatore ad una o più stanze
     *
     * @param attuatoreAss attuatore da associare
     * @param stanzeAss    stanze scelte
     */
    public void associaAttuatoreAStanze(Attuatore attuatoreAss, Iterable<Stanza> stanzeAss) {
        for (Stanza s : stanzeAss) {
            s.inserisciAttuatore(attuatoreAss);
        }
    }

    /**
     * Associa sensore ad uno o più artefatti
     *
     * @param sensoreAss   sensore da associare
     * @param artefattoAss artefatto scelto
     */
    public void associaSensoreAdArtefatti(Sensore sensoreAss, Iterable<Artefatto> artefattoAss) {
        for (Artefatto a : artefattoAss) {
            a.inserisciSensore(sensoreAss);
        }
    }

    /**
     * Associa attuatore ad uno o più artefatti
     *
     * @param attuatoreAss attuatore da associare
     * @param artefattoAss artefatti scelti
     */
    public void associaAttuatoreAdArtefatti(Attuatore attuatoreAss, Iterable<Artefatto> artefattoAss) {
        for (Artefatto a : artefattoAss) {
            a.inserisciAttuatore(attuatoreAss);
        }
    }

    /**
     * Associa artefatto ad uno o più stanze
     *
     * @param artefattoAss artefatto da associare
     * @param stanzeAss    stanze scelte
     */
    public void associaArtefattoAStanze(Artefatto artefattoAss, Iterable<Stanza> stanzeAss) {
        for (Stanza s : stanzeAss) {
            s.inserisciArtefatto(artefattoAss);
        }
    }


    /**
     * Getter.
     *
     * @return le stanze.
     */
    public List<Stanza> getStanze() {
        return stanze.getStanze();
    }

    /**
     * Getter
     *
     * @return degli artefatti.
     */
    public List<Artefatto> getArtefatti() {
        return artefatti.getArtefatti();
    }

    /**
     * Getter
     *
     * @return il numero delle stanze.
     */
    public int getSizeStanze() {
        return stanze.getStanze().size();
    }

    /**
     * Getter
     *
     * @return il numero degli artefatti.
     */
    public int getSizeArtefatti() {
        return artefatti.getArtefatti().size();
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
        return regole.getRegole().size();
    }

    /**
     * Getter
     *
     * @return regole
     */
    public List<Regola> getRegole() {
        return regole.getRegole();
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
    public List<Attuatore> getAttuatori(){
        List<Attuatore> attuatori=new ArrayList<>();
        attuatori.addAll(stanze.getAttuatori());
        attuatori.addAll(artefatti.getAttuatori());
        return attuatori;
    }


}
