package it.unibs.fp.view.classiDiServizio.regola.antecedente.costituenteLogico;

import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.operatori.OperatoriRelazionali;
import it.unibs.fp.model.regola.Orologio;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogico;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogicoFactory;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioCategoriaSensori;
import it.unibs.fp.view.classiDiServizio.infoRilevabile.ClasseDiServizioInfoRilevabile;
import it.unibs.fp.view.classiDiServizio.operatori.ClasseDiServizioOperatoriRelazionali;
import it.unibs.fp.view.classiDiServizio.regola.ClasseDiServizioOrologio;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioUnitaImmobiliare;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.MyMenu;

import java.io.Serializable;
import java.util.InputMismatchException;

public class ClasseDiServizioCostituenteLogico implements Serializable {

    /**
     * Menu per creare un costituente logico
     *
     * @param unitaImmobiliare per permettere la creazione del costituente logico
     * @return un costituente logico
     */
    public static CostituenteLogico menuCreaCostituenteLogico(UnitaImmobiliare unitaImmobiliare) {
        CostituenteLogico costituenteLogico = null;
        String[] azione = {"Con info rilevabile", "Con orologio", "Con valore parametrico", "Con valore numerico"};
        MyMenu menu = new MyMenu("Menu creazione COSTITUENTE LOGICO", azione);
        int scelta = menu.scegliPerMenuSenzaUscita();
        switch (scelta) {
            case 1: {
                costituenteLogico = creaCostituenteLogicoInfoRilevabile(unitaImmobiliare);
            }
            break;

            case 2: {
                costituenteLogico = creaCostituenteLogicoOrologio();
            }
            break;

            case 3: {
                costituenteLogico = creaCostituenteLogicoParametrico(unitaImmobiliare);
            }
            break;

            case 4: {
                costituenteLogico = creaCostituenteLogicoNumerico(unitaImmobiliare);
            }
            break;
        }

        return costituenteLogico;
    }

    /**
     * Crea costituente logico numerico
     *
     * @param unitaImmobiliare per scelta sensore
     * @return costituente logico
     */
    private static CostituenteLogico creaCostituenteLogicoNumerico(UnitaImmobiliare unitaImmobiliare) {
        Sensore sensore = ClasseDiServizioUnitaImmobiliare.scegliSensore(unitaImmobiliare);
        InfoRilevabile primoOpLogico;
        double secondoOpLogico;
        OperatoriRelazionali opRelazionale;
        primoOpLogico = ClasseDiServizioCategoriaSensori.scegliInfoRilevabile(sensore.getCategoriaSensori());
        opRelazionale = ClasseDiServizioOperatoriRelazionali.sceltaOperatoreRelazionale();
        secondoOpLogico = InputDati.leggiDouble("Inserisci un valore numerico: ");

        return CostituenteLogicoFactory.creaCostituenteLogico(primoOpLogico, secondoOpLogico, opRelazionale);
    }

    /**
     * Crea costituente logico orologio
     *
     * @return costituente logico creato
     */
    private static CostituenteLogico creaCostituenteLogicoOrologio() {
        Orologio secondoOpLogico;
        OperatoriRelazionali opRelazionale;
        opRelazionale = ClasseDiServizioOperatoriRelazionali.sceltaOperatoreRelazionale();
        secondoOpLogico = ClasseDiServizioOrologio.creaOrologio();

        return CostituenteLogicoFactory.creaCostituenteLogico(secondoOpLogico, opRelazionale);
    }

    /**
     * Crea costituente logico info rilevabile
     *
     * @param unitaImmobiliare per la creazione del costituente logico
     * @return costituente logico
     */
    public static CostituenteLogico creaCostituenteLogicoInfoRilevabile(UnitaImmobiliare unitaImmobiliare) {
        Sensore sensore = ClasseDiServizioUnitaImmobiliare.scegliSensore(unitaImmobiliare);
        InfoRilevabile primoOpLogico = null;
        InfoRilevabile secondoOpLogico = null;
        OperatoriRelazionali opRelazionale = null;
        boolean finito;
        do {
            try {
                primoOpLogico = ClasseDiServizioCategoriaSensori.scegliInfoRilevabile(sensore.getCategoriaSensori());
                opRelazionale = ClasseDiServizioOperatoriRelazionali.sceltaOperatoreRelazionale();
                secondoOpLogico = ClasseDiServizioCategoriaSensori.scegliInfoRilevabile(sensore.getCategoriaSensori());
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

    /**
     * CreaCostituenteLogicoParametrico
     *
     * @param unitaImmobiliare per la creazione del costituente logico
     * @return costituente logico
     */
    public static CostituenteLogico creaCostituenteLogicoParametrico(UnitaImmobiliare unitaImmobiliare) {
        Sensore sensore = ClasseDiServizioUnitaImmobiliare.scegliSensore(unitaImmobiliare);
        InfoRilevabile primoOpLogico;
        String secondoOpLogico;
        OperatoriRelazionali opRelazionale;
        primoOpLogico = ClasseDiServizioCategoriaSensori.scegliInfoRilevabile(sensore.getCategoriaSensori());
        opRelazionale = ClasseDiServizioOperatoriRelazionali.sceltaOperatoreRelazionale();
        secondoOpLogico = InputDati.leggiStringaNonVuota("Inserisci un valore parametrico: ");

        return CostituenteLogicoFactory.creaCostituenteLogico(primoOpLogico, secondoOpLogico, opRelazionale);
    }

    /**
     * Descrivi costituente logico
     *
     * @param costituenteLogico da visualizzare
     * @return la descrizione del costituente logico
     */
    public static String descriviCostituenteLogico(CostituenteLogico costituenteLogico) {
        InfoRilevabile primoOperatoreLogico = costituenteLogico.getPrimoOperatoreLogico();
        InfoRilevabile secondoOperatoreLogico = costituenteLogico.getSecondoOperatoreLogico();
        OperatoriRelazionali operatoreRelazionale = costituenteLogico.getOperatoreRelazionale();
        Double secondoOperatoreCostante = costituenteLogico.getSecondoOperatoreCostante();
        String secondoOperatoreScalare = costituenteLogico.getSecondoOperatoreScalare();
        Orologio oraAttuale = ClasseDiServizioOrologio.creaOraAttuale();
        Orologio secondoOperatoreOrologio = costituenteLogico.getSecondoOperatoreOrologio();

        StringBuilder tmp = new StringBuilder();
        if (primoOperatoreLogico != null && operatoreRelazionale != null) {
            tmp.append(primoOperatoreLogico.getNome()).append(" ").append(operatoreRelazionale.getValue());

            if (secondoOperatoreLogico != null)
                tmp.append(" " + ClasseDiServizioInfoRilevabile.descriviSoloValoreRilevato(secondoOperatoreLogico));
            if (secondoOperatoreCostante != null)
                tmp.append(" " + secondoOperatoreCostante);
            if (secondoOperatoreScalare != null)
                tmp.append(" " + secondoOperatoreScalare);
        } else if (secondoOperatoreOrologio != null && operatoreRelazionale != null) {
            tmp.append(ClasseDiServizioOrologio.toString(oraAttuale)).append(" ");
            tmp.append(operatoreRelazionale.getValue()).append(" " + ClasseDiServizioOrologio.toString(secondoOperatoreOrologio));
        }
        return tmp.toString();
    }

}
