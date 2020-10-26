package it.unibs.fp.dao.file;

import it.unibs.fp.dao.DAO;
import it.unibs.fp.model.utenti.Manutentore;
import it.unibs.fp.view.mylib.ServizioFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ManutentoreFileDAO implements DAO<Manutentore> {
    Contenitore contenitore;
    @Override
    public void connetti() {
        File cFile = new File("Contenitore.dat");
        if (cFile.exists()) {
            contenitore = (Contenitore) ServizioFile.caricaSingoloOggetto(new File("Contenitore.dat"));
        } else {
            Contenitore contenitore = new Contenitore();
            ServizioFile.salvaSingoloOggetto(cFile, contenitore);
        }
    }

    @Override
    public void aggiungiESalva(Manutentore manutentore) {
        connetti();
        contenitore.setManutentore(manutentore);
        ServizioFile.salvaSingoloOggetto(new File("Contenitore.dat"), contenitore);
    }

    @Override
    public List<Manutentore> carica() {
        connetti();
        List<Manutentore> manutentori = new ArrayList<>();
        manutentori.add(contenitore.getManutentore());
        return manutentori;
    }


}
