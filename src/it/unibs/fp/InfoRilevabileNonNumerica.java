package it.unibs.fp;

import it.unibs.fp.mylib.NumeriCasuali;

import java.io.Serializable;
import java.util.ArrayList;

public class InfoRilevabileNonNumerica extends InfoRilevabile implements Serializable {
    private ArrayList<String> valori;
    private String valoreAttuale;

    public InfoRilevabileNonNumerica(String nome,ArrayList<String> valori){
        super(nome,2);
        this.valori = valori;
        valoreAttuale = "default";
    }

    public void inserisciValore(String valore){
        valori.add(valore);
    }

    public String rilevaVariabile(){
        return valoreAttuale = valori.get(NumeriCasuali.estraiIntero(0,valori.size()));
    }

    @Override
    public String toString() {
        String val = "";
        for(String s: valori){
            val+=s+'\n';
        }
        return "InformazioneRilevabile:\n" +
                "nome='" + super.getNome() +
                ", valori=" + val +
                '\n';
    }
}
