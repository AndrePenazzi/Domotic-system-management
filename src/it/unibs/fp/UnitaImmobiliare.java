package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class UnitaImmobiliare implements Serializable {
    private String nome;
    private ArrayList<Stanza> stanze;
    private ArrayList<Artefatto> artefatti;

    public UnitaImmobiliare(String nome) {
        this.nome = nome;
        this.stanze = new ArrayList<>();
        this.artefatti = new ArrayList<>();
    }

    public int getSizeStanze() {
        return stanze.size();
    }

    public int getSizeArtefatti() {
        return stanze.size();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public ArrayList<Stanza> getStanze() {
        return stanze;
    }

    public ArrayList<Artefatto> getArtefatti() {
        return artefatti;
    }

    public void inserisciStanza(Stanza stanza) {
        stanze.add(stanza);
    }

    public void inserisciArtefatto(Artefatto artefatto) {
        artefatti.add(artefatto);
    }

    public void associaSensoreAStanze(Sensore sensoreAss, ArrayList<Stanza> stanzeAss) {
        for (Stanza s : stanzeAss) {
            s.inserisciSensore(sensoreAss);
        }
    }

    public void associaAttuatoreAStanze(Attuatore attuatoreAss, ArrayList<Stanza> stanzeAss) {
        for (Stanza s : stanzeAss) {
            s.inserisciAttuatore(attuatoreAss);
        }
    }

    public void associaSensoreAdArtefatti(Sensore sensoreAss, ArrayList<Artefatto> artefattoAss) {
        for (Artefatto a : artefattoAss) {
            a.inserisciSensore(sensoreAss);
        }
    }

    public void associaAttuatoreAdArtefatti(Attuatore attuatoreAss, ArrayList<Artefatto> artefattoAss) {
        for (Artefatto a : artefattoAss) {
            a.inserisciAttuatore(attuatoreAss);
        }
    }

    public String visualizzaStanze() {
        StringBuilder tmp = new StringBuilder("");
        tmp.append("Le stanze sono:\n");
        for (Stanza s : stanze) {
            tmp.append(s.toString()).append("\n");
        }
        return tmp.toString();
    }

    public String visualizzaArtefatti() {
        StringBuilder tmp = new StringBuilder("");
        tmp.append("Gli Artefatti sono:\n");
        for (Artefatto a : artefatti) {
            tmp.append(a.toString()).append("\n");
        }
        return tmp.toString();
    }


    @Override
    public String toString() {
        return "L'unità immobiliare è così composta:\n" +
                visualizzaStanze() +
                visualizzaArtefatti();
    }
}
