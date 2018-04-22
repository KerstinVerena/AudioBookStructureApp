package com.example.android.audiobookstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HorrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);


        ImageView iconView = findViewById(R.id.genre_icon_view);
        TextView genreView = findViewById(R.id.genre_name_view);

        iconView.setImageResource(R.drawable.evil_hand);
        genreView.setBackgroundColor(getResources().getColor(R.color.horror));
        genreView.setText(R.string.horror);

        final ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(R.string.horror_book_1, R.string.horror_author_1, R.drawable.tentacles_skull));
        books.add(new Book(R.string.horror_book_2, R.string.horror_author_2, R.drawable.raise_zombie));
        books.add(new Book(R.string.horror_book_3, R.string.horror_author_3, R.drawable.vampire_dracula));
        books.add(new Book(R.string.horror_book_4, R.string.horror_author_4, R.drawable.werewolf));

        BookAdapter showBooks = new BookAdapter(this, books);

        final ListView listView = findViewById(R.id.book_list);
        listView.setAdapter(showBooks);

        // Setting an onClicklistener on items in an ArrayList uses code from: https://stackoverflow.com/questions/15480857/adding-button-listener-in-arraylist
        // Please refer to the link for more information.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //Send information to other activities.
            // More information can be found in this tutorial: https://www.youtube.com/watch?v=WBbsvqSu0is
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playing = new Intent(HorrorActivity.this, PlayingActivity.class);
                playing.putExtra("Book", books.get(position));

                startActivity(playing);
            }
        });

        //Find the View that shows "Library"
        TextView toLibrary = findViewById(R.id.back_to_library);

        //Set an onClickListener on the library view that allows the user to return to the library.
        toLibrary.setOnClickListener(new View.OnClickListener()

        {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(HorrorActivity.this, MainActivity.class);
                startActivity(numbersIntent);
            }
        });


    }

}

