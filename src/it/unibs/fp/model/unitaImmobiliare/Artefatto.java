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

    public Artefatto() {
        sensori = new Sensori();
        attuatori = new Attuatori();
        this.nome = "";
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
     * Visualizza i attuatori
     *
     * @return descrizione attuatori
     */
    public String visualizzaAttuatori() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("Gli attuatori sono:\n");
        for (Attuatore a : attuatori.getAttuatori()) {
            tmp.append(a.getNome()).append("\n");
        }
        return tmp.toString();
    }

    /**
     * Visualizza i sensori
     *
     * @return descrizione sensori
     */
    public String visualizzaSensori() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("Gli sensori sono:\n");
        for (Sensore s : sensori.getSensori()) {
            tmp.append(s.toString()).append("\n");
        }
        return tmp.toString();
    }

    /**
     * toString.
     *
     * @return descrizione dell'artefatto.
     */
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n" + nome);

        if (!sensori.getSensori().isEmpty()) {
            int i = 1;
            tmp.append("\nSensori:\n");
            for (Sensore s : sensori.getSensori()) {
                tmp.append(i + " " + s.toString()).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora sensori associati");

        if (!attuatori.getAttuatori().isEmpty()) {
            int i = 1;
            tmp.append("\nAttuatori:\n");
            for (Attuatore a : attuatori.getAttuatori()) {
                tmp.append(i + " " + a.toString()).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora attuatori associati");
        return tmp.toString();
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
