package it.unibs.fp.test;

import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.infoRilevabile.InfoRilevabileNonNumerica;
import it.unibs.fp.infoRilevabile.InfoRilevabileNumerica;
import it.unibs.fp.operatori.OperatoriRelazionali;
import it.unibs.fp.regola.CostituenteLogico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//TODO unpo di roba
class CostituenteLogicoTest {

    private static final String NOME_1 = "Temperatura";
    private static final String NOME_2 = "Temperatura2";
    private static Double min1 = -15.0;
    private static Double max1 = 50.0;
    private static InfoRilevabileNumerica infoRilevabileNumerica1 = new InfoRilevabileNumerica(NOME_1, min1, max1);
    private static Double min2 = 0.0;
    private static Double max2 = 100.0;
    private static InfoRilevabileNumerica infoRilevabileNumerica2 = new InfoRilevabileNumerica(NOME_2, min1, max1);

    private static OperatoriRelazionali op = OperatoriRelazionali.MAGGIORE;

    private static CostituenteLogico costituenteLogico = new CostituenteLogico(infoRilevabileNumerica1, infoRilevabileNumerica1, op);


    public void creaCostituenteLogico() {
    }

    //TODO ????
    @Test
    void isTrue() {

    }

    @Test
    void calcolaValoreBooleano() {
        boolean valoreCalcolato = costituenteLogico.calcolaValoreBooleano();
        assert valoreCalcolato || !valoreCalcolato;
    }

    @Test
    void testToString() {
    }

    @Test
    void getPrimoOperatoreLogico() {
        assertEquals(infoRilevabileNumerica1,costituenteLogico.getPrimoOperatoreLogico());
    }

    @Test
    void setPrimoOperatoreLogico() {
    }

    @Test
    void getSecondoOperatoreLogico() {
        assertEquals(infoRilevabileNumerica2,costituenteLogico.getSecondoOperatoreLogico());
    }

    @Test
    void setSecondoOperatoreLogico() {
    }

    @Test
    void getOperatoreRelazionale() {
        assertEquals(op,costituenteLogico.getOperatoreRelazionale());
    }

    @Test
    void setOperatoreRelazionale() {
    }
}