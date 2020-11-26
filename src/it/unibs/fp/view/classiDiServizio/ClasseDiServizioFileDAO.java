package it.unibs.fp.view.classiDiServizio;

import it.unibs.fp.dao.fileDAO.FruitoreDAO;
import it.unibs.fp.dao.fileDAO.ListaCategorieDAO;
import it.unibs.fp.dao.fileDAO.ManutentoreDAO;
import it.unibs.fp.dao.fileDAO.UnitaImmobiliariDAO;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliari;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.model.utenti.Manutentore;

public class ClasseDiServizioFileDAO {
    private static ManutentoreDAO manutentoreDAO = new ManutentoreDAO();
    private static FruitoreDAO fruitoreDAO = new FruitoreDAO();
    private static UnitaImmobiliariDAO unitaImmobiliariDAO = new UnitaImmobiliariDAO();
    private static ListaCategorieDAO listaCategorieDAO = new ListaCategorieDAO();

    public static void salvaManutentore(Manutentore manutentore){
        manutentoreDAO.inserisci(manutentore);
    }

    public static void salvaFruitore(Fruitore fruitore){
        fruitoreDAO.inserisci(fruitore);
    }

    public static void salvaUnitaImmboliari(UnitaImmobiliari unitaImmobiliari){
        unitaImmobiliariDAO.inserisci(unitaImmobiliari);
    }

    public static void salvaListaCategorie(ListaCategorie listaCategorie){
        listaCategorieDAO.inserisci(listaCategorie);
    }
}
