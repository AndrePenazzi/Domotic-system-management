package it.unibs.fp.test;

import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.categoria.ListaCategorie;
import org.junit.jupiter.api.Test;


public class ListaCategorieTest {
    private static ListaCategorie listaCategorieNuova;

    @Test
    public void inizializzazioneTest(){
        listaCategorieNuova = new ListaCategorie();
        assert listaCategorieNuova.getSizeCategorieAttuatori()==0;
        assert listaCategorieNuova.getSizeCategorieSensori()==0;
    }

    @Test
    public void aggiuntaCategoriaAttuatori(){
        listaCategorieNuova = new ListaCategorie();
        CategoriaAttuatori catAtt = new CategoriaAttuatori();
        listaCategorieNuova.inserisciESalvaCategoriaAttuatori(catAtt);
        assert listaCategorieNuova.getSizeCategorieAttuatori()==1;
    }
    @Test
    public void aggiuntaCategoriaSensori(){
        listaCategorieNuova = new ListaCategorie();
        CategoriaSensori catSen = new CategoriaSensori();
        listaCategorieNuova.inserisciESalvaCategoriaSensori(catSen);
        assert listaCategorieNuova.getSizeCategorieSensori()==1;
    }

}
