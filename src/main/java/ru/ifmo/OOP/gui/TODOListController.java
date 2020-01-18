package ru.ifmo.OOP.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import ru.ifmo.OOP.dal.exception.DaoException;
import ru.ifmo.OOP.domain.BackgroundOperation;
import ru.ifmo.OOP.domain.TaskManager;
import javafx.fxml.FXML;

import ru.ifmo.OOP.domain.entity.Task;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class TODOListController {

    private TaskManager tm = new TaskManager();

    ObservableList<Task> wordsList = FXCollections.observableArrayList();

    @FXML
    private Button buttonPlus;

    @FXML
    private ListView<Task> tableview;

    @FXML
    private Button buttonMinus;

    @FXML
    private TextArea textBlock;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button buttonDump;

    @FXML
    private Button buttonSave;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    public void initialize() throws DaoException {
        ProgressListener pl = new ProgressListener(progressBar);
        BackgroundOperation bo = new BackgroundOperation();
        bo.add(pl);
        bo.run(() -> {
            try {
                bo.setProgress(20);
                TimeUnit.SECONDS.sleep(2);
                bo.changeProgress(5);
                TimeUnit.SECONDS.sleep(1);
                bo.changeProgress(8);
                TimeUnit.SECONDS.sleep(1);
                bo.changeProgress(18);
                TimeUnit.SECONDS.sleep(2);
                bo.changeProgress(20);
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });
        try {
            tableview.getItems().addAll(tm.getAllTasks());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        buttonPlus.setOnAction(e -> createTask());
        buttonMinus.setOnAction(e -> {
            try {
                deleteTask();
            } catch (DaoException e1) {
                e1.printStackTrace();
            }
        });
        buttonSave.setOnAction(e -> {
            try {
                saveTask();
            } catch (DaoException e1) {
                e1.printStackTrace();
            }
        });
        buttonDump.setOnAction(e -> saveDump());
    }

    /*
    @FXML
    public void setText(ActionEvent actionEvent) throws IOException, SQLException {
        this.setDate(actionEvent);
    }

    @FXML
    private void setDate(ActionEvent actionEvent) throws IOException, SQLException {
        this.createTask(actionEvent);
    }*/

    @FXML
    private void createTask(){
        Task newTask = tm.createNewTask(textBlock.toString(), datePicker.getValue().toString());
//        Task newTask = new Task(0, textBlock.toString(), datePicker.getValue().toString(), "");
    }

    @FXML
    void deleteTask() {
        ObservableList<Task> task;
        task = tableview.getSelectionModel().getSelectedItems();
        for(Task d: task){
            tm.remove(d.getId());
        }
    }

    @FXML
    void saveDump() {
        tm.createDump();
    }

    @FXML
    private void saveTask() throws DaoException {
        tm.updateTask(0, textBlock.toString(), datePicker.getValue().toString(), "");
    }
}
