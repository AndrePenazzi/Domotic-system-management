package it.unibs.fp.model.utenti;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.model.unitaImmobiliare.Stanza;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.ClasseDiServizio;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioListaCategorie;

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

    public void inserisciRegola(int unitaImmobiliareIndex, Regola regola) {
        unitaImmobiliari.get(unitaImmobiliareIndex).inserisciRegola(regola);
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
        return ClasseDiServizioListaCategorie.visualizzaCategorieSensori(listaCategorie);
    }

    /**
     * Visualizza la descrizione delle categorie attuatori
     *
     * @param listaCategorie scelta
     * @return la descrizione delle categorie attuatori
     */
    public String visualizzaDescrizioneCatergorieAttuatori(ListaCategorie listaCategorie) {
        return ClasseDiServizioListaCategorie.visualizzaCategorieAttuatori(listaCategorie);
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