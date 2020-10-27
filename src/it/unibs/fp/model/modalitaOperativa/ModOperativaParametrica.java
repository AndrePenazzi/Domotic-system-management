package it.unibs.fp.model.modalitaOperativa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ModOperativaParametrica extends ModOperativa implements Serializable {
    private List<String> paramentri;
    private String parametroAttuale;

    /**
     * Costruttore
     * @param nome della modalità operativa
     * @param paramentri scelti
     */
    public ModOperativaParametrica(String nome, List<String> paramentri) {
        super(nome);
        this.paramentri = paramentri;
    }

    /**
     * Getter
     *
     * @return parametri
     */
    public List<String> getParamentri() {
        return paramentri;
    }

    public int getSizeParamentri() {
        return paramentri.size();
    }

    public String getParametro(int i) {
        return paramentri.get(i);
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


    public int getType(){
        return 2;
    }
}
