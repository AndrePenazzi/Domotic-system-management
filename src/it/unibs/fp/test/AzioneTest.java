package it.unibs.fp.test;

import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import it.unibs.fp.model.regola.Azione;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AzioneTest {
    private static final String NOME_ATTUATORE="MOTORE ELETTRICO";
    private static final String NOME_MOD_OPERATIVA="Termometro";
    private static final Attuatore attuatoreNuovo = new Attuatore(NOME_ATTUATORE, new CategoriaAttuatori());
    private static final ModOperativa modOperativaNuova = new ModOperativa(NOME_MOD_OPERATIVA);


    @Test
    public void inizializzazioneTest() {
        Azione azioneNuova = new Azione();
        assertNull(azioneNuova.getAttuatore());
        assertNull(azioneNuova.getModOperativa());
    }

    @Test
    public void assegnazioneTest() {
        Azione azioneNuova = new Azione(attuatoreNuovo,modOperativaNuova);
        assertEquals(NOME_ATTUATORE, azioneNuova.getAttuatore().getNome());
        assertEquals(NOME_MOD_OPERATIVA, azioneNuova.getModOperativa().getNome());
    }

    @Test
    void eseguiAzione() {
        Azione azioneNuova = new Azione(attuatoreNuovo,modOperativaNuova);
        assertEquals(NOME_MOD_OPERATIVA, azioneNuova.getModOperativa().getNome());
        azioneNuova.eseguiAzione();
        assertEquals(NOME_MOD_OPERATIVA, azioneNuova.getAttuatore().getModOperativa().getNome());
    }

}