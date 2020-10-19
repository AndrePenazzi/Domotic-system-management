package it.unibs.fp.model.modalitaOperativa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ModOperativaParamentrica extends ModOperativa implements Serializable {
    private List<String> paramentri;
    private String parametroAttuale;

    /**
     * Costruttore
     * @param nome della modalità operativa
     * @param paramentri scelti
     */
    public ModOperativaParamentrica(String nome, List<String> paramentri) {
        super(nome,2);
        this.paramentri = paramentri;
    }

    public ModOperativaParamentrica() {
        super("",2);
        this.paramentri = new ArrayList<>();
    }

    /**
     * Getter
     *
     * @return parametri
     */
    public List<String> getParamentri() {
        return paramentri;
    }

    /**
     * Setter
     *
     * @param paramentri da modificare
     */
    public void setParamentri(List<String> paramentri) {
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
