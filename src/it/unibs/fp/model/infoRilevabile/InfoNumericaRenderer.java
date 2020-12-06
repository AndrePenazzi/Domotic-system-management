package it.unibs.fp.model.infoRilevabile;

public class InfoNumericaRenderer implements Renderer{
    private Renderer next;

    public InfoNumericaRenderer(Renderer next) {
        this.next = next;
    }

    @Override
    public String render(InfoRilevabile info) {
        if(info instanceof InfoRilevabileNumerica) {
....
            return ...descrivivalorerilevato
        }
        return this.next.render(info);
    }

}
