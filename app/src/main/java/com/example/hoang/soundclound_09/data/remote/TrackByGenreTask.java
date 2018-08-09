package com.example.hoang.soundclound_09.data.remote;

import android.os.AsyncTask;
import android.util.Log;

import com.example.hoang.soundclound_09.data.JSONUtils;
import com.example.hoang.soundclound_09.data.Track;
import com.example.hoang.soundclound_09.mainhome.HomeMusicContract;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by AM on 8/1/2018.
 */

public class TrackByGenreTask extends AsyncTask<String, Void, ArrayList<Track>> {

    private SoundCloudApiConnection mConnection = null;
    private HomeMusicContract.presenter mView;

    public TrackByGenreTask(HomeMusicContract.presenter presenter) {
        this.mView = presenter;
    }

    @Override
    protected ArrayList<Track> doInBackground(String... strings) {
        ArrayList<Track> tracks = null;
        try {
            mConnection = new SoundCloudApiConnection(Config.TRACK_URL_GENRE +
                    strings[0]);
            mConnection.connect();
            tracks = JSONUtils.parseJsonToTracks
                    (mConnection.getArrayJsonObject());
        } catch (IOException e) {
            return null;
        } catch (JSONException e) {
            return null;
        }
        mConnection.close();
        return tracks;
    }

    @Override
    protected void onPostExecute(ArrayList<Track> tracks) {
        Log.d("track by", tracks.get(0).getGenre());
        mView.loadListGenerMusic(tracks);
        super.onPostExecute(tracks);
    }
}
