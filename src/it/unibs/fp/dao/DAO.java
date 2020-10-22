package it.unibs.fp.dao;

import java.util.List;

public interface DAO<T> {

    void connetti();

    void aggiungiESalva(T t);

    List<T> carica();

}