package it.unibs.fp.test;

import it.unibs.fp.model.modalitaOperativa.ModOperativaParamentrica;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
//TODO DA TESTARE ULTERIORMENTE L'ARRAYLIST
public class ModOperativaParametricaTest {
    private static final String NOME_MODALITA_OPERATIVA_PARAMETRICA="MOTORE ELETTRICO";
    private static final ArrayList<String> PARAMETRI= new ArrayList<>(Arrays.asList("Temperatura","energia"));

    private static ModOperativaParamentrica nuovaModOperativaParamentrica;

    @Test
    public void assegnazioneTest(){
        nuovaModOperativaParamentrica = new ModOperativaParamentrica(NOME_MODALITA_OPERATIVA_PARAMETRICA,PARAMETRI);
        assertEquals(NOME_MODALITA_OPERATIVA_PARAMETRICA,nuovaModOperativaParamentrica.getNome());
        assertEquals(PARAMETRI,nuovaModOperativaParamentrica.getParamentri());
        assert nuovaModOperativaParamentrica.getParamentri().size()==2;
    }
}
