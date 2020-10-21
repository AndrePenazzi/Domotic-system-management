package it.unibs.fp.model.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.regola.Regola;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UnitaImmobiliare implements Serializable {
    private String nome;
    private List<Stanza> stanze;
    private List<Artefatto> artefatti;
    private List<Regola> regole;


    /**
     * Costruttore unita' immobiliare
     *
     * @param nome dell'unita' immobiliare
     */
    public UnitaImmobiliare(String nome) {
        this.nome = nome;
        this.stanze = new ArrayList<>();
        this.artefatti = new ArrayList<>();
        this.regole = new ArrayList<>();
    }

    public UnitaImmobiliare() {
        this.nome = "";
        this.stanze = new ArrayList<>();
        this.artefatti = new ArrayList<>();
        this.regole = new ArrayList<>();
    }

    /**
     * Cambia lo stato delle regole da attiva a disattiva o viceversa in automatico
     *
     * @param regola scelta
     */
    public void cambiaRegolaAttivaDisattiva(Regola regola) {
        int i = trovaRegola(regola);
        regole.get(i).setAttiva(!regole.get(i).isAttiva());
    }

    /**
     * Visualizza le regole con il loro stato
     *
     * @return lo stato delle regole
     */
    public String visualizzaStatoRegole() {
        StringBuilder statoRegole = new StringBuilder();
        for (int i = 0; i < regole.size(); i++) {
            statoRegole.append(regole.get(i).visualizzaStatoRegola());
        }
        return statoRegole.toString();
    }

    public void inserisciRegola(Regola regola) {
        regole.add(regola);
    }


    /**
     * Trova la regola se esistente restituisce -1 altrimenti
     *
     * @param regola da trovare
     * @return indice della regola
     */
    public int trovaRegola(Regola regola) {
        for (int i = 0; i < regole.size(); i++) {
            if (regole.get(i).equals(regola))
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
        stanze.add(stanza);
    }

    /**
     * Inserisci un nuovo artefatto
     *
     * @param artefatto inserito
     */
    public void inserisciArtefatto(Artefatto artefatto) {
        artefatti.add(artefatto);
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
     * toString.
     *
     * @return descrizione delle stanze nell'unità immobiliare.
     */
    public String visualizzaStanze() {
        StringBuilder tmp = new StringBuilder();
        if (!stanze.isEmpty()) {
            int i = 1;
            tmp.append("\nStanze:\n");
            for (Stanza s : stanze) {
                tmp.append(i);
                tmp.append(" ");
                tmp.append(s.getNome());
                tmp.append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora stanze nella unità immobiliare");
        return tmp.toString();
    }

    /**
     * toString.
     *
     * @return descrizione degli artefatti nell'unità immobiliare.
     */
    public String visualizzaArtefatti() {
        StringBuilder tmp = new StringBuilder();
        if (!artefatti.isEmpty()) {
            int i = 1;
            tmp.append("\nArtefatti:\n");
            for (Artefatto s : artefatti) {
                tmp.append(i);
                tmp.append(" ");
                tmp.append(s.toString());
                tmp.append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora artefatti nella unità immobiliare");
        return tmp.toString();
    }

    /**
     * toString.
     *
     * @return descrizione dell'unita' immobiliare.
     */
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n");
        tmp.append(nome);
        tmp.append(visualizzaArtefatti());
        tmp.append(visualizzaStanze());
        return tmp.toString();
    }

    /**
     * Getter.
     *
     * @return le stanze.
     */
    public List<Stanza> getStanze() {
        return stanze;
    }

    /**
     * Getter
     *
     * @return degli artefatti.
     */
    public List<Artefatto> getArtefatti() {
        return artefatti;
    }

    /**
     * Getter
     *
     * @return il numero delle stanze.
     */
    public int getSizeStanze() {
        return stanze.size();
    }

    /**
     * Getter
     *
     * @return il numero degli artefatti.
     */
    public int getSizeArtefatti() {
        return artefatti.size();
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
        return regole.size();
    }

    /**
     * Getter
     *
     * @return regole
     */
    public List<Regola> getRegole() {
        return regole;
    }

    /**
     * Setter
     *
     * @param regole scelte
     */
    public void setRegole(List<Regola> regole) {
        this.regole = regole;
    }

    /**
     * Visualliza le regole
     *
     * @return la visualizzazione delle regole
     */
    public String visualizzaRegole() {
        StringBuilder str = new StringBuilder();
        if (!regole.isEmpty())
            for (Regola r : regole)
                str.append("\n" + r.toString());
        else
            str.append("Non ci sono ancora regole in questa unità immobiliare");
        return str.toString();
    }
}
