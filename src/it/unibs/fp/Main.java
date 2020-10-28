package it.unibs.fp;

import it.unibs.fp.dao.file.Contenitore;
import it.unibs.fp.dao.file.ContenitoreDAO;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.view.classiDiServizio.ClasseDiServizio;
import it.unibs.fp.view.mylib.*;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.model.utenti.Manutentore;

public class Main {
    private static ContenitoreDAO contenitoreDAO;

    public static void main(String[] args) {
        creaFileDAO();
        Contenitore contenitore = contenitoreDAO.carica();
        Fruitore fruitore = contenitore.getManutentore().getFruitore();
        Manutentore manutentore = contenitore.getManutentore();
        ListaCategorie listaCategorie = contenitore.getListaCategorie();

        System.out.println(BelleStringhe.incornicia("Benvenuto"));
        ClasseDiServizio.menuPrincipale(fruitore, manutentore, listaCategorie);

    }

    private static void creaFileDAO() {
        contenitoreDAO = new ContenitoreDAO();
    }
}
