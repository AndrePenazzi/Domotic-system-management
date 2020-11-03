package it.unibs.fp.view.classiDiServizio.dispositiviPeriferici;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioCategoriaSensori;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioListaCategorie;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioSensore {
    /**
     * Creatore di sensori
     *
     * @param listaCategorie per la creazione di sensori
     * @return il sensore creato
     */
    public static Sensore creaSensore(ListaCategorie listaCategorie) {
        System.out.println(ClasseDiServizioListaCategorie.descrizioneNomeCategorieSensori(listaCategorie));
        int categoria = InputDati.leggiIntero("Scegli categoria : ", 1, listaCategorie.getSizeCategorieSensori());
        categoria--;
        String nome = InputDati.leggiStringaNonVuota("Inserisci nome sensore : ");
        nome += "_" + listaCategorie.getNomeCategoriaSensori(categoria);
        System.out.println("Si è creato il sensore " + nome + "\n");
        return new Sensore(nome, listaCategorie.getCategoriaSensori(categoria));

    }

    public static String visualizzaInfoRilevabili(Sensore sensore) {
        String nome = sensore.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n");
        tmp.append(nome);
        tmp.append("\n");
        tmp.append(ClasseDiServizioCategoriaSensori.descrizioneInfoRilevabiliNonNumerate(sensore.getCategoriaSensori()));
        return tmp.toString();
    }

    public static String visualizzaValoreRilevato(Sensore sensore) {
        String nome = sensore.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n");
        tmp.append(nome);
        tmp.append("\n");
        tmp.append(ClasseDiServizioCategoriaSensori.visualizzaValoreRilevato(sensore.getCategoriaSensori()));
        return tmp.toString();
    }

    /**
     * toString
     *
     * @param sensore da visualizzare
     * @return descrizione del sensore
     */
    public static String toString(Sensore sensore) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(sensore.getNome());
        tmp.append("\n");
        tmp.append(ClasseDiServizioCategoriaSensori.toString(sensore.getCategoriaSensori()));
        return tmp.toString();

    }
}
