package it.unibs.fp;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Orologio implements Serializable {
    private int ora;
    private int minuti;

    public Orologio(int ora, int minuti) {
        this.ora = ora;
        this.minuti = minuti;
    }

    public Orologio() {
        Calendar calendar = GregorianCalendar.getInstance();
        ora = calendar.get(Calendar.HOUR_OF_DAY);
        minuti = calendar.get(Calendar.MINUTE);
    }

    @Override
    public String toString() {
        return ora + ":" + minuti;
    }
}