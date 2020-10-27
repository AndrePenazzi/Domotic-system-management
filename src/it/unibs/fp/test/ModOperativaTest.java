/*
package it.unibs.fp.test;

import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//TODO: FUNZIONA MA SERVONO DEI THROWS O QUALCOSA PER IL TYPE(NE ABBIAMO SOLO 2); TESTA MEGLIO ANCHE IL NOME CATEGORIA PER LA LUNGHEZZA
public class ModOperativaTest {
    private static final String NOME_CATEGORIA_SENSORE = "Termometro";
    private static final int TYPE1 = 1;
    private static final int TYPE2 = 2;
    private static final int TYPE0 = 0;
    private static final int TYPE_NEGATIVE = -1;
    private static final int TYPE3 = 3;

    private static ModOperativa modOperativaNuova;

    @Test
    public void inizializzazioneTest() {
        ModOperativa modOperativa = new ModOperativa();
        assertEquals("", modOperativa.getNome());
    }

    @Test
    public void assegnazioneTest0() {
        modOperativaNuova = new ModOperativa(NOME_CATEGORIA_SENSORE, TYPE0);
        assertEquals(NOME_CATEGORIA_SENSORE, modOperativaNuova.getNome());
        assertEquals(TYPE0, modOperativaNuova.getType());
    }

    @Test
    public void assegnazioneTest1() {
        modOperativaNuova = new ModOperativa(NOME_CATEGORIA_SENSORE, TYPE1);
        assertEquals(NOME_CATEGORIA_SENSORE, modOperativaNuova.getNome());
        assertEquals(TYPE1, modOperativaNuova.getType());
    }

    @Test
    public void assegnazioneTest2() {
        modOperativaNuova = new ModOperativa(NOME_CATEGORIA_SENSORE, TYPE2);
        assertEquals(NOME_CATEGORIA_SENSORE, modOperativaNuova.getNome());
        assertEquals(TYPE2, modOperativaNuova.getType());
    }

    @Test
    public void assegnazioneTest3() {
        modOperativaNuova = new ModOperativa(NOME_CATEGORIA_SENSORE, TYPE3);
        assertEquals(NOME_CATEGORIA_SENSORE, modOperativaNuova.getNome());
        assertEquals(TYPE3, modOperativaNuova.getType());
    }


    @Test
    public void assegnazioneTestNegativo() {
        modOperativaNuova = new ModOperativa(NOME_CATEGORIA_SENSORE, TYPE_NEGATIVE);
        assertEquals(NOME_CATEGORIA_SENSORE, modOperativaNuova.getNome());
        assertEquals(TYPE_NEGATIVE, modOperativaNuova.getType());
    }


}
*/
