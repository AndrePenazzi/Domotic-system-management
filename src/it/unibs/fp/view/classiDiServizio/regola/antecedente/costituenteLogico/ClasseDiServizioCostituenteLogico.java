package it.unibs.fp.view.classiDiServizio.regola.antecedente.costituenteLogico;

import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.operatori.OperatoriRelazionali;
import it.unibs.fp.model.regola.Orologio;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogico;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogicoFactory;
import it.unibs.fp.view.classiDiServizio.infoRilevabile.ClasseDiServizioInfoRilevabile;
import it.unibs.fp.view.classiDiServizio.operatori.ClasseDiServizioOperatoriRelazionali;
import it.unibs.fp.view.classiDiServizio.regola.ClasseDiServizioOrologio;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.MyMenu;

import java.io.Serializable;
import java.util.InputMismatchException;

public class ClasseDiServizioCostituenteLogico implements Serializable {
    public static CostituenteLogico menuCreaCostituenteLogico() {
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
                    costituenteLogico = creaCostituenteLogicoInfoRilevabile();
                }
                break;

                case 2: {
                    costituenteLogico = creaCostituenteLogicoOrologio();
                }
                break;

                case 3: {
                    costituenteLogico = creaCostituenteLogicoParametrico();
                }
                break;

                case 4: {
                    costituenteLogico = creaCostituenteLogicoNumerico();
                }
                break;
            }
        } while (!finito);

        return costituenteLogico;
    }

    private static CostituenteLogico creaCostituenteLogicoNumerico() {
        InfoRilevabile primoOpLogico;
        double secondoOpLogico;
        OperatoriRelazionali opRelazionale;
        primoOpLogico = ClasseDiServizioInfoRilevabile.menuCreaInfoRilevabile();
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

    public static CostituenteLogico creaCostituenteLogicoInfoRilevabile() {
        InfoRilevabile primoOpLogico = null;
        InfoRilevabile secondoOpLogico = null;
        OperatoriRelazionali opRelazionale = null;
        boolean finito;
        do {
            try {
                primoOpLogico = ClasseDiServizioInfoRilevabile.menuCreaInfoRilevabile();
                opRelazionale = ClasseDiServizioOperatoriRelazionali.sceltaOperatoreRelazionale();
                secondoOpLogico = ClasseDiServizioInfoRilevabile.menuCreaInfoRilevabile();
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

    public static CostituenteLogico creaCostituenteLogicoParametrico() {
        InfoRilevabile primoOpLogico;
        String secondoOpLogico;
        OperatoriRelazionali opRelazionale;
        primoOpLogico = ClasseDiServizioInfoRilevabile.menuCreaInfoRilevabile();
        opRelazionale = ClasseDiServizioOperatoriRelazionali.sceltaOperatoreRelazionale();
        secondoOpLogico = InputDati.leggiStringaNonVuota("Inserisci un valore parametrico");

        return CostituenteLogicoFactory.creaCostituenteLogico(primoOpLogico, secondoOpLogico, opRelazionale);
    }
}
