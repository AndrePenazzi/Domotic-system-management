package it.unibs.fp.view.classiDiServizio;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliari;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.model.utenti.Manutentore;
import it.unibs.fp.view.classiDiServizio.utenti.ClasseDiServizioFruitore;
import it.unibs.fp.view.classiDiServizio.utenti.ClasseDiServizioManutentore;
import it.unibs.fp.view.mylib.BelleStringhe;
import it.unibs.fp.view.mylib.MyMenu;

public class ClasseDiServizio {


    public static void menuPrincipale(Manutentore manutentore, Fruitore fruitore, UnitaImmobiliari unitaImmobiliari, ListaCategorie listaCategorie) {

        boolean finito = false;
        String[] azione = {"Accedi come manutentore", "Accedi come fruitore"};
        MyMenu menu = new MyMenu("Menu principale", azione);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("Grazie per aver usato Domotic System Management");
                }
                break;

                case 1: {
                    System.out.println(BelleStringhe.incornicia(manutentore.getNome()));
                    ClasseDiServizioManutentore.stampaMenuManutentore(unitaImmobiliari, listaCategorie);

                }
                break;

                case 2: {
                    System.out.println(BelleStringhe.incornicia(fruitore.getNome()));
                    ClasseDiServizioFruitore.stampaMenuFruitore(unitaImmobiliari, listaCategorie);
                    //salvataggio
                    ClasseDiServizioJSONDAO.salvaUnitaImmboliari(unitaImmobiliari);
                }
                break;
            }
        } while (!finito);
    }
}