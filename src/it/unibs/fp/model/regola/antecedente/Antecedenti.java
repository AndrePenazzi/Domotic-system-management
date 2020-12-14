package it.unibs.fp.model.regola.antecedente;

import it.unibs.fp.model.operatori.OperatoriBooleani;

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

    public boolean calcolaAntecedenti() {
        List<Integer> posizioneOr = new ArrayList<>();
        for (int i = 1; i < antecendenti.size(); i++) {
            if (antecendenti.get(i).getOpBooleano() == OperatoriBooleani.OR)
                posizioneOr.add(i);
        }
        List<Boolean> risultatiAnd = new ArrayList<>(calcolaAnd(posizioneOr));

        boolean tmp = false;
        for (int i = 0; i < risultatiAnd.size(); i++) {
            tmp = tmp || risultatiAnd.get(i);
        }
        return tmp;
    }


    public List<Boolean> calcolaAnd(List<Integer> posizioneOr) {
        List<Boolean> risultatiAnd = new ArrayList<>();
        boolean tmp = true;
        for (int i = 0; i < posizioneOr.get(0); i++) {
            tmp = tmp && antecendenti.get(i).getCostituenteLogico().calcolaValoreBooleano();
        }
        risultatiAnd.add(tmp);

        for (int i = 1; i < posizioneOr.size(); i++) {
            tmp = true;
            for (int j = posizioneOr.get(i - 1); j < posizioneOr.get(i); j++) {
                tmp = tmp && antecendenti.get(j).getCostituenteLogico().calcolaValoreBooleano();
            }
            risultatiAnd.add(tmp);
        }

        tmp = true;
        for (int i = posizioneOr.get(posizioneOr.size() - 1); i < antecendenti.size(); i++) {
            tmp = tmp && antecendenti.get(i).getCostituenteLogico().calcolaValoreBooleano();
        }
        risultatiAnd.add(tmp);

        return risultatiAnd;
    }


}
