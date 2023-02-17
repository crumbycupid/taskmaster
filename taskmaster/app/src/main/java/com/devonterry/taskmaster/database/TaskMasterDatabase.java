package com.devonterry.taskmaster.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.devonterry.taskmaster.dao.TaskDao;
import com.devonterry.taskmaster.model.Task;

@Database(entities = {Task.class}, version = 1)
public abstract class TaskMasterDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();

}
