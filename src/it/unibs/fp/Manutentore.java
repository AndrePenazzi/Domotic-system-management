package it.unibs.fp;

import java.io.Serializable;
import java.util.ArrayList;

public class Manutentore implements Serializable {

    public Manutentore() {
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
     * Inserisci una nuova stanza nell'unità immobiliare
     *
     * @param stanza           nuova da aggiungere
     * @param unitaImmobiliare esistente
     */
    public void inserisciStanza(Stanza stanza, UnitaImmobiliare unitaImmobiliare) {
        unitaImmobiliare.inserisciStanza(stanza);
    }

    /**
     * Inserisci un nuova artefatto nell'unità immobiliare
     *
     * @param artefatto        nuovo da aggiungere
     * @param unitaImmobiliare esistente
     */
    public void inserisciArtefatto(Artefatto artefatto, UnitaImmobiliare unitaImmobiliare) {
        unitaImmobiliare.inserisciArtefatto(artefatto);
    }

    //TODO da aggiungere nell'UML e da finire
    public void inserisciArtefattoInStanza() {

    }

    /**
     * Associa un sensore ad una certa quantità di stanze
     *
     * @param sensoreAss       da associare alle stanze
     * @param stanzeAss        stanze scelte
     * @param unitaImmobiliare che contiene le stanze
     */
    public void associaSensoreAStanze(Sensore sensoreAss, ArrayList<Stanza> stanzeAss, UnitaImmobiliare unitaImmobiliare) {
        unitaImmobiliare.associaSensoreAStanze(sensoreAss, stanzeAss);
    }

    /**
     * Associa un attuatore ad una certa quantità di stanze
     *
     * @param attuatoreAss     da associare alle stanze
     * @param stanzeAss        stanze scelte
     * @param unitaImmobiliare che contiene le stanze
     */
    public void associaAttuatoreAStanze(Attuatore attuatoreAss, ArrayList<Stanza> stanzeAss, UnitaImmobiliare unitaImmobiliare) {
        unitaImmobiliare.associaAttuatoreAStanze(attuatoreAss, stanzeAss);
    }

    /**
     * Associa un sensore ad una certa quantità di artefatti
     *
     * @param sensoreAss       da associare agli artefatti
     * @param artefattoAss     artefatti scelti
     * @param unitaImmobiliare che contiene gli artefatti
     */
    public void associaSensoreAdArtefatti(Sensore sensoreAss, ArrayList<Artefatto> artefattoAss, UnitaImmobiliare unitaImmobiliare) {
        unitaImmobiliare.associaSensoreAdArtefatti(sensoreAss, artefattoAss);
    }

    /**
     * Associa un attuatore ad una certa quantità di artefatti
     *
     * @param attuatoreAss     da associare agli artefatti
     * @param artefattoAss     artefatti scelti
     * @param unitaImmobiliare che contiene gli artefatti
     */
    public void associaAttuatoreAdArtefatti(Attuatore attuatoreAss, ArrayList<Artefatto> artefattoAss, UnitaImmobiliare unitaImmobiliare) {
        unitaImmobiliare.associaAttuatoreAdArtefatti(attuatoreAss, artefattoAss);
    }

    /**
     * Visualizza la descrizione delle categorie
     *
     * @param listaCategorie scelta
     * @return la descrizione da visualizzare
     */
    public String visualizzaDescrizioneCatergorie(ListaCategorie listaCategorie) {
        return listaCategorie.toString();
    }

    /**
     * Visualizza la descrizione delle stanze dell'unità immobiliare richiesta
     *
     * @param unitaImmobiliare da visualizzare
     * @return la descrizione delle stanze
     */
    public String visualizzaDescrizioneStanze(UnitaImmobiliare unitaImmobiliare) {
        return unitaImmobiliare.visualizzaStanze();
    }

    /**
     * Visualizza la descrizione delgli artefatti dell'unità immobiliare richiesta
     *
     * @param unitaImmobiliare da visualizzare
     * @return la descrizione degli artefatti
     */
    public String visualizzaDescrizioneArtefatti(UnitaImmobiliare unitaImmobiliare) {
        return unitaImmobiliare.visualizzaArtefatti();
    }

    /**
     * Visualizza la descrizione dell'unità immobiliare richiesta
     *
     * @param unitaImmobiliare da visualizzare
     * @return la descrizione dell'unitaImmobiliare
     */
    public String visualizzaDescrizioneUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) {
        return unitaImmobiliare.toString();
    }

}
