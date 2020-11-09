package it.unibs.fp.model.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Attuatori;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.dispositiviPeriferici.Sensori;

import java.io.Serializable;


public class Stanza implements Serializable {
    private String nome;
    private Artefatti artefatti;
    private Sensori sensori;
    private Attuatori attuatori;

    /**
     * Costruttore della stanza.
     *
     * @param nome della stanza.
     */
    public Stanza(String nome) {
        sensori = new Sensori();
        attuatori = new Attuatori();
        artefatti = new Artefatti();
        this.nome = nome;
    }

    /**
     * Inserisci un nuovo artefatto nella stanza
     *
     * @param artefatto nuovo
     */
    public void inserisciArtefatto(Artefatto artefatto) {
        artefatti.inserisciArtefatto(artefatto);
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
     * @return sensori
     */
    public Sensori getSensori() {
        return sensori;
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return sensore
     */
    public Sensore getSensore(int i) {
        return sensori.getSensore(i);
    }

    /**
     * Getter
     *
     * @return size di sensori
     */
    public int getSizeSensori() {
        return sensori.getSize();
    }

    /**
     * Getter
     *
     * @return attutatori
     */
    public Attuatori getAttuatoriInStanza() {
        Attuatori attuatori = new Attuatori();
        for (Attuatore a : this.attuatori.getAttuatori()) {
            attuatori.inserisciAttuatore(a);
        }
        return attuatori;
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return attuatorie alla posizione i
     */
    public Attuatore getAttuatoreInStanza(int i) {
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

    /**
     * Setter
     *
     * @param nome della stanza
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter
     *
     * @return artefatti
     */
    public Artefatti getArtefatti() {
        return artefatti;
    }

    /**
     * Setter
     *
     * @param artefatti all'interno della stanza
     */
    public void setArtefatti(Artefatti artefatti) {
        this.artefatti = artefatti;
    }

    /**
     * Getter
     *
     * @return Artefatti in stanza
     */
    public Artefatti getArtefattiInStanza() {
        return artefatti;
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return Artefatto
     */
    public Artefatto getArtefatto(int i) {
        return artefatti.getArtefatto(i);
    }

    /**
     * Getter
     *
     * @return size Artefatti
     */
    public int getSizeArtefatti() {
        return artefatti.getSizeArtefatti();
    }

    /**
     * Getter
     *
     * @return size di attuatori
     */
    public int getSizeAttuatori() {
        return attuatori.getSize();
    }
}