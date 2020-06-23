package it.unibs.fp;

public class CostituenteLogico {
    private InfoRilevabile primoOperatoreLogico;
    private InfoRilevabile secondoOperatoreLogico;
    private OperatoriRelazionali operatoreRelazionale;

    /**
     * Costruttore con valori
     * @param primoOperatoreLogico Informazione rilevabile 1
     * @param secondoOperatoreLogico Informazione rilevabile 2
     * @param operatoreRelazionale >,<,=,<=,>=
     */
    public CostituenteLogico(InfoRilevabile primoOperatoreLogico, InfoRilevabile secondoOperatoreLogico, OperatoriRelazionali operatoreRelazionale) {
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
     * @param primoOperatoreLogico scelto
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
     * @param secondoOperatoreLogico scelto
     */
    public void setSecondoOperatoreLogico(InfoRilevabile secondoOperatoreLogico) {
        this.secondoOperatoreLogico = secondoOperatoreLogico;
    }

    /**
     * Getter
     * @return operatoreRelazionale
     */
    public OperatoriRelazionali getOperatoreRelazionale() {
        return operatoreRelazionale;
    }

    /**
     * Setter
     * @param operatoreRelazionale scelto
     */
    public void setOperatoreRelazionale(OperatoriRelazionali operatoreRelazionale) {
        this.operatoreRelazionale = operatoreRelazionale;
    }

    /**
     * Calcolo del valore booleano attuale del costituente logico
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
