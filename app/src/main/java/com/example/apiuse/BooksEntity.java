package com.example.apiuse;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class BooksEntity {
    @PrimaryKey
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "price")
    public double price;;

    @ColumnInfo(name = "tittle")
    public String tittle;

    @ColumnInfo(name = "imageLink")
    public String imageLink;
}
