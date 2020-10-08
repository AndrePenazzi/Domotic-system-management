package it.unibs.fp.test;

import it.unibs.fp.categoria.CategoriaSensori;
import it.unibs.fp.infoRilevabile.InfoRilevabile;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaSensoriTest {
    private static final String NOME_CATEGORIA_SENSORE="Termometro";
    private static final String TESTO_LIBERO="Termometro per il COVID19";
    private static final ArrayList<InfoRilevabile> infoRilevabili = new ArrayList<>();



    private static CategoriaSensori categoriaNuova ;

    @Test
    public void inizializzazioneTest(){
        CategoriaSensori cat = new CategoriaSensori();
        assertEquals("",cat.getNome());
        assertEquals("",cat.getTestoLibero());
        assert cat.getInformazioniRilevabili().size()==0;
    }

    @Test
    public void assegnazioneTest(){
        InfoRilevabile infoRilevabile = new InfoRilevabile();
        infoRilevabili.add(infoRilevabile);
        categoriaNuova = new CategoriaSensori(NOME_CATEGORIA_SENSORE,TESTO_LIBERO,infoRilevabili);
        assertEquals(NOME_CATEGORIA_SENSORE,categoriaNuova.getNome());
        assertEquals(TESTO_LIBERO,categoriaNuova.getTestoLibero());
        assert categoriaNuova.getInformazioniRilevabili().size()==1;
    }

    //TODO
    @Test
    void getLunghezzaMassima() {
    }

    //TODO
    @Test
    void testToString() {
    }

    @Test
    void getTestoLibero() {
        assertEquals(TESTO_LIBERO,categoriaNuova.getTestoLibero());
    }

    @Test
    void setTestoLibero() {
        String testoLiberoNuovo = "Testo libero nuovo";
        categoriaNuova.setTestoLibero(testoLiberoNuovo);
        assertEquals(testoLiberoNuovo,categoriaNuova.getTestoLibero());
        categoriaNuova.setTestoLibero(TESTO_LIBERO);
    }

    @Test
    void getInformazioniRilevabili() {
        assertEquals(infoRilevabili,categoriaNuova.getInformazioniRilevabili());
    }

    @Test
    void setInformazioniRilevabili() {
        ArrayList<InfoRilevabile> infoRilevabiliNuove = new ArrayList<>();
        categoriaNuova.setInformazioniRilevabili(infoRilevabiliNuove);
        assertEquals(infoRilevabiliNuove,categoriaNuova.getInformazioniRilevabili());
        categoriaNuova.setInformazioniRilevabili(infoRilevabiliNuove);
    }

    @Test
    void getNome() {
        assertEquals(NOME_CATEGORIA_SENSORE,categoriaNuova.getNome());
    }

    @Test
    void setNome() {
        String nomeNuovo = "Term";
        categoriaNuova.setNome(nomeNuovo);
        assertEquals(nomeNuovo,categoriaNuova.getNome());
        categoriaNuova.setNome(NOME_CATEGORIA_SENSORE);
    }
}