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
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private Button mJokeButton;
    public static String mJokeString = "";
    public static ArrayList<String> mJokeArrayList = new ArrayList<>();
    private InterstitialAd mInterstitialAd;

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
        View root = inflater.inflate(R.layout.fragment_main_free, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.ad_View);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

            mJokeButton = (Button) root.findViewById(R.id.button2);

            mJokeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mInterstitialAd.show();

                    mInterstitialAd.setAdListener(new AdListener() {
                            @Override
                            public void onAdClosed() {
                                super.onAdClosed();
                                Intent intent = new Intent(getContext(), LibraryActivity.class);
                                intent.putStringArrayListExtra("JokeText", mJokeArrayList);
                                startActivity(intent);
                                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                            }
                        });

                }
            });
            return root;
        }}
