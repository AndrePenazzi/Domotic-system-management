package it.unibs.fp.test;

import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNumerica;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaSensoriTest {
    private static final String NOME_CATEGORIA_SENSORE="Termometro";
    private static final String TESTO_LIBERO="Termometro che misura una variabile fisica";
    private static final ArrayList<InfoRilevabile> infoRilevabili = creaInfoRilevabili();
    private static final String NOME_INFORMAZIONE_RILEVABILE="Temperatura";
    private static final double MIN=0.0;
    private static final double MAX=40.0;
    private static final InfoRilevabile infoRilevabile = new InfoRilevabileNumerica(NOME_INFORMAZIONE_RILEVABILE,MIN,MAX);
    private CategoriaSensori categoriaNuova;

    private static ArrayList<InfoRilevabile> creaInfoRilevabili(){
        ArrayList<InfoRilevabile> infoRilevabilit = new ArrayList<>();
        infoRilevabilit.add(infoRilevabile);
        return infoRilevabilit;
    }

    @Test
    public void inizializzazioneTest(){
        categoriaNuova = new CategoriaSensori(NOME_CATEGORIA_SENSORE,TESTO_LIBERO,infoRilevabili);
        assertEquals(NOME_CATEGORIA_SENSORE,categoriaNuova.getNome());
        assertEquals(TESTO_LIBERO,categoriaNuova.getTestoLibero());
        assert categoriaNuova.getInformazioniRilevabili().size()==1;
    }


    @Test
    void getTestoLibero() {
        categoriaNuova = new CategoriaSensori(NOME_CATEGORIA_SENSORE,TESTO_LIBERO,infoRilevabili);
        assertEquals(TESTO_LIBERO,categoriaNuova.getTestoLibero());
    }


    @Test
    void getInformazioniRilevabili() {
        categoriaNuova = new CategoriaSensori(NOME_CATEGORIA_SENSORE,TESTO_LIBERO,infoRilevabili);
        assertEquals(infoRilevabili,categoriaNuova.getInformazioniRilevabili());
    }


    @Test
    void getNome() {
        categoriaNuova = new CategoriaSensori(NOME_CATEGORIA_SENSORE,TESTO_LIBERO,infoRilevabili);
        assertEquals(NOME_CATEGORIA_SENSORE,categoriaNuova.getNome());
    }

    @Test
    void setNome() {
        categoriaNuova = new CategoriaSensori(NOME_CATEGORIA_SENSORE,TESTO_LIBERO,infoRilevabili);
        String nomeNuovo = "Term";
        categoriaNuova.setNome(nomeNuovo);
        assertEquals(nomeNuovo,categoriaNuova.getNome());
        categoriaNuova.setNome(NOME_CATEGORIA_SENSORE);
    }
}
