package it.unibs.fp.view.classiDiServizio.dispositiviPeriferici;

import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioCategoriaAttuatori;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioListaCategorie;
import it.unibs.fp.view.classiDiServizio.modalitaOperativa.ClasseDiServizioModOperativa;
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
            System.out.println(ClasseDiServizioListaCategorie.descrizioneNomeCategorieAttuatori(listaCategorie));
            int categoria = InputDati.leggiIntero("Scegli categoria : ", 1, listaCategorie.getSizeCategorieAttuatori());
            categoria--;
            String nome = InputDati.leggiStringaNonVuota("Inserisci nome attuatore : ");
            nome += "_" + listaCategorie.getNomeCategoriaAttuatori(categoria);
            System.out.println("Si è creato l'attuatore " + nome);
            return new Attuatore(nome, listaCategorie.getCategoriaAttuatori(categoria));
        }
        System.out.println("Creare almeno una categoria attuatori");
        return null;
    }

    public static void modificaModOperativa(Attuatore attuatore) {
        String nome = attuatore.getNome();
        System.out.println(nome);
        ClasseDiServizioCategoriaAttuatori.modificaModOperativa(attuatore.getCategoriaAttuatori());
    }

    /**
     * toString
     *
     * @param attuatore da visualizzare
     * @return descrizione attuatore
     */
    public static String toString(Attuatore attuatore) {
        String nome = attuatore.getNome();
        StringBuilder tmp = new StringBuilder();
        tmp.append(nome);
        tmp.append("\n" + ClasseDiServizioCategoriaAttuatori.toString(attuatore.getCategoriaAttuatori()));
        tmp.append("\n" + ClasseDiServizioModOperativa.toString(attuatore.getModOperativa()));
        return tmp.toString();
    }
}
