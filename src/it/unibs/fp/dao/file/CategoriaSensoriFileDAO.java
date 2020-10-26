package it.unibs.fp.dao.file;

import it.unibs.fp.dao.DAO;
import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.view.mylib.ServizioFile;

import java.io.File;
import java.util.List;

public class CategoriaSensoriFileDAO implements DAO<CategoriaSensori> {
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
    public void aggiungiESalva(CategoriaSensori categoriaSensori) {
        connetti();
        contenitore.getListaCategorie().getCategorieSensori().add(categoriaSensori);
        ServizioFile.salvaSingoloOggetto(new File("Contenitore.dat"), contenitore);
    }

    @Override
    public List<CategoriaSensori> carica() {
        connetti();
        return contenitore.getListaCategorie().getCategorieSensori();
    }
}
