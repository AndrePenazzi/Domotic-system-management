package it.unibs.fp.model.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Attuatori;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.dispositiviPeriferici.Sensori;

import java.io.Serializable;

public class Artefatto implements Serializable {
    private String nome;
    private Sensori sensori;
    private Attuatori attuatori;


    /**
     * Costruttore dell'artefatto.
     *
     * @param nome dell'artefatto
     */
    public Artefatto(String nome) {
        sensori = new Sensori();
        attuatori = new Attuatori();
        this.nome = nome;
    }

    /**
     * Inserisci un sensore.
     *
     * @param sensore inserito.
     */
    public void inserisciSensore(Sensore sensore) {
        sensori.inserisciSensore(sensore);
    }

    /**
     * Inserisci un attuatore.
     *
     * @param attuatore inserito.
     */
    public void inserisciAttuatore(Attuatore attuatore) {
        attuatori.inserisciAttuatore(attuatore);
    }

    /**
     * Getter
     *
     * @return List di sensori.
     */
    public Sensori getSensoriInArtefatto() {
        return sensori;
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return sensore alla posizione i
     */
    public Sensore getSensoreInArtefatto(int i) {
        return sensori.getSensore(i);
    }

    /**
     * Getter
     *
     * @return size di sensori
     */
    public int getSizeSensoriInArtefatto() {
        return sensori.getSize();
    }

    /**
     * Getter
     *
     * @return List di attuatori.
     */
    public Attuatori getAttuatoriInArtefatto() {
        return attuatori;
    }

    /**
     * Getter
     *
     * @return size di attuatori in artefatto
     */
    public int getSizeAttuatoriInArtefatto() {
        return attuatori.getSize();
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return attuatore alla posizione i
     */
    public Attuatore getAttuatoreInArtefatto(int i) {
        return attuatori.getAttuatore(i);
    }

    /**
     * Getter
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

}
