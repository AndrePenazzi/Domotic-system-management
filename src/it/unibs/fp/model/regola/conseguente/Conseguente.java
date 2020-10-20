package it.unibs.fp.model.regola.conseguente;

import it.unibs.fp.model.regola.conseguente.azione.Azione;

public class Conseguente {
    private Azione azione;

    public Conseguente(Azione azione){
        this.azione=azione;
    }
    public Azione getAzione() {
        return azione;
    }

    public void setAzione(Azione azione) {
        this.azione = azione;
    }
}
