package com.example.timemanagerapplication;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    private TaskRepository mRepository;
    private LiveData<List<Task>> mAllTask;

    public TaskViewModel (Application application) {
        super(application);
        mRepository = new TaskRepository(application);
        mAllTask = mRepository.getmAllTask();
    }

    LiveData<List<Task>> getmAllTask() {
        return mAllTask;
    }

    public void insert(Task Task) { mRepository.insert(Task); }

}
