package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class ModOperativaParamentrica extends ModOperativa implements Serializable {
    private ArrayList<String> paramentri;
    /**
     * Costruttore
     *
     * @param nome della modalità operativa
     */
    public ModOperativaParamentrica(String nome, ArrayList<String> paramentri) {
        super(nome);
        this.paramentri = paramentri;
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
