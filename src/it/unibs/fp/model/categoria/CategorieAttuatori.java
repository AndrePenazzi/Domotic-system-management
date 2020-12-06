package it.unibs.fp.model.categoria;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategorieAttuatori implements Serializable {
    private List<CategoriaAttuatori> categorieAttuatori;

    public CategorieAttuatori() {
        categorieAttuatori = new ArrayList<>();
    }

    public List<CategoriaAttuatori> getCategorieAttuatori() {
        return categorieAttuatori;
    }

    public void setCategorieAttuatori(List<CategoriaAttuatori> categorieAttuatori) {
        this.categorieAttuatori = categorieAttuatori;
    }

    public CategoriaAttuatori getCategoriaAttuatori(int i) {
        return categorieAttuatori.get(i);
    }

    public boolean isEmpty() {
        return categorieAttuatori.isEmpty();
    }

    public int getSize() {
        return categorieAttuatori.size();
    }

    public void setCategoriaAttuatori(List<CategoriaAttuatori> categorieAttuatori) {
        this.categorieAttuatori = categorieAttuatori;
    }

    public void inserisciCategoriaAttuatore(CategoriaAttuatori categoriaAttuatori) {
        categorieAttuatori.add(categoriaAttuatori);
    }

    public boolean controlloOmonimia(CategoriaAttuatori catAtt) {
        for (CategoriaAttuatori a : categorieAttuatori)
            if (catAtt.controlloOmonimia(a)) {
                return true;
            }
        return false;
    }
}
