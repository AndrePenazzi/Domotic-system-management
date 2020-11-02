package it.unibs.fp.model.dispositiviPeriferici;

import it.unibs.fp.model.categoria.CategoriaSensori;

import java.io.Serializable;

public class Sensore implements Serializable {
    private String nome;
    private CategoriaSensori categoriaSensori;

    /**
     * Costruttore sensore
     *
     * @param nome             del sensore
     * @param categoriaSensori tipologia di sensore
     */
    public Sensore(String nome, CategoriaSensori categoriaSensori) {
        this.nome = nome;
        this.categoriaSensori = categoriaSensori;
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
     * @param nome del sensore.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter
     *
     * @return CategoriaSensori
     */
    public CategoriaSensori getCategoriaSensori() {
        return categoriaSensori;
    }

    /**
     * Setter
     *
     * @param categoriaSensori da sostituire
     */
    public void setCategoriaSensori(CategoriaSensori categoriaSensori) {
        this.categoriaSensori = categoriaSensori;
    }


}
