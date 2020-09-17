package it.unibs.fp.test;

import it.unibs.fp.infoRilevabile.InfoRilevabileNumerica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InfoRilevabileTest {
    private static final String NOME_INFORMAZIONE_RILEVABILE="Temperatura";
    private static final double MIN=-27.2;
    private static final double MAX=100.5;

    @Test
    public void infoRilevabileNumericaTest(){
        InfoRilevabileNumerica info = new InfoRilevabileNumerica(NOME_INFORMAZIONE_RILEVABILE,MIN,MAX);
        assertEquals(NOME_INFORMAZIONE_RILEVABILE,info.getNome());
        assertEquals(MIN,info.getMin());
        assertEquals(MAX,info.getMax());
    }

}
