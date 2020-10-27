package it.unibs.fp.model.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatori;

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

    public Attuatori getAttuatoriInStanze(){
        Attuatori attuatori=new Attuatori();

        for (Stanza s : stanze) {
            attuatori.getAttuatori().addAll(s.getAttuatoriInStanza().getAttuatori());
        }
        return attuatori;
    }


    public void inserisciStanza(Stanza stanza) {
        stanze.add(stanza);
    }
}
