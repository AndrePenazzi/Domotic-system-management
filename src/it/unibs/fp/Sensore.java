package it.unibs.fp;

import java.io.Serializable;

public class Sensore implements Serializable {
    private String nome;
    private CategoriaSensori categoriaSensori;

    /**
     * Costruttore sensore
     *
     * @param nome del sensore
     * @param categoriaSensori tipologia di sensore
     */
    public Sensore(String nome, CategoriaSensori categoriaSensori) {
        this.nome = nome;
        this.categoriaSensori = categoriaSensori;
    }


    /**
     * Genera un numero casuale tra il minimo e il massimo della categoriaSensori
     *
     * @return misura
     */
//TODO CAMBIATO
    public String rilevaVariabileFisica() {
        InfoRilevabile infoRilevabile = categoriaSensori.getInformazioniRilevabili().get(0);
        if(categoriaSensori.getInformazioniRilevabili().get(0).getType()==0)
            return String.valueOf(((InfoRilevabileNumerica)infoRilevabile).rilevaVariabile());
        if(categoriaSensori.getInformazioniRilevabili().get(0).getType()==1)
            return String.valueOf(((InfoRilevabileNonNumerica)infoRilevabile).rilevaVariabile());
        return "C'è stato qualche errore";
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

    /**
     * toString.
     *
     * @return descrizione del sensore.
     */
    @Override
    public String toString() {
        return "Sensore:\n" +
                "nome='" + nome +
                ", categoriaSensori=" + categoriaSensori;
    }

}
