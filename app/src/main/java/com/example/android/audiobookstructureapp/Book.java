package com.example.android.audiobookstructureapp;

/* This class includes code derived from the Android Flavor App (https://github.com/udacity/ud839_CustomAdapter_Example)
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0.
 */

import android.os.Parcel;
import android.os.Parcelable;

//Implement Parcelable to send information to other activities. More information and code about implementing Parcelable can be found in this tutorial: https://www.youtube.com/watch?v=WBbsvqSu0is

public class Book implements Parcelable {

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
    // Name of the book
    private int mBookNameID;
    // Name of the author
    private int mAuthorNameID;
    // Drawable resource ID for the book Icon
    private int mBookIconId;

    /*
     * Create a new GenreList object.
     *
     * @param vName is the name of the genre
     * @param iconResourceId is drawable reference ID that corresponds to the genre icon
     * @param genreColorId gets the color for each genre
     * */
    public Book(int bookNameId, int authorNameId, int bookIconId) {
        mBookNameID = bookNameId;
        mAuthorNameID = authorNameId;
        mBookIconId = bookIconId;
    }

    protected Book(Parcel in) {
        mBookNameID = in.readInt();
        mAuthorNameID = in.readInt();
        mBookIconId = in.readInt();
    }

    /**
     * Get the name of the Book
     */
    public int getbookNameID() {
        return mBookNameID;
    }

    /**
     * Get the name of the author
     */
    public int getauthorNameID() {
        return mAuthorNameID;
    }

    /**
     * Get the icon for the book
     */
    public int getbookIconID() {
        return mBookIconId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mBookNameID);
        parcel.writeInt(mAuthorNameID);
        parcel.writeInt(mBookIconId);
    }
}
