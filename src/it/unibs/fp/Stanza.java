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
     * toString.
     *
     * @return descrizione degli artefatti nell'unità immobiliare.
     */
    public String visualizzaArtefatti() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("Gli Artefatti sono:\n");
        for (Artefatto a : artefatti) {
            tmp.append(a.toString()).append("\n");
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

        if (!sensori.isEmpty()) {
            int i = 1;
            tmp.append("\nSensori:\n");
            for (Sensore s : sensori) {
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

}