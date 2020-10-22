package it.unibs.fp.model.unitaImmobiliare;


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


    public void inserisciArtefatto(Artefatto artefatto) {
        artefatti.add(artefatto);
    }
}
