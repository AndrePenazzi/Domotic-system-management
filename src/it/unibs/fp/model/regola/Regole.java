package it.unibs.fp.model.regola;


import java.util.ArrayList;
import java.util.List;

public class Regole {
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
