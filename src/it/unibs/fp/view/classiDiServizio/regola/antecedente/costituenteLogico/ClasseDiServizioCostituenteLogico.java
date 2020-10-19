package it.unibs.fp.view.classiDiServizio.regola.antecedente.costituenteLogico;

import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.operatori.OperatoriRelazionali;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogico;
import it.unibs.fp.model.regola.antecedente.costituenteLogico.CostituenteLogicoFactory;
import it.unibs.fp.view.classiDiServizio.ClasseDiServizioFruitore;
import it.unibs.fp.view.classiDiServizio.ClasseDiServizioManutentore;
import it.unibs.fp.view.classiDiServizio.Contenitore;
import it.unibs.fp.view.mylib.MyMenu;

public class ClasseDiServizioCostituenteLogico {
    public static void menuCreaCostituenteLogico(Contenitore contenitore) {
        CostituenteLogico costituenteLogico;
        boolean finito = false;
        String[] azione = {"Con info rilevabile", "Con orologio","Con valore parametrico","Con valore numerico"};
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
                    costituenteLogico= creaCostituenteLogicoInfoRilevabile();
                }
                break;

                case 2: {
                    ClasseDiServizioFruitore.stampaMenuFruitore(contenitore);
                }
                break;
            }
        } while (!finito);
    }
    public static CostituenteLogico creaCostituenteLogicoInfoRilevabile(){
        InfoRilevabile primoOpLogico;
        InfoRilevabile secondoOpLogico;
        OperatoriRelazionali opRelazionale;

        return CostituenteLogicoFactory.creaCostituenteLogico();
    }
}
