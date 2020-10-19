package it.unibs.fp.test;

import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.model.unitaImmobiliare.Stanza;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.model.utenti.Manutentore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManutentoreTest {
    private static Manutentore manutentore;
    private static UnitaImmobiliare unitaPerAssegnazioneTest;
    private static Attuatore attuatoreNuovo;
    private static Stanza stanzaNuova;
    private static Artefatto artefattoNuovo;
    private static Sensore sensoreNuovo;
    private static CategoriaAttuatori catAttNuova;
    private static CategoriaSensori catSenNuova;
    private static ListaCategorie listaCategorieNuova;


    //Passa ma non va bene, quando si inizializza MANCANO LE UNITA IMMOBILIARI ATTENZIONE COSTRUTTORE MANUTENTORE
    @Test
    public void assegnazioneTest() {
        unitaPerAssegnazioneTest= new UnitaImmobiliare();
        manutentore = new Manutentore();
        manutentore.aggiungiUnitaImmobiliare(unitaPerAssegnazioneTest);
        assert manutentore.getSizeUnitaImmobiliari() == 1;
    }

    @Test
    void aggiungiUnitaImmobiliare() {
        unitaPerAssegnazioneTest= new UnitaImmobiliare();
        manutentore = new Manutentore();
        manutentore.aggiungiUnitaImmobiliare(unitaPerAssegnazioneTest);
        assertEquals("",manutentore.getUnitaImmobiliari().get(0).getNome());
        assert manutentore.getSizeUnitaImmobiliari() == 1;
    }

    @Test
    void inserisciStanza() {
        unitaPerAssegnazioneTest= new UnitaImmobiliare();
        manutentore = new Manutentore();
        stanzaNuova= new Stanza();
        manutentore.aggiungiUnitaImmobiliare(unitaPerAssegnazioneTest);
        manutentore.inserisciStanza(stanzaNuova,manutentore.getUnitaImmobiliari().get(0));
        assertEquals("",manutentore.getUnitaImmobiliari().get(0).getStanze().get(0).getNome());
        assert manutentore.getUnitaImmobiliari().get(0).getSizeStanze() == 1;
        assert manutentore.getUnitaImmobiliari().get(0).getSizeArtefatti() == 0;
    }

    @Test
    void inserisciArtefatto() {
        unitaPerAssegnazioneTest= new UnitaImmobiliare();
        manutentore = new Manutentore();
        artefattoNuovo= new Artefatto();
        manutentore.aggiungiUnitaImmobiliare(unitaPerAssegnazioneTest);
        manutentore.inserisciArtefatto(artefattoNuovo,manutentore.getUnitaImmobiliari().get(0));
        assertEquals("",manutentore.getUnitaImmobiliari().get(0).getArtefatti().get(0).getNome());
        assert manutentore.getUnitaImmobiliari().get(0).getSizeStanze() == 0;
        assert manutentore.getUnitaImmobiliari().get(0).getSizeArtefatti() == 1;
    }

    @Test
    void associaSensoreAStanze() {
        unitaPerAssegnazioneTest= new UnitaImmobiliare();
        manutentore = new Manutentore();
        manutentore.aggiungiUnitaImmobiliare(unitaPerAssegnazioneTest);
        stanzaNuova= new Stanza();
        sensoreNuovo=new Sensore();
        manutentore.inserisciStanza(stanzaNuova,manutentore.getUnitaImmobiliari().get(0));
        manutentore.associaSensoreAStanze(sensoreNuovo,manutentore.getUnitaImmobiliari().get(0).getStanze(),manutentore.getUnitaImmobiliari().get(0));
        assertEquals("",manutentore.getUnitaImmobiliari().get(0).getStanze().get(0).getSensori().get(0).getNome());
        assert manutentore.getUnitaImmobiliari().get(0).getSizeStanze() == 1;
        assert manutentore.getUnitaImmobiliari().get(0).getSizeArtefatti() == 0;
        assert manutentore.getUnitaImmobiliari().get(0).getSizeRegole() == 0;
    }

    @Test
    void associaAttuatoreAStanze() {
        unitaPerAssegnazioneTest= new UnitaImmobiliare();
        manutentore = new Manutentore();
        manutentore.aggiungiUnitaImmobiliare(unitaPerAssegnazioneTest);
        stanzaNuova= new Stanza();
        attuatoreNuovo=new Attuatore();
        manutentore.inserisciStanza(stanzaNuova,manutentore.getUnitaImmobiliari().get(0));
        manutentore.associaAttuatoreAStanze(attuatoreNuovo,manutentore.getUnitaImmobiliari().get(0).getStanze(),manutentore.getUnitaImmobiliari().get(0));
        assertEquals("",manutentore.getUnitaImmobiliari().get(0).getStanze().get(0).getAttuatori().get(0).getNome());
        assert manutentore.getUnitaImmobiliari().get(0).getSizeStanze() == 1;
        assert manutentore.getUnitaImmobiliari().get(0).getSizeArtefatti() == 0;
        assert manutentore.getUnitaImmobiliari().get(0).getSizeRegole() == 0;
    }

    @Test
    void associaSensoreAdArtefatti() {
        unitaPerAssegnazioneTest= new UnitaImmobiliare();
        manutentore = new Manutentore();
        manutentore.aggiungiUnitaImmobiliare(unitaPerAssegnazioneTest);
        artefattoNuovo= new Artefatto();
        sensoreNuovo=new Sensore();
        manutentore.inserisciArtefatto(artefattoNuovo,manutentore.getUnitaImmobiliari().get(0));
        manutentore.associaSensoreAdArtefatti(sensoreNuovo,manutentore.getUnitaImmobiliari().get(0).getArtefatti(),manutentore.getUnitaImmobiliari().get(0));
        assertEquals("",manutentore.getUnitaImmobiliari().get(0).getArtefatti().get(0).getSensori().get(0).getNome());
        assert manutentore.getUnitaImmobiliari().get(0).getSizeStanze() == 0;
        assert manutentore.getUnitaImmobiliari().get(0).getSizeArtefatti() == 1;
        assert manutentore.getUnitaImmobiliari().get(0).getSizeRegole() == 0;
    }

    @Test
    void associaAttuatoreAdArtefatti() {
        unitaPerAssegnazioneTest= new UnitaImmobiliare();
        manutentore = new Manutentore();
        manutentore.aggiungiUnitaImmobiliare(unitaPerAssegnazioneTest);
        artefattoNuovo= new Artefatto();
        attuatoreNuovo=new Attuatore();
        manutentore.inserisciArtefatto(artefattoNuovo,manutentore.getUnitaImmobiliari().get(0));
        manutentore.associaAttuatoreAdArtefatti(attuatoreNuovo,manutentore.getUnitaImmobiliari().get(0).getArtefatti(),manutentore.getUnitaImmobiliari().get(0));
        assertEquals("",manutentore.getUnitaImmobiliari().get(0).getArtefatti().get(0).getAttuatori().get(0).getNome());
        assert manutentore.getUnitaImmobiliari().get(0).getSizeStanze() == 0;
        assert manutentore.getUnitaImmobiliari().get(0).getSizeArtefatti() == 1;
        assert manutentore.getUnitaImmobiliari().get(0).getSizeRegole() == 0;
    }

    @Test
    void associaArtefattoAStanze() {
        unitaPerAssegnazioneTest= new UnitaImmobiliare();
        manutentore = new Manutentore();
        manutentore.aggiungiUnitaImmobiliare(unitaPerAssegnazioneTest);
        artefattoNuovo= new Artefatto();
        stanzaNuova= new Stanza();
        manutentore.inserisciStanza(stanzaNuova,manutentore.getUnitaImmobiliari().get(0));
        manutentore.associaArtefattoAStanze(artefattoNuovo,manutentore.getUnitaImmobiliari().get(0).getStanze(),manutentore.getUnitaImmobiliari().get(0));
        assertEquals("",manutentore.getUnitaImmobiliari().get(0).getStanze().get(0).getArtefatti().get(0).getNome());
        assert manutentore.getUnitaImmobiliari().get(0).getSizeStanze() == 1;
        assert manutentore.getUnitaImmobiliari().get(0).getSizeArtefatti() == 0;
        assert manutentore.getUnitaImmobiliari().get(0).getSizeRegole() == 0;
    }

    //TODO MA COME LO TESTO?
    @Test
    void inserisciESalvaCategoriaAttuatori() {
        unitaPerAssegnazioneTest= new UnitaImmobiliare();
        manutentore = new Manutentore();
        manutentore.aggiungiUnitaImmobiliare(unitaPerAssegnazioneTest);
        catAttNuova= new CategoriaAttuatori();
        listaCategorieNuova= new ListaCategorie();
        manutentore.inserisciESalvaCategoriaAttuatori(listaCategorieNuova,catAttNuova);
        assert manutentore.getUnitaImmobiliari().get(0).getSizeStanze() == 0;
        assert manutentore.getUnitaImmobiliari().get(0).getSizeArtefatti() == 0;
        assert manutentore.getUnitaImmobiliari().get(0).getSizeRegole() == 0;
    }

    @Test
    void inserisciESalvaCategoriaSensori() {
        unitaPerAssegnazioneTest= new UnitaImmobiliare();
        manutentore = new Manutentore();
        manutentore.aggiungiUnitaImmobiliare(unitaPerAssegnazioneTest);
        catSenNuova= new CategoriaSensori();
        listaCategorieNuova= new ListaCategorie();
        manutentore.inserisciESalvaCategoriaSensori(listaCategorieNuova,catSenNuova);
        assert manutentore.getUnitaImmobiliari().get(0).getSizeStanze() == 0;
        assert manutentore.getUnitaImmobiliari().get(0).getSizeArtefatti() == 0;
        assert manutentore.getUnitaImmobiliari().get(0).getSizeRegole() == 0;
    }

}