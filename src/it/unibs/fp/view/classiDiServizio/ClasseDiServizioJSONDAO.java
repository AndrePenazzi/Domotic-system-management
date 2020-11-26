package it.unibs.fp.view.classiDiServizio;

import it.unibs.fp.dao.JSONDAO.FruitoreDAO;
import it.unibs.fp.dao.JSONDAO.ListaCategorieDAO;
import it.unibs.fp.dao.JSONDAO.ManutentoreDAO;
import it.unibs.fp.dao.JSONDAO.UnitaImmobiliariDAO;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliari;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.model.utenti.Manutentore;


public class ClasseDiServizioJSONDAO {
    private static final ManutentoreDAO manutentoreDAO = new ManutentoreDAO();
    private static final FruitoreDAO fruitoreDAO = new FruitoreDAO();
    private static final UnitaImmobiliariDAO unitaImmobiliariDAO = new UnitaImmobiliariDAO();
    private static final ListaCategorieDAO listaCategorieDAO = new ListaCategorieDAO();

    public static void salvaManutentore(Manutentore manutentore) {
        manutentoreDAO.inserisci(manutentore);
    }

    public static void salvaFruitore(Fruitore fruitore) {
        fruitoreDAO.inserisci(fruitore);
    }

    public static void salvaUnitaImmboliari(UnitaImmobiliari unitaImmobiliari) {
        unitaImmobiliariDAO.inserisci(unitaImmobiliari);
    }

    public static void salvaListaCategorie(ListaCategorie listaCategorie) {
        listaCategorieDAO.inserisci(listaCategorie);
    }

    public static Manutentore caricaManutentore() {
        return manutentoreDAO.carica();
    }

    public static Fruitore caricaFruitore() {
        return fruitoreDAO.carica();
    }

    public static ListaCategorie caricaListaCategorie() {
        return listaCategorieDAO.carica();
    }

    public static UnitaImmobiliari caricaUnitaImmobiliare() {
        return unitaImmobiliariDAO.carica();
    }
}
