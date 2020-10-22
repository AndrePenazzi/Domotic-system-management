package it.unibs.fp.view.classiDiServizio.regola.conseguente.azione;

import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import it.unibs.fp.model.regola.conseguente.azione.Azione;
import it.unibs.fp.model.regola.Orologio;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioCategoriaAttuatori;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioAttuatore;
import it.unibs.fp.view.classiDiServizio.modalitaOperativa.ClasseDiServizioModOperativa;
import it.unibs.fp.view.classiDiServizio.regola.ClasseDiServizioOrologio;
import it.unibs.fp.view.mylib.MyMenu;


public class ClasseDiServizioAzione {
    public static Azione menuCreaAzione(CategoriaAttuatori categoriaA) {
        Azione azione = null;
        boolean finito = false;
        String[] azione_menu = {"Azione base", "Con orologio"};
        MyMenu menu = new MyMenu("Menu creazione AZIONE", azione_menu);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("USCITA MENU Azione");
                }
                break;

                case 1: {
                    azione = creaAzioneBase(categoriaA);
                }
                break;

                case 2: {
                    azione = creaAzioneOrologio(categoriaA);
                }
                break;
            }
        } while (!finito);

        return azione;
    }

    private static Azione creaAzioneOrologio(CategoriaAttuatori categoriaA) {
        Attuatore attuatore;
        ModOperativa modOperativa;
        Orologio start;
        attuatore = ClasseDiServizioAttuatore.scegliAttuatore();
        modOperativa = ClasseDiServizioCategoriaAttuatori.scegliModOperativa(categoriaA);
        start = ClasseDiServizioOrologio.creaOrologio();

        return new Azione(attuatore, modOperativa, start);
    }

    public static Azione creaAzioneBase(CategoriaAttuatori categoriaA) {
        Attuatore attuatore;
        ModOperativa modOperativa;
        attuatore = ClasseDiServizioAttuatore.scegliAttuatore();
        modOperativa = ClasseDiServizioCategoriaAttuatori.scegliModOperativa(categoriaA);

        return new Azione(attuatore, modOperativa);
    }
}
