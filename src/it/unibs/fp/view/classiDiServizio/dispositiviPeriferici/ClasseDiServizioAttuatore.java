package it.unibs.fp.view.classiDiServizio.dispositiviPeriferici;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioAttuatore {
    /**
     * Crea un nuovo attuatore
     *
     * @param listaCategorie per scegliere la tipologia di attuatori da creare
     * @return un nuovo attuatore
     */
    public static Attuatore creaAttuatore(ListaCategorie listaCategorie) {
        if (listaCategorie.getSizeCategorieAttuatori() != 0) {
            System.out.println(listaCategorie.visualizzaCategorieAttuatori());
            int categoria = InputDati.leggiIntero("Scegli categoria : ", 1, listaCategorie.getSizeCategorieAttuatori());
            categoria--;
            String nome = InputDati.leggiStringaNonVuota("Inserisci nome attuatore : ");
            nome += "_" + listaCategorie.getCategorieAttuatori().get(categoria).getNome();
            System.out.println("Si è creato l'attuatore " + nome);
            return new Attuatore(nome, listaCategorie.getCategorieAttuatori().get(categoria));
        }
        System.out.println("Creare almeno una categoria attuatori");
        return null;
    }



    public static String toString(Attuatore attuatore) {
        String nome = attuatore.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append("\n" + nome);
        tmp.append("\n" + attuatore.getCategoriaAttuatori());
        tmp.append("\n" + attuatore.getModOperativa());
        return tmp.toString();
    }
}
