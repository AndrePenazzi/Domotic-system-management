package it.unibs.fp.dao.file;

import it.unibs.fp.dao.DAO;
import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.view.mylib.ServizioFile;

import java.io.File;
import java.util.List;

public class CategoriaAttuatoriFileDAO implements DAO<CategoriaAttuatori> {

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
    public void aggiungiESalva(CategoriaAttuatori categoriaAttuatori) {
        connetti();
        contenitore.getListaCategorie().getCategorieAttuatori().add(categoriaAttuatori);
        ServizioFile.salvaSingoloOggetto(new File("Contenitore.dat"), contenitore);
    }

    @Override
    public List<CategoriaAttuatori> carica() {
        connetti();
        return contenitore.getListaCategorie().getCategorieAttuatori();
    }
}
