package com.example.android.audiobookstructureapp;

/* This class includes code derived from the Android Flavor App (https://github.com/udacity/ud839_CustomAdapter_Example)
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0.
 */

public class Genre {

    // Name of genre
    private int mGenreNameID;

    // Drawable resource ID for the Genre Icon
    private int mGenreIconId;

    // Genre specific color
    private int mGenreColor;

    /*
     * Create a new GenreList object.
     *
     * @param vName is the name of the genre
     * @param iconResourceId is drawable reference ID that corresponds to the genre icon
     * @param genreColorId gets the color for each genre
     * */
    public Genre(int genreNameId, int iconResourceId, int genreColorId) {
        mGenreNameID = genreNameId;
        mGenreIconId = iconResourceId;
        mGenreColor = genreColorId;
    }

    /**
     * Get the name of the Genre ID
     */
    public int getGenreNameID() {
        return mGenreNameID;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mGenreIconId;
    }

    /**
     * Get the color resource ID
     */
    public int getColorId() {
        return mGenreColor;
    }
}
