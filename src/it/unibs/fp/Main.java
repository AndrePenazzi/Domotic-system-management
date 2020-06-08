package it.unibs.fp;

import it.unibs.fp.mylib.*;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        Manutentore manutentore;
        UnitaImmobiliare unitaImmobiliare;
        Fruitore fruitore;
        ListaCategorie listaCategorie;

        File fM = new File("datiManutentore.txt");
        File fLC = new File("datiListaCategorie.txt");
        File fUI = new File("datiUnitaImmobiliare.txt");
        File fF = new File("datiFruitore.txt");

        if (fM.exists() && fLC.exists() && fUI.exists() && fF.exists()) {
            System.out.println("File caricati correttamente");
            manutentore = (Manutentore) ServizioFile.caricaSingoloOggetto(new File("datiManutentore.txt"));
            unitaImmobiliare = (UnitaImmobiliare) ServizioFile.caricaSingoloOggetto(new File("datiUnitaImmobiliare.txt"));
            fruitore = (Fruitore) ServizioFile.caricaSingoloOggetto(new File("datiFruitore.txt"));
            listaCategorie = (ListaCategorie) ServizioFile.caricaSingoloOggetto(new File("datiListaCategorie.txt"));
        } else {
            String nomeUnitaImmobiliare=InputDati.leggiStringaNonVuota("Inserisci il nome dell'unita' immobiliare");

            manutentore = new Manutentore();

            //TODO da sostituire con nomeUnitaImmobiliare
            unitaImmobiliare = new UnitaImmobiliare("Casa di pav");
            fruitore = new Fruitore();
            listaCategorie = new ListaCategorie();
            ServizioFile.salvaSingoloOggetto(new File("datiManutentore.txt"), manutentore);
            ServizioFile.salvaSingoloOggetto(new File("datiUnitaImmobiliare.txt"), unitaImmobiliare);
            ServizioFile.salvaSingoloOggetto(new File("datiFruitore.txt"), fruitore);
            ServizioFile.salvaSingoloOggetto(new File("datiListaCategorie.txt"), listaCategorie);
        }

        System.out.println(BelleStringhe.incornicia("Benvenuto"));

        ClasseDiServizio.menuPrincipale(manutentore, unitaImmobiliare, listaCategorie);

    }
}
