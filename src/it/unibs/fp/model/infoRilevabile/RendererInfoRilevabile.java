package it.unibs.fp.model.infoRilevabile;

public interface RendererInfoRilevabile {
    String renderDescriviValoreRilevato(InfoRilevabile info);
    String renderDescriviSoloValoreRilevato(InfoRilevabile info);
    String renderToString(InfoRilevabile info);
}
