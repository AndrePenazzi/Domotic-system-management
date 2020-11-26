package it.unibs.fp.dao.fileDAO;

import it.unibs.fp.dao.DAO;
import it.unibs.fp.model.utenti.Manutentore;
import it.unibs.fp.view.classiDiServizio.utenti.ClasseDiServizioManutentore;
import it.unibs.fp.view.mylib.ServizioFile;

import java.io.File;

public class ManutentoreDAO implements DAO<Manutentore> {


    @Override
    public void inserisci(Manutentore manutentore) {
        File cFile = new File("salvataggiSuDisco/file/manutentore.dat");
        ServizioFile.salvaSingoloOggetto(cFile, manutentore);
    }

    @Override
    public void aggiorna(Manutentore manutentore) {
        inserisci(manutentore);
    }

    @Override
    public Manutentore carica() {
        File cFile = new File("salvataggiSuDisco/file/manutentore.dat");
        if (!cFile.exists()) {
            inserisci(ClasseDiServizioManutentore.creaManutentore());
        }
        return (Manutentore) ServizioFile.caricaSingoloOggetto(cFile);

    }
}
