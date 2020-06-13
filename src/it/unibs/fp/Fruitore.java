package it.unibs.fp;

import java.io.Serializable;

public class Fruitore implements Serializable {

    public Fruitore(){

    }

    public String visualizzaDescrizioneCatergorieSensori(ListaCategorie listaCategorie){
        return (listaCategorie.visualizzaCategorieSensori());
    }
    public String visualizzaDescrizioneCatergorieAttuatori(ListaCategorie listaCategorie){
        return (listaCategorie.visualizzaCategorieAttuatori());
    }

    public String visualizzaStanze(UnitaImmobiliare unitaImmobiliare){
        return (unitaImmobiliare.visualizzaStanze());
    }

    public String visualizzaArtefatti(UnitaImmobiliare unitaImmobiliare){
        return (unitaImmobiliare.visualizzaArtefatti());
    }

    public String valoriRilevati(UnitaImmobiliare unitaImmobiliare){
        String s = "";
        for (Stanza stanza :
                unitaImmobiliare.getStanze()) {
            s+=(stanza.getNome());
            for (Sensore sensore :
                    stanza.getSensori()) {
                s+=(sensore.getNome() + " " + sensore.rilevaVariabileFisica());
            }
            for (Artefatto artefatto :
                    stanza.getArtefatti()) {
                s+=(artefatto.getNome());
                for (Sensore sensore :
                        artefatto.getSensori()) {
                    s+=(sensore.getNome() + " " + sensore.rilevaVariabileFisica());
                }
            }
        }
        s+=("---------------------------------------------");
        return s;
    }
}
