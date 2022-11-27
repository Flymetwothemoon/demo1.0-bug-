package com.example.roomwordssample;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {world.class},version = 5,exportSchema = false)
public abstract class database extends RoomDatabase {
    public static database sInstance;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static database getInstance(Context context){
        if (sInstance ==null){
            synchronized (database.class){
                if(sInstance==null){
                    sInstance = Room.databaseBuilder(context,database.class,"data").fallbackToDestructiveMigration().build();
                }
            }
        }
        return sInstance;
    }
    public abstract dao mDao();

}
