package it.unibs.fp.model.dispositiviPeriferici;

import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import it.unibs.fp.model.modalitaOperativa.ModOperativaNonParamentrica;

import java.io.Serializable;

public class    Attuatore implements Serializable {
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
        this.modOperativa = new ModOperativaNonParamentrica("Idle");
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
