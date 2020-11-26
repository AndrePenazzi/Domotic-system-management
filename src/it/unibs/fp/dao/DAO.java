package it.unibs.fp.dao;


import java.io.IOException;

public interface DAO<T> {

    void inserisci(T t) throws IOException;

    void aggiorna(T t) throws IOException;

    T carica() throws IOException;
}