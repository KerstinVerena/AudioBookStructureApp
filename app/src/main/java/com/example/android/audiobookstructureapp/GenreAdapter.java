package com.example.android.audiobookstructureapp;

/* This class includes code derived from the Android Flavor App (https://github.com/udacity/ud839_CustomAdapter_Example)
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0;
 */

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class GenreAdapter extends ArrayAdapter<Genre> {

    public GenreAdapter(Activity context, ArrayList<Genre> sortByGenre) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for a TextView, an ImageView and a color resource, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, sortByGenre);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.genre_list_item, parent, false);
        }

        // Get the {@link Genre} object located at this position in the list
        Genre currentGenre = getItem(position);

        // Find the TextView in the genre_list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.genre_name_view);
        // Get the version name from the current Genre object and
        // set this text on the name TextView
        nameTextView.setText(currentGenre.getGenreNameID());
        // set the color on the name TextView
        nameTextView.setBackgroundResource(currentGenre.getColorId());


        // Find the ImageView in the genre_list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.genre_icon_view);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(currentGenre.getImageResourceId());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
