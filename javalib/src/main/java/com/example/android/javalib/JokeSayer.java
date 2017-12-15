package com.example.android.javalib;

import java.util.ArrayList;

public class JokeSayer {

    private ArrayList<String> mJoke = new ArrayList<>();

    public ArrayList<String> getJoke() {

        return mJoke;
    }

    public void setJoke() {
//        this.mJoke = joke;
        mJoke.add("Hi this is a joke");
        mJoke.add("Joke and Coke rhyme like dope");

    }
}
