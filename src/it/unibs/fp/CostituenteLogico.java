package it.unibs.fp;

public class CostituenteLogico {
    InfoRilevabile primoOperatoreLogico;
    InfoRilevabile secondoOperatoreLogico;
    OperazioniRelazionale operatoreRelazionale;

    /**
     * Costruttore con valori
     * @param primoOperatoreLogico Informazione rilevabile 1
     * @param secondoOperatoreLogico Informazione rilevabile 2
     * @param operatoreRelazionale >,<,=,<=,>=
     */
    public CostituenteLogico(InfoRilevabile primoOperatoreLogico, InfoRilevabile secondoOperatoreLogico, OperazioniRelazionale operatoreRelazionale) {
        this.primoOperatoreLogico = primoOperatoreLogico;
        this.secondoOperatoreLogico = secondoOperatoreLogico;
        this.operatoreRelazionale = operatoreRelazionale;
    }

    /**
     * Costruttore con valore true
     */
    public CostituenteLogico() {
        this.primoOperatoreLogico = null;
        this.secondoOperatoreLogico = null;
        this.operatoreRelazionale = null;
    }

    /**
     * Getter
     * @return primoOperatoreLogico
     */
    public InfoRilevabile getPrimoOperatoreLogico() {
        return primoOperatoreLogico;
    }

    /**
     * Setter
     * @param primoOperatoreLogico
     */
    public void setPrimoOperatoreLogico(InfoRilevabile primoOperatoreLogico) {
        this.primoOperatoreLogico = primoOperatoreLogico;
    }

    /**
     * Getter
     * @return secondoOperatoreLogico
     */
    public InfoRilevabile getSecondoOperatoreLogico() {
        return secondoOperatoreLogico;
    }

    /**
     * Setter
     * @param secondoOperatoreLogico
     */
    public void setSecondoOperatoreLogico(InfoRilevabile secondoOperatoreLogico) {
        this.secondoOperatoreLogico = secondoOperatoreLogico;
    }

    /**
     * Getter
     * @return operatoreRelazionale
     */
    public OperazioniRelazionale getOperatoreRelazionale() {
        return operatoreRelazionale;
    }

    /**
     * Setter
     * @param operatoreRelazionale
     */
    public void setOperatoreRelazionale(OperazioniRelazionale operatoreRelazionale) {
        this.operatoreRelazionale = operatoreRelazionale;
    }

    /**
     * Calcolo del valore booleano attuale del costituente logico
     * @return valore calcolato
     */
    public boolean calcolaValoreBooleano() {
        if (primoOperatoreLogico != null && secondoOperatoreLogico != null && operatoreRelazionale != null) {
            if (operatoreRelazionale == OperazioniRelazionale.UGUALE) {
                if (primoOperatoreLogico.getType() == 1) {
                    if (((InfoRilevabileNumerica) primoOperatoreLogico).rilevaVariabile() == ((InfoRilevabileNumerica) secondoOperatoreLogico).rilevaVariabile())
                        return true;
                } else {
                    if (((InfoRilevabileNonNumerica) primoOperatoreLogico).rilevaVariabile() == ((InfoRilevabileNonNumerica) secondoOperatoreLogico).rilevaVariabile())
                        return true;
                }
            } else if (operatoreRelazionale == OperazioniRelazionale.MAGGIORE) {
                if (((InfoRilevabileNumerica) primoOperatoreLogico).rilevaVariabile() > ((InfoRilevabileNumerica) secondoOperatoreLogico).rilevaVariabile())
                    return true;
            } else if (operatoreRelazionale == OperazioniRelazionale.MINORE) {
                if (((InfoRilevabileNumerica) primoOperatoreLogico).rilevaVariabile() < ((InfoRilevabileNumerica) secondoOperatoreLogico).rilevaVariabile())
                    return true;
            } else if (operatoreRelazionale == OperazioniRelazionale.MAGGIORE_UGUALE) {
                if (((InfoRilevabileNumerica) primoOperatoreLogico).rilevaVariabile() >= ((InfoRilevabileNumerica) secondoOperatoreLogico).rilevaVariabile())
                    return true;
            } else if (operatoreRelazionale == OperazioniRelazionale.MINORE_UGUALE) {
                if (((InfoRilevabileNumerica) primoOperatoreLogico).rilevaVariabile() <= ((InfoRilevabileNumerica) secondoOperatoreLogico).rilevaVariabile())
                    return true;
            }
        }
        else return  true;

        return false;
    }

    /**
     * toString
     * @return nomi e opeartore relazionale
     */
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        if (primoOperatoreLogico != null && secondoOperatoreLogico != null && operatoreRelazionale != null)
            tmp.append(primoOperatoreLogico.getNome()).append(" ").append(operatoreRelazionale.toString()).append(" ").append(secondoOperatoreLogico.getNome());
        return tmp.toString();
    }
}
