package it.unibs.fp;

import java.util.ArrayList;

public class Manutentore {
    private ListaCategorie listaCategorie;
    public Manutentore() {
        listaCategorie = new ListaCategorie();
    }

    public void inserisciESalvaCategoriaAttuatori(CategoriaAttuatori categoriaAttuatori){
        listaCategorie.inserisciESalvaCategoriaAttuatori(categoriaAttuatori);
    }

    public void inserisciESalvaCategoriaSensori(CategoriaSensori categoriaSensori){
        listaCategorie.inserisciESalvaCategoriaSensori(categoriaSensori);
    }

    public void inserisciStanza(Stanza stanza, UnitàImmobiliare unitàImmobiliare){
        unitàImmobiliare.inserisciStanza(stanza);
    }

    public void inserisciArtefatto(Artefatto artefatto, UnitàImmobiliare unitàImmobiliare){
        unitàImmobiliare.inserisciArtefatto(artefatto);
    }

    public void inserisciAttuatore(Attuatore attuatore, UnitàImmobiliare unitàImmobiliare){

    }

    public void associaSensoreAStanze(Sensore sensoreAss, ArrayList<Stanza> stanzeAss){

    }

    public void associaAttuatoreAStanze(Attuatore attuatoreAss,ArrayList<Stanza> stanzeAss){

    }

    public void associaSensoreAdArtefatti(Sensore sensoreAss,ArrayList<Artefatto> artefattoAss){

    }

    public void associaAttuatoreAdArtefatti(Attuatore attuatoreAss,ArrayList<Artefatto> artefattoAss) {

    }

    public ListaCategorie getListaCategorie() {
        return listaCategorie;
    }

    public String visualizzaCategorieSensori(){
        return listaCategorie.visualizzaCategorieSensori();
    }

    public int getSizeCategorieSensori(){
        return listaCategorie.getSizeCategorieSensori();
    }

    public String visualizzaDescrizioneCatergorie(){
        return null;
    }

    public String visualizzaDescrizioneStanze(){
        return null;
    }



}
