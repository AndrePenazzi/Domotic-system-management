package it.unibs.fp;

import it.unibs.fp.dao.file.Contenitore;
import it.unibs.fp.dao.file.ContenitoreDAO;
import it.unibs.fp.model.categoria.ListaCategorie;
import it.unibs.fp.model.unitaImmobiliare.Artefatto;
import it.unibs.fp.model.unitaImmobiliare.Stanza;
import it.unibs.fp.model.unitaImmobiliare.Stanze;
import it.unibs.fp.model.unitaImmobiliare.UnitaImmobiliare;
import it.unibs.fp.view.classiDiServizio.ClasseDiServizio;
import it.unibs.fp.view.mylib.*;
import it.unibs.fp.model.utenti.Fruitore;
import it.unibs.fp.model.utenti.Manutentore;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static ContenitoreDAO contenitoreDAO;

    public static void main(String[] args) {
        //creaFileDAO();
        //Contenitore contenitore = contenitoreDAO.carica();

        //Fruitore fruitore = contenitore.getManutentore().getFruitore();

        //Manutentore manutentore = contenitore.getManutentore();

        //ListaCategorie listaCategorie = contenitore.getListaCategorie();

        //DA ELIMINARE
        Fruitore fruitore = new Fruitore("Simranjeet");
        UnitaImmobiliare unitaImmobiliare1 = new UnitaImmobiliare("Casa di Gablito");
        UnitaImmobiliare unitaImmobiliare2 = new UnitaImmobiliare("Casa di Pavneesh");
        Stanza stanza1 = new Stanza("cucina");
        Stanza stanza2 = new Stanza("salotto");
        Stanza stanza3 = new Stanza("garage");
        Stanza stanza4 = new Stanza("corridoio");
        Artefatto artefatto1 = new Artefatto("cancello");
        Artefatto artefatto2 = new Artefatto("annaffiatoio");
        Artefatto artefattoInStanza1 = new Artefatto("tapparelle");
        Artefatto artefattoInStanza2 = new Artefatto("lampadario");

        Stanze stanzeTemporanee1 = new Stanze();

        unitaImmobiliare1.inserisciArtefatto(artefatto1);
        unitaImmobiliare1.inserisciArtefatto(artefatto2);
        unitaImmobiliare2.inserisciArtefatto(artefatto1);

        unitaImmobiliare1.inserisciStanza(stanza1);
        unitaImmobiliare1.inserisciStanza(stanza2);
        unitaImmobiliare1.inserisciStanza(stanza3);
        unitaImmobiliare1.inserisciStanza(stanza4);
        unitaImmobiliare2.inserisciStanza(stanza3);
        unitaImmobiliare2.inserisciStanza(stanza4);

        stanzeTemporanee1.setStanze(Arrays.asList(unitaImmobiliare1.getStanza(0), unitaImmobiliare1.getStanza(1)));
        unitaImmobiliare1.associaArtefattoAStanze(artefattoInStanza1, stanzeTemporanee1);
        stanzeTemporanee1.setStanze(Arrays.asList(unitaImmobiliare1.getStanza(2), unitaImmobiliare1.getStanza(3)));
        unitaImmobiliare1.associaArtefattoAStanze(artefattoInStanza2,stanzeTemporanee1);
        stanzeTemporanee1.setStanze(Arrays.asList(unitaImmobiliare1.getStanza(2), unitaImmobiliare1.getStanza(3)));
        unitaImmobiliare2.associaArtefattoAStanze(artefattoInStanza2,stanzeTemporanee1);


        fruitore.inserisciUnitaImmobiliare(unitaImmobiliare1);
        fruitore.inserisciUnitaImmobiliare(unitaImmobiliare2);
        Manutentore manutentore = new Manutentore("Abhinandan", fruitore);
        ListaCategorie listaCategorie = new ListaCategorie();


        //FINO A QUA


        System.out.println(BelleStringhe.incornicia("Benvenuto"));
        ClasseDiServizio.menuPrincipale(fruitore, manutentore, listaCategorie);

    }

    private static void creaFileDAO() {
        contenitoreDAO = new ContenitoreDAO();
    }
}
