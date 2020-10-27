package it.unibs.fp.dao.file;

import it.unibs.fp.dao.DAO;
import it.unibs.fp.view.mylib.ServizioFile;

import java.io.File;

public class ContenitoreDAO implements DAO<Contenitore> {
    Contenitore contenitore;

    @Override
    public void connetti() {
        File cFile = new File("Contenitore.dat");
        if (cFile.exists()) {
            contenitore = (Contenitore) ServizioFile.caricaSingoloOggetto(new File("Contenitore.dat"));
        } else {
            contenitore = new Contenitore();
            ServizioFile.salvaSingoloOggetto(cFile, contenitore);
        }
    }


    @Override
    public void aggiungiESalva(Contenitore contenitore) {
        connetti();
        ServizioFile.salvaSingoloOggetto(new File("Contenitore.dat"), contenitore);
    }

    @Override
    public Contenitore carica() {
        connetti();
        return contenitore;
    }
}
