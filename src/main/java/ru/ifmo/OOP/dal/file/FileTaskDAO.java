package ru.ifmo.OOP.dal.file;
/*
import ru.ifmo.OOP.dal.Dao;
import ru.ifmo.OOP.dal.exception.DaoException;
import ru.ifmo.OOP.domain.entity.Task;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileTaskDAO implements Dao<Task> {

    @Override
    public Task create(Task entity) {
        return entity;
    }
    @Override
    public List<Task> getAll() {
        List<String> list = null;
        try {
            FileInputStream fstream = new FileInputStream("TASKLIST");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                list.add(strLine);
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
        return list;
    }
    @Override
    public Task getById(int id) {
        try {
            //return getline("TASKLIST", id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Task();
    }

    @Override
    public void update(Task entity) {
    }

    @Override
    public void remove(int id) {
    }

    private Task getTaskFunc(String task){

        //Task newTask = new Task();
        //return newTask;
    }
}*/
