package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

//TODO MODIFICARE I TOSTRING E SIMILI
public class Fruitore implements Serializable {
    private ArrayList<UnitaImmobiliare> unitaImmobiliari;

    public Fruitore() {
        unitaImmobiliari = new ArrayList<>();
    }


    public String visualizzaUnitaImmobiliari() {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < unitaImmobiliari.size(); i++)
            tmp.append(i + 1).append(" ").append(unitaImmobiliari.get(i).toString()).append("\n");
        return tmp.toString();
    }

    public void aggiungiUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) {
        unitaImmobiliari.add(unitaImmobiliare);
    }

    //TODO SE ESCE -1 ERROREEEEE
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
    public void associaSensoreAStanze(Sensore sensoreAss, ArrayList<Stanza> stanzeAss, UnitaImmobiliare unitaImmobiliare) {
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
    public void associaAttuatoreAStanze(Attuatore attuatoreAss, ArrayList<Stanza> stanzeAss, UnitaImmobiliare unitaImmobiliare) {
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
    public void associaSensoreAdArtefatti(Sensore sensoreAss, ArrayList<Artefatto> artefattoAss, UnitaImmobiliare unitaImmobiliare) {
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
    public void associaAttuatoreAdArtefatti(Attuatore attuatoreAss, ArrayList<Artefatto> artefattoAss, UnitaImmobiliare unitaImmobiliare) {
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
    public void associaArtefattoAStanze(Artefatto artefatto, ArrayList<Stanza> stanzeAss, UnitaImmobiliare unitaImmobiliare) {
        if (unitaImmobiliari.contains(unitaImmobiliare)) {
            unitaImmobiliari.get(trovaIndiceUnitaImmobiliare(unitaImmobiliare)).associaArtefattoAStanze(artefatto, stanzeAss);
        }
    }

/*
    **
     * Visualizza la descrizione delle stanze dell'unità immobiliare
     *
     * @param unitaImmobiliari scelta
     * @return la descrizione delle stanze
     *
    public String visualizzaStanze(UnitaImmobiliare unitaImmobiliari) {
            return (unitaImmobiliari.visualizzaStanze());
    }

    **
     * Visualizza la descrizione degli artefatti dell'unità immobiliare
     *
     * @param unitaImmobiliare scelta
     * @return la descrizione degli artefatti
     *
    public String visualizzaArtefatti(UnitaImmobiliare unitaImmobiliare) {
        return (unitaImmobiliare.visualizzaArtefatti());
    }
    */

    public ArrayList<UnitaImmobiliare> getUnitaImmobiliari() {
        return unitaImmobiliari;
    }

    public void setUnitaImmobiliari(ArrayList<UnitaImmobiliare> unitaImmobiliari) {
        this.unitaImmobiliari = unitaImmobiliari;
    }


    //TODO CAMBIATO TUTTO QUELLO SOPRA!!!!

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
        StringBuilder s = new StringBuilder();
        for (Stanza stanza :
                unitaImmobiliare.getStanze()) {
            s.append(stanza.getNome());
            for (Sensore sensore :
                    stanza.getSensori()) {
                s.append(sensore.getNome()).append(" ").append(sensore.rilevaVariabileFisica());
            }
            for (Artefatto artefatto :
                    stanza.getArtefatti()) {
                s.append(artefatto.getNome());
                for (Sensore sensore :
                        artefatto.getSensori()) {
                    s.append(sensore.getNome()).append(" ").append(sensore.rilevaVariabileFisica());
                }
            }
        }
        s.append("---------------------------------------------");
        return s.toString();
    }
}
