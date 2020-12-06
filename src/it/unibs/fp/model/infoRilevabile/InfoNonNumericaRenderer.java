package it.unibs.fp.model.infoRilevabile;

public class InfoNonNumericaRenderer implements Renderer{


    @Override
    public String render(InfoRilevabile info) {
        if(info instanceof InfoRilevabileNonNumerica) {
....
        }
    }
}
