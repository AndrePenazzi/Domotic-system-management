package it.unibs.fp;

import java.io.Serializable;

public class CostituenteLogico implements Serializable {
    private InfoRilevabile primoOperatoreLogico = null;
    private InfoRilevabile secondoOperatoreLogico = null;
    private OperatoriRelazionali operatoreRelazionale = null;
    private Double secondoOperatoreCostante = null;
    private String secondoOperatoreScalare = null;
    private Orologio time = null;
    private Orologio secondoOperatoreOrologio = null;

    /**
     * Costruttore con valori
     *
     * @param primoOperatoreLogico   Informazione rilevabile 1
     * @param secondoOperatoreLogico Informazione rilevabile 2
     * @param operatoreRelazionale   per il confronto
     */
    public CostituenteLogico(InfoRilevabile primoOperatoreLogico, InfoRilevabile secondoOperatoreLogico, OperatoriRelazionali operatoreRelazionale) {
        this.primoOperatoreLogico = primoOperatoreLogico;
        this.secondoOperatoreLogico = secondoOperatoreLogico;
        this.operatoreRelazionale = operatoreRelazionale;
    }


    /**
     * Costruttore con costante
     *
     * @param primoOperatoreLogico     da confrontare
     * @param secondoOperatoreCostante double
     * @param operatoreRelazionale     per il confronto
     */
    public CostituenteLogico(InfoRilevabile primoOperatoreLogico, double secondoOperatoreCostante, OperatoriRelazionali operatoreRelazionale) {
        this.secondoOperatoreLogico = null;
        this.primoOperatoreLogico = primoOperatoreLogico;
        this.secondoOperatoreCostante = secondoOperatoreCostante;
        this.operatoreRelazionale = operatoreRelazionale;
    }

    /**
     * Costruttore costituente logico
     *
     * @param primoOperatoreLogico    da confrontare
     * @param secondoOperatoreScalare String
     * @param operatoreRelazionale    per il confronto
     */
    public CostituenteLogico(InfoRilevabile primoOperatoreLogico, String secondoOperatoreScalare, OperatoriRelazionali operatoreRelazionale) {
        this.secondoOperatoreLogico = null;
        this.primoOperatoreLogico = primoOperatoreLogico;
        this.secondoOperatoreScalare = secondoOperatoreScalare;
        this.operatoreRelazionale = operatoreRelazionale;
    }

    /**
     * Costruttore con orologio
     *
     * @param secondoOperatoreLogico orologio
     * @param operatoreRelazionale   per il confronto
     */
    public CostituenteLogico(Orologio secondoOperatoreLogico, OperatoriRelazionali operatoreRelazionale) {
        this.secondoOperatoreOrologio = secondoOperatoreLogico;
        this.operatoreRelazionale = operatoreRelazionale;
    }

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

    /**
     * Controlla se esiste il primo operatore logico
     *
     * @return true se esiste falso altrimenti
     */
    public boolean isTrue() {
        return primoOperatoreLogico != null || time != null;
    }


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
     * toString
     *
     * @return nomi e opeartore relazionale
     */
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        if (primoOperatoreLogico != null && operatoreRelazionale != null) {
            tmp.append(primoOperatoreLogico.getNome()).append(" ").append(operatoreRelazionale.toString());

            if (secondoOperatoreLogico != null)
                tmp.append(" " + secondoOperatoreLogico);
            if (secondoOperatoreCostante != null)
                tmp.append(" " + secondoOperatoreCostante);
            if (secondoOperatoreScalare != null)
                tmp.append(" " + secondoOperatoreScalare);
        } else if (time != null) {
            tmp.append(time).append(" ").append(operatoreRelazionale.toString()).append(secondoOperatoreOrologio);
        }
        return tmp.toString();
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
}
