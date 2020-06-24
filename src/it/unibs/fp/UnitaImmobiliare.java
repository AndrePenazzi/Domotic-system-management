package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class UnitaImmobiliare implements Serializable {
    private String nome;
    private ArrayList<Stanza> stanze;
    private ArrayList<Artefatto> artefatti;
    private ArrayList<Regola> regole;


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

    /**
     * Cambia lo stato delle regole da attiva a disattiva o viceversa in automatico
     * @param regola scelta
     */
    public void cambiaRegolaAttivaDisattiva(Regola regola) {
        int i = trovaRegola(regola);
        regole.get(i).setAttiva(!regole.get(i).isAttiva());
    }

    /**
     * Visualizza le regole con il loro stato
     * @return lo stato delle regole
     */
    public String visualizzaStatoRegole() {
        StringBuilder statoRegole = new StringBuilder();
        for (int i = 0; i < regole.size(); i++) {
            statoRegole.append(regole.get(i).visualizzaStatoRegola());
        }
        return statoRegole.toString();
    }

    /**
     * Inserisci la regola per la prima volta
     *
     * @param attuatore    per settare la sua modalità operativa
     * @param modOperativa scelta
     */
    public void inserisciRegola(Attuatore attuatore, ModOperativa modOperativa) {
        regole.add(new Regola());
        int i = regole.size();
        regole.get(i - 1).inserisciCostituenteLogico();
        regole.get(i - 1).inserisciAzione(attuatore, modOperativa);
    }

    /**
     * Inserisci la regola per la prima volta con start
     *
     * @param attuatore    per settare la sua modalità operativa
     * @param modOperativa scelta
     * @param start        ora di assegnamento
     */
    public void inserisciRegola(Attuatore attuatore, ModOperativa modOperativa, Orologio start) {
        regole.add(new Regola());
        int i = regole.size();
        regole.get(i - 1).inserisciCostituenteLogico();
        regole.get(i - 1).inserisciAzione(attuatore, modOperativa, start);
    }

    /**
     * Inserisci la regola per la prima volta
     *
     * @param regola       scelta
     * @param attuatore    per settare la sua modalità operativa
     * @param modOperativa scelta
     */
    public void aggiungiAzione(Regola regola, Attuatore attuatore, ModOperativa modOperativa) {
        int i;
        if (regole.contains(regola)) {
            i = trovaRegola(regola);
            regole.get(i).inserisciAzione(attuatore, modOperativa);
        }
    }

    /**
     * Inserisci il primo costituente logico
     *
     * @param regola          scelta
     * @param primoOpLogico   primo operatore da confrontare
     * @param secondoOpLogico secondo operatore da confrontare
     * @param opRelazionale   operatore relazionale per il confronto
     */
    public void aggiungiPrimoCosituenteLogicoARegola(Regola regola, InfoRilevabile primoOpLogico, InfoRilevabile secondoOpLogico, OperatoriRelazionali opRelazionale) {
        int i;
        if (regole.contains(regola)) {
            i = trovaRegola(regola);
            regole.get(i).inserisciCostituenteLogico(primoOpLogico, secondoOpLogico, opRelazionale);
        }
    }

    /**
     * Inserisci il primo costituente logico
     *
     * @param regola            scelta
     * @param primoOpLogico     primo operatore da confrontare
     * @param secondoOpCostante double
     * @param opRelazionale     per il confronto
     */
    public void aggiungiPrimoCosituenteLogicoARegola(Regola regola, InfoRilevabile primoOpLogico, double secondoOpCostante, OperatoriRelazionali opRelazionale) {
        int i;
        if (regole.contains(regola)) {
            i = trovaRegola(regola);
            regole.get(i).inserisciCostituenteLogico(primoOpLogico, secondoOpCostante, opRelazionale);
        }
    }

    /**
     * Inserisci il primo costituente logico
     *
     * @param regola            scelta
     * @param primoOpLogico     primo operatore da confrontare
     * @param secondoOpCostante String
     * @param opRelazionale     per il confronto
     */
    public void aggiungiPrimoCosituenteLogicoARegola(Regola regola, InfoRilevabile primoOpLogico, String secondoOpCostante, OperatoriRelazionali opRelazionale) {
        int i;
        if (regole.contains(regola)) {
            i = trovaRegola(regola);
            regole.get(i).inserisciCostituenteLogico(primoOpLogico, secondoOpCostante, opRelazionale);
        }
    }

    /**
     * Inserisci il primo costituente logico
     *
     * @param regola        scelta
     * @param orologio primo operatore da confrontare
     * @param opRelazionale per il confronto
     */
    public void aggiungiPrimoCosituenteLogicoARegola(Regola regola, Orologio orologio, OperatoriRelazionali opRelazionale) {
        int i;
        if (regole.contains(regola)) {
            i = trovaRegola(regola);
            regole.get(i).inserisciCostituenteLogico(orologio, opRelazionale);
        }
    }

    /**
     * Inserisci l'ennesimo costituente logico
     *
     * @param regola          scelta
     * @param primoOpLogico   primo operatore da confrontare
     * @param secondoOpLogico info rilevabile
     * @param opRelazionale   per il confronto
     * @param opBooleano      per confrontare i costituenti logici
     */
    public void aggiungiEnnesimoCosituenteLogicoARegola(Regola regola, InfoRilevabile primoOpLogico, InfoRilevabile secondoOpLogico, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano) {
        int i;
        if (regole.contains(regola)) {
            i = trovaRegola(regola);
            regole.get(i).inserisciCostituenteLogico(primoOpLogico, secondoOpLogico, opRelazionale, opBooleano);
        }
    }

    /**
     * Aggiungi ennesimo costituente logico a regola
     *
     * @param regola            scelta
     * @param primoOpLogico     scelto
     * @param secondoOpCostante double
     * @param opRelazionale     per il confronto
     * @param opBooleano        per il confronto tra costituenti
     */
    public void aggiungiEnnesimoCosituenteLogicoARegola(Regola regola, InfoRilevabile primoOpLogico, double secondoOpCostante, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano) {
        int i;
        if (regole.contains(regola)) {
            i = trovaRegola(regola);
            regole.get(i).inserisciCostituenteLogico(primoOpLogico, secondoOpCostante, opRelazionale, opBooleano);
        }
    }

    /**
     * Aggiungi ennesimo costituente logico a regola
     *
     * @param regola            scelta
     * @param primoOpLogico     scelto
     * @param secondoOpCostante String
     * @param opRelazionale     per il confronto
     * @param opBooleano        per il confronto tra costituenti
     */
    public void aggiungiEnnesimoCosituenteLogicoARegola(Regola regola, InfoRilevabile primoOpLogico, String secondoOpCostante, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano) {
        int i;
        if (regole.contains(regola)) {
            i = trovaRegola(regola);
            regole.get(i).inserisciCostituenteLogico(primoOpLogico, secondoOpCostante, opRelazionale, opBooleano);
        }
    }

    /**
     * Aggiungi ennesimo costituente logico a regola con orologio
     *
     * @param regola        scelta
     * @param opRelazionale per il confronto
     * @param opBooleano    per il confronto tra costituenti
     * @param orologio      da confrontare
     */
    public void aggiungiEnnesimoCosituenteLogicoARegola(Regola regola, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano, Orologio orologio) {
        int i;
        if (regole.contains(regola)) {
            i = trovaRegola(regola);
            regole.get(i).inserisciCostituenteLogico(opRelazionale, opBooleano, orologio);
        }
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
    public void associaSensoreAStanze(Sensore sensoreAss, ArrayList<Stanza> stanzeAss) {
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
    public void associaAttuatoreAStanze(Attuatore attuatoreAss, ArrayList<Stanza> stanzeAss) {
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
    public void associaSensoreAdArtefatti(Sensore sensoreAss, ArrayList<Artefatto> artefattoAss) {
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
    public void associaAttuatoreAdArtefatti(Attuatore attuatoreAss, ArrayList<Artefatto> artefattoAss) {
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
    public void associaArtefattoAStanze(Artefatto artefattoAss, ArrayList<Stanza> stanzeAss) {
        for (Stanza s : stanzeAss) {
            s.inserisciArtefatto(artefattoAss);
        }
    }

    /**
     * Getter.
     *
     * @return le stanze.
     */
    public ArrayList<Stanza> getStanze() {
        return stanze;
    }

    /**
     * Getter
     *
     * @return degli artefatti.
     */
    public ArrayList<Artefatto> getArtefatti() {
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
                tmp.append(s.toString());
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
    public ArrayList<Regola> getRegole() {
        return regole;
    }

    /**
     * Setter
     *
     * @param regole scelte
     */
    public void setRegole(ArrayList<Regola> regole) {
        this.regole = regole;
    }

    /**
     * Visualliza le regole
     *
     * @return la visualizzazione delle regole
     */
    public String visualizzaRegole() {
        StringBuilder str = new StringBuilder();
        for (Regola r : regole)
            str.append("\n" + regole.toString());
        return str.toString();
    }
}
