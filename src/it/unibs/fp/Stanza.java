package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

//TODO sensori e stanze
public class Stanza implements Serializable {
    private String nome;
    private ArrayList<Artefatto> artefatti;

    /**
     * Costruttore della stanza.
     *
     * @param nome della stanza.
     */
    public Stanza(String nome) {
        artefatti = new ArrayList<>();
        this.nome = nome;
    }

    /**
     * Getter
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Artefatto> getArtefatti() {
        return artefatti;
    }

    public void setArtefatti(ArrayList<Artefatto> artefatti) {
        this.artefatti = artefatti;
    }

    public void inserisciArtefatto(Artefatto artefatto){
        artefatti.add(artefatto);
    }

    /**
     * toString.
     *
     * @return descrizione della stanza.
     */
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("");
        tmp.append("Nella stanza").append(nome).append(" ci sono i seguenti artefatti: \n");
        for (Artefatto a:artefatti ) {
            tmp.append(a.toString()).append("\n");
        }
        return tmp.toString();
    }
}
