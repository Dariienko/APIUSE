package com.example.apiuse;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface BooksDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) //ВАЖНО для нашей задачи
    public void insertBooks(BooksEntity booksEntity);

    @Query("Select * FROM BooksEntity")
    public LiveData<BooksEntity> getBooks();
}
