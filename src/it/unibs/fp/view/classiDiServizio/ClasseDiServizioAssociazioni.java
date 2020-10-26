package it.unibs.fp.view.classiDiServizio;

import it.unibs.fp.dao.file.Contenitore;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.dispositiviPeriferici.Attuatore;
import it.unibs.fp.model.dispositiviPeriferici.Sensore;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioAttuatore;
import it.unibs.fp.view.classiDiServizio.dispositiviPeriferici.ClasseDiServizioSensore;
import it.unibs.fp.view.classiDiServizio.unitaImmobiliare.ClasseDiServizioUnitaImmobiliare;
import it.unibs.fp.view.mylib.InputDati;
import it.unibs.fp.view.mylib.ServizioFile;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.model.unitaImmobiliare.Stanza;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.model.utenti.Manutentore;

import java.io.File;
import java.util.List;

public class ClasseDiServizioAssociazioni {

    //----------------------------------ASSOCIA-----------------------------------------------------

    /**
     * Associa un artefatto ad una o più stanze
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void associaArtefattoAStanze(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = ClasseDiServizioInserimenti.scegliUnitaImmobiliare(manutentore);//TODO DA SPOSTARE ALL'ESTERNO fallo scegliere prima
        if (!unitaImmobiliare.getArtefatti().isEmpty())
            do {
                Artefatto artefatto = ClasseDiServizioUnitaImmobiliare.scegliArtefatto(unitaImmobiliare);
                List<Stanza> stanze = ClasseDiServizioUnitaImmobiliare.scegliStanze(unitaImmobiliare);
                manutentore.associaArtefattoAStanze(artefatto, stanze, unitaImmobiliare);
                contenitore.setListaCategorie(listaCategorie);
                contenitore.setManutentore(manutentore);
                ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
            } while (InputDati.yesOrNo("Vuoi associare un'altro artefatto a stanze?"));
        else
            System.out.println("Bisogna prima creare un artefatto");

    }

    /**
     * Associa un sensore ad una o più stanze
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void associaSensoreAStanze(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = ClasseDiServizioInserimenti.scegliUnitaImmobiliare(manutentore);

        if (!listaCategorie.getCategorieSensori().isEmpty() && !unitaImmobiliare.getStanze().isEmpty()) {
            do {
                Sensore nuovoSensore = ClasseDiServizioSensore.creaSensore(listaCategorie);
                List<Stanza> stanze = ClasseDiServizioUnitaImmobiliare.scegliStanze(unitaImmobiliare);
                manutentore.associaSensoreAStanze(nuovoSensore, stanze, unitaImmobiliare);

                contenitore.setListaCategorie(listaCategorie);
                contenitore.setManutentore(manutentore);
                ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
            } while (InputDati.yesOrNo("Vuoi associare un'altro sensore a una stanza?"));
        } else {
            if (listaCategorie.getCategorieSensori().isEmpty())
                System.out.println("Bisogna prima creare una categoria sensori");
            if (unitaImmobiliare.getStanze().isEmpty())
                System.out.println("Bisogna prima avere una stanza nell'unità immobiliare");
        }
    }

    /**
     * Associa un attuatore a una o piu stanze
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void associaAttuatoreAStanze(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = ClasseDiServizioInserimenti.scegliUnitaImmobiliare(manutentore);//TODO DA SPOSTARE ALL'ESTERNO fallo scegliere prima

        if (!listaCategorie.getCategorieAttuatori().isEmpty() && !unitaImmobiliare.getStanze().isEmpty()) {
            do {
                Attuatore nuovoAttuatore = ClasseDiServizioAttuatore.creaAttuatore(listaCategorie);
                List<Stanza> stanze = ClasseDiServizioUnitaImmobiliare.scegliStanze(unitaImmobiliare);
                manutentore.associaAttuatoreAStanze(nuovoAttuatore, stanze, unitaImmobiliare);
                contenitore.setListaCategorie(listaCategorie);
                contenitore.setManutentore(manutentore);
                ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
            } while (InputDati.yesOrNo("Vuoi associare un'altro sensore a stanze?"));
        } else {
            if (listaCategorie.getCategorieAttuatori().isEmpty())
                System.out.println("Bisogna prima creare una categoria attuatori");
            if (unitaImmobiliare.getStanze().isEmpty())
                System.out.println("Bisogna prima avere una stanza nell'unità immobiliare");
        }
    }

    /**
     * Associa un sensore ad uno o piu artefatti
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void associaSensoreAdArtefatti(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = ClasseDiServizioInserimenti.scegliUnitaImmobiliare(manutentore);
        if (!unitaImmobiliare.getArtefatti().isEmpty() && !listaCategorie.getCategorieSensori().isEmpty()) {
            do {
                Sensore nuovoSensore = ClasseDiServizioSensore.creaSensore(listaCategorie);
                List<Artefatto> artefatti = ClasseDiServizioUnitaImmobiliare.scegliArtefatti(unitaImmobiliare);
                for (Artefatto a : artefatti)
                    for (Sensore s : a.getSensori())
                        if (nuovoSensore.getCategoriaSensori() == s.getCategoriaSensori())
                            System.out.println("Esite già un sensore con la stessa categoria in uno degli artefatti");

                manutentore.associaSensoreAdArtefatti(nuovoSensore, artefatti, unitaImmobiliare);

                contenitore.setListaCategorie(listaCategorie);
                contenitore.setManutentore(manutentore);
                ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
            } while (InputDati.yesOrNo("Vuoi associare un'altro sensore ad artefatti?"));
        } else {
            if (listaCategorie.getCategorieSensori().isEmpty())
                System.out.println("Bisogna prima creare una categoria sensori");
            if (unitaImmobiliare.getArtefatti().isEmpty())
                System.out.println("Bisogna prima avere un artefatto nell'unità immobiliare");
        }
    }

    /**
     * Associa un attuatore ad uno o piu artefatti
     *
     * @param contenitore per ottenere gli oggetti necessari
     */
    static void associaAttuatoreAdArtefatti(Contenitore contenitore) {
        ListaCategorie listaCategorie = contenitore.getListaCategorie();
        Manutentore manutentore = contenitore.getManutentore();
        UnitaImmobiliare unitaImmobiliare = ClasseDiServizioInserimenti.scegliUnitaImmobiliare(manutentore);//TODO DA SPOSTARE ALL'ESTERNO fallo scegliere prima
        if (!unitaImmobiliare.getArtefatti().isEmpty() && !listaCategorie.getCategorieAttuatori().isEmpty()) {
            do {
                Attuatore nuovoAttuatore = ClasseDiServizioAttuatore.creaAttuatore(listaCategorie);
                List<Artefatto> artefatti = ClasseDiServizioUnitaImmobiliare.scegliArtefatti(unitaImmobiliare);
                manutentore.associaAttuatoreAdArtefatti(nuovoAttuatore, artefatti, unitaImmobiliare);

                contenitore.setListaCategorie(listaCategorie);
                contenitore.setManutentore(manutentore);
                ServizioFile.salvaSingoloOggetto(new File("contenitore.dat"), contenitore);
            } while (InputDati.yesOrNo("Vuoi associare un'altro attuatore ad artefatti?"));
        } else {
            if (listaCategorie.getCategorieAttuatori().isEmpty())
                System.out.println("Bisogna prima creare una categoria attuatori");
            if (unitaImmobiliare.getArtefatti().isEmpty())
                System.out.println("Bisogna prima avere un artefatto nell'unità immobiliare");
        }
    }


    //-----------------------------FINE ASSOCIA-----------------------------------------------------

}
