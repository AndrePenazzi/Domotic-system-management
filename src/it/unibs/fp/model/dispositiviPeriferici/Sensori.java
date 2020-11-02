package it.unibs.fp.model.dispositiviPeriferici;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sensori implements Serializable {
    private List<Sensore> sensori;

    /**
     * Costruttore Sensori
     */
    public Sensori() {
        sensori = new ArrayList<>();
    }

    /**
     * Getter
     *
     * @return Sensori
     */
    public List<Sensore> getSensori() {
        return sensori;
    }

    /**
     * Setter
     *
     * @param sensori da modificare
     */
    public void setSensori(List<Sensore> sensori) {
        this.sensori = sensori;
    }

    /**
     * Check if sensori è vuoto
     *
     * @return true se è vuoto, altrimenti false
     */
    public boolean isEmpty() {
        return sensori.isEmpty();
    }

    /**
     * Getter
     *
     * @param i la posizione
     * @return Sensore
     */
    public Sensore getSensore(int i) {
        return sensori.get(i);
    }

    /**
     * Getter
     *
     * @return size di sensori
     */
    public int getSize() {
        return sensori.size();
    }

    /**
     * Inserisci Sensore
     *
     * @param sensore da inserire
     */
    public void inserisciSensore(Sensore sensore) {
        sensori.add(sensore);
    }
}
