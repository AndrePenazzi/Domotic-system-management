package it.unibs.fp;

import it.unibs.fp.mylib.NumeriCasuali;

import java.io.Serializable;
import java.util.ArrayList;

public class InfoRilevabileNonNumerica extends InfoRilevabile implements Serializable {
    private ArrayList<String> valori;
    private String valoreAttuale;

    /**
     * Costrutore di informazione con valori in forma di stringa
     * @param nome dell'informazione
     * @param valori sottoforma di stringa
     */
    public InfoRilevabileNonNumerica(String nome,ArrayList<String> valori){
        super(nome,2);
        this.valori = valori;
        valoreAttuale = "default";
    }

    /**
     * Inserimento del valore
     * @param valore da inserire nella lista dei valori
     */
    public void inserisciValore(String valore){
        valori.add(valore);
    }

    /**
     * Rilevamento della variabile casualmente
     * @return un valore estratto casualmente tra quelli disponibili
     */
    public String rilevaVariabile(){
        return valoreAttuale = valori.get(NumeriCasuali.estraiIntero(0,valori.size()));
    }

    /**
     * To string della classe
     * @return informazioni rilevanti
     */
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n"+getNome());

        if (!valori.isEmpty()) {
            int i = 1;
            tmp.append("\nValori:\n");
            for (String s : valori) {
                tmp.append(i+" "+s).append("\n");
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora valori associati");
        return tmp.toString();
    }

    public void setValori(ArrayList<String> valori) {
        this.valori = valori;
    }

    public ArrayList<String> getValori() {
        return valori;
    }

    public String getValoreAttuale() {
        return valoreAttuale;
    }

    public void setValoreAttuale(String valoreAttuale) {
        this.valoreAttuale = valoreAttuale;
    }
}
