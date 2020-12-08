package it.unibs.fp.model.modalitaOperativa;

import java.util.List;

public class ModOperativaParametrica implements ModOperativa {
    private List<String> paramentri;
    private String parametroAttuale;
    private String nome;
    /**
     * Costruttore
     *
     * @param nome       della modalità operativa
     * @param paramentri scelti
     */
    public ModOperativaParametrica(String nome, List<String> paramentri) {
        this.nome = nome;
        this.paramentri = paramentri;
    }

    /**
     * Getter
     *
     * @return parametri
     */
    public List<String> getParamentri() {
        return paramentri;
    }

    /**
     * Setter
     *
     * @param paramentri da modificare
     */
    public void setParamentri(List<String> paramentri) {
        this.paramentri = paramentri;
    }

    /**
     * Getter
     *
     * @return size di parametri
     */
    public int getSizeParamentri() {
        return paramentri.size();
    }

    /**
     * Getter
     *
     * @param i posizione
     * @return parametro alla posizione i
     */
    public String getParametro(int i) {
        return paramentri.get(i);
    }

    /**
     * Getter
     *
     * @return parametroAttuale
     */
    public String getParametroAttuale() {
        return parametroAttuale;
    }

    /**
     * Setter
     *
     * @param parametroAttuale da modificare
     */
    public void setParametroAttuale(String parametroAttuale) {
        this.parametroAttuale = parametroAttuale;
    }


    /**
     * Getter
     *
     * @return nome
     */
    @Override
    public String getNome() {
        return nome;
    }

    /**
     * Setter
     *
     * @param nome da modificare
     */
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
}
