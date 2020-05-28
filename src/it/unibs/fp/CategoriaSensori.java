package it.unibs.fp;

import java.util.ArrayList;

public class CategoriaSensori {
    private String nome;
    private ArrayList<Sensore> sensori;

    public CategoriaSensori(String nome) {
        this.nome = nome;
        this.sensori = new ArrayList<>();
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Sensore> getSensori() {
        return sensori;
    }

    public void setSensori(ArrayList<Sensore> sensori) {
        this.sensori = sensori;
    }

}
