package com.example.hoang.soundclound_09.mainhome;

import com.example.hoang.soundclound_09.data.Track;

import java.util.List;

public interface HomeMusicContract {
    interface presenter {
        void loadListGenerMusic(List<Track> tracks);
    }

    interface View {
        void showListGenerMusic(List<Track> tracks);
    }
}
