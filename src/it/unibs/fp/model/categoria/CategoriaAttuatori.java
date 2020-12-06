package it.unibs.fp.model.categoria;

import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import it.unibs.fp.model.modalitaOperativa.ModOperativaNonParametrica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoriaAttuatori implements Serializable {
    private static final int LUNGHEZZA_MASSIMA = 30;
    private String nome;
    private final String testoLibero;
    private List<ModOperativa> modalitaOperative = new ArrayList<>();

    /**
     * Costruttore
     *
     * @param nome              della categoria attuatori
     * @param testoLibero       nel quale inserire informazioni varie riguardo la categoria di attuatori
     * @param modalitaOperative elenco delle modalità operative
     * @throws IllegalArgumentException il testo libero ha una lunghezza massima
     */
    public CategoriaAttuatori(String nome, String testoLibero, List<ModOperativa> modalitaOperative) throws IllegalArgumentException {
        this.nome = nome;
        if (testoLibero.length() > LUNGHEZZA_MASSIMA)
            throw new IllegalArgumentException("Il testo non può contenere più di " + LUNGHEZZA_MASSIMA + " caratteri.");
        this.testoLibero = testoLibero;
        this.modalitaOperative.add(new ModOperativaNonParametrica("Idle"));
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
    public List<ModOperativa> getModalitaOperative() {
        return modalitaOperative;
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return posizione della modalità operativa
     */
    public ModOperativa getModalitaOperativa(int i) {
        return modalitaOperative.get(i);
    }

    /**
     * Getter
     *
     * @return size di ModalitaOperative
     */
    public int getSizeModalitaOperative() {
        return modalitaOperative.size();
    }

    /**
     * Controlla se il nome di catSen è uguale al nome di questa categoria sensori
     *
     * @param catAtt da controllare
     * @return true se è uguale false altrimenti
     */
    public boolean controlloOmonimia(CategoriaAttuatori catAtt) {
        return catAtt.getNome().equals(nome);
    }
}
