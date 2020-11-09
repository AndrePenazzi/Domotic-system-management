package it.unibs.fp.view.classiDiServizio.regola.conseguente;

import it.unibs.fp.model.regola.conseguente.Conseguente;
import it.unibs.fp.model.regola.conseguente.azione.Azione;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.regola.conseguente.azione.ClasseDiServizioAzione;


public class ClasseDiServizioConseguente {
    public static Conseguente creaConseguente(UnitaImmobiliare unitaImmobiliare) {
        Azione azione;
        azione = ClasseDiServizioAzione.menuCreaAzione(unitaImmobiliare);

        return new Conseguente(azione);
    }

    /**
     * Descrivi conseguente
     *
     * @param conseguente da visualizzare
     * @return descrizione conseguente
     */
    public static String descriviConseguente(Conseguente conseguente) {
        StringBuilder str = new StringBuilder();
        str.append(" " + ClasseDiServizioAzione.descriviAzione(conseguente.getAzione()));

        return str.toString();
    }

}
