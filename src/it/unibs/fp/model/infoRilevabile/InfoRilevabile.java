package it.unibs.fp.model.infoRilevabile;

import java.io.Serializable;

public abstract class InfoRilevabile implements Serializable {
    private String nome;

    /**
     * Costruttore con il tipo
     *
     * @param nome dell'info rilevabile
     */
    public InfoRilevabile(String nome) {
        this.nome = nome;
    }

    /**
     * Getter
     *
     * @return il nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter
     *
     * @param nome della informazione rilevabile
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    /**
     * Getter
     *
     * @return il tipo sottoforma di intero
     */
    public abstract int getType();
}