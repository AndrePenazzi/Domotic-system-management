package it.unibs.fp.test;

import it.unibs.fp.dispositiviPeriferici.Attuatore;
import it.unibs.fp.dispositiviPeriferici.Sensore;
import it.unibs.fp.unitaImmobiliare.Artefatto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtefattoTest {
    private static final String NOME_ARTEFATTO="Cancello";

    private static Artefatto artefattoNuovo;


    @Test
    public void inizializzazioneTest() {
        Artefatto artefatto = new Artefatto();
        assertEquals("", artefatto.getNome());
        assert artefatto.getSensori().size() == 0;
        assert artefatto.getAttuatori().size() == 0;
    }

    @Test
    public void assegnazioneTest() {
        artefattoNuovo = new Artefatto(NOME_ARTEFATTO);
        assertEquals(NOME_ARTEFATTO, artefattoNuovo.getNome());
        assert artefattoNuovo.getSensori().size() == 0;
        assert artefattoNuovo.getAttuatori().size() == 0;

    }

    @Test
    void inserisciSensore() {
        artefattoNuovo = new Artefatto(NOME_ARTEFATTO);
        Sensore sensore = new Sensore();
        artefattoNuovo.inserisciSensore(sensore);
        assert artefattoNuovo.getSensori().size() == 1;
        assert artefattoNuovo.getAttuatori().size() == 0;
    }

    @Test
    void inserisciAttuatore() {
        artefattoNuovo = new Artefatto(NOME_ARTEFATTO);
        Attuatore attuatore = new Attuatore();
        artefattoNuovo.inserisciAttuatore(attuatore);
        assert artefattoNuovo.getSensori().size() == 0;
        assert artefattoNuovo.getAttuatori().size() == 1;
    }

}