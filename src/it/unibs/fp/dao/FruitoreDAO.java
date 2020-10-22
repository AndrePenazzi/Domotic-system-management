package it.unibs.fp.dao;

import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.view.mylib.ServizioFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FruitoreDAO implements DAO<Fruitore>{
    Contenitore contenitore;
    @Override
    public void connetti() {
        Contenitore contenitore = (Contenitore) ServizioFile.caricaSingoloOggetto(new File("Contenitore.dat"));
    }

    @Override
    public void aggiungiESalva(Fruitore fruitore) {
        connetti();
        contenitore.getManutentore().setFruitore(fruitore);
        ServizioFile.salvaSingoloOggetto(new File("Contenitore.dat"), contenitore);
    }
    @Override
    public List<Fruitore> carica() {
        connetti();
        List<Fruitore> fruitori = new ArrayList<>();
        fruitori.add(contenitore.getManutentore().getFruitore());
        return fruitori;
    }
}
