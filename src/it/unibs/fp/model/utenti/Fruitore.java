package it.unibs.fp.model.utenti;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.unitaImmobiliare.*;

import java.io.Serializable;


public class Fruitore implements Serializable {
    private UnitaImmobiliari unitaImmobiliari;
    private String nome;

    /**
     * Costruttore fruitore
     */
    public Fruitore(String nome) {
        unitaImmobiliari = new UnitaImmobiliari();
        this.nome=nome;
    }

    public void inserisciRegola(int unitaImmobiliareIndex, Regola regola) {
        unitaImmobiliari.getUnitaImmobiliari().get(unitaImmobiliareIndex).inserisciRegola(regola);
    }


    public void inserisciRegola(UnitaImmobiliare unitaImmobiliare, Regola regola) {
        unitaImmobiliare.inserisciRegola(regola);
    }

    /**
     * Aggiungere un unità immobiliare per il fruitore
     *
     * @param unitaImmobiliare scelta per essere inserita
     */
    public void aggiungiUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) {
        unitaImmobiliari.inserisciUnitaImmobiliare(unitaImmobiliare);
    }

    /**
     * Trova l'indice dell'unità immobiliare cercata
     *
     * @param unitaImmobiliare scelta
     * @return indice unità immobiliare
     */
    public int trovaIndiceUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) {
        for (int i = 0; i < unitaImmobiliari.getUnitaImmobiliari().size(); i++) {
            if (unitaImmobiliari.getUnitaImmobiliari().get(i).equals(unitaImmobiliare))
                return i;
        }
        return -1;
    }

    /**
     * Inserisci una nuova stanza nell'unità immobiliare
     *
     * @param stanza           nuova da aggiungere
     * @param unitaImmobiliare esistente
     */
    public void inserisciStanza(Stanza stanza, UnitaImmobiliare unitaImmobiliare) {
        if (unitaImmobiliari.getUnitaImmobiliari().contains(unitaImmobiliare)) {
            unitaImmobiliari.getUnitaImmobiliari().get(trovaIndiceUnitaImmobiliare(unitaImmobiliare)).inserisciStanza(stanza);
        }
    }

    /**
     * Inserisci un nuova artefatto nell'unità immobiliare
     *
     * @param artefatto        nuovo da aggiungere
     * @param unitaImmobiliare esistente
     */
    public void inserisciArtefatto(Artefatto artefatto, UnitaImmobiliare unitaImmobiliare) {
        if (unitaImmobiliari.getUnitaImmobiliari().contains(unitaImmobiliare)) {
            unitaImmobiliari.getUnitaImmobiliari().get(trovaIndiceUnitaImmobiliare(unitaImmobiliare)).inserisciArtefatto(artefatto);
        }
    }

    /**
     * Associa un sensore ad una certa quantità di stanze
     *
     * @param sensoreAss       da associare alle stanze
     * @param stanzeAss        stanze scelte
     * @param unitaImmobiliare che contiene le stanze
     */
    public void associaSensoreAStanze(Sensore sensoreAss, Stanze stanzeAss, UnitaImmobiliare unitaImmobiliare) {
        if (unitaImmobiliari.getUnitaImmobiliari().contains(unitaImmobiliare)) {
            unitaImmobiliari.getUnitaImmobiliari().get(trovaIndiceUnitaImmobiliare(unitaImmobiliare)).associaSensoreAStanze(sensoreAss, stanzeAss);
        }
    }

    /**
     * Associa un attuatore ad una certa quantità di stanze
     *
     * @param attuatoreAss     da associare alle stanze
     * @param stanzeAss        stanze scelte
     * @param unitaImmobiliare che contiene le stanze
     */
    public void associaAttuatoreAStanze(Attuatore attuatoreAss, Stanze stanzeAss, UnitaImmobiliare unitaImmobiliare) {
        if (unitaImmobiliari.getUnitaImmobiliari().contains(unitaImmobiliare)) {
            unitaImmobiliari.getUnitaImmobiliari().get(trovaIndiceUnitaImmobiliare(unitaImmobiliare)).associaAttuatoreAStanze(attuatoreAss, stanzeAss);
        }
    }

    /**
     * Associa un sensore ad una certa quantità di artefatti
     *
     * @param sensoreAss       da associare agli artefatti
     * @param artefattoAss     artefatti scelti
     * @param unitaImmobiliare che contiene gli artefatti
     */
    public void associaSensoreAdArtefatti(Sensore sensoreAss, Artefatti artefattoAss, UnitaImmobiliare unitaImmobiliare) {
        if (unitaImmobiliari.getUnitaImmobiliari().contains(unitaImmobiliare)) {
            unitaImmobiliari.getUnitaImmobiliari().get(trovaIndiceUnitaImmobiliare(unitaImmobiliare)).associaSensoreAdArtefatti(sensoreAss, artefattoAss);
        }
    }

    /**
     * Associa un attuatore ad una certa quantità di artefatti
     *
     * @param attuatoreAss     da associare agli artefatti
     * @param artefattoAss     artefatti scelti
     * @param unitaImmobiliare che contiene gli artefatti
     */
    public void associaAttuatoreAdArtefatti(Attuatore attuatoreAss,Artefatti artefattoAss, UnitaImmobiliare unitaImmobiliare) {
        if (unitaImmobiliari.getUnitaImmobiliari().contains(unitaImmobiliare)) {
            unitaImmobiliari.getUnitaImmobiliari().get(trovaIndiceUnitaImmobiliare(unitaImmobiliare)).associaAttuatoreAdArtefatti(attuatoreAss, artefattoAss);
        }
    }

    /**
     * Associa artefatto a stanze
     *
     * @param artefatto        da associare alle stanze
     * @param stanzeAss        stanze scelte
     * @param unitaImmobiliare che contiene gli artefatti
     */
    public void associaArtefattoAStanze(Artefatto artefatto, Stanze stanzeAss, UnitaImmobiliare unitaImmobiliare) {
        if (unitaImmobiliari.getUnitaImmobiliari().contains(unitaImmobiliare)) {
            unitaImmobiliari.getUnitaImmobiliari().get(trovaIndiceUnitaImmobiliare(unitaImmobiliare)).associaArtefattoAStanze(artefatto, stanzeAss);
        }
    }



    /**
     * Getter delle unità immobiliari del fruitore
     *
     * @return le varie unità immobiliari
     */
    public UnitaImmobiliari getUnitaImmobiliariInFruitore() {
        return unitaImmobiliari;
    }
    
    public int getSizeUnitaImmobiliariInFruitore() {
        return unitaImmobiliari.getSizeUnitaImmobiliari();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Setter
     *
     * @param unitaImmobiliari da modificare
     */
    public void setUnitaImmobiliari(UnitaImmobiliari unitaImmobiliari) {
        this.unitaImmobiliari = unitaImmobiliari;
    }

}