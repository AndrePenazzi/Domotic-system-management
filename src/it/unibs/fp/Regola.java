package it.unibs.fp;

import it.unibs.fp.mylib.OperatoriBooleani;

import java.util.ArrayList;

public class Regola {
    private ArrayList<CostituenteLogico> antecedente;
    private ArrayList<Azione> conseguente;
    private ArrayList<OperatoriBooleani> opBooleani;

    /**
     * Costruttore regola
     */
    public Regola() {
        this.antecedente = new ArrayList<>();
        this.conseguente = new ArrayList<>();
        this.opBooleani = new ArrayList<>();
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
     * Inserisci costituente logico
     *
     * @param primoOpLogico   primo operatore logico scelto
     * @param secondoOpLogico secondo operatore logico scelto
     * @param opRelazionale   scelto
     */
    public void inserisciCostituenteLogico(InfoRilevabile primoOpLogico, InfoRilevabile secondoOpLogico, OperatoriRelazionali opRelazionale) {
        antecedente.set(0, new CostituenteLogico(primoOpLogico, secondoOpLogico, opRelazionale));
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
     * To String
     *
     * @return descrizione
     */
    @Override//TODO I FOR PER ANTECEDENTE E CONSEGUENTE
    public String toString() {
        return "Regola:" +
                "if " + antecedente + " else " + conseguente;
    }
}
