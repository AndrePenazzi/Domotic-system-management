package it.unibs.fp.model.dispositiviPeriferici;

import java.util.ArrayList;
import java.util.List;

public class Attuatori {
    private List<Attuatore> attuatori;

    public Attuatori() {
        attuatori = new ArrayList<>();
    }

    public List<Attuatore> getAttuatori() {
        return attuatori;
    }

    public void setAttuatori(List<Attuatore> attuatori) {
        this.attuatori = attuatori;
    }


    public void inserisciAttuatore(Attuatore attuatore) {
        attuatori.add(attuatore);
    }
}