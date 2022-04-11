package com.example.timemanagerapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import androidx.annotation.NonNull;

@Entity(tableName = "Tasks_table")
public class Task {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Task")
    private String mTask;

//    @ColumnInfo(name = "Task_description")
//    private String mTask_description;
//
//    @ColumnInfo(name = "Task_time")
//    private  String mTask_time;

//    public boolean ismTask_status() {
//        return mTask_status;
//    }
//
//    public String getmTask_date() {
//        return mTask_date;
//    }
//
//    public String getmTask_time() {
//        return mTask_time;
//    }
//
//    public String getmTask_description() {
//        return mTask_description;
//    }

    @NonNull
    public String getmTask() {
        return mTask;
    }

//    @ColumnInfo(name = "Task_date")
//    private String mTask_date;
//
//    @ColumnInfo(name = "Task_status")
//    private boolean mTask_status;

    public Task(String Task) {
        this.mTask = Task;
//        this.mTask_description = Task_description;
//        this.mTask_time = Task_time;
//        this.mTask_date = Task_date;
//        this.mTask_status = Task_status;
    }
}
