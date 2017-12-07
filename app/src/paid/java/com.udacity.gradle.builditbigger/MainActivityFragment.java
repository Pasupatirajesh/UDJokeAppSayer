package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.androidlib.LibraryActivity;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private Button mJokeButton;
    public static String mJokeString = "";
    public static ArrayList<String> mJokeArrayList = new ArrayList<>();

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new EndpointsAsyncTask(getContext()).execute(new Pair<Context, String>(getActivity(), ""));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);


        mJokeButton = (Button) root.findViewById(R.id.button2);

        mJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LibraryActivity.class);
                if(mJokeArrayList !=null)
                    intent.putStringArrayListExtra("JokeText", mJokeArrayList);
                    startActivity(intent);
            }
        });
        return root;
    }
}
