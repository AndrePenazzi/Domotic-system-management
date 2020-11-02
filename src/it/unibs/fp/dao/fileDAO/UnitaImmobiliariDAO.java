package it.unibs.fp.dao.fileDAO;

import it.unibs.fp.dao.DAO;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliari;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.view.mylib.ServizioFile;

import java.io.File;

public class UnitaImmobiliariDAO implements DAO<UnitaImmobiliari> {
    @Override
    public void inserisci(UnitaImmobiliari unitaImmobiliari) {
        File cFile = new File("salvataggiSuDisco/unitaImmobiliari.dat");
        ServizioFile.salvaSingoloOggetto(cFile, unitaImmobiliari);
    }

    @Override
    public void aggiorna(UnitaImmobiliari unitaImmobiliari) {
        inserisci(unitaImmobiliari);
    }

    @Override
    public UnitaImmobiliari carica() {
        File cFile = new File("salvataggiSuDisco/unitaImmobiliari.dat");
        if (!cFile.exists()) {
            inserisci(new UnitaImmobiliari());
        }
        return (UnitaImmobiliari) ServizioFile.caricaSingoloOggetto(cFile);
    }
}
