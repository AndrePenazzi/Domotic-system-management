package it.unibs.fp.test;

import it.unibs.fp.categoria.CategoriaAttuatori;
import it.unibs.fp.dispositiviPeriferici.Attuatore;
import it.unibs.fp.infoRilevabile.InfoRilevabile;
import it.unibs.fp.infoRilevabile.InfoRilevabileNumerica;
import it.unibs.fp.modalitaOperativa.ModOperativa;
import it.unibs.fp.operatori.OperatoriBooleani;
import it.unibs.fp.operatori.OperatoriRelazionali;
import it.unibs.fp.regola.Orologio;
import it.unibs.fp.regola.Regola;
import org.junit.jupiter.api.Test;

import javax.naming.directory.Attributes;

import static org.junit.jupiter.api.Assertions.*;

class RegolaTest {


    @Test
    void inserisciCostituenteLogico() {
        Regola regola = new Regola();
        regola.inserisciCostituenteLogico();
        assertEquals(1,regola.getAntecedente().size());
    }

    @Test
    void testInserisciCostituenteLogico() {
        Regola regola = new Regola();
        InfoRilevabile infoRilevabile1 = new InfoRilevabileNumerica("InfoRilevabile1",-10,10);
        InfoRilevabile infoRilevabile2 = new InfoRilevabileNumerica("InfoRilevabile2",-10,10);
        OperatoriRelazionali operatoriRelazionali = OperatoriRelazionali.MAGGIORE_UGUALE;
        OperatoriBooleani operatoreBooleano = OperatoriBooleani.AND;
        regola.inserisciCostituenteLogico(infoRilevabile1,infoRilevabile2,operatoriRelazionali,operatoreBooleano);
        assertEquals(1,regola.getAntecedente().size());
    }

    @Test
    void testInserisciCostituenteLogico1() {
        Regola regola = new Regola();
        InfoRilevabile infoRilevabile1 = new InfoRilevabileNumerica("InfoRilevabile1",-10,10);
        String secondoOperatore = "Aperto";
        OperatoriRelazionali operatoriRelazionali = OperatoriRelazionali.MAGGIORE_UGUALE;
        OperatoriBooleani operatoreBooleano = OperatoriBooleani.AND;
        regola.inserisciCostituenteLogico(infoRilevabile1,secondoOperatore,operatoriRelazionali,operatoreBooleano);
        assertEquals(1,regola.getAntecedente().size());
    }

    @Test
    void testInserisciCostituenteLogico2() {
        Regola regola = new Regola();
        InfoRilevabile infoRilevabile1 = new InfoRilevabileNumerica("InfoRilevabile1",-10,10);
        double secondoOperatoreLogico = 10.0;
        OperatoriRelazionali operatoriRelazionali = OperatoriRelazionali.MAGGIORE_UGUALE;
        OperatoriBooleani operatoreBooleano = OperatoriBooleani.AND;
        regola.inserisciCostituenteLogico(infoRilevabile1,secondoOperatoreLogico,operatoriRelazionali,operatoreBooleano);
        assertEquals(1,regola.getAntecedente().size());
    }

    @Test
    void testInserisciCostituenteLogico3() {
        Regola regola = new Regola();
        InfoRilevabile infoRilevabile1 = new InfoRilevabileNumerica("InfoRilevabile1",-10,10);
        String secondoOperatore = "Aperto";
        OperatoriRelazionali operatoriRelazionali = OperatoriRelazionali.MAGGIORE_UGUALE;
        regola.inserisciCostituenteLogico(infoRilevabile1,secondoOperatore,operatoriRelazionali);
        assertEquals(1,regola.getAntecedente().size());
    }

    @Test
    void testInserisciCostituenteLogico4() {
        Regola regola = new Regola();
        InfoRilevabile infoRilevabile1 = new InfoRilevabileNumerica("InfoRilevabile1",-10,10);
        InfoRilevabile infoRilevabile2 = new InfoRilevabileNumerica("InfoRilevabile2",-10,10);
        OperatoriRelazionali operatoriRelazionali = OperatoriRelazionali.MAGGIORE_UGUALE;
        regola.inserisciCostituenteLogico(infoRilevabile1,infoRilevabile2,operatoriRelazionali);
        assertEquals(1,regola.getAntecedente().size());
    }

    @Test
    void testInserisciCostituenteLogico5() {
        Regola regola = new Regola();
        InfoRilevabile infoRilevabile1 = new InfoRilevabileNumerica("InfoRilevabile1",-10,10);
        double secondoOperatoreLogico = 10.0;
        OperatoriRelazionali operatoriRelazionali = OperatoriRelazionali.MAGGIORE_UGUALE;
        regola.inserisciCostituenteLogico(infoRilevabile1,secondoOperatoreLogico,operatoriRelazionali);
        assertEquals(1,regola.getAntecedente().size());
    }

    @Test
    void testInserisciCostituenteLogico6() {
        Regola regola = new Regola();
        Orologio orologio = new Orologio();
        OperatoriRelazionali operatoriRelazionali = OperatoriRelazionali.MAGGIORE_UGUALE;
        regola.inserisciCostituenteLogico(orologio,operatoriRelazionali);
        assertEquals(1,regola.getAntecedente().size());
    }

    //TODO ?
    @Test
    void testInserisciCostituenteLogico7() {
    }

    @Test
    void inserisciAzione() {
        Regola regola = new Regola();
        CategoriaAttuatori categoriaAttuatori = new CategoriaAttuatori();
        Attuatore attuatore = new Attuatore("AttuatoreTest",categoriaAttuatori);
        ModOperativa modOperativa = new ModOperativa("ModOperativa");
        regola.inserisciAzione(attuatore,modOperativa);
        assertEquals(1,regola.getConseguente().size());
    }

    @Test
    void testInserisciAzione() {
        Regola regola = new Regola();
        CategoriaAttuatori categoriaAttuatori = new CategoriaAttuatori();
        Attuatore attuatore = new Attuatore("AttuatoreTest",categoriaAttuatori);
        ModOperativa modOperativa = new ModOperativa("ModOperativa");
        Orologio orologio = new Orologio();
        regola.inserisciAzione(attuatore, modOperativa, orologio);
        assertEquals(1,regola.getConseguente().size());
    }

    @Test
    void visualizzaStatoRegola() {
    }

    @Test
    void testToString() {
    }

    @Test
    void getAntecedente() {
    }

    @Test
    void setAntecedente() {
    }

    @Test
    void getConseguente() {
    }

    @Test
    void setConseguente() {
    }

    @Test
    void getOpBooleani() {
    }

    @Test
    void setOpBooleani() {
    }

    @Test
    void isAttiva() {
    }

    @Test
    void setAttiva() {
    }
}