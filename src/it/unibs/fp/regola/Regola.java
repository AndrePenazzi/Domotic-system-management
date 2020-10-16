package it.unibs.fp.regola;

import it.unibs.fp.dispositiviPeriferici.Attuatore;
import it.unibs.fp.operatori.OperatoriBooleani;
import it.unibs.fp.modalitaOperativa.ModOperativa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Regola implements Serializable {
    private List<AntecedenteSingolo> antecedenti;
    private List<Azione> conseguenti;

    private boolean attiva;


    /**
     * Costruttore regola
     */
    public Regola() {
        this.antecedenti = new ArrayList<>();
        this.conseguenti = new ArrayList<>();
        attiva = true;
    }



    /**
     * Inserisci una nuova azione
     *
     * @param attuatore    nel quale inserire un'azione
     * @param modOperativa scelta
     */
    public void inserisciAzione(Attuatore attuatore, ModOperativa modOperativa) {
        Azione azione = new Azione(attuatore, modOperativa);
        conseguenti.add(azione);
    }

    /**
     * Inserisci una nuova azione con start
     *
     * @param attuatore    nel quale inserire un'azione
     * @param modOperativa scelta
     * @param start        con ora di assegnamento
     */
    public void inserisciAzione(Attuatore attuatore, ModOperativa modOperativa, Orologio start) {
        Azione azione = new Azione(attuatore, modOperativa, start);
        conseguenti.add(azione);
    }

    /**
     * Visualizza la regola con il suo stato
     *
     * @return la regola ed il suo stato
     */
    public String visualizzaStatoRegola() {
        StringBuilder regola = new StringBuilder();
        for (int i = 0; i < antecedenti.size(); i++) {
            regola.append(" " + antecedenti.get(i).toString());
            if (i % 2 == 0 && opBooleani.get(0) != null)
                regola.append(opBooleani.get(i));
        }

        for (int i = 0; i < conseguenti.size(); i++) {
            regola.append(" " + conseguenti.get(i).toString());
            if (i < conseguenti.size() - 1)
                regola.append(",");
        }

        regola.append("La regola:" +
                "if " + antecedente + " then " + conseguenti + " è ");
        if (attiva) {
            return regola.append("attiva\n").toString();
        } else return regola.append("disattiva\n").toString();
    }

    /**
     * To String
     *
     * @return descrizione
     */
    @Override
    public String toString() {
        StringBuilder regola = new StringBuilder();
        for (int i = 0; i < antecedente.size(); i++) {
            regola.append(" " + antecedente.get(i).toString());
            if (i % 2 == 0 && opBooleani != null && i<antecedente.size()-1)
                regola.append(opBooleani.get(i));
        }

        for (int i = 0; i < conseguenti.size(); i++) {
            regola.append(" " + conseguenti.get(i).toString());
            if (i < conseguenti.size() - 1)
                regola.append(",");
        }


        return "Regola:" +
                "if " + antecedente + " then " + conseguenti + "\n";
    }


    /**
     * Getter
     *
     * @return antecedente
     */
    public List<CostituenteLogico> getAntecedente() {
        return antecedente;
    }

    /**
     * Setter
     *
     * @param antecedente scelto
     */
    public void setAntecedente(List<CostituenteLogico> antecedente) {
        this.antecedente = antecedente;
    }

    /**
     * Getter
     *
     * @return conseguente
     */
    public List<Azione> getConseguenti() {
        return conseguenti;
    }

    /**
     * Setter
     *
     * @param conseguenti scelto
     */
    public void setConseguenti(List<Azione> conseguenti) {
        this.conseguenti = conseguenti;
    }

    /**
     * Getter
     *
     * @return operatoriBooleani
     */
    public List<OperatoriBooleani> getOpBooleani() {
        return opBooleani;
    }

    /**
     * Setter
     *
     * @param opBooleani da modificare
     */
    public void setOpBooleani(List<OperatoriBooleani> opBooleani) {
        this.opBooleani = opBooleani;
    }

    /**
     * Getter
     *
     * @return lo stato della regola
     */
    public boolean isAttiva() {
        return attiva;
    }

    /**
     * Setter
     *
     * @param attiva da modificare
     */
    public void setAttiva(boolean attiva) {
        this.attiva = attiva;
    }
}
