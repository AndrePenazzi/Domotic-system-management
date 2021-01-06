package it.unibs.fp.model.infoRilevabile;

import it.unibs.fp.view.classiDiServizio.infoRilevabile.InfoNonNumericaRendererInfoRilevabile;
import it.unibs.fp.view.classiDiServizio.infoRilevabile.InfoNumericaRendererInfoRilevabile;

import java.util.ArrayList;
import java.util.List;

public class CompositeRendererInfoRilevabile implements RendererInfoRilevabile {

    List<SelectableRendererInfoRilevabile> renderers = new ArrayList<>() {
        {
            add(new InfoNumericaRendererInfoRilevabile());
            add(new InfoNonNumericaRendererInfoRilevabile());
        }
    };

    private RendererInfoRilevabile getRendererFor(InfoRilevabile info) {
        for(SelectableRendererInfoRilevabile renderer : this.renderers) {
            if(renderer.canHandle(info))
                return renderer;
        }
        return null;
    }

    @Override
    public String renderDescriviValoreRilevato(InfoRilevabile info) {
        return getRendererFor(info).renderDescriviValoreRilevato(info);
    }

    @Override
    public String renderDescriviSoloValoreRilevato(InfoRilevabile info) {
        return getRendererFor(info).renderDescriviSoloValoreRilevato(info);
    }

    @Override
    public String renderToString(InfoRilevabile info) {
        return getRendererFor(info).renderToString(info);
    }
}
