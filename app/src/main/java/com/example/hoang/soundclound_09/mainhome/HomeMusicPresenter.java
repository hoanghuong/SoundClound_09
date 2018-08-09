package com.example.hoang.soundclound_09.mainhome;

import com.example.hoang.soundclound_09.data.Track;
import com.example.hoang.soundclound_09.data.remote.TrackByGenreTask;

import java.util.List;

public class HomeMusicPresenter implements HomeMusicContract.presenter {
    private HomeMusicContract.View mView;

    public HomeMusicPresenter(String genre, HomeMusicContract.View view) {
        this.mView = view;
        new TrackByGenreTask(this).execute(genre);
    }

    @Override
    public void loadListGenerMusic(List<Track> tracks) {
        mView.showListGenerMusic(tracks);
    }
}
