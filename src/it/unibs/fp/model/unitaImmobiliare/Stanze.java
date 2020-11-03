package it.unibs.fp.model.unitaImmobiliare;

import it.unibs.fp.model.dispositiviPeriferici.Attuatori;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Stanze implements Serializable {
    private List<Stanza> stanze;

    public Stanze() {
        stanze = new ArrayList<>();
    }

    /**
     * Getter
     *
     * @return stanze
     */
    public List<Stanza> getStanze() {
        return stanze;
    }

    public void setStanze(List<Stanza> stanze) {
        this.stanze = stanze;
    }

    public int getSizeStanze() {
        return stanze.size();
    }

    public Stanza getStanza(int i) {
        return stanze.get(i);
    }

    public Attuatori getAttuatoriInStanze() {
        Attuatori attuatori = new Attuatori();

        for (Stanza s : stanze) {
            for (int i = 0; i < s.getSizeArtefatti(); i++) {
                Artefatto artefatto = s.getArtefatto(i);
                for (int j = 0; j < artefatto.getSizeAttuatoriInArtefatto(); j++) {
                    attuatori.inserisciAttuatore(artefatto.getAttuatoreInArtefatto(j));
                }
            }
            for (int k = 0; k < s.getSizeAttuatori(); k++)
                attuatori.inserisciAttuatore(s.getAttuatoreInStanza(k));
        }
        return attuatori;
    }

    /**
     * Check if stanze is empty
     *
     * @return true if is empty
     */
    public boolean isEmpty() {
        return stanze.isEmpty();
    }


    public void inserisciStanza(Stanza stanza) {
        stanze.add(stanza);
    }
}
