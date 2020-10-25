package it.unibs.fp.view.classiDiServizio.regola;

import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.regola.antecedente.Antecedenti;
import it.unibs.fp.model.regola.conseguente.Conseguenti;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.regola.antecedente.ClasseDiServizioAntecedenti;
import it.unibs.fp.view.classiDiServizio.regola.conseguente.ClasseDiServizioConseguenti;

public class ClasseDiServizioRegola {

    public static Regola creaRegola(UnitaImmobiliare unitaImmobiliare) {
        Regola regola = new Regola();
        Antecedenti antecedenti = ClasseDiServizioAntecedenti.creaAntecedenti(unitaImmobiliare);
        regola.inserisciAntecedenti(antecedenti);

        Conseguenti conseguenti = ClasseDiServizioConseguenti.creaConseguenti(unitaImmobiliare);
        regola.inserisciConseguenti(conseguenti);

        return regola;
    }

    public static String visualizzaStatoRegola(Regola regola) {
        StringBuilder str = new StringBuilder();
        str.append("La regola:");
        str.append("if " + ClasseDiServizioAntecedenti.visualizzaAntecedenti(regola.getAntecedenti()));
        str.append(" then " + ClasseDiServizioConseguenti.visualizzaConseguenti(regola.getConseguenti()));
        return str.toString();

    }

    public static String toString(Regola regola) {
        StringBuilder str = new StringBuilder();
        toString(regola);
        str.append(" è ");
        if (regola.isAttiva()) {
            return str.append("attiva\n").toString();
        } else return str.append("disattiva\n").toString();
    }
}
