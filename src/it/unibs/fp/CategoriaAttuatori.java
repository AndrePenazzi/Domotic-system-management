package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoriaAttuatori implements Serializable {
    private String nome;
    private ArrayList<Attuatore> attuatori;

    public CategoriaAttuatori(String nome) {
        this.nome = nome;
        this.attuatori = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Attuatore> getAttuatori() {
        return attuatori;
    }

    public void setAttuatori(ArrayList<Attuatore> attuatori) {
        this.attuatori = attuatori;
    }

    public String toString() {
        return "Categoria sensori: nome=" + nome + ".\n";
    }
}
