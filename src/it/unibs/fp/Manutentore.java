package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class Manutentore implements Serializable {
    private ListaCategorie listaCategorie;

    public Manutentore() {
        listaCategorie = new ListaCategorie();
    }

    public void inserisciESalvaCategoriaAttuatori(CategoriaAttuatori categoriaAttuatori) {
        boolean found = false;
        for (int i = 0; i < listaCategorie.getSizeCategorieAttuatori(); i++) {
            if (!listaCategorie.getCategorieAttuatori().get(i).getNome().equals(categoriaAttuatori.getNome()))
                found = true;
        }
        if (!found)
        listaCategorie.inserisciESalvaCategoriaAttuatori(categoriaAttuatori);
    }

    public void inserisciESalvaCategoriaSensori(CategoriaSensori categoriaSensori) {
        boolean found = false;
        for (int i = 0; i < listaCategorie.getSizeCategorieSensori(); i++) {
            if (listaCategorie.getCategorieSensori().get(i).getNome().equals(categoriaSensori.getNome()))
                found = true;
        }
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

    public ListaCategorie getListaCategorie() {
        return listaCategorie;
    }

    public String visualizzaCategorieSensori() {
        return listaCategorie.visualizzaCategorieSensori();
    }

    public String visualizzaCategorieAttuatori() {
        return listaCategorie.visualizzaCategorieAttuatori();
    }

    public String visualizzaDescrizioneCatergorie() {
        return null;
    }

    public String visualizzaDescrizioneStanze(UnitaImmobiliare unitaImmobiliare) {
        return unitaImmobiliare.visualizzaStanze();
    }

    @Override
    public String toString() {
        return "Manutentore{" +
                "listaCategorie=" + listaCategorie +
                '}';
    }

}
