package it.unibs.fp.view.classiDiServizio.regola;

import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.regola.antecedente.Antecedenti;
import it.unibs.fp.model.regola.conseguente.Conseguenti;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.regola.antecedente.ClasseDiServizioAntecedenti;
import it.unibs.fp.view.classiDiServizio.regola.conseguente.ClasseDiServizioConseguenti;

public class ClasseDiServizioRegola {

    /**
     * Crea una nuova regola
     * @param unitaImmobiliare nella quale creare una regola
     * @return una regola
     */
    public static Regola creaRegola(UnitaImmobiliare unitaImmobiliare) {
        Regola regola = new Regola();
        Antecedenti antecedenti = ClasseDiServizioAntecedenti.creaAntecedenti(unitaImmobiliare);
        regola.inserisciAntecedenti(antecedenti);

        Conseguenti conseguenti = ClasseDiServizioConseguenti.creaConseguenti(unitaImmobiliare);
        regola.inserisciConseguenti(conseguenti);

        return regola;
    }

    /**
     * Descrivi stato regola
     *
     * @param regola da visualizzare
     * @return descrizione dello stato della regola
     */
    public static String descriviStatoRegola(Regola regola) {
        StringBuilder str = new StringBuilder();
        str.append("La regola: if");
        str.append(ClasseDiServizioAntecedenti.descriviAntecedenti(regola.getAntecedenti()));
        str.append(" then" + ClasseDiServizioConseguenti.descriviConseguenti(regola.getConseguenti()));
        return str.toString();
    }

    /**
     * Descrizione regola
     *
     * @param regola da visualizzare
     * @return descrizione regola
     */
    public static String toString(Regola regola) {
        StringBuilder str = new StringBuilder();
        str.append(descriviStatoRegola(regola));
        str.append(" ||| questa regola è ");
        if (regola.isAttiva()) {
            return str.append("attiva\n").toString();
        } else return str.append("disattiva\n").toString();
    }
}
