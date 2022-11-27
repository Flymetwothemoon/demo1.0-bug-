package com.example.roomwordssample;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private dao mDao;
    private LiveData<List<world>> mAllworlds;

    WordRepository(Application application) {
        database db = database.getInstance(application);
        mDao = db.mDao();
        mAllworlds = mDao.getAlphabetizedWords();
    }

    LiveData<List<world>> getAllworlds() {
        return mAllworlds;
    }

    void insert(world word) {
        database.databaseWriteExecutor.execute(() -> {
            mDao.insert(word);
        });
    }
}
