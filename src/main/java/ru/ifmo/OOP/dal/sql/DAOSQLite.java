package ru.ifmo.OOP.dal.sql;

import ru.ifmo.OOP.dal.Dao;
import ru.ifmo.OOP.dal.exception.DaoException;
import ru.ifmo.OOP.domain.entity.Task;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface DAOSQLite<T> extends Dao {
    /* Read */
    // TODO: consider using interfaces whenever possible (e.g., List instead of ArrayList)

    Task create(Task task) throws DaoException;

    T getById(int id) throws DaoException;

    List<T> getFromInterval(Date date1, Date date2) throws DaoException;

    public List<String> getAllTasksText() throws DaoException;

    Task update(Task task) throws DaoException;

    void deleteToDate(Date date) throws DaoException;
}
