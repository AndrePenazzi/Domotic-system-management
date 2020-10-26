package it.unibs.fp.view.classiDiServizio;

import it.unibs.fp.dao.file.Contenitore;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.model.utenti.Manutentore;
import it.unibs.fp.view.mylib.MyMenu;

import java.util.List;

public class ClasseDiServizio {

    /**
     * Menu di scelta utente (manutentore o fruitore)
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    public static void menuPrincipale(Fruitore fruitore, Manutentore manutentore, ListaCategorie listaCategorie) {

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
                    ClasseDiServizioManutentore.stampaMenuManutentore(contenitore);
                }
                break;

                case 2: {
                    ClasseDiServizioFruitore.stampaMenuFruitore(fruitore,listaCategorie);
                }
                break;
            }
        } while (!finito);
    }
}