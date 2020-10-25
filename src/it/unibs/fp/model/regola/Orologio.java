package it.unibs.fp.model.regola;

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

    public int getOra() {
        return ora;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public int getMinuti() {
        return minuti;
    }

    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }
}