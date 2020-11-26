package it.unibs.fp.dao.JSONDAO;

import com.google.gson.Gson;
import it.unibs.fp.dao.DAO;
import it.unibs.fp.model.categoria.ListaCategorie;

import java.io.*;

public class ListaCategorieDAO implements DAO<ListaCategorie> {
    Gson gson;
    Writer writer;
    Reader reader;
    File cFile;

    public ListaCategorieDAO() {
        gson = new Gson();
        cFile = new File("salvataggiSuDisco/JSON/listaCategorie.json");
    }

    @Override
    public void inserisci(ListaCategorie listaCategorie) {
        try {
            writer = new FileWriter(cFile);
            gson.toJson(listaCategorie, writer);
            writer.flush();
            writer.close();
        } catch (IOException ignored) {
        }
    }

    @Override
    public void aggiorna(ListaCategorie listaCategorie) {
        inserisci(listaCategorie);
    }

    @Override
    public ListaCategorie carica() {
        if (!cFile.exists()) {
            inserisci(new ListaCategorie());
        }
        try {
            reader = new FileReader(cFile);
        } catch (IOException ignored) {
        }
        return gson.fromJson(reader, ListaCategorie.class);
    }
}

