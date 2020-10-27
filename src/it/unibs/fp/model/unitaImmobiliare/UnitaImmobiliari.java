package it.unibs.fp.model.unitaImmobiliare;

import java.util.ArrayList;
import java.util.List;

public class UnitaImmobiliari {
    private List<UnitaImmobiliare> unitaImmobiliari;

    public UnitaImmobiliari() {
        unitaImmobiliari = new ArrayList<>();
    }

    public List<UnitaImmobiliare> getUnitaImmobiliari() {
        return unitaImmobiliari;
    }
    public UnitaImmobiliare getUnitaImmobiliare(int i) {
        return unitaImmobiliari.get(i);
    }
    public int getSizeUnitaImmobiliari() {
        return unitaImmobiliari.size();
    }

    public void setUnitaImmobiliari(List<UnitaImmobiliare> unitaImmobiliari) {
        this.unitaImmobiliari = unitaImmobiliari;
    }
    public boolean isEmpty(){
        return unitaImmobiliari.isEmpty();
    }

    public void inserisciUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) {
        unitaImmobiliari.add(unitaImmobiliare);
    }
}
