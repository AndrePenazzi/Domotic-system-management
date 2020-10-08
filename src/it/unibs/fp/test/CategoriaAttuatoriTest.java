package it.unibs.fp.test;

import it.unibs.fp.categoria.CategoriaAttuatori;
import it.unibs.fp.modalitaOperativa.ModOperativa;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoriaAttuatoriTest {
    private static final String NOME_CATEGORIA_ATTUATORE="MOTORE ELETTRICO";
    private static final String TESTO_LIBERO="Motore elettrico per la casa";
    private static final ArrayList<ModOperativa> modOperative = new ArrayList<>();

    private static CategoriaAttuatori categoriaNuova ;

    @Test
    public void inizializzazioneTest(){
        CategoriaAttuatori cat = new CategoriaAttuatori();
        assertEquals("",cat.getNome());
        assertEquals("",cat.getTestoLibero());
        assert cat.getModalitaOperative().size()==0;
    }

    @Test
    public void assegnazioneTest(){
        ModOperativa modOperativa = new ModOperativa();
        modOperative.add(modOperativa);
        categoriaNuova = new CategoriaAttuatori(NOME_CATEGORIA_ATTUATORE,TESTO_LIBERO,modOperative);
        assertEquals(NOME_CATEGORIA_ATTUATORE,categoriaNuova.getNome());
        assertEquals(TESTO_LIBERO,categoriaNuova.getTestoLibero());
        assert categoriaNuova.getModalitaOperative().size()==1;
    }



}
