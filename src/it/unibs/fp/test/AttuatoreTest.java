package it.unibs.fp.test;

import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttuatoreTest {
    private static final String NOME_ATTUATORE="Motore elettrico";
    private static final ModOperativa modOperativa = new ModOperativa();

    private static Attuatore attuatoreNuovo;

    @Test
    public void inizializzazioneTest(){
        CategoriaAttuatori categoriaNuova= new CategoriaAttuatori();
        attuatoreNuovo = new Attuatore();
        assertEquals("",attuatoreNuovo.getNome());
        assertEquals("",categoriaNuova.getNome());
        assertEquals("",modOperativa.getNome());
    }

    @Test
    public void assegnazioneTest(){
        CategoriaAttuatori categoriaNuova;
        ModOperativa modOperativa = new ModOperativa();
        categoriaNuova = new CategoriaAttuatori();
        attuatoreNuovo = new Attuatore(NOME_ATTUATORE,categoriaNuova);
        assertEquals(NOME_ATTUATORE,attuatoreNuovo.getNome());
        assertEquals("",modOperativa.getNome());
        assertEquals("",categoriaNuova.getNome());
    }
}
