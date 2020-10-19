package it.unibs.fp.model.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Artefatto implements Serializable {
    private String nome;
    private List<Sensore> sensori;
    private List<Attuatore> attuatori;

    /**
     * Costruttore dell'artefatto.
     *
     * @param nome dell'artefatto
     */
    public Artefatto(String nome) {
        sensori = new ArrayList<>();
        attuatori = new ArrayList<>();
        this.nome = nome;
    }

    public Artefatto() {
        this.nome="";
        sensori = new ArrayList<>();
        attuatori = new ArrayList<>();
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
     * Visualizza i attuatori
     *
     * @return descrizione attuatori
     */
    public String visualizzaAttuatori() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("Gli attuatori sono:\n");
        for (Attuatore a : attuatori) {
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
        for (Sensore s : sensori) {
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

        if (!sensori.isEmpty()) {
            int i = 1;
            tmp.append("\nSensori:\n");
            for (Sensore s : sensori) {
                tmp.append(i + " " + s.toString()).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora sensori associati");

        if (!attuatori.isEmpty()) {
            int i = 1;
            tmp.append("\nAttuatori:\n");
            for (Attuatore a : attuatori) {
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
        return sensori;
    }

    /**
     * Getter
     *
     * @return List di attuatori.
     */
    public List<Attuatore> getAttuatori() {
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

}
