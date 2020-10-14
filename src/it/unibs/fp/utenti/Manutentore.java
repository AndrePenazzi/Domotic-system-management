package it.unibs.fp.utenti;

import it.unibs.fp.categoria.CategoriaAttuatori;
import it.unibs.fp.categoria.CategoriaSensori;
import it.unibs.fp.categoria.ListaCategorie;
import it.unibs.fp.dispositiviPeriferici.Attuatore;
import it.unibs.fp.dispositiviPeriferici.Sensore;
import it.unibs.fp.unitaImmobiliare.Artefatto;
import it.unibs.fp.unitaImmobiliare.Stanza;
import it.unibs.fp.unitaImmobiliare.UnitaImmobiliare;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Manutentore implements Serializable {
    private Fruitore fruitore;

    /**
     * Costruttore
     *
     * @param fruitore l'unico fruitore associato
     */
    public Manutentore(Fruitore fruitore) {
        this.fruitore = fruitore;
    }
    public Manutentore() {
        this.fruitore = new Fruitore();
    }

    /**
     * Aggiunta di un unità immobiliare
     *
     * @param unitaImmobiliare da inserire nella lista
     */
    public void aggiungiUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) {
        fruitore.aggiungiUnitaImmobiliare(unitaImmobiliare);
    }

    /**
     * visualizza la lista dei nomi delle unità immobiliari
     *
     * @return la lista dei nomi delle unità immobiliari
     */
    public String visualizzaListaUnitaImmobiliari() {
        return fruitore.visualizzaListaUnitaImmobiliari();
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
    public void associaSensoreAStanze(Sensore sensoreAss, List<Stanza> stanzeAss, UnitaImmobiliare unitaImmobiliare) {
        fruitore.associaSensoreAStanze(sensoreAss, stanzeAss, unitaImmobiliare);
    }

    /**
     * Associa un attuatore ad una certa quantità di stanze
     *
     * @param attuatoreAss     da associare alle stanze
     * @param stanzeAss        stanze scelte
     * @param unitaImmobiliare che contiene le stanze
     */
    public void associaAttuatoreAStanze(Attuatore attuatoreAss, List<Stanza> stanzeAss, UnitaImmobiliare unitaImmobiliare) {
        fruitore.associaAttuatoreAStanze(attuatoreAss, stanzeAss, unitaImmobiliare);
    }

    /**
     * Associa un sensore ad una certa quantità di artefatti
     *
     * @param sensoreAss       da associare agli artefatti
     * @param artefattoAss     artefatti scelti
     * @param unitaImmobiliare che contiene gli artefatti
     */
    public void associaSensoreAdArtefatti(Sensore sensoreAss, List<Artefatto> artefattoAss, UnitaImmobiliare unitaImmobiliare) {
        fruitore.associaSensoreAdArtefatti(sensoreAss, artefattoAss, unitaImmobiliare);
    }

    /**
     * Associa un attuatore ad una certa quantità di artefatti
     *
     * @param attuatoreAss     da associare agli artefatti
     * @param artefattoAss     artefatti scelti
     * @param unitaImmobiliare che contiene gli artefatti
     */
    public void associaAttuatoreAdArtefatti(Attuatore attuatoreAss, List<Artefatto> artefattoAss, UnitaImmobiliare unitaImmobiliare) {
        fruitore.associaAttuatoreAdArtefatti(attuatoreAss, artefattoAss, unitaImmobiliare);
    }

    /**
     * Associa artefatto a stanze
     *
     * @param artefatto        da associare alle stanze
     * @param stanzeAss        stanze scelte
     * @param unitaImmobiliare che contiene gli artefatti
     */
    public void associaArtefattoAStanze(Artefatto artefatto, List<Stanza> stanzeAss, UnitaImmobiliare unitaImmobiliare) {
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
     * Visualizza la descrizione dei sensori delle categorie sensori
     *
     * @param listaCategorie scelta
     * @return la descrizione delle categorie sensori
     */
    public String visualizzaDescrizioneCatergorieSensori(ListaCategorie listaCategorie) {
        return (listaCategorie.visualizzaCategorieSensori());
    }

    /**
     * Visualizza la descrizione degli attuatori delle categorie attuatori
     *
     * @param listaCategorie scelta
     * @return la descrizione delle categorie attuatori
     */
    public String visualizzaDescrizioneCatergorieAttuatori(ListaCategorie listaCategorie) {
        return (listaCategorie.visualizzaCategorieAttuatori());
    }

    /**
     * Visualizza la descrizione delle stanze dell'unità immobiliare
     *
     * @param unitaImmobiliare scelta
     * @return la descrizione delle stanze
     */
    public String visualizzaStanze(UnitaImmobiliare unitaImmobiliare) {
        return (unitaImmobiliare.visualizzaStanze());
    }

    /**
     * Visualizza la descrizione degli artefatti dell'unità immobiliare
     *
     * @param unitaImmobiliare scelta
     * @return la descrizione degli artefatti
     */
    public String visualizzaArtefatti(UnitaImmobiliare unitaImmobiliare) {
        return (fruitore.visualizzaArtefatti(unitaImmobiliare));
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
        return fruitore.getUnitaImmobiliari().size();
    }

    /**
     * Getter
     *
     * @return unitaImmobiliare
     */
    public List<UnitaImmobiliare> getUnitaImmobiliari() {
        return fruitore.getUnitaImmobiliari();
    }

    /**
     * Setter
     *
     * @param unitaImmobiliari da modificare
     */
    public void setUnitaImmobiliari(ArrayList<UnitaImmobiliare> unitaImmobiliari) {
        fruitore.setUnitaImmobiliari(unitaImmobiliari);
    }
}
