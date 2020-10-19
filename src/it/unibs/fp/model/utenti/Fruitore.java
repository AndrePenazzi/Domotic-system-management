package it.unibs.fp.model.utenti;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import it.unibs.fp.model.operatori.OperatoriBooleani;
import it.unibs.fp.model.operatori.OperatoriRelazionali;
import it.unibs.fp.model.regola.Orologio;
import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.model.unitaImmobiliare.Stanza;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Fruitore implements Serializable {
    private List<UnitaImmobiliare> unitaImmobiliari;

    /**
     * Costruttore fruitore
     */
    public Fruitore() {
        unitaImmobiliari = new ArrayList<>();
    }

    /**
     * Inserisci la regola per la prima volta
     *
     * @param unitaImmobiliareIndex indice dell'unità immobiliare scelta
     * @param attuatore        per settare la sua modalità operativa
     * @param modOperativa     scelta
     */
    public void inserisciRegola(int unitaImmobiliareIndex, Attuatore attuatore, ModOperativa modOperativa) {
        unitaImmobiliari.get(unitaImmobiliareIndex).inserisciRegola(attuatore, modOperativa);
    }

    /**
     * Inserisci la regola per la prima volta con strat
     *
     * @param unitaImmobiliare scelta
     * @param attuatore        per settare la sua modalità operativa
     * @param modOperativa     scelta
     * @param start            ora di assegnameto
     */
    public void inserisciRegola(UnitaImmobiliare unitaImmobiliare, Attuatore attuatore, ModOperativa modOperativa, Orologio start) {
        unitaImmobiliare.inserisciRegola(attuatore, modOperativa, start);
    }

    /**
     * Inserisci la regola per la prima volta
     *
     * @param unitaImmobiliare scelta
     * @param regola           scelta
     * @param attuatore        per settare la sua modalità operativa
     * @param modOperativa     scelta
     */
    public void aggiungiAzione(UnitaImmobiliare unitaImmobiliare, Regola regola, Attuatore attuatore, ModOperativa modOperativa) {
        unitaImmobiliare.aggiungiAzione(regola, attuatore, modOperativa);
    }


    /**
     * Inserisci il primo costituente logico
     *
     * @param unitaImmobiliare scelta
     * @param regola           scelta
     * @param primoOpLogico    primo operatore da confrontare
     * @param secondoOpLogico  info rilevabile
     * @param opRelazionale    operatore relazionale per il confronto
     */
    public void aggiungiPrimoCosituenteLogicoARegola(UnitaImmobiliare unitaImmobiliare, Regola regola, InfoRilevabile primoOpLogico, InfoRilevabile secondoOpLogico, OperatoriRelazionali opRelazionale) {
        unitaImmobiliare.aggiungiPrimoCosituenteLogicoARegola(regola, primoOpLogico, secondoOpLogico, opRelazionale);
    }

    /**
     * Aggiungi primo costituente logico a regola
     *
     * @param unitaImmobiliare scelta
     * @param regola           scelta
     * @param primoOpLogico    scelto
     * @param secondoOpLogico  double
     * @param opRelazionale    per il confronto
     */
    public void aggiungiPrimoCosituenteLogicoARegola(UnitaImmobiliare unitaImmobiliare, Regola regola, InfoRilevabile primoOpLogico, double secondoOpLogico, OperatoriRelazionali opRelazionale) {
        unitaImmobiliare.aggiungiPrimoCosituenteLogicoARegola(regola, primoOpLogico, secondoOpLogico, opRelazionale);
    }

    /**
     * Aggiungi primo costituente logico a regola
     *
     * @param unitaImmobiliare scelta
     * @param regola           scelta
     * @param primoOpLogico    scelto
     * @param secondoOpLogico  String
     * @param opRelazionale    per il confronto
     */
    public void aggiungiPrimoCosituenteLogicoARegola(UnitaImmobiliare unitaImmobiliare, Regola regola, InfoRilevabile primoOpLogico, String secondoOpLogico, OperatoriRelazionali opRelazionale) {
        unitaImmobiliare.aggiungiPrimoCosituenteLogicoARegola(regola, primoOpLogico, secondoOpLogico, opRelazionale);
    }

    /**
     * Aggiungi primo costituente logico a regola con orologio
     *
     * @param unitaImmobiliare scelta
     * @param regola           scelta
     * @param opRelazionale    per il confronto
     * @param orologio         da confrontare
     */
    public void aggiungiPrimoCosituenteLogicoARegola(UnitaImmobiliare unitaImmobiliare, Regola regola, OperatoriRelazionali opRelazionale, Orologio orologio) {
        unitaImmobiliare.aggiungiPrimoCosituenteLogicoARegola(regola, orologio, opRelazionale);
    }

    /**
     * Inserisci l'ennesimo costituente logico
     *
     * @param unitaImmobiliare scelta
     * @param regola           scelta
     * @param primoOpLogico    primo operatore da confrontare
     * @param secondoOpLogico  info rilevabile
     * @param opRelazionale    per il confronto
     * @param opBooleano       per confrontare i costituenti logici
     */
    public void aggiungiEnnesimoCosituenteLogicoARegola(UnitaImmobiliare unitaImmobiliare, Regola regola, InfoRilevabile primoOpLogico, InfoRilevabile secondoOpLogico, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano) {
        unitaImmobiliare.aggiungiEnnesimoCosituenteLogicoARegola(regola, primoOpLogico, secondoOpLogico, opRelazionale, opBooleano);
    }

    /**
     * Inserisci l'ennesimo costituente logico con orologio
     *
     * @param unitaImmobiliare scelta
     * @param regola           scelta
     * @param opRelazionale    per il confronto
     * @param opBooleano       per confrontare i costituenti logici
     * @param orologio         da confrontare
     */
    public void aggiungiEnnesimoCosituenteLogicoARegola(UnitaImmobiliare unitaImmobiliare, Regola regola, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano, Orologio orologio) {
        unitaImmobiliare.aggiungiEnnesimoCosituenteLogicoARegola(regola, opRelazionale, opBooleano, orologio);
    }

    /**
     * Aggiungi ennesimo costituente logico a regola
     *
     * @param unitaImmobiliare scelta
     * @param regola           scelta
     * @param primoOpLogico    scelto
     * @param secondoOpLogico  double
     * @param opRelazionale    per il confronto
     * @param opBooleano       per il confronto tra costituenti
     */
    public void aggiungiEnnesimoCosituenteLogicoARegola(UnitaImmobiliare unitaImmobiliare, Regola regola, InfoRilevabile primoOpLogico, double secondoOpLogico, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano) {
        unitaImmobiliare.aggiungiEnnesimoCosituenteLogicoARegola(regola, primoOpLogico, secondoOpLogico, opRelazionale, opBooleano);
    }

    /**
     * Aggiungi ennesimo costituente logico a regola
     *
     * @param unitaImmobiliare scelta
     * @param regola           scelta
     * @param primoOpLogico    scelto
     * @param secondoOpLogico  String
     * @param opRelazionale    per il confronto
     * @param opBooleano       per il confronto tra costituenti
     */
    public void aggiungiEnnesimoCosituenteLogicoARegola(UnitaImmobiliare unitaImmobiliare, Regola regola, InfoRilevabile primoOpLogico, String secondoOpLogico, OperatoriRelazionali opRelazionale, OperatoriBooleani opBooleano) {
        unitaImmobiliare.aggiungiEnnesimoCosituenteLogicoARegola(regola, primoOpLogico, secondoOpLogico, opRelazionale, opBooleano);
    }

    /**
     * Aggiungere un unità immobiliare per il fruitore
     *
     * @param unitaImmobiliare scelta per essere inserita
     */
    public void aggiungiUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) {
        unitaImmobiliari.add(unitaImmobiliare);
    }

    /**
     * Trova l'indice dell'unità immobiliare cercata
     *
     * @param unitaImmobiliare scelta
     * @return indice unità immobiliare
     */
    public int trovaIndiceUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) {
        for (int i = 0; i < unitaImmobiliari.size(); i++) {
            if (unitaImmobiliari.get(i).equals(unitaImmobiliare))
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
        if (unitaImmobiliari.contains(unitaImmobiliare)) {
            unitaImmobiliari.get(trovaIndiceUnitaImmobiliare(unitaImmobiliare)).inserisciStanza(stanza);
        }
    }

    /**
     * Inserisci un nuova artefatto nell'unità immobiliare
     *
     * @param artefatto        nuovo da aggiungere
     * @param unitaImmobiliare esistente
     */
    public void inserisciArtefatto(Artefatto artefatto, UnitaImmobiliare unitaImmobiliare) {
        if (unitaImmobiliari.contains(unitaImmobiliare)) {
            unitaImmobiliari.get(trovaIndiceUnitaImmobiliare(unitaImmobiliare)).inserisciArtefatto(artefatto);
        }
    }

    /**
     * Associa un sensore ad una certa quantità di stanze
     *
     * @param sensoreAss       da associare alle stanze
     * @param stanzeAss        stanze scelte
     * @param unitaImmobiliare che contiene le stanze
     */
    public void associaSensoreAStanze(Sensore sensoreAss, List<Stanza> stanzeAss, UnitaImmobiliare unitaImmobiliare) {
        if (unitaImmobiliari.contains(unitaImmobiliare)) {
            unitaImmobiliari.get(trovaIndiceUnitaImmobiliare(unitaImmobiliare)).associaSensoreAStanze(sensoreAss, stanzeAss);
        }
    }

    /**
     * Associa un attuatore ad una certa quantità di stanze
     *
     * @param attuatoreAss     da associare alle stanze
     * @param stanzeAss        stanze scelte
     * @param unitaImmobiliare che contiene le stanze
     */
    public void associaAttuatoreAStanze(Attuatore attuatoreAss, List<Stanza> stanzeAss, UnitaImmobiliare unitaImmobiliare) {
        if (unitaImmobiliari.contains(unitaImmobiliare)) {
            unitaImmobiliari.get(trovaIndiceUnitaImmobiliare(unitaImmobiliare)).associaAttuatoreAStanze(attuatoreAss, stanzeAss);
        }
    }

    /**
     * Associa un sensore ad una certa quantità di artefatti
     *
     * @param sensoreAss       da associare agli artefatti
     * @param artefattoAss     artefatti scelti
     * @param unitaImmobiliare che contiene gli artefatti
     */
    public void associaSensoreAdArtefatti(Sensore sensoreAss, List<Artefatto> artefattoAss, UnitaImmobiliare unitaImmobiliare) {
        if (unitaImmobiliari.contains(unitaImmobiliare)) {
            unitaImmobiliari.get(trovaIndiceUnitaImmobiliare(unitaImmobiliare)).associaSensoreAdArtefatti(sensoreAss, artefattoAss);
        }
    }

    /**
     * Associa un attuatore ad una certa quantità di artefatti
     *
     * @param attuatoreAss     da associare agli artefatti
     * @param artefattoAss     artefatti scelti
     * @param unitaImmobiliare che contiene gli artefatti
     */
    public void associaAttuatoreAdArtefatti(Attuatore attuatoreAss, List<Artefatto> artefattoAss, UnitaImmobiliare unitaImmobiliare) {
        if (unitaImmobiliari.contains(unitaImmobiliare)) {
            unitaImmobiliari.get(trovaIndiceUnitaImmobiliare(unitaImmobiliare)).associaAttuatoreAdArtefatti(attuatoreAss, artefattoAss);
        }
    }

    /**
     * Associa artefatto a stanze
     *
     * @param artefatto        da associare alle stanze
     * @param stanzeAss        stanze scelte
     * @param unitaImmobiliare che contiene gli artefatti
     */
    public void associaArtefattoAStanze(Artefatto artefatto, List<Stanza> stanzeAss, UnitaImmobiliare unitaImmobiliare) {
        if (unitaImmobiliari.contains(unitaImmobiliare)) {
            unitaImmobiliari.get(trovaIndiceUnitaImmobiliare(unitaImmobiliare)).associaArtefattoAStanze(artefatto, stanzeAss);
        }
    }

    /**
     * Lista delle unità immobilari e loro caratteristiche
     *
     * @return lista unità immobilari
     */
    public String visualizzaUnitaImmobiliari() {
        StringBuilder tmp = new StringBuilder();
        if (!unitaImmobiliari.isEmpty()) {
            int i = 1;
            for (UnitaImmobiliare unitaImmobiliare : unitaImmobiliari) {
                tmp.append(i + " " + unitaImmobiliare.getNome()).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora unità immobiliare che si possiedono");
        return tmp.toString();
    }

    /**
     * Lista delle unità immobilari con solo i nomi
     *
     * @return lista unità immobilari
     */
    public String visualizzaListaUnitaImmobiliari() {
        StringBuilder tmp = new StringBuilder();
        if (!unitaImmobiliari.isEmpty()) {
            int i = 1;
            for (UnitaImmobiliare unitaImmobiliare : unitaImmobiliari) {
                tmp.append("\n");
                tmp.append(i + " " + unitaImmobiliare.getNome());
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora unità immobiliare che si possiedono");
        return tmp.toString();
    }

    /**
     * Visualizza la descrizione delle categorie sensori
     *
     * @param listaCategorie scelta
     * @return la descrizione delle categorie sensori
     */
    public String visualizzaDescrizioneCatergorieSensori(ListaCategorie listaCategorie) {
        return (listaCategorie.visualizzaCategorieSensori());
    }

    /**
     * Visualizza la descrizione delle categorie attuatori
     *
     * @param listaCategorie scelta
     * @return la descrizione delle categorie attuatori
     */
    public String visualizzaDescrizioneCatergorieAttuatori(ListaCategorie listaCategorie) {
        return (listaCategorie.visualizzaCategorieAttuatori());
    }

    /**
     * Visualizza la descrizione delle stanze dell'unità immobiliare
     *
     * @param unitaImmobiliare scelta
     * @return la descrizione delle stanze
     */
    public String visualizzaStanze(UnitaImmobiliare unitaImmobiliare) {
        String tmp = "";
        if (unitaImmobiliari.contains(unitaImmobiliare)) {
            tmp = unitaImmobiliari.get(trovaIndiceUnitaImmobiliare(unitaImmobiliare)).visualizzaStanze();
        }
        return tmp;
    }

    /**
     * Visualizza la descrizione degli artefatti dell'unità immobiliare
     *
     * @param unitaImmobiliare scelta
     * @return la descrizione degli artefatti
     */
    public String visualizzaArtefatti(UnitaImmobiliare unitaImmobiliare) {
        String tmp = "";
        if (unitaImmobiliari.contains(unitaImmobiliare)) {
            tmp = unitaImmobiliari.get(trovaIndiceUnitaImmobiliare(unitaImmobiliare)).visualizzaArtefatti();
        }
        return tmp;
    }

    /**
     * Visualizza i valori rilevati dai sensori
     *
     * @param unitaImmobiliare scelta
     * @return i valori rilevati
     */
    public String valoriRilevati(UnitaImmobiliare unitaImmobiliare) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n");
        if (!unitaImmobiliare.getStanze().isEmpty())
            for (Stanza stanza :
                    unitaImmobiliare.getStanze()) {
                tmp.append("\n");
                tmp.append(stanza.getNome());
                if (!stanza.getSensori().isEmpty())
                    for (Sensore sensore :
                            stanza.getSensori()) {
                        tmp.append("\n" + sensore.getNome()).append(" ").append(sensore.rilevaVariabileFisica());
                    }
                else tmp.append("\nNon ci sono sensori nella stanza");
                if (!stanza.getArtefatti().isEmpty())
                    for (Artefatto artefatto :
                            stanza.getArtefatti()) {
                        tmp.append("\n" + artefatto.getNome());
                        if (!artefatto.getSensori().isEmpty())
                            for (Sensore sensore :
                                    artefatto.getSensori()) {
                                tmp.append("\n" + sensore.getNome()).append(" ").append(sensore.rilevaVariabileFisica());
                            }
                        else tmp.append("\nNon ci sono sensori nell'artefatto");
                    }
                else tmp.append("\nNon ci sono artefatti nella stanza");
            }
        else tmp.append("\nNon ci sono stanze nella unità immobiliare");
        return tmp.toString();
    }

    /**
     * Getter delle unità immobiliari del fruitore
     *
     * @return le varie unità immobiliari
     */
    public List<UnitaImmobiliare> getUnitaImmobiliari() {
        return unitaImmobiliari;
    }

    /**
     * Setter
     *
     * @param unitaImmobiliari da modificare
     */
    public void setUnitaImmobiliari(List<UnitaImmobiliare> unitaImmobiliari) {
        this.unitaImmobiliari = unitaImmobiliari;
    }

}