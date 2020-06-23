package it.unibs.fp;

import java.io.Serializable;

public class InfoRilevabile implements Serializable {
    private String nome;
    private int type;

    /**
     * Getter del tipo di informazione rilevabile
     * @return il tipo sottoforma di intero
     */
    public int getType() {
        return type;
    }

    /**
     * Setter del tipo di informazione rilevabile
     * @param type tipo sottoforma di intero
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Costruttore con il tipo
     * @param nome dell'info rilevabile
     * @param type sottoforma di intero
     */
    public InfoRilevabile(String nome, int type){
        this.nome = nome;
        this.type = type;
    }

    /**
     * Getter del nome dell'info rilevabile
     * @return il nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter del nome dell'informazione rilevabile
     * @param nome della informazione rilevabile
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
