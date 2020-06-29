package it.unibs.fp;

import it.unibs.fp.mylib.MyMenu;

public class ClasseDiServizio {

    /**
     * Menu di scelta utente (manutentore o fruitore)
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    public static void menuPrincipale(Contenitore contenitore) {

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
                    ClasseDiServizioFruitore.stampaMenuFruitore(contenitore);
                }
                break;
            }
        } while (!finito);
    }
}