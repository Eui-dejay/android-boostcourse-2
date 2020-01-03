package com.example.movieproject2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class ReviewerItemView extends LinearLayout {

    TextView textViewId;
    TextView textViewReview;
    public ReviewerItemView(Context context) {
        super(context);

        init(context);
    }

    public ReviewerItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.reviewer_item,this,true);

        textViewId = (TextView) findViewById(R.id.textViewId);
        textViewReview = (TextView) findViewById(R.id.textViewReview);
    }

    public void setName(String name) {
        textViewId.setText(name);
    }

    public void setTextViewReview(String reviewText) {
        textViewReview.setText(reviewText);
    }
}
