package it.unibs.fp;

import java.util.ArrayList;

public class UnitàImmobiliare {
    private String nome;
    private ArrayList<Stanza> stanze;
    private ArrayList<Artefatto> artefatti;

    public UnitàImmobiliare(String nome) {
        this.nome = nome;
        this.stanze = new ArrayList<>();
        this.artefatti = new ArrayList<>();
    }

    public int getSizeStanze(){
        return stanze.size();
    }
    public int getSizeArtefatti(){
        return stanze.size();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String visualizzaStanze(){
        String s="";
        for(int i=0;i<stanze.size();i++){
            s+=(i+1)+" "+stanze.get(i).toString()+"\n";
        }
        return s;
    }

    public ArrayList<Stanza> getStanze() {
        return stanze;
    }

    public ArrayList<Artefatto> getArtefatti() {
        return artefatti;
    }

    public void inserisciStanza(Stanza stanza){
        stanze.add(stanza);
    }

    public void inserisciArtefatto(Artefatto artefatto){
        artefatti.add(artefatto);
    }

    public void associaSensoreAStanze(Sensore sensoreAss,ArrayList<Stanza> stanzeAss){
        for(Stanza s:stanzeAss){
            s.inserisciSensore(sensoreAss);
        }
    }

    public void associaAttuatoreAStanze(Attuatore attuatoreAss,ArrayList<Stanza> stanzeAss){
        for(Stanza s:stanzeAss){
            s.inserisciAttuatore(attuatoreAss);
        }
    }

    public void associaSensoreAdArtefatti(Sensore sensoreAss,ArrayList<Artefatto> artefattoAss){
        for(Artefatto a:artefattoAss){
            a.inserisciSensore(sensoreAss);
        }
    }

    public void associaAttuatoreAdArtefatti(Attuatore attuatoreAss,ArrayList<Artefatto> artefattoAss){
        for(Artefatto a:artefattoAss){
            a.inserisciAttuatore(attuatoreAss);
        }
    }

    @Override
    public String toString() {
        return "it.unibs.fp.UnitàImmobiliare{" +
                "nome='" + nome + '\'' +
                ", stanze=" + stanze +
                ", artefatti=" + artefatti +
                '}';
    }
}
