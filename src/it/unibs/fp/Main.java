package it.unibs.fp;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliari;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.model.utenti.Manutentore;
import it.unibs.fp.view.classiDiServizio.ClasseDiServizio;
import it.unibs.fp.view.classiDiServizio.ClasseDiServizioJSONDAO;
import it.unibs.fp.view.mylib.BelleStringhe;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Manutentore manutentore = ClasseDiServizioJSONDAO.caricaManutentore();
        Fruitore fruitore = ClasseDiServizioJSONDAO.caricaFruitore();
        UnitaImmobiliari unitaImmobiliari = ClasseDiServizioJSONDAO.caricaUnitaImmobiliare();
        ListaCategorie listaCategorie = ClasseDiServizioJSONDAO.caricaListaCategorie();


        System.out.println(BelleStringhe.incornicia("Benvenuto"));
        ClasseDiServizio.menuPrincipale(manutentore, fruitore, unitaImmobiliari, listaCategorie);
    }

}
