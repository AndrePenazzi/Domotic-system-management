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
            String nomeUnitaImmobiliare=InputDati.leggiStringaNonVuota("Inserisci il nome dell'unita' immobiliare: ");
            UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare(nomeUnitaImmobiliare);
            Manutentore manutentore = new Manutentore();
            Fruitore fruitore = new Fruitore();
            ListaCategorie listaCategorie = new ListaCategorie();
            contenitore = new Contenitore(unitaImmobiliare,manutentore,fruitore,listaCategorie);
            ServizioFile.salvaSingoloOggetto(new File("contenitore.txt"), contenitore);
        }

        System.out.println(BelleStringhe.incornicia("Benvenuto"));

        ClasseDiServizio.menuPrincipale(contenitore);

    }
}
