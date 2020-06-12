package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoriaAttuatori implements Serializable {
    private static final int LUNGHEZZA_MASSIMA = 25;
    private String nome;
    private String testoLibero;
    private ArrayList<ModOperativa> modalitaOperative = new ArrayList<>();

    /**
     * Costruttore
     *
     * @param nome              della categoria attuatori
     * @param testoLibero       nel quale inserire informazioni varie riguardo la categoria di attuatori
     * @param modalitaOperative elenco delle modalità operative
     * @throws IllegalArgumentException il testo libero ha una lunghezza massima
     */
    public CategoriaAttuatori(String nome, String testoLibero, ArrayList<ModOperativa> modalitaOperative) throws IllegalArgumentException {
        this.nome = nome;
        if (testoLibero.length() > LUNGHEZZA_MASSIMA)
            throw new IllegalArgumentException("Il testo non può contenere più di " + LUNGHEZZA_MASSIMA + " caratteri.");
        this.testoLibero = testoLibero;
        this.modalitaOperative.add(new ModOperativa("Idle"));
        this.modalitaOperative = modalitaOperative;
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
     * @return testo libero
     */
    public String getTestoLibero() {
        return testoLibero;
    }

    /**
     * Getter
     *
     * @return modalità operativa
     */
    public ArrayList<ModOperativa> getModalitaOperative() {
        return modalitaOperative;
    }

    /**
     * toString
     *
     * @return dati della categoriaAtturatori
     */
    @Override
    public String toString() {
        return "CategoriaAttuatori:\n" +
                "nome='" + nome +
                ", testoLibero='" + testoLibero +
                ", modalitaOperative=" + modalitaOperative;
    }


}
