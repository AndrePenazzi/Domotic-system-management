package it.unibs.fp.model.regola.conseguente.azione;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import it.unibs.fp.model.regola.Orologio;

import java.io.Serializable;

public class Azione implements Serializable {
    private Attuatore attuatore;
    private ModOperativa modOperativa;
    private Orologio start;

    /**
     * Costruttore
     *
     * @param attuatore    da modificare
     * @param modOperativa da assegnare
     */
    public Azione(Attuatore attuatore, ModOperativa modOperativa) {
        this.attuatore = attuatore;
        this.modOperativa = modOperativa;
        start = null;
    }

    /**
     * Costruttore con staart
     *
     * @param attuatore    da modificare
     * @param modOperativa da assegnare
     * @param start        tempo di assegnamento
     */
    public Azione(Attuatore attuatore, ModOperativa modOperativa, Orologio start) {
        this.attuatore = attuatore;
        this.modOperativa = modOperativa;
        this.start = start;
    }

    /**
     * Esegue l'azione e modifica la modalità operativa
     */
    public void eseguiAzione() {
        attuatore.setModOperativa(modOperativa);
    }

    /**
     * Getter
     *
     * @return start
     */
    public Orologio getStart() {
        return start;
    }

    public void setStart(Orologio start) {
        this.start = start;
    }

    /**
     * Getter
     *
     * @return attuatore
     */
    public Attuatore getAttuatore() {
        return attuatore;
    }

    /**
     * Setter
     *
     * @param attuatore scelto
     */
    public void setAttuatore(Attuatore attuatore) {
        this.attuatore = attuatore;
    }

    /**
     * Getter
     *
     * @return nome attuatore
     */
    public String getNomeAttuatore() {
        return attuatore.getNome();
    }

    /**
     * Getter
     *
     * @return modOperativa scelta
     */
    public ModOperativa getModOperativa() {
        return modOperativa;
    }

    /**
     * Setter
     *
     * @param modOperativa scelta
     */
    public void setModOperativa(ModOperativa modOperativa) {
        this.modOperativa = modOperativa;
    }

    /**
     * Getter
     *
     * @return nome modOperativa
     */
    public String getNomeModOperativa() {
        return modOperativa.getNome();
    }

}
