package com.example.roomwordssample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class worldviewmodel extends AndroidViewModel {
    private WordRepository mRepository;

    private final LiveData<List<world>> mAllWords;
    public worldviewmodel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllworlds();
    }
    LiveData<List<world>> getAllWords() { return mAllWords; }

    public void insert(world word) { mRepository.insert(word); }
}
