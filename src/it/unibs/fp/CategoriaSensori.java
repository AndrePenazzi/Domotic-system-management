package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

//TODO c'è un attributo descrizione in generalità da rivedere
public class CategoriaSensori implements Serializable {
    private String nome;
    private ArrayList<Sensore> sensori;

    public CategoriaSensori(String nome) {
        this.nome = nome;
        this.sensori = new ArrayList<>();
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

    public String toString() {
        return "Categoria sensori: nome=" + nome + ".\n";
    }

}
