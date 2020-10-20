package it.unibs.fp.model.regola;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import it.unibs.fp.model.regola.antecedente.Antecedenti;
import it.unibs.fp.model.regola.conseguente.Conseguenti;
import it.unibs.fp.model.regola.conseguente.azione.Azione;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Regola implements Serializable {
    private Antecedenti antecedenti;
    private Conseguenti conseguenti;
    private boolean attiva;


    /**
     * Costruttore regola
     */
    public Regola() {
        this.antecedenti = new Antecedenti();
        this.conseguenti = new Conseguenti();
        attiva = true;
    }

    public void inserisciConseguenti(Conseguenti conseguenti) {
        this.conseguenti.setConseguenti(conseguenti.getConseguenti());
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

    public void inserisciAntecedenti(Antecedenti antecedenti) {
        this.antecedenti.setAntecendenti(antecedenti.getAntecendenti());
    }

    /**
     * Visualizza la regola con il suo stato
     *
     * @return la regola ed il suo stato
     */
    public String visualizzaStatoRegola() {
        StringBuilder regola = new StringBuilder();
        for (int i = 0; i < antecedenti.getAntecendenti().size(); i++) {
            regola.append(" " + antecedenti.getAntecendenti().get(i).toString());
        }

        for (int i = 0; i < conseguenti.size(); i++) {
            regola.append(" " + conseguenti.get(i).toString());
            if (i < conseguenti.size() - 1)
                regola.append(",");
        }

        regola.append("La regola:" +
                "if " + antecedenti.toString() + " then " + conseguenti + " è ");//era antecedente non funzionerà
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
        for (int i = 0; i < antecedenti.getAntecendenti().size(); i++) {
            regola.append(" " + antecedenti.getAntecendenti().get(i).toString());
        }

        for (int i = 0; i < conseguenti.size(); i++) {
            regola.append(" " + conseguenti.get(i).toString());
            if (i < conseguenti.size() - 1)
                regola.append(",");
        }


        return "Regola:" +
                "if " + antecedenti.toString() + " then " + conseguenti + "\n";//era antecedente non funzionerà
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
