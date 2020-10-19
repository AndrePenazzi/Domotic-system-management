package it.unibs.fp.model.regola;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.modalitaOperativa.ModOperativa;

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
    public Azione() {
        this.attuatore = null;
        this.modOperativa = null;
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
     * ToString
     *
     * @return Nome dell'attuatore e della modalità da assegnare
     */
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        tmp.append(attuatore.getNome()).append(":=").append(modOperativa.getNome());
        if (start != null)
            tmp.append("," + "start := " + start);
        return tmp.toString();
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

}
