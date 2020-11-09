package it.unibs.fp.model.regola.antecedente.costituenteLogico;

import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNonNumerica;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNumerica;
import it.unibs.fp.model.operatori.OperatoriRelazionali;
import it.unibs.fp.model.regola.Orologio;

import java.io.Serializable;

public abstract class CostituenteLogico implements Serializable {
    private InfoRilevabile primoOperatoreLogico;
    private InfoRilevabile secondoOperatoreLogico;
    private OperatoriRelazionali operatoreRelazionale;
    private Double secondoOperatoreCostante;
    private String secondoOperatoreScalare = null;
    private Orologio time;
    private Orologio secondoOperatoreOrologio = null;

    //TODO da aggiungere alla factory

    /**
     * Costruttore con valore true
     */
    public CostituenteLogico() {
        this.primoOperatoreLogico = null;
        this.secondoOperatoreLogico = null;
        this.operatoreRelazionale = null;
        this.secondoOperatoreCostante = null;
        this.time = null;
    }

    //todo non funzionerà mai sicuro

    /**
     * Calcolo del valore booleano attuale del costituente logico
     *
     * @return valore calcolato
     */
    public boolean calcolaValoreBooleano() {
        if (primoOperatoreLogico != null && secondoOperatoreLogico != null && operatoreRelazionale != null) {
            if (operatoreRelazionale == OperatoriRelazionali.UGUALE) {
                if (primoOperatoreLogico.getType() == 1) {
                    return ((InfoRilevabileNumerica) primoOperatoreLogico).rilevaVariabile() == ((InfoRilevabileNumerica) secondoOperatoreLogico).rilevaVariabile();
                } else {
                    return ((InfoRilevabileNonNumerica) primoOperatoreLogico).rilevaVariabile().equals(((InfoRilevabileNonNumerica) secondoOperatoreLogico).rilevaVariabile());
                }
            } else if (operatoreRelazionale == OperatoriRelazionali.MAGGIORE) {
                return ((InfoRilevabileNumerica) primoOperatoreLogico).rilevaVariabile() > ((InfoRilevabileNumerica) secondoOperatoreLogico).rilevaVariabile();
            } else if (operatoreRelazionale == OperatoriRelazionali.MINORE) {
                return ((InfoRilevabileNumerica) primoOperatoreLogico).rilevaVariabile() < ((InfoRilevabileNumerica) secondoOperatoreLogico).rilevaVariabile();
            } else if (operatoreRelazionale == OperatoriRelazionali.MAGGIORE_UGUALE) {
                return ((InfoRilevabileNumerica) primoOperatoreLogico).rilevaVariabile() >= ((InfoRilevabileNumerica) secondoOperatoreLogico).rilevaVariabile();
            } else if (operatoreRelazionale == OperatoriRelazionali.MINORE_UGUALE) {
                return ((InfoRilevabileNumerica) primoOperatoreLogico).rilevaVariabile() <= ((InfoRilevabileNumerica) secondoOperatoreLogico).rilevaVariabile();
            }
        } else return true;
        return false;
    }


    /**
     * Getter
     *
     * @return primoOperatoreLogico
     */
    public InfoRilevabile getPrimoOperatoreLogico() {
        return primoOperatoreLogico;
    }

    /**
     * Setter
     *
     * @param primoOperatoreLogico scelto
     */
    public void setPrimoOperatoreLogico(InfoRilevabile primoOperatoreLogico) {
        this.primoOperatoreLogico = primoOperatoreLogico;
    }

    /**
     * Getter
     *
     * @return secondoOperatoreLogico
     */
    public InfoRilevabile getSecondoOperatoreLogico() {
        return secondoOperatoreLogico;
    }

    /**
     * Setter
     *
     * @param secondoOperatoreLogico scelto
     */
    public void setSecondoOperatoreLogico(InfoRilevabile secondoOperatoreLogico) {
        this.secondoOperatoreLogico = secondoOperatoreLogico;
    }

    /**
     * Getter
     *
     * @return operatoreRelazionale
     */
    public OperatoriRelazionali getOperatoreRelazionale() {
        return operatoreRelazionale;
    }

    /**
     * Setter
     *
     * @param operatoreRelazionale scelto
     */
    public void setOperatoreRelazionale(OperatoriRelazionali operatoreRelazionale) {
        this.operatoreRelazionale = operatoreRelazionale;
    }

    /**
     * Getter
     *
     * @return secondoOperatoreCostante
     */
    public Double getSecondoOperatoreCostante() {
        return secondoOperatoreCostante;
    }

    /**
     * Setter
     *
     * @param secondoOperatoreCostante da settare
     */
    public void setSecondoOperatoreCostante(Double secondoOperatoreCostante) {
        this.secondoOperatoreCostante = secondoOperatoreCostante;
    }

    /**
     * Getter
     *
     * @return secondoOperatoreScalare
     */
    public String getSecondoOperatoreScalare() {
        return secondoOperatoreScalare;
    }

    /**
     * Setter
     *
     * @param secondoOperatoreScalare da settare
     */
    public void setSecondoOperatoreScalare(String secondoOperatoreScalare) {
        this.secondoOperatoreScalare = secondoOperatoreScalare;
    }

    /**
     * Getter
     *
     * @return time
     */
    public Orologio getTime() {
        return time;
    }

    public void setTime(Orologio time) {
        this.time = time;
    }

    /**
     * Getter
     *
     * @return secondoOperatoreOrologio
     */
    public Orologio getSecondoOperatoreOrologio() {
        return secondoOperatoreOrologio;
    }

    public void setSecondoOperatoreOrologio(Orologio secondoOperatoreOrologio) {
        this.secondoOperatoreOrologio = secondoOperatoreOrologio;
    }

    /**
     * Controlla se esiste il primo operatore logico
     *
     * @return true se esiste falso altrimenti
     */
    public boolean isTrue() {
        return primoOperatoreLogico != null || time != null;
    }
}
