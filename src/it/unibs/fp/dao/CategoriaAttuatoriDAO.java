package it.unibs.fp.dao;

import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.view.mylib.ServizioFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CategoriaAttuatoriDAO implements DAO<CategoriaAttuatori>{

    Contenitore contenitore;
    @Override
    public void connetti() {
        contenitore = (Contenitore) ServizioFile.caricaSingoloOggetto(new File("Contenitore.dat"));
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
