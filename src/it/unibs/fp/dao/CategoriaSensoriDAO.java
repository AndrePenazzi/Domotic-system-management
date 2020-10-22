package it.unibs.fp.dao;

import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.view.mylib.ServizioFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CategoriaSensoriDAO implements DAO<CategoriaSensori>{
    Contenitore contenitore;
    @Override
    public void connetti() {
        contenitore = (Contenitore) ServizioFile.caricaSingoloOggetto(new File("Contenitore.dat"));
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
