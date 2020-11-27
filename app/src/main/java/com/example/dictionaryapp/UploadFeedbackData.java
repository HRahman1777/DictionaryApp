package com.example.dictionaryapp;

public class UploadFeedbackData {
    private String name;
    private String email;
    private String word;
    private String meaning;
    private String comment;

    public UploadFeedbackData(String name, String email, String word, String meaning, String comment) {
        this.name = name;
        this.email = email;
        this.word = word;
        this.meaning = meaning;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
