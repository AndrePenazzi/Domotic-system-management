package it.unibs.fp.dao.JSONDAO;

import com.google.gson.Gson;
import it.unibs.fp.dao.DAO;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliari;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioUnitaImmobiliari;

import java.io.*;

public class UnitaImmobiliariDAO implements DAO<UnitaImmobiliari> {
    Gson gson;
    Writer writer;
    Reader reader;
    File cFile;

    public UnitaImmobiliariDAO() {
        gson = new Gson();
        cFile = new File("salvataggiSuDisco/JSON/unitaImmobiliari.json");
    }

    @Override
    public void inserisci(UnitaImmobiliari unitaImmobiliari) {
        try {
            writer = new FileWriter(cFile);
            gson.toJson(unitaImmobiliari, writer);
            writer.flush();
            writer.close();
        } catch (IOException ignored) {
        }
    }

    @Override
    public void aggiorna(UnitaImmobiliari unitaImmobiliari) {
        inserisci(unitaImmobiliari);
    }

    @Override
    public UnitaImmobiliari carica() {
        if (!cFile.exists()) {
            inserisci(ClasseDiServizioUnitaImmobiliari.creaUnitaImmobiliari());
        }
        try {
            reader = new FileReader(cFile);
        } catch (IOException ignored) {
        }
        return gson.fromJson(reader, UnitaImmobiliari.class);
    }
}

