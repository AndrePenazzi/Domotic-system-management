package it.unibs.fp;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.view.classiDiServizio.ClasseDiServizio;
import it.unibs.fp.dao.Contenitore;
import it.unibs.fp.view.mylib.*;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.model.utenti.Manutentore;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File cFile = new File("contenitore.dat");
        Contenitore contenitore;

        if (cFile.exists()) {
            System.out.println("File caricati correttamente");
            contenitore = (Contenitore) ServizioFile.caricaSingoloOggetto(cFile);
        } else {
            Fruitore fruitore = new Fruitore();
            Manutentore manutentore = new Manutentore(fruitore);
            ListaCategorie listaCategorie = new ListaCategorie();
            contenitore = new Contenitore(manutentore, listaCategorie);
            ServizioFile.salvaSingoloOggetto(new File("contenitore"), contenitore);
        }

        System.out.println(BelleStringhe.incornicia("Benvenuto"));

        ClasseDiServizio.menuPrincipale(contenitore);
    }
}
