package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaCategorie implements Serializable {
    private ArrayList<CategoriaSensori> categorieSensori;
    private ArrayList<CategoriaAttuatori> categorieAttuatori;

    public ListaCategorie(){
        categorieSensori = new ArrayList<>();
        categorieAttuatori = new ArrayList<>();
    }

    public ArrayList<CategoriaSensori> getCategorieSensori() {
        return categorieSensori;
    }

    public ArrayList<CategoriaAttuatori> getCategorieAttuatori() {
        return categorieAttuatori;
    }

    public void inserisciESalvaCategoriaAttuatori(CategoriaAttuatori categoriaAttuatori){
        categorieAttuatori.add(categoriaAttuatori);
    }

    public void inserisciESalvaCategoriaSensori(CategoriaSensori categoriaSensori){
        categorieSensori.add(categoriaSensori);
    }

    public int getSizeCategorieSensori(){
        return categorieSensori.size();
    }

    public int getSizeCategorieAttuatori(){
        return categorieAttuatori.size();
    }

    public String visualizzaCategorieSensori(){
        StringBuilder s= new StringBuilder();
        for(int i=0;i<categorieSensori.size();i++){
            s.append(i + 1).append(" ").append(categorieSensori.get(i).toString()).append("\n");
        }
        return s.toString();
    }

    public String visualizzaCategorieAttuatori(){
        StringBuilder s= new StringBuilder();
        for(int i=0;i<categorieAttuatori.size();i++){
            s.append(i + 1).append(" ").append(categorieAttuatori.get(i).toString()).append("\n");
        }
        return s.toString();
    }
}
