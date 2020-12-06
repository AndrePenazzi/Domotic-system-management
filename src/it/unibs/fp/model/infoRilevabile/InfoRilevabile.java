package it.unibs.fp.model.infoRilevabile;

import java.io.Serializable;

public interface InfoRilevabile <T> extends Serializable {

    /**
     * Getter
     *
     * @return il nome
     */
     String getNome();

    /**
     * Setter
     *
     * @param nome della informazione rilevabile
     */
     void setNome(String nome);

     T rilevaVariabile();



    interface Renderer {
        String render1(InfoRilevabile info);

        String render2(InfoRilevabile info);

        String render3(InfoRilevabile info);
    }

    interface SelectableRenderer extends Renderer {
        boolean canHandle(InfoRilevabile info)
    }


    Renderer renderer = new InfoNumericaRenderer(new InfoNonNumericaRenderer(...))




    class CompositeRenderer implements Renderer {
        List<SelectableRenderer> renderers = new ArrayList<>() {
            {
                add(new InfoNumericaRenderer())
                add(new InfoNonNumericaRenderer())
                add(new InfoBellaRenderer())
            }
        }

        private Renderer getRendererFor(InfoRilevabile info) {
            for(var renderer : this.renderers) {
                if(renderer.canHandle(info))
                    return renderer
            }
            return new EmptyRenderer()
        }

        String renderer1(InfoRilevabile info) {
            return getRendererFor(info).renderer1(info)
        }

        String renderer2(InfoRilevabile info) {
            return getRendererFor(info).renderer2(info)
        }

        String renderer3(InfoRilevabile info) {
            return getRendererFor(info).renderer3(info)
        }
    }

    class InfoNonNumericaRenderer implements SelectableRenderer {
        String renderer(InfoRilevabile info) {
            var myInfo = (InfoNonNumerica)info
            return ...
        }

        boolean canHandle(InfoRilevabile info) {
            return info instanceof InfoNonNumerica
        }
    }
}