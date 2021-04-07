package com.example.books;

class Books {
    String title,starDate,endDate;
    int rating;

    public Books(String title, String starDate, String endDate, int rating) {
        this.title = title;
        this.starDate = starDate;
        this.endDate = endDate;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getStarDate() {
        return starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
