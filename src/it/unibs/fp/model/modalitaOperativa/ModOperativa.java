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


    /**
     * Getter
     *
     * @return la tipologia della modalità operativa
     */
    public abstract int getType();


    /**
     * Getter
     *
     * @return nome che descrive ogni singola modalità operativa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter
     *
     * @param nome da modificare
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
