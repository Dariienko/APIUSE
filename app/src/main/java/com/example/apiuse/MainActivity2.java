package com.example.apiuse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class MainActivity2 extends AppCompatActivity {
    private BooksViewModel booksViewModel;
    LiveData<BooksEntity> booksData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = getIntent().getExtras();
        String bookTittle = bundle.get("bookTittleValue").toString();
        EditText printTittleName = findViewById(R.id.tittleName);
        EditText printAmount = findViewById(R.id.printAmount);
        ImageView printTittlePicture = findViewById(R.id.imageView);
        booksViewModel = new ViewModelProvider(this).get(BooksViewModel.class);
        booksData = booksViewModel.getBooksData(bookTittle);
        booksData.observe(this, new Observer<BooksEntity>() {
            @Override
            public void onChanged(BooksEntity booksEntity) {
                if (booksData.getValue() != null) {
                    Log.d("RemoteKIQ", booksData.getValue().imageLink);
                    Picasso.get().load(booksData.getValue().imageLink).into(printTittlePicture);
                    printTittleName.setText(booksData.getValue().tittle);
                    printAmount.setText(String.valueOf(booksData.getValue().price) +" UAH");
                }
            }
        });
    }
}