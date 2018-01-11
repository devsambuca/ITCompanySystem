package net.devsambuca.dao;

public interface IDao<T> {
    void create(T t);
    void read(long id);
    void update(T t);
    void delete(long id);
}
