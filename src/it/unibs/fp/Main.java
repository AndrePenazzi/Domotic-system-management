package it.unibs.fp;

import it.unibs.fp.mylib.*;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File cFile = new File("contenitore.txt");
        Contenitore contenitore;

        if (cFile.exists()) {
            System.out.println("File caricati correttamente");
            contenitore = (Contenitore) ServizioFile.caricaSingoloOggetto(cFile);
        } else {
            Fruitore fruitore = new Fruitore();
            Manutentore manutentore = new Manutentore(fruitore);
            ListaCategorie listaCategorie = new ListaCategorie();
            contenitore = new Contenitore(manutentore,fruitore,listaCategorie);
            ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);
        }

        System.out.println(BelleStringhe.incornicia("Benvenuto"));

        ClasseDiServizio.menuPrincipale(contenitore);
    }
}
