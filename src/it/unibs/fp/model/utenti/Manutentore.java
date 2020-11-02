package it.unibs.fp.model.utenti;

import it.unibs.fp.model.categoria.CategoriaAttuatori;
import it.unibs.fp.model.categoria.CategoriaSensori;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.model.unitaImmobiliare.*;
import it.unibs.fp.view.classiDiServizio.utenti.ClasseDiServizioFruitore;

import java.io.Serializable;

public class Manutentore implements Serializable {
    private Fruitore fruitore;
    private String nome;


    public Manutentore(String nome, Fruitore fruitore) {
        this.nome = nome;
        this.fruitore = fruitore;
    }

    /**
     * Aggiunta di un unità immobiliare
     *
     * @param unitaImmobiliare da inserire nella lista
     */
    public void aggiungiUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) {
        fruitore.inserisciUnitaImmobiliare(unitaImmobiliare);
    }


    /**
     * Inserisci una nuova stanza nell'unità immobiliare
     *
     * @param stanza           nuova da aggiungere
     * @param unitaImmobiliare esistente
     */
    public void inserisciStanza(Stanza stanza, UnitaImmobiliare unitaImmobiliare) {
        fruitore.inserisciStanza(stanza, unitaImmobiliare);
    }

    /**
     * Inserisci un nuova artefatto nell'unità immobiliare
     *
     * @param artefatto        nuovo da aggiungere
     * @param unitaImmobiliare esistente
     */
    public void inserisciArtefatto(Artefatto artefatto, UnitaImmobiliare unitaImmobiliare) {
        fruitore.inserisciArtefatto(artefatto, unitaImmobiliare);
    }

    /**
     * Associa un sensore ad una certa quantità di stanze
     *
     * @param sensoreAss       da associare alle stanze
     * @param stanzeAss        stanze scelte
     * @param unitaImmobiliare che contiene le stanze
     */
    public void associaSensoreAStanze(Sensore sensoreAss, Stanze stanzeAss, UnitaImmobiliare unitaImmobiliare) {
        fruitore.associaSensoreAStanze(sensoreAss, stanzeAss, unitaImmobiliare);
    }

    /**
     * Associa un attuatore ad una certa quantità di stanze
     *
     * @param attuatoreAss     da associare alle stanze
     * @param stanzeAss        stanze scelte
     * @param unitaImmobiliare che contiene le stanze
     */
    public void associaAttuatoreAStanze(Attuatore attuatoreAss, Stanze stanzeAss, UnitaImmobiliare unitaImmobiliare) {
        fruitore.associaAttuatoreAStanze(attuatoreAss, stanzeAss, unitaImmobiliare);
    }

    /**
     * Associa un sensore ad una certa quantità di artefatti
     *
     * @param sensoreAss       da associare agli artefatti
     * @param artefattoAss     artefatti scelti
     * @param unitaImmobiliare che contiene gli artefatti
     */
    public void associaSensoreAdArtefatti(Sensore sensoreAss, Artefatti artefattoAss, UnitaImmobiliare unitaImmobiliare) {
        fruitore.associaSensoreAdArtefatti(sensoreAss, artefattoAss, unitaImmobiliare);
    }

    /**
     * Associa un attuatore ad una certa quantità di artefatti
     *
     * @param attuatoreAss     da associare agli artefatti
     * @param artefattoAss     artefatti scelti
     * @param unitaImmobiliare che contiene gli artefatti
     */
    public void associaAttuatoreAdArtefatti(Attuatore attuatoreAss, Artefatti artefattoAss, UnitaImmobiliare unitaImmobiliare) {
        fruitore.associaAttuatoreAdArtefatti(attuatoreAss, artefattoAss, unitaImmobiliare);
    }

    /**
     * Associa artefatto a stanze
     *
     * @param artefatto        da associare alle stanze
     * @param stanzeAss        stanze scelte
     * @param unitaImmobiliare che contiene gli artefatti
     */
    public void associaArtefattoAStanze(Artefatto artefatto, Stanze stanzeAss, UnitaImmobiliare unitaImmobiliare) {
        fruitore.associaArtefattoAStanze(artefatto, stanzeAss, unitaImmobiliare);
    }


    /**
     * Inseriscce e salva una categoria di attuatori se non esiste già
     *
     * @param listaCategorie     lista delle categorie esistenti
     * @param categoriaAttuatori nuova categoria di attuatori
     */
    public void inserisciESalvaCategoriaAttuatori(ListaCategorie listaCategorie, CategoriaAttuatori categoriaAttuatori) {
        boolean found = false;
        for (CategoriaAttuatori c : listaCategorie.getCategorieAttuatori())
            if (c.getNome().equals(categoriaAttuatori.getNome())) {
                found = true;
                break;
            }

        if (!found)
            listaCategorie.inserisciESalvaCategoriaAttuatori(categoriaAttuatori);
    }

    /**
     * Inseriscce e salva una categoria di sensori se non esiste già
     *
     * @param listaCategorie   lista delle categorie esistenti
     * @param categoriaSensori nuova categoria di sensori
     */
    public void inserisciESalvaCategoriaSensori(ListaCategorie listaCategorie, CategoriaSensori categoriaSensori) {
        boolean found = false;
        for (CategoriaSensori s : listaCategorie.getCategorieSensori())
            if (s.getNome().equals(categoriaSensori.getNome())) {
                found = true;
                break;
            }
        if (!found)
            listaCategorie.inserisciESalvaCategoriaSensori(categoriaSensori);
    }


    /**
     * Getter
     *
     * @return fruitore
     */
    public Fruitore getFruitore() {
        return fruitore;
    }

    /**
     * Setter
     *
     * @param fruitore scelto
     */
    public void setFruitore(Fruitore fruitore) {
        this.fruitore = fruitore;
    }

    /**
     * Getter
     *
     * @return SizeUnitaImmobiliare
     */
    public int getSizeUnitaImmobiliari() {
        return fruitore.getSizeUnitaImmobiliariInFruitore();
    }

    /**
     * Getter
     *
     * @return unitaImmobiliare
     */
    public UnitaImmobiliari getUnitaImmobiliari() {
        return fruitore.getUnitaImmobiliariInFruitore();
    }

    /**
     * Setter
     *
     * @param unitaImmobiliari da modificare
     */
    public void setUnitaImmobiliari(UnitaImmobiliari unitaImmobiliari) {
        fruitore.setUnitaImmobiliari(unitaImmobiliari);
    }
}
