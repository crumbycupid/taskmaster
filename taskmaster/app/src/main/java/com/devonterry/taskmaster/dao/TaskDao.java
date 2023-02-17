package com.devonterry.taskmaster.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.devonterry.taskmaster.model.Task;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    public void insertATask (Task task);

    @Query("SELECT * FROM Task")
    public List<Task> findAll();

    @Query("SELECT * FROM Task WHERE id = :id")
    public Task findById(Long id);

//    @Query("SELECT * FROM Task WHERE taskState = taskState")
//    public List<Task> findAllByState(Task.TaskStateEnum taskState);

    @Delete
    public void delete(Task task);

    @Update
    public void update(Task task);
}
