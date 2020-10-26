package it.unibs.fp.model.unitaImmobiliare;


import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Attuatori;

import java.util.ArrayList;
import java.util.List;

public class Artefatti {
    private List<Artefatto> artefatti;

    public Artefatti() {
        artefatti = new ArrayList<>();
    }

    public List<Artefatto> getArtefatti() {
        return artefatti;
    }

    public void setArtefatti(List<Artefatto> artefatti) {
        this.artefatti = artefatti;
    }

    public Attuatori getAttuatori(){
        Attuatori attuatori=new Attuatori();
        for (Artefatto a : artefatti) {
            attuatori.getAttuatori().addAll(a.getAttuatoriInArtefatto().getAttuatori());
        }
        return attuatori;
    }

    public void inserisciArtefatto(Artefatto artefatto) {
        artefatti.add(artefatto);
    }
}
