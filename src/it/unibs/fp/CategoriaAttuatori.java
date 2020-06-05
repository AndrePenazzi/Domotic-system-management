package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoriaAttuatori implements Serializable {
    private static final int LUNGHEZZA_MASSIMA = 25;
    private String nome;
    private ArrayList<Attuatore> attuatori;
    private String testoLibero;
    private ArrayList<ModalitaOperativa> modalitaOperative = new ArrayList<>();

    public CategoriaAttuatori(String nome, String testoLibero, ArrayList<ModalitaOperativa> modalitaOperative) throws IllegalArgumentException {
        this.nome = nome;
        this.attuatori = new ArrayList<>();
        if (testoLibero.length() > LUNGHEZZA_MASSIMA)
            throw new IllegalArgumentException("Il testo non può contenere più di " + LUNGHEZZA_MASSIMA + " caratteri.");
        this.testoLibero = testoLibero;
        this.modalitaOperative.add(new ModalitaOperativa("Idle"));
        this.modalitaOperative = modalitaOperative;
    }

    public static int getLunghezzaMassima() {
        return LUNGHEZZA_MASSIMA;
    }

    public String getTestoLibero() {
        return testoLibero;
    }

    public ArrayList<ModalitaOperativa> getModalitaOperative() {
        return modalitaOperative;
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
     * @return attuatori.
     */
    public ArrayList<Attuatore> getAttuatori() {
        return attuatori;
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
