package it.unibs.fp.test;

import it.unibs.fp.categoria.CategoriaAttuatori;
import it.unibs.fp.categoria.CategoriaSensori;
import it.unibs.fp.dispositiviPeriferici.Attuatore;
import it.unibs.fp.dispositiviPeriferici.Sensore;
import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.infoRilevabile.InfoRilevabileNumerica;
import it.unibs.fp.unitaImmobiliare.Artefatto;
import it.unibs.fp.unitaImmobiliare.Stanza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StanzaTest {

    private static final String NOME_STANZA = "Camera da letto";
    private static final Stanza stanza = new Stanza(NOME_STANZA);


    @Test
    void inserisciArtefatto() {
        String nomeArtefatto = "Cancello";
        Artefatto artefatto = new Artefatto(nomeArtefatto);
        stanza.inserisciArtefatto(artefatto);
        assertEquals(artefatto,stanza.getArtefatti().get(0));
    }

    @Test
    void inserisciSensore() {
        String nomeSensore = "Termometro";
        CategoriaSensori categoriaSensori = new CategoriaSensori();
        Sensore sensore = new Sensore(nomeSensore,categoriaSensori);
        stanza.inserisciSensore(sensore);
        assertEquals(sensore,stanza.getSensori().get(0));
    }

    @Test
    void inserisciAttuatore() {
        String nomeAttuatore = "Attuatore";
        CategoriaAttuatori categoriaAttuatori = new CategoriaAttuatori();
        Attuatore attuatore = new Attuatore(nomeAttuatore, categoriaAttuatori);
        stanza.inserisciAttuatore(attuatore);
        assertEquals(attuatore,stanza.getAttuatori().get(0));
    }

    //TODO
    @Test
    void visualizzaArtefatti() {
    }

    //TODO
    @Test
    void testToString() {
    }

    //TODO come inserisci
    @Test
    void getSensori() {

    }

    //TODO come inserisci
    @Test
    void getAttuatori() {
    }


    @Test
    void getNome() {
       assertEquals(NOME_STANZA,stanza.getNome());
    }

    @Test
    void setNome() {
        String nomeNuovo = "Salotto";
        stanza.setNome(nomeNuovo);
        assertEquals(nomeNuovo,stanza.getNome());
    }

    //TODO come inserisci
    @Test
    void getArtefatti() {
    }

    //TODO come inserisci
    @Test
    void setArtefatti() {
    }
}