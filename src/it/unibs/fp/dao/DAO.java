package it.unibs.fp.dao;


public interface DAO<T> {

    void inserisci(T t);

    void aggiorna(T t);

    T carica();
}