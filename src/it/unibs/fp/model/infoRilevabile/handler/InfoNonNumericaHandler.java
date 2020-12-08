package it.unibs.fp.model.infoRilevabile.handler;

import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNonNumerica;

public class InfoNonNumericaHandler implements HandlerInfoRilevabile {
    @Override
    public boolean canHandle(InfoRilevabile info) {
        return info instanceof InfoRilevabileNonNumerica;
    }
}
