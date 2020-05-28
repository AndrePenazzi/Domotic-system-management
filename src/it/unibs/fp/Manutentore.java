package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class Manutentore implements Serializable {
    private ListaCategorie listaCategorie;
    public Manutentore() {
        listaCategorie = new ListaCategorie();
    }

    public void inserisciESalvaCategoriaAttuatori(CategoriaAttuatori categoriaAttuatori) {
        for (int i = 0; i < listaCategorie.getSizeCategorieSensori(); i++) {
            if (!listaCategorie.getCategorieAttuatori().contains(categoriaAttuatori))
                listaCategorie.inserisciESalvaCategoriaAttuatori(categoriaAttuatori);
        }
    }

    public void inserisciESalvaCategoriaSensori(CategoriaSensori categoriaSensori) {
        for (int i = 0; i < listaCategorie.getSizeCategorieSensori(); i++) {
            if (!listaCategorie.getCategorieSensori().contains(categoriaSensori))
                listaCategorie.inserisciESalvaCategoriaSensori(categoriaSensori);
        }
    }

    public void inserisciStanza(Stanza stanza, UnitaImmobiliare unitaImmobiliare){
        unitaImmobiliare.inserisciStanza(stanza);
    }

    public void inserisciArtefatto(Artefatto artefatto, UnitaImmobiliare unitaImmobiliare){
        unitaImmobiliare.inserisciArtefatto(artefatto);
    }

    public void inserisciAttuatore(Attuatore attuatore, UnitaImmobiliare unitaImmobiliare){

    }

    public void associaSensoreAStanze(Sensore sensoreAss, ArrayList<Stanza> stanzeAss){

    }

    public void associaAttuatoreAStanze(Attuatore attuatoreAss,ArrayList<Stanza> stanzeAss){

    }

    public void associaSensoreAdArtefatti(Sensore sensoreAss,ArrayList<Artefatto> artefattoAss){

    }

    @Override
    public String toString() {
        return "Manutentore{" +
                "listaCategorie=" + listaCategorie +
                '}';
    }

    public void associaAttuatoreAdArtefatti(Attuatore attuatoreAss, ArrayList<Artefatto> artefattoAss) {

    }

    public ListaCategorie getListaCategorie() {
        return listaCategorie;
    }

    public String visualizzaCategorieSensori(){
        return listaCategorie.visualizzaCategorieSensori();
    }


    public String visualizzaDescrizioneCatergorie(){
        return null;
    }

    public String visualizzaDescrizioneStanze(){
        return null;
    }



}
