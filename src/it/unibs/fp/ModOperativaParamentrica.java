package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class ModOperativaParamentrica extends ModOperativa implements Serializable {
    private ArrayList<String> paramentri;
    private String paremetroAttuale;



    /**
     * Costruttore
     *
     * @param nome della modalità operativa
     */
    public ModOperativaParamentrica(String nome, ArrayList<String> paramentri) {
        super(nome,2);
        this.paramentri = paramentri;
    }

    public ArrayList<String> getParamentri() {
        return paramentri;
    }

    public void setParamentri(ArrayList<String> paramentri) {
        this.paramentri = paramentri;
    }

    public String getParemetroAttuale() {
        return paremetroAttuale;
    }

    public void setParemetroAttuale(String paremetroAttuale) {
        this.paremetroAttuale = paremetroAttuale;
    }

    /**
     * toString
     *
     * @return i dati della modalità operativa
     */
    @Override
    public String toString() {
        String val = "";
        for(String s: paramentri){
            val+=s+'\n';
        }
        return "ModalitaOperativa:\n" +
                "nome='" + super.getNome() +
                ", valore=" + val;
    }
}
