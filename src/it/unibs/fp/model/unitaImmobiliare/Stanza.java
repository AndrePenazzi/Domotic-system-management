package it.unibs.fp.model.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Attuatori;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.dispositiviPeriferici.Sensori;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Stanza implements Serializable {
    private String nome;
    private List<Artefatto> artefatti;
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
        artefatti = new ArrayList<>();
        this.nome = nome;
    }
    public Stanza(){
        sensori = new Sensori();
        attuatori = new Attuatori();
        artefatti = new ArrayList<>();
        this.nome = "";

    }

    /**
     * Inserisci un nuovo artefatto nella stanza
     *
     * @param artefatto nuovo
     */
    public void inserisciArtefatto(Artefatto artefatto) {
        artefatti.add(artefatto);
    }


    /**
     * Inserisci un sensore.
     *
     * @param sensore inserito.
     */
    public void inserisciSensore(Sensore sensore) {
        sensori.getSensori().add(sensore);
    }

    /**
     * Inserisci un attuatore.
     *
     * @param attuatore inserito.
     */
    public void inserisciAttuatore(Attuatore attuatore) {
        attuatori.getAttuatori().add(attuatore);
    }


    /**
     * Getter
     *
     * @return sensori
     */
    public List<Sensore> getSensori() {
        return sensori.getSensori();
    }

    /**
     * Getter
     *
     * @return attutatori
     */
    public List<Attuatore> getAttuatori() {
        return attuatori.getAttuatori();
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
    public List<Artefatto> getArtefatti() {
        return artefatti;
    }

    /**
     * Setter
     *
     * @param artefatti all'interno della stanza
     */
    public void setArtefatti(List<Artefatto> artefatti) {
        this.artefatti = artefatti;
    }
}