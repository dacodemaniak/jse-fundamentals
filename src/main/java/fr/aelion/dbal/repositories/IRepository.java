package fr.aelion.dbal.repositories;

import java.util.List;

public interface IRepository<T> {
    public List<T> findAll();

    public T findById(int id);
}
