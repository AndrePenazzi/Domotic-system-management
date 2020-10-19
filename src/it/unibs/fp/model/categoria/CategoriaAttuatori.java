package it.unibs.fp.model.categoria;

import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import it.unibs.fp.model.modalitaOperativa.ModOperativaNonParamentrica;
import it.unibs.fp.model.modalitaOperativa.ModOperativaParamentrica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoriaAttuatori implements Serializable {
    private static final int LUNGHEZZA_MASSIMA = 30;
    private String nome;
    private String testoLibero;
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
        this.modalitaOperative.add(new ModOperativaNonParamentrica("Idle"));
        this.modalitaOperative = modalitaOperative;
    }

    public CategoriaAttuatori() {
        this.nome="";
        this.testoLibero="";
        this.modalitaOperative = new ArrayList<>();
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
     * @return dati della categoriaAtturatori
     */
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n" + nome);
        tmp.append("\n" + testoLibero);

        if (!modalitaOperative.isEmpty()) {
            int i = 1;
            tmp.append("\nModalità operative:\n");
            for (ModOperativa modOperativa : modalitaOperative) {
                if (modOperativa.getType() == 1)
                    tmp.append(i + " " + ((ModOperativaNonParamentrica) modOperativa).toString());
                else
                    tmp.append(i + " " + ((ModOperativaParamentrica) modOperativa).toString());
                i++;
            }
        } else
            tmp.append("\nNon ci sono ancora modalità operative associate");
        return tmp.toString();
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
}
