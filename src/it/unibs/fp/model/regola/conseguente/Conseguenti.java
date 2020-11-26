package it.unibs.fp.model.regola.conseguente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Conseguenti implements Serializable {
    private List<Conseguente> conseguenti;

    /**
     * Costruttore conseguenti
     */
    public Conseguenti() {
        conseguenti = new ArrayList<>();
    }

    /**
     * Getter
     *
     * @return conseguenti
     */
    public List<Conseguente> getConseguenti() {
        return conseguenti;
    }

    /**
     * Setter
     *
     * @param conseguenti da modificare
     */
    public void setConseguenti(List<Conseguente> conseguenti) {
        this.conseguenti = conseguenti;
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return conseguente alla posizione i
     */
    public Conseguente getConseguente(int i) {
        return conseguenti.get(i);
    }

    /**
     * Getter
     *
     * @return size conseguenti
     */
    public int getConseguentiSize() {
        return conseguenti.size();
    }

    /**
     * Inserisci i conseguenti
     *
     * @param conseguente da inserire
     */
    public void inserisciConseguente(Conseguente conseguente) {
        conseguenti.add(conseguente);
    }
}
