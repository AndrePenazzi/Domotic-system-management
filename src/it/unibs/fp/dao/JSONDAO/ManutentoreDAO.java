package it.unibs.fp.dao.JSONDAO;

import com.google.gson.Gson;
import it.unibs.fp.dao.DAO;
import it.unibs.fp.model.utenti.Manutentore;
import it.unibs.fp.view.classiDiServizio.utenti.ClasseDiServizioManutentore;

import java.io.*;

public class ManutentoreDAO implements DAO<Manutentore> {
    Gson gson;
    Writer writer;
    Reader reader;
    File cFile;

    public ManutentoreDAO() {
        gson = new Gson();
        cFile = new File("salvataggiSuDisco/JSON/manutentore.json");
    }

    @Override
    public void inserisci(Manutentore manutentore) {
        try {
            writer = new FileWriter(cFile);
            gson.toJson(manutentore, writer);
            writer.flush();
            writer.close();
        } catch (IOException ignored) {
        }
    }

    @Override
    public void aggiorna(Manutentore manutentore) {
        inserisci(manutentore);
    }

    @Override
    public Manutentore carica() {
        if (!cFile.exists()) {
            inserisci(ClasseDiServizioManutentore.creaManutentore());
        }
        try {
            reader = new FileReader(cFile);
        } catch (IOException ignored) {
        }
        return gson.fromJson(reader, Manutentore.class);
    }
}

