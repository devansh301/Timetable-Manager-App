package com.example.timemanagerapplication;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;

@Database(entities = {Task.class}, version = 1, exportSchema = false)
public abstract class TaskRoomDatabase extends RoomDatabase {

    public abstract TaskDao taskDao();
    private static TaskRoomDatabase INSTANCE;

    static TaskRoomDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (TaskRoomDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TaskRoomDatabase.class, "task_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){
            @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                super.onOpen(db);
                new PopulateDbAsync(INSTANCE).execute();
            }
    };
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final TaskDao mDao;
        String[] tasks = {"dolphin", "crocodile", "cobra"};

        PopulateDbAsync(TaskRoomDatabase db) {
            mDao = db.taskDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();

            for (int i = 0; i <= tasks.length -  1; i++) {
                Task task = new Task(tasks[i]);
                mDao.insert1(task);
            }
            return null;
        }
    }
}
