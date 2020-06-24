package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class Regola implements Serializable {
    private ArrayList<CostituenteLogico> antecedente;
    private ArrayList<Azione> conseguente;
    private ArrayList<OperatoriBooleani> opBooleani;
    private boolean attiva;


    /**
     * Costruttore regola
     */
    public Regola() {
        this.antecedente = new ArrayList<>();
        this.conseguente = new ArrayList<>();
        this.opBooleani = new ArrayList<>();
        attiva = true;
    }

    /**
     * Inserisci costituente logico scelto
     *
     * @param primoOpLogico   primo operatore logico scelto
     * @param secondoOpLogico secondo operatore logico scelto
     * @param opRelazionale   scelto
     * @param opBooleano      che separa i costituenti logici
     */
    public void inserisciCostituenteLogico(InfoRilevabile primoOpLogico, InfoRilevabile secondoOpLogico, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano) {
        opBooleani.add(opBooleano);
        CostituenteLogico costituenteLogico = new CostituenteLogico(primoOpLogico, secondoOpLogico, opRelazionale);
        antecedente.add(costituenteLogico);
    }

    /**
     * Inserisci il costituente logico
     *
     * @param primoOpLogico   da confrontare
     * @param secondoOpLogico String
     * @param opRelazionale   per il confronto
     * @param opBooleano      per confrontare i costituenti logici
     */
    public void inserisciCostituenteLogico(InfoRilevabile primoOpLogico, String secondoOpLogico, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano) {
        opBooleani.add(opBooleano);
        CostituenteLogico costituenteLogico = new CostituenteLogico(primoOpLogico, secondoOpLogico, opRelazionale);
        antecedente.add(costituenteLogico);

    }

    /**
     * Inserisci il costituente logico
     *
     * @param opRelazionale da confrontare
     * @param opBooleano    per il confronto
     * @param orologio      da confrontare
     */
    public void inserisciCostituenteLogico(OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano, Orologio orologio) {
        opBooleani.add(opBooleano);
        CostituenteLogico costituenteLogico = new CostituenteLogico(orologio, opRelazionale);
        antecedente.add(costituenteLogico);

    }

    /**
     * Inserisci il costituente logico
     *
     * @param primoOpLogico     da confrontare
     * @param secondoOpCostante costante
     * @param opRelazionale     per il confronto
     * @param opBooleano        per confrontare i costituenti logici
     */
    public void inserisciCostituenteLogico(InfoRilevabile primoOpLogico, double secondoOpCostante, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano) {
        opBooleani.add(opBooleano);
        CostituenteLogico costituenteLogico = new CostituenteLogico(primoOpLogico, secondoOpCostante, opRelazionale);
        antecedente.add(costituenteLogico);

    }

    /**
     * Inserisci constituente logico
     *
     * @param primoOpLogico     scelto
     * @param secondoOpCostante String
     * @param opRelazionale     per il confronto
     */
    public void inserisciCostituenteLogico(InfoRilevabile primoOpLogico, String secondoOpCostante, OperatoriRelazionali opRelazionale) {
        CostituenteLogico costituenteLogico = new CostituenteLogico(primoOpLogico, secondoOpCostante, opRelazionale);
        antecedente.add(costituenteLogico);

    }

    /**
     * Inserisci costituente logico
     *
     * @param primoOpLogico   primo operatore logico scelto
     * @param secondoOpLogico secondo operatore logico scelto
     * @param opRelazionale   per il confronto
     */
    public void inserisciCostituenteLogico(InfoRilevabile primoOpLogico, InfoRilevabile secondoOpLogico, OperatoriRelazionali opRelazionale) {
        antecedente.set(0, new CostituenteLogico(primoOpLogico, secondoOpLogico, opRelazionale));
    }

    /**
     * Inserisci il costituente logico
     *
     * @param primoOpLogico     da confrontare
     * @param secondoOpCostante costante
     * @param opRelazionale     per il confronto
     */
    public void inserisciCostituenteLogico(InfoRilevabile primoOpLogico, double secondoOpCostante, OperatoriRelazionali opRelazionale) {
        antecedente.set(0, new CostituenteLogico(primoOpLogico, secondoOpCostante, opRelazionale));
    }

    /**
     * Inserisci il costituente logico
     *
     * @param orologio      da confrontare con l'orario attuale
     * @param opRelazionale per il confronto
     */
    public void inserisciCostituenteLogico(Orologio orologio, OperatoriRelazionali opRelazionale) {
        antecedente.set(0, new CostituenteLogico(orologio, opRelazionale));
    }


    /**
     * Inserisci costituente logico
     */
    public void inserisciCostituenteLogico() {
        CostituenteLogico costituenteLogico = new CostituenteLogico();
        antecedente.add(costituenteLogico);
    }

    /**
     * Inserisci una nuova azione
     *
     * @param attuatore    nel quale inserire un'azione
     * @param modOperativa scelta
     */
    public void inserisciAzione(Attuatore attuatore, ModOperativa modOperativa) {
        Azione azione = new Azione(attuatore, modOperativa);
        conseguente.add(azione);
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
        conseguente.add(azione);
    }

    /**
     * Visualizza la regola con il suo stato
     *
     * @return la regola ed il suo stato
     */
    public String visualizzaStatoRegola() {
        StringBuilder regola = new StringBuilder();
        for (int i = 0; i < antecedente.size(); i++) {
            regola.append(" " + antecedente.get(i).toString());
            if (i % 2 == 0 && opBooleani.get(0) != null)
                regola.append(opBooleani.get(i));
        }

        for (int i = 0; i < conseguente.size(); i++) {
            regola.append(" " + conseguente.get(i).toString());
            if (i < conseguente.size() - 1)
                regola.append(",");
        }

        regola.append("La regola:" +
                "if " + antecedente + " then " + conseguente + " è ");
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

        for (int i = 0; i < conseguente.size(); i++) {
            regola.append(" " + conseguente.get(i).toString());
            if (i < conseguente.size() - 1)
                regola.append(",");
        }


        return "Regola:" +
                "if " + antecedente + " then " + conseguente + "\n";
    }


    /**
     * Getter
     *
     * @return antecedente
     */
    public ArrayList<CostituenteLogico> getAntecedente() {
        return antecedente;
    }

    /**
     * Setter
     *
     * @param antecedente scelto
     */
    public void setAntecedente(ArrayList<CostituenteLogico> antecedente) {
        this.antecedente = antecedente;
    }

    /**
     * Getter
     *
     * @return conseguente
     */
    public ArrayList<Azione> getConseguente() {
        return conseguente;
    }

    /**
     * Setter
     *
     * @param conseguente scelto
     */
    public void setConseguente(ArrayList<Azione> conseguente) {
        this.conseguente = conseguente;
    }

    /**
     * Getter
     *
     * @return operatoriBooleani
     */
    public ArrayList<OperatoriBooleani> getOpBooleani() {
        return opBooleani;
    }

    /**
     * Setter
     *
     * @param opBooleani da modificare
     */
    public void setOpBooleani(ArrayList<OperatoriBooleani> opBooleani) {
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
