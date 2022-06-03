package com.example.apiuse;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class BooksViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<BooksEntity> booksData;
    private String tittleName;
    LiveData<BooksEntity> getBooksData(String s) {
        tittleName = s;
        booksData = repository.getBooksData(tittleName);
        return booksData;
    }

    public BooksViewModel (Application application) {
        super(application);
        repository = new Repository(application);
    }
}