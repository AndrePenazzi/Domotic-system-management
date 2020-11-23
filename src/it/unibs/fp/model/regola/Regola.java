package it.unibs.fp.model.regola;

import it.unibs.fp.model.regola.antecedente.Antecedenti;
import it.unibs.fp.model.regola.conseguente.Conseguenti;

import java.io.Serializable;

public class Regola implements Serializable {
    private Antecedenti antecedenti;
    private Conseguenti conseguenti;
    private boolean attiva;


    /**
     * Costruttore regola
     */
    public Regola() {
        this.antecedenti = new Antecedenti();
        this.conseguenti = new Conseguenti();
        attiva = true;
    }

    /**
     * Getter
     *
     * @return antecedenti
     */
    public Antecedenti getAntecedenti() {
        return antecedenti;
    }

    public void setAntecedenti(Antecedenti antecedenti) {
        this.antecedenti = antecedenti;
    }

    /**
     * Getter
     *
     * @return conseguenti
     */
    public Conseguenti getConseguenti() {
        return conseguenti;
    }

    public void setConseguenti(Conseguenti conseguenti) {
        this.conseguenti = conseguenti;
    }

    /**
     * Inserisci conseguenti
     *
     * @param conseguenti da inserire
     */
    public void inserisciConseguenti(Conseguenti conseguenti) {
        this.conseguenti.setConseguenti(conseguenti.getConseguenti());
    }

    /**
     * Inserisci antecedenti
     *
     * @param antecedenti da inserire
     */
    public void inserisciAntecedenti(Antecedenti antecedenti) {
        this.antecedenti.setAntecendenti(antecedenti.getAntecendenti());
    }

    /**
     * Getter
     *
     * @return lo stato della regola
     */
    public boolean isAttiva() {
        return attiva;
    }

    /**
     * Setter
     *
     * @param attiva da modificare
     */
    public void setAttiva(boolean attiva) {
        this.attiva = attiva;
    }

    /**
     * AttivaDisattivaRegola
     */
    public void attivaDisattivaRegola() {
        this.attiva = !this.attiva;
    }
}
