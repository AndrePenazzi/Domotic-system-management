package it.unibs.fp.model.categoria;

import it.unibs.fp.model.infoRilevabile.InfoRilevabile;

import java.io.Serializable;
import java.util.List;

public class CategoriaSensori implements Serializable {
    private static final int LUNGHEZZA_MASSIMA = 50;
    private String nome;
    private String testoLibero;
    private List<InfoRilevabile> informazioniRilevabili;

    /**
     * Costruttore categoria sensori
     *
     * @param nome                   della categoria sensori
     * @param testoLibero            nel quale inserire informazioni varie riguardo la categoria di sensori
     * @param informazioniRilevabili elenco delle informazioni rilevabili
     * @throws IllegalArgumentException il testo libero ha una lunghezza massima
     */
    public CategoriaSensori(String nome, String testoLibero, List<InfoRilevabile> informazioniRilevabili) throws IllegalArgumentException {
        this.nome = nome;
        if (testoLibero.length() > LUNGHEZZA_MASSIMA)
            throw new IllegalArgumentException("Il testo non può contenere più di " + LUNGHEZZA_MASSIMA + " caratteri.");
        this.testoLibero = testoLibero;
        this.informazioniRilevabili = informazioniRilevabili;

        if (informazioniRilevabili.isEmpty())
            throw new IllegalArgumentException("Deve esserci almeno un'informazione rilevabile.");
    }

    /**
     * Getter
     *
     * @return la lunghezza massima
     */
    public int getLunghezzaMassima() {
        return LUNGHEZZA_MASSIMA;
    }

    /**
     * Getter
     *
     * @return testo libero
     */
    public String getTestoLibero() {
        return testoLibero;
    }

    /**
     * Getter
     *
     * @return informazioni rilevabili
     */
    public List<InfoRilevabile> getInformazioniRilevabili() {
        return informazioniRilevabili;
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return informazione rilevabile alla posizione i
     */
    public InfoRilevabile getInformazioneRilevabile(int i) {
        return informazioniRilevabili.get(i);
    }

    /**
     * Getter
     *
     * @return size di informazioni rilevabili
     */
    public int getSizeInformazioniRilevabili() {
        return informazioniRilevabili.size();
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

}
