package com.example.roomwordssample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(world...worlds);
    @Query("Delete FROM world")
    public void deleteAll();
    @Query("SELECT * FROM world ORDER BY worlds asc")
    public LiveData<List<world>> getAlphabetizedWords();
}
