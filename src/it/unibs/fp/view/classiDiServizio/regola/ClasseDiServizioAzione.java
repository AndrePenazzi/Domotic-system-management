package it.unibs.fp.view.classiDiServizio.regola;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import it.unibs.fp.model.operatori.OperatoriRelazionali;
import it.unibs.fp.model.regola.Azione;
import it.unibs.fp.model.regola.Orologio;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogico;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogicoFactory;
import it.unibs.fp.view.classiDiServizio.infoRilevabile.ClasseDiServizioInfoRilevabile;
import it.unibs.fp.view.classiDiServizio.operatori.ClasseDiServizioOperatoriRelazionali;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.MyMenu;

import java.util.InputMismatchException;

public class ClasseDiServizioAzione {
    public static Azione menuCreaAzione() {
        Azione azione = null;
        boolean finito = false;
        String[] azione_menu = {"Azione base", "Con orologio"};
        MyMenu menu = new MyMenu("Menu creazione AZIONE", azione_menu);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito = true;
                    System.out.println("USCITA MENU Azione");
                }
                break;

                case 1: {
                    azione = creaAzioneBase();
                }
                break;

                case 2: {
                    azione = creaAzioneOrologio();
                }
                break;
            }
        } while (!finito);

        return azione;
    }

    private static Azione creaAzioneOrologio() {
        Attuatore attuatore;
        ModOperativa modOperativa;
        Orologio start;

        start = ClasseDiServizioOrologio.creaOrologio();

        return new Azione(attuatore, modOperativa, start);
    }

    public static CostituenteLogico creaAzioneBase() {
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
