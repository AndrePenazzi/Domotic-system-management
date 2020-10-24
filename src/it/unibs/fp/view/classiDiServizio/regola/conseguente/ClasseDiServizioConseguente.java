package it.unibs.fp.view.classiDiServizio.regola.conseguente;

import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.regola.conseguente.Conseguente;
import it.unibs.fp.model.regola.conseguente.azione.Azione;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.regola.conseguente.azione.ClasseDiServizioAzione;


public class ClasseDiServizioConseguente {
    public static Conseguente creaConseguente(CategoriaAttuatori categoriaA, UnitaImmobiliare unitaImmobiliare) {
        Azione azione;
        azione = ClasseDiServizioAzione.menuCreaAzione(categoriaA, unitaImmobiliare);

        return new Conseguente(azione);
    }

    public static String visualizzaConseguente(Conseguente conseguente){
        StringBuilder str = new StringBuilder();
            str.append(" " + ClasseDiServizioAzione.visualizzaAzione(conseguente.getAzione()));

        return str.toString();
    }

}
