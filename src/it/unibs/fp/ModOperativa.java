package it.unibs.fp;

import java.io.Serializable;

public class ModOperativa implements Serializable {
    private String nome;

    public ModOperativa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
