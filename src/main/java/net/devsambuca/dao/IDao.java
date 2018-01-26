package net.devsambuca.dao;

import java.io.FileNotFoundException;

public interface IDao<T> {
    void create(T t);
    T read(long id) throws FileNotFoundException;
    void update(T t);
    void delete(long id);
}
