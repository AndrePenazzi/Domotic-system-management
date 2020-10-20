package it.unibs.fp.model.modalitaOperativa;

import java.io.Serializable;

public abstract class ModOperativa implements Serializable {
    private String nome;

    /**
     * Costruttore nome
     *
     * @param nome descrive la modalitò operativa
     */
    public ModOperativa(String nome) {
        this.nome = nome;
    }

    public ModOperativa() {
        this.nome="";
    }

    /**
     * Getter del tipo di modalitò operativa
     *
     * @return la tipologia della modalità operativa
     */
    public abstract int getType();


    /**
     * Getter del nome
     *
     * @return nome che descrive ogni singola modalità operativa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter del nome
     *
     * @param nome da modificare
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
