package com.example.movieproject2;

public class ReviewerItem {

    String name;
    String reviewText;

    public ReviewerItem(String name, String reviewText) {
        this.name = name;
        this.reviewText = reviewText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    @Override
    public String toString() {
        return "ReviewerItem{" +
                "name='" + name + '\'' +
                ", reviewText='" + reviewText + '\'' +
                '}';
    }
}


