package it.unibs.fp.test;

import it.unibs.fp.model.modalitaOperativa.ModOperativaNonParamentrica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
//TODO TESTA MEGLIO LA LUNGHEZZA DEL NOME
public class ModOperativaNonParametrica {
    private static final String NOME_MODALITA_OPERATIVA_PARAMETRICA="MOTORE ELETTRICO";
    private static final double VALORE=10;

    private static ModOperativaNonParamentrica nuovaModOperativaNonParamentrica;

    @Test
    public void inizializzazioneTest(){
        ModOperativaNonParamentrica modOperativaParamentrica = new ModOperativaNonParamentrica();
        assertEquals("",modOperativaParamentrica.getNome());
    }

    @Test
    public void assegnazioneTest() {
        nuovaModOperativaNonParamentrica = new ModOperativaNonParamentrica(NOME_MODALITA_OPERATIVA_PARAMETRICA, VALORE);
        assertEquals(NOME_MODALITA_OPERATIVA_PARAMETRICA, nuovaModOperativaNonParamentrica.getNome());
        assertEquals(VALORE, nuovaModOperativaNonParamentrica.getValore());
    }

}
