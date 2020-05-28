package it.unibs.fp;

import java.util.ArrayList;

public class CategoriaAttuatori {
    private String nome;
    private ArrayList<Attuatore> attuatori;

    public CategoriaAttuatori(String nome) {
        this.nome = nome;
        this.attuatori = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "CategorieSensori{" +
                "nome='" + nome + '\'' +
                '}';
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
}
