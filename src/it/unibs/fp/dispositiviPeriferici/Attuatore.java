package it.unibs.fp.dispositiviPeriferici;

import it.unibs.fp.categoria.CategoriaAttuatori;
import it.unibs.fp.modalitaOperativa.ModOperativa;

import java.io.Serializable;
import java.util.ArrayList;

public class Attuatore implements Serializable {
    private String nome;
    private CategoriaAttuatori categoriaAttuatori;
    private ModOperativa modOperativa;

    /**
     * Costruttore attuatore
     *
     * @param nome               dell'attuatore
     * @param categoriaAttuatori tipologia di attuatore
     */
    public Attuatore(String nome, CategoriaAttuatori categoriaAttuatori) {
        this.nome = nome;
        this.categoriaAttuatori = categoriaAttuatori;
        this.modOperativa = new ModOperativa("Idle");
    }

    public Attuatore() {
        this.nome="";
        this.categoriaAttuatori=null;
        this.modOperativa = new ModOperativa("Idle");
    }


    /**
     * toString.
     *
     * @return descrizione dell'attuatore.
     */
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n" + nome);
        tmp.append("\n" + categoriaAttuatori);
        tmp.append("\n" + modOperativa);
        return tmp.toString();
    }

    /**
     * Ritorna le categoria a cui l'attuatore appartiene
     *
     * @return categoria dell'attuatore
     */
    public CategoriaAttuatori getCategoriaAttuatori() {
        return categoriaAttuatori;
    }

    /**
     * Setter della categoria a cui l'attuatore appartiene
     *
     * @param categoriaAttuatori tipologia di attuatore
     */
    public void setCategoriaAttuatori(CategoriaAttuatori categoriaAttuatori) {
        this.categoriaAttuatori = categoriaAttuatori;
    }

    /**
     * Getter modalità operativa attuale dell'attuatore
     *
     * @return modalità operativa
     */
    public ModOperativa getModOperativa() {
        return modOperativa;
    }

    /**
     * Setter modalità operativa scelta
     *
     * @param modOperativa tipo di funzionamento
     */
    public void setModOperativa(ModOperativa modOperativa) {
        this.modOperativa = modOperativa;
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


}
