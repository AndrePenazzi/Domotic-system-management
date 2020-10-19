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

    public InfoRilevabile() {
    }

    /**
     * Getter del nome dell'info rilevabile
     *
     * @return il nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter del nome dell'informazione rilevabile
     *
     * @param nome della informazione rilevabile
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    /**
     * Getter del tipo di informazione rilevabile
     *
     * @return il tipo sottoforma di intero
     */
    public abstract int getType();
}