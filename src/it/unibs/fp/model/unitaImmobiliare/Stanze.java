package it.unibs.fp.model.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;

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

    public List<Attuatore> getAttuatori(){
        List<Attuatore> attuatori=new ArrayList<>();

        for (Stanza s : stanze) {
            attuatori.addAll(s.getAttuatori());
        }
        return attuatori;
    }


    public void inserisciStanza(Stanza stanza) {
        stanze.add(stanza);
    }
}
