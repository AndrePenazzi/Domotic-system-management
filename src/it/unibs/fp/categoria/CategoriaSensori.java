package it.unibs.fp.categoria;

import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.infoRilevabile.InfoRilevabileNonNumerica;
import it.unibs.fp.infoRilevabile.InfoRilevabileNumerica;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoriaSensori implements Serializable {
    private static final int LUNGHEZZA_MASSIMA = 25;
    private String nome;
    private String testoLibero;
    private ArrayList<InfoRilevabile> informazioniRilevabili;

    /**
     * Costruttore categoria sensori
     *
     * @param nome                   della categoria sensori
     * @param testoLibero            nel quale inserire informazioni varie riguardo la categoria di sensori
     * @param informazioniRilevabili elenco delle informazioni rilevabili
     * @throws IllegalArgumentException il testo libero ha una lunghezza massima
     */
    public CategoriaSensori(String nome, String testoLibero, ArrayList<InfoRilevabile> informazioniRilevabili) throws IllegalArgumentException {
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
    public static int getLunghezzaMassima() {
        return LUNGHEZZA_MASSIMA;
    }

    /**
     * toString
     *
     * @return dati della categoriaSensori
     */
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        tmp.append(nome + "\n");
        tmp.append(testoLibero);

        if (!informazioniRilevabili.isEmpty()) {
            int i = 1;
            tmp.append("\nInformazioni rilevabili:\n");
            for (InfoRilevabile infoRilevabile : informazioniRilevabili) {
                if (infoRilevabile.getType() == 1)
                    tmp.append(i + " " + ((InfoRilevabileNumerica) infoRilevabile).toString());
                else
                    tmp.append(i + " " + ((InfoRilevabileNonNumerica) infoRilevabile).toString());
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora informazioni rilevabili associate\n");
        return tmp.toString();
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
     * Setter
     *
     * @param testoLibero modificato
     */
    public void setTestoLibero(String testoLibero) {
        this.testoLibero = testoLibero;
    }

    /**
     * Getter
     *
     * @return informazioni rilevabili
     */
    public ArrayList<InfoRilevabile> getInformazioniRilevabili() {
        return informazioniRilevabili;
    }

    /**
     * Setter
     *
     * @param informazioniRilevabili dalla categoria di sensori
     */
    public void setInformazioniRilevabili(ArrayList<InfoRilevabile> informazioniRilevabili) {
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

}
