package it.unibs.fp.dispositiviPeriferici;

import it.unibs.fp.categoria.CategoriaSensori;
import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.infoRilevabile.InfoRilevabileNonNumerica;
import it.unibs.fp.infoRilevabile.InfoRilevabileNumerica;

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

    public Sensore() {
        this.nome="";
        this.categoriaSensori = new CategoriaSensori();
    }


    /**
     * Genera un numero casuale tra il minimo e il massimo della categoriaSensori
     *
     * @return misura
     */
    public String rilevaVariabileFisica() {
        for(InfoRilevabile infoRilevabile : categoriaSensori.getInformazioniRilevabili()) {
            System.err.println("hey man");
            if (categoriaSensori.getInformazioniRilevabili().get(0).getType() == 1)
                return String.valueOf(((InfoRilevabileNumerica) infoRilevabile).rilevaVariabile());
            if (categoriaSensori.getInformazioniRilevabili().get(0).getType() == 2)
                return String.valueOf(((InfoRilevabileNonNumerica) infoRilevabile).rilevaVariabile());
        }
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
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n");
        tmp.append(nome);
        tmp.append("\n");
        tmp.append(categoriaSensori);
        return tmp.toString();
    }

}
