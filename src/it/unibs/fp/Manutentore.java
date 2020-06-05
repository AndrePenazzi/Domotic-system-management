package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class Manutentore implements Serializable {

    public Manutentore() {
    }

    public void inserisciESalvaCategoriaAttuatori(ListaCategorie listaCategorie, CategoriaAttuatori categoriaAttuatori) {
        boolean found = false;
        for(CategoriaAttuatori c:listaCategorie.getCategorieAttuatori())
            if(c.equals(categoriaAttuatori.getNome()))
                found = true;

        if (!found)
            listaCategorie.inserisciESalvaCategoriaAttuatori(categoriaAttuatori);
    }

    public void inserisciESalvaCategoriaSensori(ListaCategorie listaCategorie, CategoriaSensori categoriaSensori) {
        boolean found = false;
        for(CategoriaSensori s: listaCategorie.getCategorieSensori())
            if(s.equals(categoriaSensori.getNome()))
                found = true;
        if (!found)
            listaCategorie.inserisciESalvaCategoriaSensori(categoriaSensori);
    }

    public void inserisciStanza(Stanza stanza, UnitaImmobiliare unitaImmobiliare) {
        unitaImmobiliare.inserisciStanza(stanza);
    }

    public void inserisciArtefatto(Artefatto artefatto, UnitaImmobiliare unitaImmobiliare) {
        unitaImmobiliare.inserisciArtefatto(artefatto);
    }

    public void associaSensoreAStanze(Sensore sensoreAss, ArrayList<Stanza> stanzeAss, UnitaImmobiliare unitaImmobiliare) {
        unitaImmobiliare.associaSensoreAStanze(sensoreAss, stanzeAss);
    }

    public void associaAttuatoreAStanze(Attuatore attuatoreAss, ArrayList<Stanza> stanzeAss, UnitaImmobiliare unitaImmobiliare) {
        unitaImmobiliare.associaAttuatoreAStanze(attuatoreAss, stanzeAss);
    }

    public void associaSensoreAdArtefatti(Sensore sensoreAss, ArrayList<Artefatto> artefattoAss, UnitaImmobiliare unitaImmobiliare) {
        unitaImmobiliare.associaSensoreAdArtefatti(sensoreAss, artefattoAss);
    }


    public void associaAttuatoreAdArtefatti(Attuatore attuatoreAss, ArrayList<Artefatto> artefattoAss, UnitaImmobiliare unitaImmobiliare) {
        unitaImmobiliare.associaAttuatoreAdArtefatti(attuatoreAss, artefattoAss);
    }

    public String visualizzaDescrizioneCatergorie() {
        return null;
    }

    public String visualizzaDescrizioneStanze(UnitaImmobiliare unitaImmobiliare) {
        return unitaImmobiliare.visualizzaStanze();
    }

}
