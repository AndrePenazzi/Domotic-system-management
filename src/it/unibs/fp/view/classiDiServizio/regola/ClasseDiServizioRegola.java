package it.unibs.fp.view.classiDiServizio.regola;

import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.regola.antecedente.Antecedenti;
import it.unibs.fp.view.classiDiServizio.regola.antecedente.ClasseDiServizioAntecedenti;
import it.unibs.fp.view.mylib.InputDati;

public class ClasseDiServizioRegola {

    public static Regola creaRegola(){
        Regola regola= new Regola();
        Antecedenti antecedenti= ClasseDiServizioAntecedenti.creaAntecedenti();
        regola.inserisciAntecedenti(antecedenti);

        do{

        }while(InputDati.yesOrNo("Vuoi inserire altri conseguenti?"));

        return regola;
    }
}
