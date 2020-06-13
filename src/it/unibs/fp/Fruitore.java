package it.unibs.fp;

import java.io.Serializable;

public class Fruitore implements Serializable {

    public Fruitore() {

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
        return (unitaImmobiliare.visualizzaStanze());
    }

    /**
     * Visualizza la descrizione degli artefatti dell'unità immobiliare
     *
     * @param unitaImmobiliare scelta
     * @return la descrizione degli artefatti
     */
    public String visualizzaArtefatti(UnitaImmobiliare unitaImmobiliare) {
        return (unitaImmobiliare.visualizzaArtefatti());
    }

    /**
     * Visualizza i valori rilevati dai sensori
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
