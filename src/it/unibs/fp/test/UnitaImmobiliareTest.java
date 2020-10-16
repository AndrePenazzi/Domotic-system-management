package it.unibs.fp.test;

import it.unibs.fp.dispositiviPeriferici.Attuatore;
import it.unibs.fp.dispositiviPeriferici.Sensore;
import it.unibs.fp.modalitaOperativa.ModOperativa;
import it.unibs.fp.unitaImmobiliare.Artefatto;
import it.unibs.fp.unitaImmobiliare.Stanza;
import it.unibs.fp.unitaImmobiliare.UnitaImmobiliare;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitaImmobiliareTest {
    private static final String NOME_UNITA_IMMOBILIARE = "Palazzo";

    private static UnitaImmobiliare unitaImmobiliareNuova;
    private static Attuatore attuatoreNuovo;
    private static ModOperativa modOperativaNuova;
    private static Stanza stanzaNuova;
    private static Artefatto artefattoNuovo;
    private static Sensore sensoreNuovo;

    @Test
    public void inizializzazioneTest() {
        UnitaImmobiliare unita = new UnitaImmobiliare();
        assertEquals("", unita.getNome());
        assert unita.getSizeStanze() == 0;
        assert unita.getSizeArtefatti() == 0;
        assert unita.getSizeRegole() == 0;
    }

    @Test
    public void assegnazioneTest() {
        unitaImmobiliareNuova = new UnitaImmobiliare(NOME_UNITA_IMMOBILIARE);
        assertEquals(NOME_UNITA_IMMOBILIARE, unitaImmobiliareNuova.getNome());
        assert unitaImmobiliareNuova.getSizeStanze() == 0;
        assert unitaImmobiliareNuova.getSizeArtefatti() == 0;
        assert unitaImmobiliareNuova.getSizeRegole() == 0;
    }

    @Test
    void cambiaRegolaAttivaDisattiva() {
        unitaImmobiliareNuova = new UnitaImmobiliare(NOME_UNITA_IMMOBILIARE);
        attuatoreNuovo = new Attuatore();
        modOperativaNuova = new ModOperativa();
        unitaImmobiliareNuova.inserisciRegola(attuatoreNuovo, modOperativaNuova);
        unitaImmobiliareNuova.cambiaRegolaAttivaDisattiva(unitaImmobiliareNuova.getRegole().get(0));
        assertFalse(unitaImmobiliareNuova.getRegole().get(0).isAttiva());
        assert unitaImmobiliareNuova.getSizeStanze() == 0;
        assert unitaImmobiliareNuova.getSizeArtefatti() == 0;
        assert unitaImmobiliareNuova.getSizeRegole() == 1;
    }

    @Test
    void inserisciRegola() {
        unitaImmobiliareNuova = new UnitaImmobiliare(NOME_UNITA_IMMOBILIARE);
        attuatoreNuovo = new Attuatore();
        modOperativaNuova = new ModOperativa();
        unitaImmobiliareNuova.inserisciRegola(attuatoreNuovo, modOperativaNuova);
        assert unitaImmobiliareNuova.getSizeStanze() == 0;
        assert unitaImmobiliareNuova.getSizeArtefatti() == 0;
        assert unitaImmobiliareNuova.getSizeRegole() == 1;
    }

    @Test
    void aggiungiAzione() {
        unitaImmobiliareNuova = new UnitaImmobiliare(NOME_UNITA_IMMOBILIARE);
        attuatoreNuovo = new Attuatore();
        modOperativaNuova = new ModOperativa();
        unitaImmobiliareNuova.inserisciRegola(attuatoreNuovo, modOperativaNuova);
        unitaImmobiliareNuova.aggiungiAzione(unitaImmobiliareNuova.getRegole().get(0),attuatoreNuovo,modOperativaNuova);
        assert unitaImmobiliareNuova.getSizeStanze() == 0;
        assert unitaImmobiliareNuova.getSizeArtefatti() == 0;
        assert unitaImmobiliareNuova.getSizeRegole() == 1;

    }

    @Test
    void aggiungiPrimoCosituenteLogicoARegola() {
    }

    @Test
    void testAggiungiPrimoCosituenteLogicoARegola() {
    }

    @Test
    void testAggiungiPrimoCosituenteLogicoARegola1() {
    }

    @Test
    void testAggiungiPrimoCosituenteLogicoARegola2() {
    }

    @Test
    void aggiungiEnnesimoCosituenteLogicoARegola() {
    }

    @Test
    void testAggiungiEnnesimoCosituenteLogicoARegola() {
    }

    @Test
    void testAggiungiEnnesimoCosituenteLogicoARegola1() {
    }

    @Test
    void testAggiungiEnnesimoCosituenteLogicoARegola2() {
    }

    @Test
    void trovaRegola() {
        unitaImmobiliareNuova = new UnitaImmobiliare(NOME_UNITA_IMMOBILIARE);
        attuatoreNuovo = new Attuatore();
        modOperativaNuova = new ModOperativa();
        unitaImmobiliareNuova.inserisciRegola(attuatoreNuovo, modOperativaNuova);
        unitaImmobiliareNuova.inserisciRegola(attuatoreNuovo, new ModOperativa("Attivo"));
        unitaImmobiliareNuova.inserisciRegola(attuatoreNuovo, modOperativaNuova);
        assertEquals("Attivo",unitaImmobiliareNuova.getRegole().get(1).getConseguenti().get(0).getModOperativa().getNome());
        assert unitaImmobiliareNuova.getSizeStanze() == 0;
        assert unitaImmobiliareNuova.getSizeArtefatti() == 0;
        assert unitaImmobiliareNuova.getSizeRegole() == 3;
    }

    @Test
    void inserisciStanza() {
        unitaImmobiliareNuova = new UnitaImmobiliare(NOME_UNITA_IMMOBILIARE);
        stanzaNuova= new Stanza();
        unitaImmobiliareNuova.inserisciStanza(stanzaNuova);
        assertEquals("",unitaImmobiliareNuova.getStanze().get(0).getNome());
        assert unitaImmobiliareNuova.getSizeStanze() == 1;
        assert unitaImmobiliareNuova.getSizeArtefatti() == 0;
        assert unitaImmobiliareNuova.getSizeRegole() == 0;
    }

    @Test
    void inserisciArtefatto() {
        unitaImmobiliareNuova = new UnitaImmobiliare(NOME_UNITA_IMMOBILIARE);
        artefattoNuovo= new Artefatto();
        unitaImmobiliareNuova.inserisciArtefatto(artefattoNuovo);
        assertEquals("",unitaImmobiliareNuova.getArtefatti().get(0).getNome());
        assert unitaImmobiliareNuova.getSizeStanze() == 0;
        assert unitaImmobiliareNuova.getSizeArtefatti() == 1;
        assert unitaImmobiliareNuova.getSizeRegole() == 0;
    }

    @Test
    void associaSensoreAStanze() {
        unitaImmobiliareNuova = new UnitaImmobiliare(NOME_UNITA_IMMOBILIARE);
        stanzaNuova= new Stanza();
        sensoreNuovo=new Sensore();
        unitaImmobiliareNuova.inserisciStanza(stanzaNuova);
        unitaImmobiliareNuova.associaSensoreAStanze(sensoreNuovo,unitaImmobiliareNuova.getStanze());
        assertEquals("",unitaImmobiliareNuova.getStanze().get(0).getSensori().get(0).getNome());
        assert unitaImmobiliareNuova.getSizeStanze() == 1;
        assert unitaImmobiliareNuova.getSizeArtefatti() == 0;
        assert unitaImmobiliareNuova.getSizeRegole() == 0;
    }

    @Test
    void associaAttuatoreAStanze() {
        unitaImmobiliareNuova = new UnitaImmobiliare(NOME_UNITA_IMMOBILIARE);
        stanzaNuova= new Stanza();
        attuatoreNuovo=new Attuatore();
        unitaImmobiliareNuova.inserisciStanza(stanzaNuova);
        unitaImmobiliareNuova.associaAttuatoreAStanze(attuatoreNuovo,unitaImmobiliareNuova.getStanze());
        assertEquals("",unitaImmobiliareNuova.getStanze().get(0).getAttuatori().get(0).getNome());
        assert unitaImmobiliareNuova.getSizeStanze() == 1;
        assert unitaImmobiliareNuova.getSizeArtefatti() == 0;
        assert unitaImmobiliareNuova.getSizeRegole() == 0;
    }

    @Test
    void associaSensoreAdArtefatti() {
        unitaImmobiliareNuova = new UnitaImmobiliare(NOME_UNITA_IMMOBILIARE);
        artefattoNuovo= new Artefatto();
        sensoreNuovo=new Sensore();
        unitaImmobiliareNuova.inserisciArtefatto(artefattoNuovo);
        unitaImmobiliareNuova.associaSensoreAdArtefatti(sensoreNuovo,unitaImmobiliareNuova.getArtefatti());
        assertEquals("",unitaImmobiliareNuova.getArtefatti().get(0).getSensori().get(0).getNome());
        assert unitaImmobiliareNuova.getSizeStanze() == 0;
        assert unitaImmobiliareNuova.getSizeArtefatti() == 1;
        assert unitaImmobiliareNuova.getSizeRegole() == 0;
    }

    @Test
    void associaAttuatoreAdArtefatti() {
        unitaImmobiliareNuova = new UnitaImmobiliare(NOME_UNITA_IMMOBILIARE);
        artefattoNuovo= new Artefatto();
        attuatoreNuovo=new Attuatore();
        unitaImmobiliareNuova.inserisciArtefatto(artefattoNuovo);
        unitaImmobiliareNuova.associaAttuatoreAdArtefatti(attuatoreNuovo,unitaImmobiliareNuova.getArtefatti());
        assertEquals("",unitaImmobiliareNuova.getArtefatti().get(0).getAttuatori().get(0).getNome());
        assert unitaImmobiliareNuova.getSizeStanze() == 0;
        assert unitaImmobiliareNuova.getSizeArtefatti() == 1;
        assert unitaImmobiliareNuova.getSizeRegole() == 0;
    }

    @Test
    void associaArtefattoAStanze() {
        unitaImmobiliareNuova = new UnitaImmobiliare(NOME_UNITA_IMMOBILIARE);
        artefattoNuovo= new Artefatto();
        attuatoreNuovo=new Attuatore();
        unitaImmobiliareNuova.inserisciArtefatto(artefattoNuovo);
        unitaImmobiliareNuova.associaAttuatoreAdArtefatti(attuatoreNuovo,unitaImmobiliareNuova.getArtefatti());
        assertEquals("",unitaImmobiliareNuova.getArtefatti().get(0).getAttuatori().get(0).getNome());
        assert unitaImmobiliareNuova.getSizeStanze() == 0;
        assert unitaImmobiliareNuova.getSizeArtefatti() == 1;
        assert unitaImmobiliareNuova.getSizeRegole() == 0;
    }


}