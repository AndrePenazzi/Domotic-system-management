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

    /**
     * Getter
     *
     * @return antecedenti
     */
    public List<Antecedente> getAntecendenti() {
        return antecendenti;
    }

    /**
     * Setter
     *
     * @param antecendenti da modificare
     */
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

    /**
     * Inserisci un nuovo antecedente
     *
     * @param antecedente da inserire
     * @throws InputMismatchException nel caso di errore di inserimento
     */
    public void inserisciAntecedente(Antecedente antecedente) throws InputMismatchException {
        if ((antecendenti.size() == 0 && antecedente.getOpBooleano() == null) || (antecendenti.size() != 0 && antecedente.getOpBooleano() != null)) {
            antecendenti.add(antecedente);
        } else {
            throw new InputMismatchException();
        }
    }

}
