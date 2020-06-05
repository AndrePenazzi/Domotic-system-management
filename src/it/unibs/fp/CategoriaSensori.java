package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

//TODO c'è un attributo descrizione in generalità da rivedere
public class CategoriaSensori implements Serializable {
    private static final int LUNGHEZZA_MASSIMA = 25;
    private String nome;
    private ArrayList<Sensore> sensori;
    private String testoLibero;
    private ArrayList<InformazioneRilevabile> informazioniRilevabili;


    /**
     * Costruttore categoria sensori
     */
    public CategoriaSensori(String nome, String testoLibero, ArrayList<InformazioneRilevabile> informazioniRilevabili) throws IllegalArgumentException {
        this.nome = nome;
        this.sensori = new ArrayList<>();
        if (testoLibero.length() > LUNGHEZZA_MASSIMA)
            throw new IllegalArgumentException("Il testo non può contenere più di " + LUNGHEZZA_MASSIMA + " caratteri.");
        this.testoLibero = testoLibero;
        this.informazioniRilevabili = informazioniRilevabili;

        if (informazioniRilevabili.isEmpty())
            throw new IllegalArgumentException("Deve esserci almeno un'informazione rilevabile.");


    }

    public String getTestoLibero() {
        return testoLibero;
    }

    public void setTestoLibero(String testoLibero) {
        this.testoLibero = testoLibero;
    }

    public ArrayList<InformazioneRilevabile> getInformazioniRilevabili() {
        return informazioniRilevabili;
    }

    public void setInformazioniRilevabili(ArrayList<InformazioneRilevabile> informazioniRilevabili) {
        this.informazioniRilevabili = informazioniRilevabili;
    }

    /**
     * Getter
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter
     *
     * @param nome modificato.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter
     *
     * @return sensori.
     */
    public ArrayList<Sensore> getSensori() {
        return sensori;
    }

    public void setSensori(ArrayList<Sensore> sensori) {
        this.sensori = sensori;
    }

    /**
     * toString
     *
     * @return descrizione categoria attuatori
     */
    public String toString() {
        return "Categoria sensori: nome=" + nome + ".\n";
    }

}
