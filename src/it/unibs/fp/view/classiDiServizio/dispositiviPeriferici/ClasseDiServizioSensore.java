package it.unibs.fp.view.classiDiServizio.dispositiviPeriferici;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioCategoriaSensori;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioListaCategorie;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioSensore {
    public static Sensore creaSensore(ListaCategorie listaCategorie) {
        System.out.println(ClasseDiServizioListaCategorie.visualizzaCategorieSensori(listaCategorie));
        int categoria = InputDati.leggiIntero("Scegli categoria : ", 1, listaCategorie.getSizeCategorieSensori());
        categoria--;
        String nome = InputDati.leggiStringaNonVuota("Inserisci nome sensore : ");
        nome += "_" + listaCategorie.getCategorieSensori().get(categoria).getNome() + ": ";
        System.out.println("Si è creato il sensore " + nome);
        return new Sensore(nome, listaCategorie.getCategorieSensori().get(categoria));

    }

    public static String visualizzaInfoRilevabili(Sensore sensore) {
        String nome = sensore.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n");
        tmp.append(nome);
        tmp.append("\n");
        tmp.append(ClasseDiServizioCategoriaSensori.visualizzaInfoRilevabiliNonNumerate(sensore.getCategoriaSensori()));
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

    public static String toString(Sensore sensore) {
        String nome = sensore.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n");
        tmp.append(nome);
        tmp.append("\n");
        tmp.append(sensore.getCategoriaSensori());
        return tmp.toString();

    }
}
