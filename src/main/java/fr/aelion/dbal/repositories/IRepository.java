package fr.aelion.dbal.repositories;

import fr.aelion.helpers.exceptions.StudentException;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface IRepository<T> {
    public List<T> findAll() throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException;

    public T findById(int id) throws SQLException, StudentException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
