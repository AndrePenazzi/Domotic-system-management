package it.unibs.fp.model.infoRilevabile;

import java.io.Serializable;

public interface InfoRilevabile <T> extends Serializable {

    /**
     * Getter
     *
     * @return il nome
     */
     String getNome();

    /**
     * Setter
     *
     * @param nome della informazione rilevabile
     */
     void setNome(String nome);

    /**
     * Rileva il valore della variabile
     *
     * @return valore rilevato
     */
     T rilevaVariabile();
}