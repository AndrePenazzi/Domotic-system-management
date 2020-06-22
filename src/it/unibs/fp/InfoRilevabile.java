package it.unibs.fp;

import java.io.Serializable;

public class InfoRilevabile implements Serializable {
    private String nome;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public InfoRilevabile(String nome, int type){
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
