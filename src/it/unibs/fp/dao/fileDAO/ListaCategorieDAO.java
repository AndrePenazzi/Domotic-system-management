package it.unibs.fp.dao.fileDAO;

import it.unibs.fp.dao.DAO;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.view.mylib.ServizioFile;

import java.io.File;

public class ListaCategorieDAO implements DAO<ListaCategorie> {
    @Override
    public void inserisci(ListaCategorie listaCategorie) {
        File cFile = new File("salvataggiSuDisco/listaCategorie.dat");
        ServizioFile.salvaSingoloOggetto(cFile,listaCategorie);
    }

    @Override
    public void aggiorna(ListaCategorie listaCategorie) {
        inserisci(listaCategorie);
    }

    @Override
    public ListaCategorie carica() {
        File cFile = new File("salvataggiSuDisco/listaCategorie.dat");
        if (!cFile.exists()) {
            inserisci(new ListaCategorie());
        }
        return (ListaCategorie) ServizioFile.caricaSingoloOggetto(cFile);
    }
}
