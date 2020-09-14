package it.unibs.fp.regola;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Orologio implements Serializable {
    private int ora;
    private int minuti;

    /**
     * Costruttore orologio
     * @param ora scelta
     * @param minuti scelti
     */
    public Orologio(int ora, int minuti) {
        this.ora = ora;
        this.minuti = minuti;
    }

    /**
     * Costruttore orologio ora attuale
     */
    public Orologio() {
        Calendar calendar = GregorianCalendar.getInstance();
        ora = calendar.get(Calendar.HOUR_OF_DAY);
        minuti = calendar.get(Calendar.MINUTE);
    }

    /**
     * toString
     * @return visualizza l'ora
     */
    @Override
    public String toString() {
        return ora + ":" + minuti;
    }
}