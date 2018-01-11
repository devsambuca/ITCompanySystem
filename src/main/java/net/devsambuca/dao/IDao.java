package net.devsambuca.dao;

public interface IDao<T> {
    void create(T t);
    T read(long id);
    void update(T t);
    void delete(long id);
}
