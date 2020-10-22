package it.unibs.fp.view.classiDiServizio.regola.antecedente.costituenteLogico;

import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.operatori.OperatoriRelazionali;
import it.unibs.fp.model.regola.Orologio;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogico;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogicoFactory;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioCategoriaSensori;
import it.unibs.fp.view.classiDiServizio.operatori.ClasseDiServizioOperatoriRelazionali;
import it.unibs.fp.view.classiDiServizio.regola.ClasseDiServizioOrologio;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.MyMenu;

import java.io.Serializable;
import java.util.InputMismatchException;

public class ClasseDiServizioCostituenteLogico implements Serializable {
    public static CostituenteLogico menuCreaCostituenteLogico(CategoriaSensori categoriaS) {
        CostituenteLogico costituenteLogico = null;
        boolean finito = false;
        String[] azione = {"Con info rilevabile", "Con orologio", "Con valore parametrico", "Con valore numerico"};
        MyMenu menu = new MyMenu("Menu creazione COSTITUENTE LOGICO", azione);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("USCITA MENU Costituente Logico");
                }
                break;

                case 1: {
                    costituenteLogico = creaCostituenteLogicoInfoRilevabile(categoriaS);
                }
                break;

                case 2: {
                    costituenteLogico = creaCostituenteLogicoOrologio();
                }
                break;

                case 3: {
                    costituenteLogico = creaCostituenteLogicoParametrico(categoriaS);
                }
                break;

                case 4: {
                    costituenteLogico = creaCostituenteLogicoNumerico(categoriaS);
                }
                break;
            }
        } while (!finito);

        return costituenteLogico;
    }

    private static CostituenteLogico creaCostituenteLogicoNumerico(CategoriaSensori categoriaS) {
        InfoRilevabile primoOpLogico;
        double secondoOpLogico;
        OperatoriRelazionali opRelazionale;
        primoOpLogico=ClasseDiServizioCategoriaSensori.scegliInfoRilevabile(categoriaS);
        opRelazionale = ClasseDiServizioOperatoriRelazionali.sceltaOperatoreRelazionale();
        secondoOpLogico = InputDati.leggiDouble("Inserisci un valore numerico");

        return CostituenteLogicoFactory.creaCostituenteLogico(primoOpLogico, secondoOpLogico, opRelazionale);
    }

    private static CostituenteLogico creaCostituenteLogicoOrologio() {
        Orologio secondoOpLogico;
        OperatoriRelazionali opRelazionale;
        opRelazionale = ClasseDiServizioOperatoriRelazionali.sceltaOperatoreRelazionale();
        secondoOpLogico = ClasseDiServizioOrologio.creaOrologio();

        return CostituenteLogicoFactory.creaCostituenteLogico(secondoOpLogico, opRelazionale);
    }

    public static CostituenteLogico creaCostituenteLogicoInfoRilevabile(CategoriaSensori categoriaS) {
        InfoRilevabile primoOpLogico = null;
        InfoRilevabile secondoOpLogico = null;
        OperatoriRelazionali opRelazionale = null;
        boolean finito;
        do {
            try {
                primoOpLogico = ClasseDiServizioCategoriaSensori.scegliInfoRilevabile(categoriaS);
                opRelazionale = ClasseDiServizioOperatoriRelazionali.sceltaOperatoreRelazionale();
                secondoOpLogico = ClasseDiServizioCategoriaSensori.scegliInfoRilevabile(categoriaS);
                if (primoOpLogico != null && secondoOpLogico != null && primoOpLogico.getType() != secondoOpLogico.getType())
                    throw new InputMismatchException();
                finito = true;
            } catch (InputMismatchException e) {
                System.out.println("Reinserisci, c'è un errore nel tipo delle informazioni rilevabili");
                finito = false;
            }
        } while (!finito);

        return CostituenteLogicoFactory.creaCostituenteLogico(primoOpLogico, secondoOpLogico, opRelazionale);
    }

    public static CostituenteLogico creaCostituenteLogicoParametrico(CategoriaSensori categoriaS) {
        InfoRilevabile primoOpLogico;
        String secondoOpLogico;
        OperatoriRelazionali opRelazionale;
        primoOpLogico = ClasseDiServizioCategoriaSensori.scegliInfoRilevabile(categoriaS);
        opRelazionale = ClasseDiServizioOperatoriRelazionali.sceltaOperatoreRelazionale();
        secondoOpLogico = InputDati.leggiStringaNonVuota("Inserisci un valore parametrico");

        return CostituenteLogicoFactory.creaCostituenteLogico(primoOpLogico, secondoOpLogico, opRelazionale);
    }
}
