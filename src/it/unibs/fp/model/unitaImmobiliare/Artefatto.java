package it.unibs.fp.model.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Attuatori;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.dispositiviPeriferici.Sensori;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


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
    public List<Sensore> getSensori() {
        return sensori.getSensori();
    }

    /**
     * Getter
     *
     * @return List di attuatori.
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

}
