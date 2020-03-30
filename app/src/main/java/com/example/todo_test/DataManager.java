package com.example.todo_test;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static DataManager instance;
    private List<Task> toDoList;

    private DataManager(){
        toDoList = new ArrayList<>();
    }

    public static DataManager getInstance() {
        if (instance == null){
            instance = new DataManager();
        }
        return instance;
    }

    public List<Task> getToDoList() {
        return toDoList;
    }

    public void addTask(Task task){
        toDoList.add(task);
    }

    public Task getTaskAt(int index){
        return toDoList.get(index);
    }

}
