package it.unibs.fp;


import it.unibs.fp.dao.fileDAO.FruitoreDAO;
import it.unibs.fp.dao.fileDAO.ListaCategorieDAO;
import it.unibs.fp.dao.fileDAO.ManutentoreDAO;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.view.classiDiServizio.ClasseDiServizio;
import it.unibs.fp.view.classiDiServizio.utenti.ClasseDiServizioManutentore;
import it.unibs.fp.view.mylib.*;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.model.utenti.Manutentore;

public class Main {
    private static ManutentoreDAO manutentoreDAO;
    private static ListaCategorieDAO listaCategorieDAO;
    private static FruitoreDAO fruitoreDAO;

    public static void main(String[] args) {
        creaFileDAO();

        ListaCategorie listaCategorie = listaCategorieDAO.carica();
        Manutentore manutentore = manutentoreDAO.carica();
        Fruitore fruitore;
        if (manutentore == null) {
            manutentoreDAO.inserisci(ClasseDiServizioManutentore.creaManutentore());
            manutentore = manutentoreDAO.carica();
        }
        fruitoreDAO.inserisci(manutentore.getFruitore());
        fruitore = fruitoreDAO.carica();


        System.out.println(BelleStringhe.incornicia("Benvenuto"));
        ClasseDiServizio.menuPrincipale(fruitore, manutentore, listaCategorie);

    }

    private static void creaFileDAO() {
        listaCategorieDAO = new ListaCategorieDAO();
        manutentoreDAO = new ManutentoreDAO();
        fruitoreDAO = new FruitoreDAO();
    }
}
