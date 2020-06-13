package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;


public class Stanza implements Serializable {
    private String nome;
    private ArrayList<Artefatto> artefatti;
    private ArrayList<Sensore> sensori;
    private ArrayList<Attuatore> attuatori;

    /**
     * Costruttore della stanza.
     *
     * @param nome della stanza.
     */
    public Stanza(String nome) {
        sensori = new ArrayList<>();
        attuatori = new ArrayList<>();
        artefatti = new ArrayList<>();
        this.nome = nome;
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
        sensori.add(sensore);
    }

    /**
     * Inserisci un attuatore.
     *
     * @param attuatore inserito.
     */
    public void inserisciAttuatore(Attuatore attuatore) {
        attuatori.add(attuatore);
    }

    /**
     * Getter
     *
     * @return sensori
     */
    public ArrayList<Sensore> getSensori() {
        return sensori;
    }

    /**
     * Getter
     *
     * @return attutatori
     */
    public ArrayList<Attuatore> getAttuatori() {
        return attuatori;
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
    public ArrayList<Artefatto> getArtefatti() {
        return artefatti;
    }

    /**
     * Setter
     *
     * @param artefatti all'interno della stanza
     */
    public void setArtefatti(ArrayList<Artefatto> artefatti) {
        this.artefatti = artefatti;
    }

    /**
     * toString.
     *
     * @return descrizione della stanza.
     */
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("Nella stanza").append(nome).append(" ci sono i seguenti artefatti: \n");
        for (Artefatto a : artefatti) {
            tmp.append(a.toString()).append("\n");
        }
        return tmp.toString();
    }
}