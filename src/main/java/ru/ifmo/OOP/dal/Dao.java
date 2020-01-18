package ru.ifmo.OOP.dal;

import ru.ifmo.OOP.dal.exception.DaoException;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface Dao<T> {
    /* Create */
    public T create(T task) throws DaoException; // returns void

    /* Read */
    // TODO: consider using interfaces whenever possible (e.g., List instead of ArrayList)
    List<T> getAll() throws DaoException;

    T getById(int id) throws DaoException;

    /* Update */
    public T update(T task) throws DaoException;  //returns void

    /* Delete */
    void remove(int id) throws DaoException;
}
