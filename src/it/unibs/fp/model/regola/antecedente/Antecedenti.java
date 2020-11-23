package it.unibs.fp.model.regola.antecedente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Antecedenti implements Serializable {
    private List<Antecedente> antecendenti;

    /**
     * Costruttore Antecedenti
     */
    public Antecedenti() {
        antecendenti = new ArrayList<>();
    }

    public List<Antecedente> getAntecendenti() {
        return antecendenti;
    }

    public void setAntecendenti(List<Antecedente> antecendenti) {
        this.antecendenti = antecendenti;
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return antecedente alla posizione i
     */
    public Antecedente getAntecendente(int i) {
        return antecendenti.get(i);
    }

    /**
     * Getter
     *
     * @return size Antecedente
     */
    public int getAntecendentiSize() {
        return antecendenti.size();
    }

    public void inserisciAntecedente(Antecedente antecedente) throws InputMismatchException {
        if ((antecendenti.size() == 0 && antecedente.getOpBooleano() == null) || (antecendenti.size() != 0 && antecedente.getOpBooleano() != null)) {
            antecendenti.add(antecedente);
        } else {
            throw new InputMismatchException();
        }
    }

}
