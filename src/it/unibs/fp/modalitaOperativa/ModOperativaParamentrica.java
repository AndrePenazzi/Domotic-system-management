package it.unibs.fp.modalitaOperativa;

import java.io.Serializable;
import java.util.ArrayList;

public class ModOperativaParamentrica extends ModOperativa implements Serializable {
    private ArrayList<String> paramentri;
    private String parametroAttuale;

    /**
     * Costruttore
     * @param nome della modalità operativa
     * @param paramentri scelti
     */
    public ModOperativaParamentrica(String nome, ArrayList<String> paramentri) {
        super(nome,2);
        this.paramentri = paramentri;
    }

    /**
     * Getter
     *
     * @return parametri
     */
    public ArrayList<String> getParamentri() {
        return paramentri;
    }

    /**
     * Setter
     *
     * @param paramentri da modificare
     */
    public void setParamentri(ArrayList<String> paramentri) {
        this.paramentri = paramentri;
    }

    /**
     * Getter
     *
     * @return parametroAttuale
     */
    public String getParametroAttuale() {
        return parametroAttuale;
    }

    /**
     * Setter
     * @param parametroAttuale da modificare
     */
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
        StringBuilder tmp = new StringBuilder();
        if (!paramentri.isEmpty()) {
            int i = 1;
            tmp.append("\nParametri:\n");
            for (String s : paramentri) {
                tmp.append(i).append(" ").append(s).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora parametri associati");
        tmp.append("\nParametro attuale: ").append(parametroAttuale);
        return tmp.toString();
    }
}
