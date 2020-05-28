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
        String s="";
        for(int i=0;i<categorieSensori.size();i++){
            s+=(i+1)+" "+categorieSensori.get(i).toString()+"\n";
        }
        return s;
    }

    public String visualizzaCategorieAttuatori(){
        String s="";
        for(int i=0;i<categorieAttuatori.size();i++){
            s+=(i+1)+" "+categorieAttuatori.get(i).toString()+"\n";
        }
        return s;
    }
}
