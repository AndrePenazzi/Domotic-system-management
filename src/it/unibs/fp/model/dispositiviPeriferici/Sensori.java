package it.unibs.fp.model.dispositiviPeriferici;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sensori implements Serializable {
    private List<Sensore> sensori;

    public Sensori() {
        sensori = new ArrayList<>();
    }

    public List<Sensore> getSensori() {
        return sensori;
    }

    public Sensore getSensore(int i){
        return sensori.get(i);
    }

    public int getSize() {
        return sensori.size();
    }

    public void setSensori(List<Sensore> sensori) {
        this.sensori = sensori;
    }


    public void inserisciSensore(Sensore sensore) {
        sensori.add(sensore);
    }
}
