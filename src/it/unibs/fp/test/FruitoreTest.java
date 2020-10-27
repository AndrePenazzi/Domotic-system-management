/*
package it.unibs.fp.test;

import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNumerica;
import it.unibs.fp.model.operatori.OperatoriBooleani;
import it.unibs.fp.model.operatori.OperatoriRelazionali;
import it.unibs.fp.model.regola.Orologio;
import it.unibs.fp.model.regola.Regola;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.model.unitaImmobiliare.Stanza;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.model.utenti.Fruitore;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FruitoreTest {

    //TODO
    @Test
    void inserisciRegola() {
        Fruitore fruitore = new Fruitore();
        Regola regola = new Regola();
    }

    //TODO
    @Test
    void testInserisciRegola() {

    }


    @Test
    void aggiungiAzione() {

    }

    @Test
    void aggiungiPrimoCosituenteLogicoARegola() {
        Fruitore fruitore = new Fruitore();
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare("TestUnitaImmobiliare");
        Regola regola = new Regola();
        InfoRilevabile infoRilevabile1 = new InfoRilevabileNumerica("infoRilevabile1",-10,10);
        InfoRilevabile infoRilevabile2 = new InfoRilevabileNumerica("infoRilevabile2",-10,10);
        OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.MAGGIORE_UGUALE;
        fruitore.aggiungiPrimoCosituenteLogicoARegola(unitaImmobiliare,regola,infoRilevabile1,infoRilevabile2,operatoreRelazionale);
    }

    @Test
    void testAggiungiPrimoCosituenteLogicoARegola() {
        Fruitore fruitore = new Fruitore();
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare("TestUnitaImmobiliare");
        Regola regola = new Regola();
        InfoRilevabile infoRilevabile1 = new InfoRilevabileNumerica("infoRilevabile1",-10,10);
        double secondoOperatoreLogico = 10.0;
        OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.MAGGIORE_UGUALE;
        fruitore.aggiungiPrimoCosituenteLogicoARegola(unitaImmobiliare,regola,infoRilevabile1,secondoOperatoreLogico,operatoreRelazionale);
    }

    //TODO importante da riguardare questo test
    @Test
    void testAggiungiPrimoCosituenteLogicoARegola1() {
        Fruitore fruitore = new Fruitore();
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare("TestUnitaImmobiliare");
        Regola regola = new Regola();
        InfoRilevabile infoRilevabile1 = new InfoRilevabileNumerica("infoRilevabile1",-10,10);
        String secondoOperatoreLogico = "Aperto";
        OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.MAGGIORE_UGUALE;
        fruitore.aggiungiPrimoCosituenteLogicoARegola(unitaImmobiliare,regola,infoRilevabile1,secondoOperatoreLogico,operatoreRelazionale);
    }

    @Test
    void testAggiungiPrimoCosituenteLogicoARegola2() {
        Fruitore fruitore = new Fruitore();
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare("TestUnitaImmobiliare");
        Regola regola = new Regola();
        InfoRilevabile infoRilevabile1 = new InfoRilevabileNumerica("infoRilevabile1",-10,10);
        Orologio orologio = new Orologio();
        OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.MAGGIORE_UGUALE;
        fruitore.aggiungiPrimoCosituenteLogicoARegola(unitaImmobiliare,regola, operatoreRelazionale,orologio);
    }

    @Test
    void aggiungiEnnesimoCosituenteLogicoARegola() {
        Fruitore fruitore = new Fruitore();
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare("TestUnitaImmobiliare");
        Regola regola = new Regola();
        InfoRilevabile infoRilevabile1 = new InfoRilevabileNumerica("infoRilevabile1",-10,10);
        InfoRilevabile infoRilevabile2 = new InfoRilevabileNumerica("infoRilevabile2",-10,10);
        OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.MAGGIORE_UGUALE;
        OperatoriBooleani operatoreBooleano = OperatoriBooleani.AND;
        fruitore.aggiungiEnnesimoCosituenteLogicoARegola(unitaImmobiliare,regola,infoRilevabile1,infoRilevabile2,operatoreRelazionale,operatoreBooleano);
    }

    @Test
    void testAggiungiEnnesimoCosituenteLogicoARegola() {
        Fruitore fruitore = new Fruitore();
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare("TestUnitaImmobiliare");
        Regola regola = new Regola();
        InfoRilevabile infoRilevabile1 = new InfoRilevabileNumerica("infoRilevabile1",-10,10);
        double secondoOperatoreLogico = 10.0;
        OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.MAGGIORE_UGUALE;
        OperatoriBooleani operatoreBooleano = OperatoriBooleani.AND;
        fruitore.aggiungiEnnesimoCosituenteLogicoARegola(unitaImmobiliare,regola, infoRilevabile1, secondoOperatoreLogico, operatoreRelazionale, operatoreBooleano);
    }

    @Test
    void testAggiungiEnnesimoCosituenteLogicoARegola1() {
        Fruitore fruitore = new Fruitore();
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare("TestUnitaImmobiliare");
        Regola regola = new Regola();
        InfoRilevabile infoRilevabile1 = new InfoRilevabileNumerica("infoRilevabile1",-10,10);
        double secondoOperatoreLogico = 10.0;
        OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.MAGGIORE_UGUALE;
        OperatoriBooleani operatoreBooleano = OperatoriBooleani.AND;
        fruitore.aggiungiEnnesimoCosituenteLogicoARegola(unitaImmobiliare,regola, infoRilevabile1, secondoOperatoreLogico, operatoreRelazionale, operatoreBooleano);
    }

    @Test
    void testAggiungiEnnesimoCosituenteLogicoARegola2() {
        Fruitore fruitore = new Fruitore();
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare("TestUnitaImmobiliare");
        Regola regola = new Regola();
        InfoRilevabile infoRilevabile1 = new InfoRilevabileNumerica("infoRilevabile1",-10,10);
        String secondoOperatoreLogico = "Aperto";
        OperatoriRelazionali operatoreRelazionale = OperatoriRelazionali.MAGGIORE_UGUALE;
        OperatoriBooleani operatoreBooleano = OperatoriBooleani.AND;
        fruitore.aggiungiEnnesimoCosituenteLogicoARegola(unitaImmobiliare,regola,infoRilevabile1,secondoOperatoreLogico,operatoreRelazionale,operatoreBooleano);
    }

    @Test
    void aggiungiUnitaImmobiliare() {
        Fruitore fruitore = new Fruitore();
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare("TestUnitaImmobiliare");
        fruitore.aggiungiUnitaImmobiliare(unitaImmobiliare);
    }

    @Test
    void trovaIndiceUnitaImmobiliare() {
        Fruitore fruitore = new Fruitore();
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare("TestUnitaImmobiliare");
        fruitore.aggiungiUnitaImmobiliare(unitaImmobiliare);
        assertEquals(0, fruitore.trovaIndiceUnitaImmobiliare(unitaImmobiliare));
    }

    @Test
    void inserisciStanza() {
        Fruitore fruitore = new Fruitore();
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare("TestUnitaImmobiliare");
        fruitore.aggiungiUnitaImmobiliare(unitaImmobiliare);
        Stanza stanza = new Stanza("StanzaTest");
        fruitore.inserisciStanza(stanza,unitaImmobiliare);
    }

    @Test
    void inserisciArtefatto() {
        Fruitore fruitore = new Fruitore();
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare("TestUnitaImmobiliare");
        fruitore.aggiungiUnitaImmobiliare(unitaImmobiliare);
        Artefatto artefatto = new Artefatto("ArtefattoTest");
        fruitore.inserisciArtefatto(artefatto, unitaImmobiliare);
    }

    @Test
    void associaSensoreAStanze() {
        Fruitore fruitore = new Fruitore();
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare("TestUnitaImmobiliare");
        fruitore.aggiungiUnitaImmobiliare(unitaImmobiliare);
        ArrayList<Stanza> stanze = new ArrayList<>();
        Stanza stanza = new Stanza("StanzaTest");
        stanze.add(stanza);
        CategoriaSensori categoriaSensori = new CategoriaSensori();
        Sensore sensore = new Sensore("SensoreTest", categoriaSensori);
        fruitore.associaSensoreAStanze(sensore,stanze,unitaImmobiliare);
    }

    @Test
    void associaAttuatoreAStanze() {
        Fruitore fruitore = new Fruitore();
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare("TestUnitaImmobiliare");
        fruitore.aggiungiUnitaImmobiliare(unitaImmobiliare);
        ArrayList<Stanza> stanze = new ArrayList<>();
        Stanza stanza = new Stanza("StanzaTest");
        stanze.add(stanza);
        CategoriaAttuatori categoriaAttuatori = new CategoriaAttuatori();
        Attuatore attuatore = new Attuatore("AttuatoreTest", categoriaAttuatori);
        fruitore.associaAttuatoreAStanze(attuatore,stanze,unitaImmobiliare);
    }

    @Test
    void associaSensoreAdArtefatti() {
        Fruitore fruitore = new Fruitore();
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare("TestUnitaImmobiliare");
        fruitore.aggiungiUnitaImmobiliare(unitaImmobiliare);
        ArrayList<Artefatto> artefatti = new ArrayList<>();
        Artefatto artefatto = new Artefatto("ArtefattoTest");
        artefatti.add(artefatto);
        CategoriaSensori categoriaSensori = new CategoriaSensori();
        Sensore sensore = new Sensore("SensoreTest", categoriaSensori);
        fruitore.associaSensoreAdArtefatti(sensore,artefatti,unitaImmobiliare);
    }

    @Test
    void associaAttuatoreAdArtefatti() {
        Fruitore fruitore = new Fruitore();
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare("TestUnitaImmobiliare");
        fruitore.aggiungiUnitaImmobiliare(unitaImmobiliare);
        ArrayList<Artefatto> artefatti = new ArrayList<>();
        Artefatto artefatto = new Artefatto("ArtefattoTest");
        artefatti.add(artefatto);
        CategoriaAttuatori categoriaAttuatori = new CategoriaAttuatori();
        Attuatore attuatore = new Attuatore("AttuatoreTest", categoriaAttuatori);
        fruitore.associaAttuatoreAdArtefatti(attuatore,artefatti,unitaImmobiliare);
    }

    @Test
    void associaArtefattoAStanze() {
        Fruitore fruitore = new Fruitore();
        UnitaImmobiliare unitaImmobiliare = new UnitaImmobiliare("TestUnitaImmobiliare");
        fruitore.aggiungiUnitaImmobiliare(unitaImmobiliare);
        ArrayList<Stanza> stanze = new ArrayList<>();
        Stanza stanza = new Stanza("StanzaTest");
        stanze.add(stanza);
        Artefatto artefatto = new Artefatto("ArtefattoTest");
        fruitore.associaArtefattoAStanze(artefatto,stanze,unitaImmobiliare);
    }

    @Test
    void visualizzaUnitaImmobiliari() {
    }

    @Test
    void visualizzaListaUnitaImmobiliari() {
    }

    @Test
    void visualizzaDescrizioneCatergorieSensori() {
    }

    @Test
    void visualizzaDescrizioneCatergorieAttuatori() {
    }

    @Test
    void visualizzaStanze() {
    }

    @Test
    void visualizzaArtefatti() {
    }

    @Test
    void valoriRilevati() {
    }

    @Test
    void getUnitaImmobiliari() {
    }

    @Test
    void setUnitaImmobiliari() {
    }
}*/
