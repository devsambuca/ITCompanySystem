package net.devsambuca.controller;

public interface IService<T> {
    void add(T t);
    void remove(long id);
}
