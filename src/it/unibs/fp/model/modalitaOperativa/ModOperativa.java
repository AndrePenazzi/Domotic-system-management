package it.unibs.fp.model.modalitaOperativa;

import java.io.Serializable;

public class ModOperativa implements Serializable {
    private String nome;
    private int type;

    /**
     * Costruttore nome
     *
     * @param nome descrive la modalitò operativa
     */
    public ModOperativa(String nome) {
        this.nome = nome;
    }

    /**
     * Costruttore con tipo
     *
     * @param nome descrive la modalità operativa
     * @param type tipo della modalità operativa
     */
    public ModOperativa(String nome, int type) {
        this.nome = nome;
        this.type = type;
    }

    public ModOperativa() {
        this.nome="";
    }

    /**
     * Getter del tipo di modalitò operativa
     *
     * @return la tipologia della modalità operativa
     */
    public int getType() {
        return type;
    }

    /**
     * Setter del tipo
     *
     * @param type descrive la tipologia della modalità operativa
     */
    public void setType(int type) {
        this.type = type;
    }


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
