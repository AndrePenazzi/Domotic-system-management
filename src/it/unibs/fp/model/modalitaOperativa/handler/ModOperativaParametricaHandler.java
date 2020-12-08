package it.unibs.fp.model.modalitaOperativa.handler;

import it.unibs.fp.model.modalitaOperativa.ModOperativa;
import it.unibs.fp.model.modalitaOperativa.ModOperativaParametrica;

public class ModOperativaParametricaHandler implements HandlerModOperativa{
    @Override
    public boolean canHandle(ModOperativa modOperativa) {
        return modOperativa instanceof ModOperativaParametrica;
    }
}
