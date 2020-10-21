package it.unibs.fp.model.dispositiviPeriferici;

import java.util.ArrayList;
import java.util.List;

public class Sensori {
    private List<Sensore> sensori;

    public Sensori() {
        sensori = new ArrayList<>();
    }

    public List<Sensore> getSensori() {
        return sensori;
    }

    public void setSensori(List<Sensore> sensori) {
        this.sensori = sensori;
    }


    public void inserisciSensore(Sensore sensore) {
        sensori.add(sensore);
    }
}
