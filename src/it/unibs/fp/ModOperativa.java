package it.unibs.fp;

import java.io.Serializable;

public class ModOperativa implements Serializable {
    private String nome;
    private int type;

    public ModOperativa(String nome) {
        this.nome = nome;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ModOperativa(String nome, int type) {
        this.nome = nome;
        this.type = type;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
