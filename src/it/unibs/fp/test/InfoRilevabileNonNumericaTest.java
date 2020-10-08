package it.unibs.fp.test;

import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.infoRilevabile.InfoRilevabileNonNumerica;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InfoRilevabileNonNumericaTest extends InfoRilevabile {

    private static final String NOME_INFORMAZIONE_RILEVABILE = "Presenza persona";
    private static ArrayList<String> valori = new ArrayList<>();

    public InfoRilevabileNonNumerica creaInfoRilevabileNonNumerica() {
        InfoRilevabileNonNumerica info = new InfoRilevabileNonNumerica(NOME_INFORMAZIONE_RILEVABILE,valori);
        return info;
    }

    @Test
    void inserisciValore() {
        InfoRilevabileNonNumerica info = creaInfoRilevabileNonNumerica();
        String valore = "Presente";
        info.inserisciValore(valore);
        assertEquals(valore,info.getValori().get(0));
    }

    @Test
    void rilevaVariabile() {
        InfoRilevabileNonNumerica info = creaInfoRilevabileNonNumerica();
        String valore = "Presente";
        String valore2 = "Non presente";
        info.inserisciValore(valore);
        info.inserisciValore(valore2);

        info.rilevaVariabile();

        assert info.getValoreAttuale()==valore || info.getValoreAttuale()==valore2;
    }

    //TODO
    @Test
    void testToString() {
    }

    @Test
    void getValori() {
        InfoRilevabileNonNumerica info = creaInfoRilevabileNonNumerica();
        String valore = "Presente";
        String valore2 = "Non presente";
        info.inserisciValore(valore);
        info.inserisciValore(valore2);

        assertEquals(valore,info.getValori().get(0));
        assertEquals(valore2,info.getValori().get(1));
    }

    @Test
    void setValori() {
        InfoRilevabileNonNumerica info = creaInfoRilevabileNonNumerica();
        ArrayList<String> valori = new ArrayList<>();
        String valore = "Presente";
        String valore2 = "Non presente";
        valori.add(valore);
        valori.add(valore2);
        info.setValori(valori);

        assertEquals(valore,info.getValori().get(0));
        assertEquals(valore2,info.getValori().get(1));

    }

    @Test
    void getValoreAttuale() {
        InfoRilevabileNonNumerica info = creaInfoRilevabileNonNumerica();
        String valore = "Presente";
        String valore2 = "Non presente";
        info.inserisciValore(valore);
        info.inserisciValore(valore2);

        info.rilevaVariabile();

        assert info.getValoreAttuale()==valore || info.getValoreAttuale()==valore2;
    }

    //TODO
    @Test
    void setValoreAttuale() {
    }
}