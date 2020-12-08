package it.unibs.fp.model.infoRilevabile;

public class InfoNumericaHandlerInfoRilevabile implements HandlerInfoRilevabile {
    @Override
    public boolean canHandle(InfoRilevabile info) {
        return info instanceof InfoRilevabileNumerica;
    }
}
