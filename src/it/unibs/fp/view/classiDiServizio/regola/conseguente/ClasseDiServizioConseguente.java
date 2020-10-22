package it.unibs.fp.view.classiDiServizio.regola.conseguente;

import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.regola.conseguente.Conseguente;
import it.unibs.fp.model.regola.conseguente.azione.Azione;
import it.unibs.fp.view.classiDiServizio.regola.conseguente.azione.ClasseDiServizioAzione;


public class ClasseDiServizioConseguente {
    public static Conseguente creaConseguente(CategoriaAttuatori categoriaA) {
        Azione azione;
        azione = ClasseDiServizioAzione.menuCreaAzione(categoriaA);

        return new Conseguente(azione);
    }

}
