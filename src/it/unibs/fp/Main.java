package it.unibs.fp;

import it.unibs.fp.dao.file.CategoriaAttuatoriFileDAO;
import it.unibs.fp.dao.file.CategoriaSensoriFileDAO;
import it.unibs.fp.dao.file.FruitoreFileDAO;
import it.unibs.fp.dao.file.ManutentoreFileDAO;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.view.classiDiServizio.ClasseDiServizio;
import it.unibs.fp.view.mylib.*;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.model.utenti.Manutentore;

public class Main {
    private static ManutentoreFileDAO manutentoreFileDAO;
    private static FruitoreFileDAO fruitoreFileDAO;
    private static CategoriaAttuatoriFileDAO categoriaAttuatoriFileDAO;
    private static CategoriaSensoriFileDAO categoriaSensoriFileDAO;

    public static void main(String[] args) {
        creaFileDAO();
        Fruitore fruitore = fruitoreFileDAO.carica().get(0);
        Manutentore manutentore = manutentoreFileDAO.carica().get(0);
        ListaCategorie listaCategorie = new ListaCategorie();
        listaCategorie.setCategorieAttuatori(categoriaAttuatoriFileDAO.carica());
        listaCategorie.setCategorieSensori(categoriaSensoriFileDAO.carica());


        System.out.println(BelleStringhe.incornicia("Benvenuto"));

    }

    private static void creaFileDAO(){
        fruitoreFileDAO = new FruitoreFileDAO();
        manutentoreFileDAO = new ManutentoreFileDAO();
        categoriaAttuatoriFileDAO = new CategoriaAttuatoriFileDAO();
        categoriaSensoriFileDAO = new CategoriaSensoriFileDAO();
    }
}
