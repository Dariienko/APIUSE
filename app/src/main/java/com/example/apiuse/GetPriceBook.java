package com.example.apiuse;

import com.example.apiuse.data.Main;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetPriceBook {
    @GET("books/v1/volumes")
    Call<Main> getPriceByTittleName(@Query("q") String tittle , @Query("key") String key);
}

