package it.unibs.fp.test;

import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNumerica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfoRilevabileNumericaTest extends InfoRilevabile {

    private static final String NOME_INFORMAZIONE_RILEVABILE = "Temperatura";
    private static final double MIN = -27.2;
    private static final double MAX = 100.5;
    private static InfoRilevabileNumerica info = new InfoRilevabileNumerica(NOME_INFORMAZIONE_RILEVABILE, MIN, MAX);

    @Test
    void rilevaVariabile() {
        double rilevato = info.rilevaVariabile();
        assert rilevato >= MIN && rilevato <= MAX;
    }

    //TODO
    @Test
    void testToString() {
    }

    @Test
    void testGetNome() {
        assertEquals(NOME_INFORMAZIONE_RILEVABILE,info.getNome());
    }

    @Test
    void getMin() {
        assertEquals(MIN,info.getMin());
    }

    @Test
    void getMax() {
        assertEquals(MAX,info.getMax());
    }

}