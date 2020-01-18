package ru.ifmo.OOP.domain;

import ru.ifmo.OOP.dal.Dao;
import ru.ifmo.OOP.dal.file.InListTaskDao;
import ru.ifmo.OOP.dal.sql.DAOSQLite;
import ru.ifmo.OOP.dal.sql.SQLiteTaskDao;
import ru.ifmo.OOP.domain.entity.Task;
import ru.ifmo.OOP.dal.exception.DaoException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskManager {

    // make private field dao:
//    private final Dao<Task> dao = new SQLiteTaskDao();
    private final Dao<Task> dao = new InListTaskDao();

    public TaskManager() {
    }

    public Task createNewTask (String taskName, String date) {
        Task task = new Task(-1, taskName, date, "");
        try {
            dao.create(task);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return task;
    }

    public Task getTaskById (int id) throws DaoException {
        return dao.getById(id);
    }

    public void updateTask (int id, String text, String date, String create_date) throws DaoException {
        Task task = new Task(id, text, date, create_date);
        // if Task has setters:
        // Task task = dao.getById(id);
        // task.text = text;
        dao.update(task);
    }

    public void remove (int id) {
        try {
            dao.remove(id);
        } catch (DaoException e) {
            System.err.println("Some exception: " + e.getMessage());

        }
    }

    public List<Task> getAllTasks() throws DaoException {
        return dao.getAll();
    }

    /*
    public List<String> getAllTasksText() throws DaoException {
        return dao.getAllTasksText();
    }

    public List<Task> getFromInterval(Date date1, Date date2) throws DaoException{
        return dao.getFromInterval(date1, date2);
    }

    public void deleteToDate(Date date) throws DaoException{
        dao.deleteToDate(date);
    }
    */
    /*
    public void createDump(...listener){
        String cmd = "mysqldump -u artem -pPwd -f TODOLIST > DumpFile.txt";
        try {
            Process pro = Runtime.getRuntime().exec(cmd) ;
            pro.waitFor();
            progressbarlistener.updateState(1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
}
