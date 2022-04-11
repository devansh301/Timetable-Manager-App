package com.example.timemanagerapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import androidx.lifecycle.LiveData;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insert1(Task Task);
//    @Insert
//    void insert2(Task Task_description);
//    @Insert
//    void insert3(Task Task_time);
//    @Insert
//    void insert4(Task Task_date);
//    @Insert
//    void insert5(Task Task_status);

    @Query("DELETE FROM Tasks_table")
    void deleteAll();

    @Query("SELECT * from Tasks_table ORDER BY Task ASC")
    LiveData<List<Task>> getAllTask();
}
