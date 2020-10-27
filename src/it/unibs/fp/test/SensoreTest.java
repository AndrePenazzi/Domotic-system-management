/*
package it.unibs.fp.test;

import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNumerica;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SensoreTest {
    private static final String NOME_SENSORE = "Termometro_T1";

    private static final String NOME_CATEGORIA_SENSORE = "Termometro";
    private static final String TESTO_LIBERO = "Termometro per il COVID19";
    private static final ArrayList<InfoRilevabile> infoRilevabili = new ArrayList<>();

    private static CategoriaSensori categoriaSensori;
    private static Sensore sensore;

    void creaCategoriaSensori() {
        infoRilevabili.add(new InfoRilevabileNumerica("Temperatura", -10, 40));
        categoriaSensori = new CategoriaSensori(NOME_CATEGORIA_SENSORE, TESTO_LIBERO, infoRilevabili);
    }

    void creaSensore() {
        sensore = new Sensore(NOME_SENSORE, categoriaSensori);
    }

    //TODO
    @Test
    void rilevaVariabileFisica() {
    }

    //TODO
    @Test
    void getNome() {
        creaCategoriaSensori();
        creaSensore();
        assertEquals(NOME_SENSORE, sensore.getNome());
    }

    @Test
    void setNome() {
        creaCategoriaSensori();
        creaSensore();
        String nomeNuovo = "Termometro_T2";
        sensore.setNome(nomeNuovo);
        assertEquals(nomeNuovo, sensore.getNome());
    }

    @Test
    void getCategoriaSensori() {
        creaCategoriaSensori();
        creaSensore();
        assertEquals(categoriaSensori,sensore.getCategoriaSensori());
    }

    @Test
    void setCategoriaSensori() {
        CategoriaSensori categoriaSensoriNuova = new CategoriaSensori("Termometro Nuovo", TESTO_LIBERO, infoRilevabili);
        creaSensore();
        sensore.setCategoriaSensori(categoriaSensoriNuova);
        assertEquals(categoriaSensoriNuova,sensore.getCategoriaSensori());
    }

    //TODO
    @Test
    void testToString() {
    }
}*/
