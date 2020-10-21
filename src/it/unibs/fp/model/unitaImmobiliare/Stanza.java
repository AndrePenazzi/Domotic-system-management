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
     * toString.
     *
     * @return descrizione degli artefatti nell'unità immobiliare.
     */
    public String visualizzaArtefatti() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("Gli Artefatti sono:\n");
        for (Artefatto a : artefatti) {
            tmp.append(a.getNome()).append("\n");
        }
        return tmp.toString();
    }

    /**
     * toString.
     *
     * @return descrizione della stanza.
     */
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        tmp.append(nome);
        if (!artefatti.isEmpty()) {
            int i = 1;
            tmp.append("\nArtefatti:\n");
            for (Artefatto a : artefatti) {
                tmp.append(i + " " + a.toString()).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora artefatti nella stanza");

        if (!sensori.getSensori().isEmpty()) {
            int i = 1;
            tmp.append("\nSensori:\n");
            for (Sensore s : sensori.getSensori()) {
                tmp.append(i + " " + s.toString()).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora sensori nella stanza");

        if (!artefatti.isEmpty()) {
            int i = 1;
            tmp.append("\nArtefatti:\n");
            for (Artefatto a : artefatti) {
                tmp.append(i + " " + a.toString()).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora artefatti nella stanza");

        return tmp.toString();
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