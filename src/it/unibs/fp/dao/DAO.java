package it.unibs.fp.dao;


public interface DAO<T> {

    void connetti();

    void aggiungiESalva(T t);
    T carica();

}