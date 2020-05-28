package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class Artefatto implements Serializable {
    private String nome;
    private ArrayList<Sensore> sensori;
    private ArrayList<Attuatore> attuatori;

    public Artefatto(String nome) {
        sensori = new ArrayList<>();
        attuatori = new ArrayList<>();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Sensore> getSensori() {
        return sensori;
    }

    public void inserisciSensore(Sensore sensore) {
        sensori.add(sensore);
    }

    public void inserisciAttuatore(Attuatore attuatore) {
        attuatori.add(attuatore);
    }

    public String toString() {
        StringBuilder tmp = new StringBuilder("");
        tmp.append("Nell'artefatto").append(nome).append(" ci sono i seguenti componenti.\nI sensori sono:\n");
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
