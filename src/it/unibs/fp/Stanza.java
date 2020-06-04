package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class Stanza implements Serializable {
    private String nome;
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
        this.nome = nome;
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
     * @return arrayList di sensori.
     */
    public ArrayList<Sensore> getSensori() {
        return sensori;
    }

    /**
     * Getter
     *
     * @return arrayList di attuatori.
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
     * toString.
     *
     * @return descrizione della stanza.
     */
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("");
        tmp.append("Nella stanza").append(nome).append(" ci sono i seguenti componenti.\nI sensori sono:\n");
        for (Sensore s : sensori) {
            tmp.append(s.toString()).append("\n");
        }
        tmp.append("Gli attuatori sono:\n");
        for (Attuatore a : attuatori) {
            tmp.append(a.toString()).append("\n");
        }
        return tmp.toString();
    }
}
