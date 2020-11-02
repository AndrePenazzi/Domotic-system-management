package it.unibs.fp.model.categoria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategorieSensori implements Serializable {
    private List<CategoriaSensori> categorieSensori;

    public CategorieSensori() {
        categorieSensori = new ArrayList<>();
    }

    public List<CategoriaSensori> getCategorieSensori() {
        return categorieSensori;
    }

    public void setCategorieSensori(List<CategoriaSensori> categorieSensori) {
        this.categorieSensori = categorieSensori;
    }

    public CategoriaSensori getCategoriaSensori(int i) {
        return categorieSensori.get(i);
    }

    public boolean isEmpty() {
        return categorieSensori.isEmpty();
    }

    public int getSize() {
        return categorieSensori.size();
    }



    public void inserisciCategoriaSensori(CategoriaSensori categoriaSensori) {
        categorieSensori.add(categoriaSensori);
    }
}
