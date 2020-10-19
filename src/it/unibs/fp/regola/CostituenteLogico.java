package it.unibs.fp.regola;

import it.unibs.fp.operatori.OperatoriRelazionali;
import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.infoRilevabile.InfoRilevabileNonNumerica;
import it.unibs.fp.infoRilevabile.InfoRilevabileNumerica;

import java.io.Serializable;

public abstract class CostituenteLogico implements Serializable {
    private InfoRilevabile primoOperatoreLogico;
    private InfoRilevabile secondoOperatoreLogico;
    private OperatoriRelazionali operatoreRelazionale;
    private Double secondoOperatoreCostante;
    private String secondoOperatoreScalare = null;
    private Orologio time;
    private Orologio secondoOperatoreOrologio = null;

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

    public Double getSecondoOperatoreCostante() {
        return secondoOperatoreCostante;
    }

    public void setSecondoOperatoreCostante(Double secondoOperatoreCostante) {
        this.secondoOperatoreCostante = secondoOperatoreCostante;
    }

    public String getSecondoOperatoreScalare() {
        return secondoOperatoreScalare;
    }

    public void setSecondoOperatoreScalare(String secondoOperatoreScalare) {
        this.secondoOperatoreScalare = secondoOperatoreScalare;
    }

    public Orologio getTime() {
        return time;
    }

    public void setTime(Orologio time) {
        this.time = time;
    }

    public Orologio getSecondoOperatoreOrologio() {
        return secondoOperatoreOrologio;
    }

    public void setSecondoOperatoreOrologio(Orologio secondoOperatoreOrologio) {
        this.secondoOperatoreOrologio = secondoOperatoreOrologio;
    }
}
