package it.unibs.fp.view.classiDiServizio;

import it.unibs.fp.dao.file.Contenitore;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNonNumerica;
import it.unibs.fp.model.regola.Regole;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioCategoriaAttuatori;
import it.unibs.fp.view.classiDiServizio.categoria.ClasseDiServizioCategoriaSensori;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioArtefatto;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioStanza;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioUnitaImmobiliare;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.ServizioFile;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.model.utenti.Manutentore;

import java.io.File;
import java.util.List;

public class ClasseDiServizioInserimenti {
    //-----------------------------INSERISCI-----------------------------------------------------

    /**
     * Inseriesci e salva una o piu categoria di attuatori
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void inserisciESalvaCategioriaAttuatori(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        do {
            manutentore.inserisciESalvaCategoriaAttuatori(listaCategorie, ClasseDiServizioCategoriaAttuatori.creaCategoriaAttuatori());
            contenitore.setListaCategorie(listaCategorie);
            contenitore.setManutentore(manutentore);
            ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
        } while (InputDati.yesOrNo("Vuoi inserire un'altra categoria attuatori?"));
        ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
    }

    /**
     * Inserisci e salva uno o piu categorie di sensori
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void inserisciESalvaCategioriaSensori(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        do {
            manutentore.inserisciESalvaCategoriaSensori(listaCategorie, ClasseDiServizioCategoriaSensori.creaCategoriaSensori());
            contenitore.setListaCategorie(listaCategorie);
            contenitore.setManutentore(manutentore);
            ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);

        } while (InputDati.yesOrNo("Vuoi inserire un'altra categoria sensori?"));
    }

    /**
     * Inserisci uno o piu nuovi artefatti
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void inserisciNuovoArtefatto(Contenitore contenitore) {
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(manutentore);
        do {
            manutentore.inserisciArtefatto(ClasseDiServizioArtefatto.creaArtefatto(), unitaImmobiliare);

            contenitore.setManutentore(manutentore);
            ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
        } while (InputDati.yesOrNo("Vuoi inserire un'altro artefatto?"));

    }

    /**
     * Inserisci una o piu nuove stanze
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void inserisciNuovaStanza(Contenitore contenitore) {
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = scegliUnitaImmobiliare(manutentore);
        do {
            manutentore.inserisciStanza(ClasseDiServizioStanza.creaStanza(), unitaImmobiliare);
            contenitore.setManutentore(manutentore);
            ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
        } while (InputDati.yesOrNo("Vuoi inserire un'altra stanza?"));
    }

    /**
     * Scegli un unità immobiliare
     *
     * @param manutentore che gestisce le unitaImmobiliari
     * @return unitaImmobiliare scelta
     */
    static UnitaImmobiliare scegliUnitaImmobiliare(Manutentore manutentore) {
        List<UnitaImmobiliare> unitaImmobiliari = manutentore.getUnitaImmobiliari();
        System.out.println(manutentore.visualizzaListaUnitaImmobiliari());
        int unitaImmobiliareScelta = InputDati.leggiIntero("Scegli UnitaImmobiliare : ", 1, manutentore.getSizeUnitaImmobiliari());
        return unitaImmobiliari.get(--unitaImmobiliareScelta);
    }

    //-----------------------------FINE INSERISCI-----------------------------------------------



    //-----------------------------CREA------------------------------------------------------------

    /**
     * Scegli un parametro con cui confrontare
     *
     * @param infoRilevabileNonNumerica informazione rilevabile non numerica
     * @return una stringa confrontata
     */
    static String scegliParametroConCuiConfrontare(InfoRilevabileNonNumerica infoRilevabileNonNumerica) { //TODO è per la creazione della regola, CONFRONTA DIVERSE COSE IN STANZE DIVERSE O ALTRO?
        int i = 1;
        for (String valore : infoRilevabileNonNumerica.getValori()) {
            System.out.println(i + " " + valore);
        }
        int scelta = InputDati.leggiIntero("Scegliere parametro con cui confrontare");
        return infoRilevabileNonNumerica.getValori().get(scelta);
    }

    //-----------------------------FINE SCEGLI-----------------------------------------------------


    /**
     * Inserisci una nuova unitàImmobiliare
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    public static void inserisciUnitaImmobiliare(Contenitore contenitore) {
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = ClasseDiServizioUnitaImmobiliare.creaUnitaImmobiliare();
        manutentore.aggiungiUnitaImmobiliare(unitaImmobiliare);
        contenitore.setManutentore(manutentore);
        ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
    }
}