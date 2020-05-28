package it.unibs.fp;

import it.unibs.fp.mylib.*;

import java.util.ArrayList;

public class Main {
    private static final String [] s = {"Accedi come manutentore","Accedi come fruitore"};
    public static void main(String args[]){
        Manutentore manutentore = new Manutentore();
        UnitàImmobiliare unitàImmobiliare = new UnitàImmobiliare("CasaPav");
        Fruitore fruitore = new Fruitore();

        System.out.println(BelleStringhe.incornicia("Benvenuto"));
        boolean finito = false;
        String[] azione = {"Accedi come manutentore","Accedi come fruitore" };
        MyMenu menu = new MyMenu("Menu principal amigo", azione);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito=true;
                    System.out.println("Grazie per aver usato DomoticSystemManagement");
                }
                break;

                case 1:{
                    stampaMenuManutentore(manutentore, unitàImmobiliare);

                }
                break;

                case 2:
                    System.out.println("ciao 2");
                    break;
            }
        } while (!finito);
    }

    private static void stampaMenuManutentore(Manutentore manutentore, UnitàImmobiliare unitàImmobiliare){
        boolean finito = false;
        String[] azione = {"Inserisci e salva categoria sensori","Inserisci e salva categoria attuatori","Inserisci nuova stanza","Inserisci nuovo artefatto","Associa sensore a stanze","Associa sensore a stanze","Associa sensore a stanze","Associa sensore a stanze" };
        MyMenu menu = new MyMenu("Menu manutentore", azione);
        do {
            int scelta = menu.scegli();
            switch (scelta) {

                case 0: {
                    finito=true;
                    System.out.println("Uscita verso menu principale");
                }
                break;

                case 1:{
                    do {
                        String nome = InputDati.leggiStringaNonVuota("Inserisci nome categoria sensori: ");
                        manutentore.inserisciESalvaCategoriaSensori(new CategoriaSensori(nome));
                    }while (InputDati.yesOrNo("Vuoi inserire un'altra categoria sensori?"));
                }
                break;
                //TODO fai nome categoria senza spazi univoco+testo libero con lunghezza predefinita+cosa misura
                case 2: {
                    do{
                        String nome = InputDati.leggiStringaNonVuota("Inserisci nome categoria attuatori: ");
                        manutentore.inserisciESalvaCategoriaAttuatori(new CategoriaAttuatori(nome));
                    }while (InputDati.yesOrNo("Vuoi inserire un'altra categoria attuatori?"));
                }
                break;

                case 3: {
                    do{
                        String nome = InputDati.leggiStringaNonVuota("Inserisci nome nuova stanza: ");
                        manutentore.inserisciStanza(new Stanza(nome),unitàImmobiliare);
                    }while (InputDati.yesOrNo("Vuoi inserire un'altra stanza?"));
                }
                break;

                case 4: {
                    do{
                        String nome = InputDati.leggiStringaNonVuota("Inserisci nome nuovo artefatto: ");
                        manutentore.inserisciArtefatto(new Artefatto(nome),unitàImmobiliare);
                    }while (InputDati.yesOrNo("Vuoi inserire un'altro artefatto?"));
                }
                break;

                case 5: {
                    do{
                        System.out.println(manutentore.visualizzaCategorieSensori());
                        int categoria = InputDati.leggiIntero("Scegli categoria : ",1, manutentore.getSizeCategorieSensori());
                        categoria--;
                        String nome = InputDati.leggiStringaNonVuota("Inserisci nome sensore : ");
                        nome+="_"+manutentore.getListaCategorie().getCategoriaSensori(categoria).getNome();
                        System.out.println("Si è creato il sensore "+nome);
                        Sensore nuovoSensore = new Sensore(nome);

                        System.out.println("Si scelga ora le stanze a cui associare tale sensore");
                        ArrayList<Stanza> stanze = new ArrayList<>();
                        do {
                            System.out.println(unitàImmobiliare.visualizzaStanze());
                            int stanzaIndex = InputDati.leggiIntero("Scegli stanza : ", 1, unitàImmobiliare.getSizeStanze());
                            stanze.add(unitàImmobiliare.getStanze().get(stanzaIndex--));
                        }while (InputDati.yesOrNo("Vuoi scegliere un'altra stanza?"));
                        unitàImmobiliare.associaSensoreAStanze(nuovoSensore,stanze);


                    }while (InputDati.yesOrNo("Vuoi associare un'altro sensore a una stanza?"));
                }
                break;
            }
        } while (!finito);

    }

}
