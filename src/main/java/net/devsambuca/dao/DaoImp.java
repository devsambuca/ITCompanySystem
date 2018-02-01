package net.devsambuca.dao;

import java.io.FileNotFoundException;

public interface DaoImp<T> {
    void create(T t);
    T read(long id);
    void update(T t);
    void delete(long id);
}
