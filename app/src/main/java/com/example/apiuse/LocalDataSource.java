package com.example.apiuse;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

public class LocalDataSource {
    final BooksDB db;

    public LocalDataSource(Context context){
        db = Room.databaseBuilder(context, BooksDB.class,"books"). fallbackToDestructiveMigration().build();
    }
    public void storeBooks(BooksEntity be) {
        db.booksDao().insertBooks(be);
    }
    public LiveData<BooksEntity> getBooks(){
        //Log.d("Запрос из базы", String.valueOf(db.weatherDao().getWeatherForecast().getValue().get(0).id));
        return db.booksDao().getBooks();
    }
}
