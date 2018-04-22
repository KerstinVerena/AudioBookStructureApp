package com.example.android.audiobookstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayingActivity extends AppCompatActivity {

    public static boolean playOrPause = true;
    public static String statePlayOrPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        if (savedInstanceState != null) {
            playOrPause = savedInstanceState.getBoolean(statePlayOrPause);
        }
        ;

        Intent playing = getIntent();
        Book currentBook = playing.getParcelableExtra("Book");

        //Add information form the strings in the different Actvities
        // More information can be found in this tutorial: https://www.youtube.com/watch?v=WBbsvqSu0is

        int bookIcon = currentBook.getbookIconID();
        int bookName = currentBook.getbookNameID();
        int authorName = currentBook.getauthorNameID();

        //Set the icon and strings from the array in the views of the layout.
        ImageView bookIconView = findViewById(R.id.book_icon_view);
        bookIconView.setImageResource(bookIcon);

        TextView bookNameView = findViewById(R.id.book_name_view);
        bookNameView.setText(bookName);

        TextView authorNameView = findViewById(R.id.book_author_view);
        authorNameView.setText(authorName);

        final ImageView playPause = findViewById(R.id.play_and_pause);

        //Set the play or pause icon according to the input.
        if (playOrPause) {
            playPause.setImageResource(R.drawable.ic_pause_60dp);
        } else {
            playPause.setImageResource(R.drawable.ic_play_arrow_60dp);
        }


        //Set an onlickListener on the play and pause button and change the symbol of the view accordingly by clicking on the view.
        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (playOrPause) {
                    playOrPause = false;
                    playPause.setImageResource(R.drawable.ic_play_arrow_60dp);
                    return;
                }

                playOrPause = true;
                playPause.setImageResource(R.drawable.ic_pause_60dp);
            }
        });

        //Find the View that shows "Library"
        TextView toLibrary = findViewById(R.id.to_library);

        //Set an onClickListener on the library view that allows the user to return to the library.
        toLibrary.setOnClickListener(new View.OnClickListener()

        {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(PlayingActivity.this, MainActivity.class);
                startActivity(numbersIntent);
            }
        });

    }

    //set Instances according to player input and restore them.

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(statePlayOrPause, playOrPause);
    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        playOrPause = savedInstanceState.getBoolean(statePlayOrPause);
    }

}

