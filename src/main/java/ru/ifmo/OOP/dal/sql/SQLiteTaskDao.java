package ru.ifmo.OOP.dal.sql;

import ru.ifmo.OOP.dal.ConnectionPool;
import ru.ifmo.OOP.dal.exception.DaoException;
import ru.ifmo.OOP.domain.entity.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteTaskDao implements DAOSQLite<Task> {

    // TODO: MAKE ALL FIELD IN THE PROJECT WITH FINAL MODIFIER
    private static final String CREATE = "INSERT INTO TASKLIST (TASK, DATE, CREATEDATE) VALUES(?, ?, date('now'))";
    private static String GET_ALL = "SELECT * FROM TASKLIST";
    private static String GET_ALL_TASKS_TEXT = "SELECT TASK FROM TASKLIST";
    private static String GET_BY_ID = "SELECT ID, TASK, DATE, CREATEDATE FROM ADDRESS WHERE ID=?";
    private static String GET_FROM_INTERVAL = "SELECT * FROM TASKLIST WHERE DATE(DATE) BETWEEN ? AND ?";
    private static String UPDATE = "UPDATE TASKLIST SET TASK=?, DATE=?, CREATEDATE=? WHERE ID=?";
    private static String REMOVE = "DELETE FROM TASKLIST WHERE ID=?";
    private static String DELETE_TO_DATE = "DELETE FROM TASKLIST WHERE DATE(DATE) BETWEEN ? AND ?";

    public SQLiteTaskDao() {
        // throw in constructor???
        // they say that constructor should not throw
        try {
            Connection con = ConnectionPool.getConnection();
            this.psCreate = con.prepareStatement(CREATE);
            this.psGetAll = con.prepareStatement(GET_ALL);
            this.psGetById = con.prepareStatement(GET_BY_ID);
            this.psGetFromInterval = con.prepareStatement(GET_FROM_INTERVAL);
            this.psGetAllTasksText = con.prepareStatement(GET_ALL_TASKS_TEXT);
            this.psUpdate = con.prepareStatement(UPDATE);
            this.psRemove = con.prepareStatement(REMOVE);
            this.psDeleteToDate = con.prepareStatement(DELETE_TO_DATE);
        } catch (Exception e) {
            throw new RuntimeException("Something bad");
        }
    }

    //private final Connection connection = ConnectionPool.getConnection();
    private PreparedStatement psCreate;
    private PreparedStatement psGetAll;
    private PreparedStatement psGetById;
    private PreparedStatement psGetFromInterval;
    private PreparedStatement psGetAllTasksText;
    private PreparedStatement psUpdate;
    private PreparedStatement psRemove;
    private PreparedStatement psDeleteToDate;


    @Override
    public void create(Task task) throws DaoException {
        try {
//            Connection con = pool.getCon();
//            Ps ps = con.prepareStatement(...);
//            ps.exec;
//            pool.release(con);

            // try-with-resources
            // try (Con con = pool.get(); Ps ps = con.prepare(...)) { ps.exec }

            //PreparedStatement preparedStatement = connection.prepareStatement(CREATE);

            psCreate.setString(1, task.getTask());
            psCreate.setString(2, task.getDate());

            psCreate.executeUpdate();

            task.setId(id from query);
        } catch (SQLException e) {
            throw new DaoException("SQL(" + e.getMessage() + ")");
        }
        /*
        finally {
            if (psCreate != null) {
                psCreate.close();
            }
            if (connection != null) {
                connection.close();
            }
        }*/
    }

    @Override
    public Object create(Object entity) throws DaoException {
        return null;
    }

    @Override
    public List<Task> getAll() throws DaoException {

        try {
            //preparedStatement = connection.prepareStatement(GET_ALL);

            ResultSet resultSet = psGetAll.executeQuery();

            // Use more generic data type (List)
            List<Task> list = null;

            while(resultSet.next()) {
                list.add(new Task(resultSet.getInt("ID"),
                        resultSet.getString("TASK"),
                        resultSet.getString("DATE"),
                        resultSet.getString("CREATEDATE")));
            }
            return list;

        } catch (SQLException e) {
            throw new DaoException("SQL(" + e.getMessage() + ")");
        }
        /*
        } finally {
            if (psGetAll != null) {
                psGetAll.close();
            }
            if (connection != null) {
                connection.close();
            }
        }*/
    }

    @Override
    public Task getById(int id) throws DaoException {

        try {
            //preparedStatement = connection.prepareStatement(getByIdRequest);
            psGetById.setLong(1, id);

            ResultSet resultSet = psGetById.executeQuery();

            return new Task(resultSet.getInt("ID"),
                    resultSet.getString("TASK"),
                    resultSet.getString("DATE"),
                    resultSet.getString("CREATEDATE"));

        }  catch (SQLException e) {
            throw new DaoException("SQL(" + e.getMessage() + ")");
        }
        /*
        } finally {
            if (psGetById != null) {
                psGetById.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;*/
    }

    @Override
    public Object update(Object entity) throws DaoException {
        return null;
    }

    @Override
    public List<Task> getFromInterval(java.util.Date date1, java.util.Date date2) throws DaoException {

        try {
            //preparedStatement = connection.prepareStatement(getFromIntervalRequest);

            psGetFromInterval.setDate(1, (Date) date1);
            psGetFromInterval.setDate(2, (Date) date2);

            ResultSet resultSet = psGetFromInterval.executeQuery();

            List<Task> list = new ArrayList<>();

            while (resultSet.next()) {
                list.add(new Task(resultSet.getInt("ID"),
                        resultSet.getString("TASK"),
                        resultSet.getString("DATE"),
                        resultSet.getString("CREATEDATE")));
            }
            return list;

        } catch (SQLException e) {
            throw new DaoException("SQL(" + e.getMessage() + ")");
        }
        /*} finally {
            if (psGetFromInterval != null) {
                psGetFromInterval.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;*/
    }

    @Override
    public List<String> getAllTasksText() throws DaoException {

        try {
            //preparedStatement = connection.prepareStatement(getAllTasksTextRequest);

            ResultSet resultSet = psGetAllTasksText.executeQuery();

            // Use more generic data type (List)
            List<String> list = new ArrayList<>();

            while(resultSet.next()) {
                list.add(resultSet.getString("TASK"));
            }
            return list;

        }  catch (SQLException e) {
            throw new DaoException("SQL(" + e.getMessage() + ")");
        }
        /*finally {
            if (psGetAllTasksText != null) {
                psGetAllTasksText.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;*/
    }

    @Override
    public Task update(Task task) throws DaoException {

        try {
            //preparedStatement = connection.prepareStatement(updateRequest);

            psUpdate.setString(1, task.getTask());
            psUpdate.setString(2, task.getDate());
            psUpdate.setString(3, task.getCreateDate());
            psUpdate.setInt(4, task.getId());

            psUpdate.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("SQL(" + e.getMessage() + ")");
        }
        /*
        } finally {
            if (psUpdate != null) {
                psUpdate.close();
            }
            if (connection != null) {
                connection.close();
            }
        }*/
        return task;
    }

    @Override
    public void remove(int id) throws DaoException {

        try {
            //preparedStatement = connection.prepareStatement(removeRequest);

            psRemove.setLong(1, id);

            psRemove.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("SQL(" + e.getMessage() + ")");
        }
        /*} finally {
            if (psRemove != null) {
                psRemove.close();
            }
            if (connection != null) {
                connection.close();
            }
        }*/
    }

    @Override
    public void deleteToDate(java.util.Date date) throws DaoException {

        try {
            //preparedStatement = connection.prepareStatement(deleteToDateRequest);

            psDeleteToDate.setDate(1, (Date) date);
            psDeleteToDate.setDate(2, new Date(2017,1, 1));

            psDeleteToDate.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("SQL(" + e.getMessage() + ")");
        }
        /*
        } finally {
            if (psDeleteToDate != null) {
                psDeleteToDate.close();
            }
            if (connection != null) {
                connection.close();
            }
        }*/
    }
}
