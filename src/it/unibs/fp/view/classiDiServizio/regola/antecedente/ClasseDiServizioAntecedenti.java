package it.unibs.fp.view.classiDiServizio.regola.antecedente;

import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.regola.antecedente.Antecedenti;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.mylib.InputDati;

import java.io.Serializable;

public class ClasseDiServizioAntecedenti implements Serializable {
    public static Antecedenti creaAntecedenti(UnitaImmobiliare unitaImmobiliare) {
        Antecedenti antecedenti = new Antecedenti();
        antecedenti.inserisciAntecedente(ClasseDiServizioAntecedente.creaAntecedenteSingolo(unitaImmobiliare));

        while (InputDati.yesOrNo("vuoi continuare ad inserire un nuovo antecedente?")) {
            antecedenti.inserisciAntecedente(ClasseDiServizioAntecedente.creaAntecedenteEnnesimo(unitaImmobiliare));
        }
        return antecedenti;
    }

    public static String visualizzaAntecedenti(Antecedenti antecedenti) {
        StringBuilder str = new StringBuilder();
        str.append(ClasseDiServizioAntecedente.visualizzaAntecedenteSingolo(antecedenti.getAntecendenti().get(0)));
        for (int i = 1; i < antecedenti.getAntecendenti().size(); i++) {
            str.append(" " + ClasseDiServizioAntecedente.visualizzaAntecedenteEnnesimo(antecedenti.getAntecendenti().get(i)));
        }
        return str.toString();
    }
}
