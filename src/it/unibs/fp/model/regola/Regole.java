package it.unibs.fp.model.regola;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Regole implements Serializable {
    private List<Regola> regole;

    public Regole() {
        regole = new ArrayList<>();
    }

    public List<Regola> getRegole() {
        return regole;
    }

    public void setRegole(List<Regola> regole) {
        this.regole = regole;
    }

    public void inserisciRegola(Regola regola) {
        regole.add(regola);
    }
}
