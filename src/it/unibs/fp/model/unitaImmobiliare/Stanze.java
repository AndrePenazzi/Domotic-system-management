package it.unibs.fp.model.unitaImmobiliare;

import java.util.ArrayList;
import java.util.List;

public class Stanze {
    private List<Stanza> stanze;

    public Stanze() {
        stanze = new ArrayList<>();
    }

    public List<Stanza> getStanze() {
        return stanze;
    }

    public void setStanze(List<Stanza> stanze) {
        this.stanze = stanze;
    }


    public void inserisciStanza(Stanza stanza) {
        stanze.add(stanza);
    }
}
