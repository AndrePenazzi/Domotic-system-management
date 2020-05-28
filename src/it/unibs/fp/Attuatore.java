package it.unibs.fp;

import java.io.Serializable;

public class Attuatore implements Serializable {
    private String nome;

    public Attuatore(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Attuatore: nome=" + nome + ".\n";
    }
}
