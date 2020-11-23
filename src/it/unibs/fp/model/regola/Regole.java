package it.unibs.fp.model.regola;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Regole implements Serializable {
    private List<Regola> regole;

    /**
     * Costruttore regole
     */
    public Regole() {
        regole = new ArrayList<>();
    }

    public List<Regola> getRegole() {
        return regole;
    }

    public void setRegole(List<Regola> regole) {
        this.regole = regole;
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return regola alla posizione i
     */
    public Regola getRegola(int i) {
        return regole.get(i);
    }

    /**
     * isEmpty
     *
     * @return true se è vuoto, false altrimenti
     */
    public Boolean isEmpty() {
        return regole.isEmpty();
    }

    /**
     * AttivaDisattivaRegola
     *
     * @param i posizione regola scelta
     */
    public void attivaDsattivaRegola(int i) {
        getRegola(i).attivaDisattivaRegola();
    }

    /**
     * Getter
     *
     * @return size regole
     */
    public int getSizeRegole() {
        return regole.size();
    }

    /**
     * Inserisci una nuova regola
     *
     * @param regola da inserire
     */
    public void inserisciRegola(Regola regola) {
        regole.add(regola);
    }
}
