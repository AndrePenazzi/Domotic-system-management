package it.unibs.fp.regola;

import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.operatori.OperatoriBooleani;
import it.unibs.fp.operatori.OperatoriRelazionali;

public class AntecedenteSingolo extends Antecedente {

    public AntecedenteSingolo(CostituenteLogico costituenteLogico) {
        setCostituenteLogico(costituenteLogico);
        setOpBooleano(null);
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
        costituentiLogici.add(costituenteLogico);
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
        costituentiLogici.add(costituenteLogico);

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
        costituentiLogici.add(costituenteLogico);

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
        costituentiLogici.add(costituenteLogico);

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
        costituentiLogici.add(costituenteLogico);

    }

    /**
     * Inserisci costituente logico
     *
     * @param primoOpLogico   primo operatore logico scelto
     * @param secondoOpLogico secondo operatore logico scelto
     * @param opRelazionale   per il confronto
     */
    public void inserisciCostituenteLogico(InfoRilevabile primoOpLogico, InfoRilevabile secondoOpLogico, OperatoriRelazionali opRelazionale) {
        costituentiLogici.set(0, new CostituenteLogico(primoOpLogico, secondoOpLogico, opRelazionale));
    }

    /**
     * Inserisci il costituente logico
     *
     * @param primoOpLogico     da confrontare
     * @param secondoOpCostante costante
     * @param opRelazionale     per il confronto
     */
    public void inserisciCostituenteLogico(InfoRilevabile primoOpLogico, double secondoOpCostante, OperatoriRelazionali opRelazionale) {
        costituentiLogici.set(0, new CostituenteLogico(primoOpLogico, secondoOpCostante, opRelazionale));
    }

    /**
     * Inserisci il costituente logico
     *
     * @param orologio      da confrontare con l'orario attuale
     * @param opRelazionale per il confronto
     */
    public void inserisciCostituenteLogico(Orologio orologio, OperatoriRelazionali opRelazionale) {
        costituentiLogici.set(0, new CostituenteLogico(orologio, opRelazionale));
    }


    /**
     * Inserisci costituente logico
     */
    public void inserisciCostituenteLogico() {
        CostituenteLogico costituenteLogico = new CostituenteLogico();
        costituentiLogici.add(costituenteLogico);
    }


}
