package it.unibs.fp.view.classiDiServizio.infoRilevabile;

import it.unibs.fp.model.infoRilevabile.InfoRilevabile;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNonNumerica;
import it.unibs.fp.model.infoRilevabile.InfoRilevabileNumerica;
import it.unibs.fp.model.infoRilevabile.SelectableRendererInfoRilevabile;

public class InfoNonNumericaRendererInfoRilevabile implements SelectableRendererInfoRilevabile {

    @Override
    public String renderDescriviValoreRilevato(InfoRilevabile info) {
        return ClasseDiServizioInfoRilevabileNumerica.descriviValoreRilevato((InfoRilevabileNumerica) info);
    }

    @Override
    public String renderDescriviSoloValoreRilevato(InfoRilevabile info) {
        return ClasseDiServizioInfoRilevabileNumerica.descriviSoloValoreRilevato((InfoRilevabileNumerica) info);
    }

    @Override
    public String renderToString(InfoRilevabile info) {
        return ClasseDiServizioInfoRilevabileNumerica.toString((InfoRilevabileNumerica) info);
    }

    @Override
    public boolean canHandle(InfoRilevabile info) {
        return info instanceof InfoRilevabileNonNumerica;
    }
}
