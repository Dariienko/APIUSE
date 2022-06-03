package com.example.apiuse;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import com.example.apiuse.data.Main;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;

public class Repository {
    private LocalDataSource localDataSource;
    private RemoteDataSource remoteDataSource;
    private LiveData<BooksEntity> booksWhisTittle;
    public Repository(Context context){
        localDataSource = new LocalDataSource(context);
        remoteDataSource = new RemoteDataSource();
    }
    public void storeBooks(Main example) {
        BooksEntity booksEntity = new BooksEntity();
        booksEntity.id = 0;
        if(example.getItems().get(0).getSaleInfo().getSaleability() == "NOT_FOR_SALE"
                || example.getItems().get(0).getSaleInfo().getSaleability() == "FREE"){
            booksEntity.price = 0;
        } else {
            booksEntity.price = example.getItems().get(0).getSaleInfo().getRetailPrice().getAmount();
        }
        booksEntity.tittle = example.getItems().get(0).getVolumeInfo().getTitle();
        Log.i("Link: ",example.getItems().get(0).getVolumeInfo().getImageLinks().getSmallThumbnail());
        booksEntity.imageLink = example.getItems().get(0).getVolumeInfo().getImageLinks().getThumbnail();
        localDataSource.storeBooks(booksEntity);
    }

    private LiveData<BooksEntity> getIfNotSetBooks() {
        if (this.booksWhisTittle == null){
            this.booksWhisTittle = localDataSource.getBooks();
        }
        return this.booksWhisTittle;
    }


    public LiveData<BooksEntity> getBooksData(String s){
        updateBookFromInternet(s);
        return getIfNotSetBooks();
    }

    private void updateBookFromInternet(String s) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                Main booksForecast = remoteDataSource.getBooks(s);
                storeBooks(booksForecast);
            }
        });
    }
}
