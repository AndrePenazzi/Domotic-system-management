package it.unibs.fp;

import java.io.Serializable;

public class Attuatore implements Serializable {
    private String nome;
    private CategoriaAttuatori categoriaAttuatori;

    /**
     * Costruttore attuatore
     *
     * @param nome               dell'attuatore
     * @param categoriaAttuatori tipologia di attuatore
     */
    public Attuatore(String nome, CategoriaAttuatori categoriaAttuatori) {
        this.nome = nome;
        this.categoriaAttuatori = categoriaAttuatori;
    }

    /**
     * Getter.
     *
     * @return name.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter.
     *
     * @param nome dell'attuatore.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * toString.
     *
     * @return descrizione dell'attuatore.
     */
    @Override
    public String toString() {
        return "Attuatore:\n" +
                "nome='" + nome +
                ", categoriaAttuatori=" + categoriaAttuatori;
    }

}
