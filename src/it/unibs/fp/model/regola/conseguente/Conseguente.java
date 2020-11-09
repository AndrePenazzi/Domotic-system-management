package it.unibs.fp.model.regola.conseguente;

import it.unibs.fp.model.regola.conseguente.azione.Azione;

import java.io.Serializable;

public class Conseguente implements Serializable {
    private Azione azione;

    public Conseguente(Azione azione) {
        this.azione = azione;
    }

    /**
     * Getter
     *
     * @return azione
     */
    public Azione getAzione() {
        return azione;
    }

    public void setAzione(Azione azione) {
        this.azione = azione;
    }
}
