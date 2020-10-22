package it.unibs.fp.view.classiDiServizio.regola.antecedente;

import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.regola.antecedente.Antecedenti;
import it.unibs.fp.view.mylib.InputDati;

import java.io.Serializable;

public class ClasseDiServizioAntecedenti implements Serializable {
    public static Antecedenti creaAntecedenti(CategoriaSensori categoriaS) {
        Antecedenti antecedenti = new Antecedenti();
        antecedenti.inserisciAntecedente(ClasseDiServizioAntecedente.creaAntecedenteSingolo(categoriaS));


        while (InputDati.yesOrNo("vuoi continuare ad inserire un nuovo antecedente?")) {
            antecedenti.inserisciAntecedente(ClasseDiServizioAntecedente.creaAntecedenteEnnesimo(categoriaS));
        }
        return antecedenti;
    }
}
