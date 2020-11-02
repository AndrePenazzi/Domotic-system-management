package it.unibs.fp.model.dispositiviPeriferici;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Attuatori implements Serializable {
    private List<Attuatore> attuatori;

    /**
     * Costruttore Attuatori
     */
    public Attuatori() {
        attuatori = new ArrayList<>();
    }

    /**
     * Getter
     *
     * @return Attuatori
     */
    public List<Attuatore> getAttuatori() {
        return attuatori;
    }

    /**
     * Setter
     *
     * @param attuatori da modificare
     */
    public void setAttuatori(List<Attuatore> attuatori) {
        this.attuatori = attuatori;
    }

    /**
     * Getter
     *
     * @param i la posizione
     * @return Attuatori
     */
    public Attuatore getAttuatore(int i) {
        return attuatori.get(i);
    }

    /**
     * Controlla se attuatori è vuota
     *
     * @return true se è vuota
     */
    public boolean isEmpty() {
        return attuatori.isEmpty();
    }

    /**
     * Getter
     *
     * @return size di attuatori
     */
    public int getSize() {
        return attuatori.size();
    }

    /**
     * Inserisci Attuatore
     *
     * @param attuatore da inserire
     */
    public void inserisciAttuatore(Attuatore attuatore) {
        attuatori.add(attuatore);
    }
}