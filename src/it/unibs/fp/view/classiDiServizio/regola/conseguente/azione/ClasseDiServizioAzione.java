package it.unibs.fp.view.classiDiServizio.regola.conseguente.azione;

import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import it.unibs.fp.model.regola.Orologio;
import it.unibs.fp.model.regola.conseguente.azione.Azione;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioCategoriaAttuatori;
import it.unibs.fp.view.classiDiServizio.regola.ClasseDiServizioOrologio;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioUnitaImmobiliare;
import it.unibs.fp.view.mylib.MyMenu;


public class ClasseDiServizioAzione {
    public static Azione menuCreaAzione(UnitaImmobiliare unitaImmobiliare) {
        Azione azione = null;
        String[] azione_menu = {"Azione base", "Con orologio"};
        MyMenu menu = new MyMenu("Menu creazione AZIONE", azione_menu);

        int scelta = menu.scegliPerMenuSenzaUscita();
        switch (scelta) {

            case 1: {
                azione = creaAzioneBase(unitaImmobiliare);
            }
            break;

            case 2: {
                azione = creaAzioneOrologio(unitaImmobiliare);
            }
            break;
        }

        return azione;
    }

    private static Azione creaAzioneOrologio(UnitaImmobiliare unitaImmobiliare) {
        Attuatore attuatore;
        ModOperativa modOperativa;
        Orologio start;

        attuatore = ClasseDiServizioUnitaImmobiliare.scegliAttuatore(unitaImmobiliare);
        modOperativa = ClasseDiServizioCategoriaAttuatori.scegliModOperativa(attuatore.getCategoriaAttuatori());
        start = ClasseDiServizioOrologio.creaOrologio();

        return new Azione(attuatore, modOperativa, start);
    }

    public static Azione creaAzioneBase(UnitaImmobiliare unitaImmobiliare) {
        Attuatore attuatore;
        ModOperativa modOperativa;
        attuatore = ClasseDiServizioUnitaImmobiliare.scegliAttuatore(unitaImmobiliare);
        modOperativa = ClasseDiServizioCategoriaAttuatori.scegliModOperativa(attuatore.getCategoriaAttuatori());

        return new Azione(attuatore, modOperativa);
    }

    /**
     * Descrivi azione
     *
     * @param azione da visualizzare
     * @return azione da descrivere
     */
    public static String descriviAzione(Azione azione) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(azione.getNomeAttuatore()).append(" := ").append(azione.getNomeModOperativa());
        if (azione.getStart() != null)
            tmp.append("," + "start := " + ClasseDiServizioOrologio.toString(azione.getStart()));
        return tmp.toString();
    }
}
