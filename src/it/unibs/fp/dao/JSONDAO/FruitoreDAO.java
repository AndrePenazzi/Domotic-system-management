package it.unibs.fp.dao.JSONDAO;

import com.google.gson.Gson;
import it.unibs.fp.dao.DAO;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.view.classiDiServizio.utenti.ClasseDiServizioFruitore;

import java.io.*;

public class FruitoreDAO implements DAO<Fruitore> {
    Gson gson;
    Writer writer;
    Reader reader;
    File cFile;

    public FruitoreDAO() {
        gson = new Gson();
        cFile = new File("salvataggiSuDisco/JSON/fruitore.json");
    }

    @Override
    public void inserisci(Fruitore fruitore) {
        try {
            writer = new FileWriter(cFile);
            gson.toJson(fruitore, writer);
            writer.flush();
            writer.close();
        } catch (IOException ignored) {
        }
    }

    @Override
    public void aggiorna(Fruitore fruitore) {
        inserisci(fruitore);
    }

    @Override
    public Fruitore carica() {
        if (!cFile.exists()) {
            inserisci(ClasseDiServizioFruitore.creaFruitore());
        }
        try{
        reader = new FileReader(cFile);
        }catch (IOException ignored){}
        return gson.fromJson(reader, Fruitore.class);
    }
}

