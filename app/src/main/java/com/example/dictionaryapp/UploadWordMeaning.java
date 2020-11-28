package com.example.dictionaryapp;

public class UploadWordMeaning {

    String strWord;
    String strMeaning;

    public UploadWordMeaning() {

    }


    public UploadWordMeaning(String strWord, String strMeaning) {
        this.strWord = strWord;
        this.strMeaning = strMeaning;
    }

    public String getStrWord() {
        return strWord;
    }

    public void setStrWord(String strWord) {
        this.strWord = strWord;
    }

    public String getStrMeaning() {
        return strMeaning;
    }

    public void setStrMeaning(String strMeaning) {
        this.strMeaning = strMeaning;
    }
}
