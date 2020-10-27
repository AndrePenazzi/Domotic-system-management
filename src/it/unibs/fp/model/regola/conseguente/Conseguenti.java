package it.unibs.fp.model.regola.conseguente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Conseguenti implements Serializable {
    private List<Conseguente> conseguenti;

    public Conseguenti() {
        conseguenti = new ArrayList<>();
    }

    public List<Conseguente> getConseguenti() {
        return conseguenti;
    }

    public void setConseguenti(List<Conseguente> conseguenti) {
        this.conseguenti = conseguenti;
    }


    public void inserisciConseguente(Conseguente conseguente) {
        conseguenti.add(conseguente);
    }
}
