package it.unibs.fp.model.infoRilevabile;

import it.unibs.fp.view.mylib.NumeriCasuali;

import java.util.List;

public class InfoRilevabileNonNumerica implements InfoRilevabile<String> {
    private String nome;
    private List<String> valori;
    private String valoreAttuale;

    /**
     * Costrutore di informazione con valori in forma di stringa
     *
     * @param nome   dell'informazione
     * @param valori sottoforma di stringa
     */
    public InfoRilevabileNonNumerica(String nome, List<String> valori) {
        this.nome = nome;
        this.valori = valori;
        valoreAttuale = "default";
    }

    /**
     * Inserimento del valore
     *
     * @param valore da inserire nella lista dei valori
     */
    public void inserisciValore(String valore) {
        valori.add(valore);
    }

    @Override
    public String rilevaVariabile() {
        return valoreAttuale = valori.get(NumeriCasuali.estraiIntero(0, valori.size() - 1));
    }


    /**
     * Getter
     *
     * @return valori
     */
    public List<String> getValori() {
        return valori;
    }

    /**
     * Setter
     *
     * @param valori da modificare
     */
    public void setValori(List<String> valori) {
        this.valori = valori;
    }

    /**
     * Getter
     *
     * @return valore attuale
     */
    public String getValoreAttuale() {
        return valoreAttuale;
    }

    /**
     * Setter
     *
     * @param valoreAttuale valore attuale
     */
    public void setValoreAttuale(String valoreAttuale) {
        this.valoreAttuale = valoreAttuale;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
}