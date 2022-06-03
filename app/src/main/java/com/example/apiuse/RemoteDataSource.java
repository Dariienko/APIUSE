package com.example.apiuse;

import android.util.Log;

import com.example.apiuse.data.Main;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {
    private GetPriceBook getPriceBook;
    public RemoteDataSource(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getPriceBook = retrofit.create(GetPriceBook.class);
    }

    public Main getBooks(String bookTittle){
        Call<Main> call = getPriceBook.getPriceByTittleName(bookTittle,"AIzaSyAhV5KtYZQVKyICaRAViaIt_LtdJe36K-I");
        try {
            Response<Main> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        }catch(IOException ioex){
            Log.e("Remote", "IOEX: " + ioex.toString());
        }
        return null;
    }

}
