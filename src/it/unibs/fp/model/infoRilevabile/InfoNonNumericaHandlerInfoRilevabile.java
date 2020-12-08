package it.unibs.fp.model.infoRilevabile;

public class InfoNonNumericaHandlerInfoRilevabile implements HandlerInfoRilevabile {
    @Override
    public boolean canHandle(InfoRilevabile info) {
        return info instanceof InfoRilevabileNonNumerica;
    }
}
