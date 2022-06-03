package com.example.apiuse;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {BooksEntity.class},version=2)
public abstract class BooksDB extends RoomDatabase {
    public static BooksDB instance;
    public abstract BooksDao booksDao();
}
