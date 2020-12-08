package it.unibs.fp.model.modalitaOperativa;

import java.io.Serializable;

public interface ModOperativa extends Serializable {


    /**
     * Getter
     *
     * @return nome che descrive ogni singola modalità operativa
     */
    String getNome();

    /**
     * Setter
     *
     * @param nome da modificare
     */
    void setNome(String nome);
}
