package it.unibs.fp.model.unitaImmobiliare;

import it.unibs.fp.model.regola.Regola;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UnitaImmobiliari implements Serializable {
    private List<UnitaImmobiliare> unitaImmobiliari;

    public UnitaImmobiliari() {
        unitaImmobiliari = new ArrayList<>();
    }

    public List<UnitaImmobiliare> getUnitaImmobiliari() {
        return unitaImmobiliari;
    }

    public void setUnitaImmobiliari(List<UnitaImmobiliare> unitaImmobiliari) {
        this.unitaImmobiliari = unitaImmobiliari;
    }

    public UnitaImmobiliare getUnitaImmobiliare(int i) {
        return unitaImmobiliari.get(i);
    }

    public int getSizeUnitaImmobiliari() {
        return unitaImmobiliari.size();
    }

    public boolean isEmpty() {
        return unitaImmobiliari.isEmpty();
    }

    public void inserisciUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) {
        unitaImmobiliari.add(unitaImmobiliare);
    }

    public void inserisciRegolaInUnitaImmobiliare(int unitaImmobiliare, Regola regola) {
        getUnitaImmobiliare(unitaImmobiliare).inserisciRegola(regola);
    }
}
