package it.unibs.fp;

import java.io.Serializable;

public class Sensore implements Serializable {
    private String nome;

    public Sensore(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //TODO PENSACI TU!!! :)
    public String rilevaVariabileFisica() {
        return "";
    }

    @Override
    public String toString() {
        return "Sensore: nome=" + nome + ".\n";
    }
}
