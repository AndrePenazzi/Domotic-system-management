package it.unibs.fp;

import it.unibs.fp.dao.fileDAO.FruitoreDAO;
import it.unibs.fp.dao.fileDAO.ListaCategorieDAO;
import it.unibs.fp.dao.fileDAO.ManutentoreDAO;
import it.unibs.fp.dao.fileDAO.UnitaImmobiliariDAO;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliari;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.model.utenti.Manutentore;
import it.unibs.fp.view.classiDiServizio.ClasseDiServizio;
import it.unibs.fp.view.mylib.BelleStringhe;

public class Main {
    private static ManutentoreDAO manutentoreDAO;
    private static ListaCategorieDAO listaCategorieDAO;
    private static FruitoreDAO fruitoreDAO;
    private static UnitaImmobiliariDAO unitaImmobiliariDAO;

    public static void main(String[] args) {
        creaFileDAO();

        ListaCategorie listaCategorie = listaCategorieDAO.carica();
        Manutentore manutentore = manutentoreDAO.carica();
        Fruitore fruitore = fruitoreDAO.carica();
        UnitaImmobiliari unitaImmobiliari = unitaImmobiliariDAO.carica();


        System.out.println(BelleStringhe.incornicia("Benvenuto"));

        ClasseDiServizio.menuPrincipale(manutentore, fruitore, unitaImmobiliari, listaCategorie);

    }

    private static void creaFileDAO() {
        listaCategorieDAO = new ListaCategorieDAO();
        manutentoreDAO = new ManutentoreDAO();
        fruitoreDAO = new FruitoreDAO();
        unitaImmobiliariDAO = new UnitaImmobiliariDAO();
    }
}
