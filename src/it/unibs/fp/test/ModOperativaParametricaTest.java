package it.unibs.fp.test;

import it.unibs.fp.model.modalitaOperativa.ModOperativaParametrica;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
//TODO DA TESTARE ULTERIORMENTE L'ARRAYLIST
public class ModOperativaParametricaTest {
    private static final String NOME_MODALITA_OPERATIVA_PARAMETRICA="MOTORE ELETTRICO";
    private static final ArrayList<String> PARAMETRI= new ArrayList<>(Arrays.asList("Temperatura","energia"));

    private static ModOperativaParametrica nuovaModOperativaParametrica;

    @Test
    public void assegnazioneTest(){
        nuovaModOperativaParametrica = new ModOperativaParametrica(NOME_MODALITA_OPERATIVA_PARAMETRICA,PARAMETRI);
        assertEquals(NOME_MODALITA_OPERATIVA_PARAMETRICA, nuovaModOperativaParametrica.getNome());
        assertEquals(PARAMETRI, nuovaModOperativaParametrica.getParamentri());
        assert nuovaModOperativaParametrica.getParamentri().size()==2;
    }
}
