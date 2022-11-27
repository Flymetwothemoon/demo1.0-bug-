package com.example.roomwordssample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class world {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo
    public String worlds;

}
