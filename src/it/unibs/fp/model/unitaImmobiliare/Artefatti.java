package it.unibs.fp.model.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatori;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Artefatti implements Serializable {
    private List<Artefatto> artefatti;

    /**
     * Costruttore Artefatti
     */
    public Artefatti() {
        artefatti = new ArrayList<>();
    }

    /**
     * Inserisci un artefatto
     *
     * @param artefatto da inserire
     */
    public void inserisciArtefatto(Artefatto artefatto) {
        artefatti.add(artefatto);
    }

    /**
     * Getter Artefatti
     *
     * @return Artefatti
     */
    public List<Artefatto> getArtefatti() {
        return artefatti;
    }

    /**
     * Setter
     *
     * @param artefatti da modificare
     */
    public void setArtefatti(List<Artefatto> artefatti) {
        this.artefatti = artefatti;
    }

    /**
     * check if artefatti is empty
     *
     * @return true if artefatti is empty
     */
    public boolean isEmpty() {
        return artefatti.isEmpty();
    }

    /**
     * Getter
     *
     * @return size di Artefatti
     */
    public int getSizeArtefatti() {
        return artefatti.size();
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return artefatto alla posizione i
     */
    public Artefatto getArtefatto(int i) {
        return artefatti.get(i);
    }

    /**
     * Getter
     *
     * @return Attuatori in artefatti
     */
    public Attuatori getAttuatoriInArtefatti() {
        Attuatori attuatori = new Attuatori();
        for (Artefatto a : artefatti) {
            for (int i = 0; i < a.getSizeAttuatoriInArtefatto(); i++)
                attuatori.inserisciAttuatore(a.getAttuatoreInArtefatto(i));
        }
        return attuatori;
    }

}
