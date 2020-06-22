package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class ModOperativaParamentrica extends ModOperativa implements Serializable {
    private ArrayList<String> paramentri;
    private String parametroAttuale;



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

    public String getParametroAttuale() {
        return parametroAttuale;
    }

    public void setParametroAttuale(String parametroAttuale) {
        this.parametroAttuale = parametroAttuale;
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
                ", valore=" + val +'\n'+"Modalità attuale: "+parametroAttuale;
    }
}
