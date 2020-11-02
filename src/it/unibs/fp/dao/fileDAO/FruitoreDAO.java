package it.unibs.fp.dao.fileDAO;

import it.unibs.fp.dao.DAO;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.view.mylib.ServizioFile;

import java.io.File;

public class FruitoreDAO implements DAO<Fruitore> {

    @Override
    public void inserisci(Fruitore fruitore) {
        File cFile = new File("salvataggiSuDisco/fruitore.dat");
        ServizioFile.salvaSingoloOggetto(cFile,fruitore);
    }

    @Override
    public void aggiorna(Fruitore fruitore) {
        inserisci(fruitore);
    }

    @Override
    public Fruitore carica() {
        File cFile = new File("salvataggiSuDisco/fruitore.dat");
        if (cFile.exists()) {
            return (Fruitore) ServizioFile.caricaSingoloOggetto(cFile);
        } else {
            return null;
        }
    }
}
