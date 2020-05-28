package it.unibs.fp;

import java.util.ArrayList;

public class Artefatto {
    private String nome;
    private ArrayList<Sensore> sensori;
    private ArrayList<Attuatore> attuatori;

    public Artefatto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Sensore> getSensori() {
        return sensori;
    }

    public void inserisciSensore(Sensore sensore){
        sensori.add(sensore);
    }

    public void inserisciAttuatore(Attuatore attuatore){
        attuatori.add(attuatore);
    }
}
