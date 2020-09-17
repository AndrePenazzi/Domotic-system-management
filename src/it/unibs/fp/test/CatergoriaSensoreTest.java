package it.unibs.fp.test;

import it.unibs.fp.categoria.CategoriaSensori;
import it.unibs.fp.infoRilevabile.InfoRilevabile;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatergoriaSensoreTest {
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


}
