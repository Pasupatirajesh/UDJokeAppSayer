package com.example.android.androidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    private TextView mJokeTextView;
    private TextView mJokerTextView;

    ArrayList<String> mStringArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        mJokeTextView=(TextView) findViewById(R.id.textView);
        mJokerTextView = findViewById(R.id.textView2);

    if(getIntent() !=null)
    {
        mStringArrayList =getIntent().getStringArrayListExtra("JokeText");
        mJokerTextView.setText(mStringArrayList.get(0));
        mJokeTextView.setText(mStringArrayList.get(1));
    }





    }
}
