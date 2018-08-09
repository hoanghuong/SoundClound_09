package com.example.hoang.soundclound_09.mainhome;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoang.soundclound_09.R;
import com.example.hoang.soundclound_09.data.Track;

import java.util.List;

public class AblumAdapter extends RecyclerView.Adapter<AblumAdapter.AblumAdapterHolder> {
    private Context mContext;
    private ItemHomeMusicClickListener mItemHomeMusicClickListener;
    private List<Track> mTrackList;

    public AblumAdapter(Context Context, ItemHomeMusicClickListener iteamHomeMusicClick,List<Track> trackList) {
        this.mContext = Context;
        this.mItemHomeMusicClickListener = iteamHomeMusicClick;
        this.mTrackList=trackList;
    }

    @NonNull
    @Override
    public AblumAdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_genres, viewGroup, false);
        return new AblumAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AblumAdapterHolder ablumAdapterHolder, int i) {
        ablumAdapterHolder.mTextGener.setText(mTrackList.get(i).getGenre());
        ablumAdapterHolder.initDetailGenres();
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class AblumAdapterHolder extends RecyclerView.ViewHolder {
        private TextView mTextGener;
        private RecyclerView mRecyclerGener;

        public AblumAdapterHolder(@NonNull View itemView) {
            super(itemView);
            mTextGener = itemView.findViewById(R.id.text_theloai);
            mRecyclerGener = itemView.findViewById(R.id.recycer_genres);
        }

        private void initDetailGenres() {
            AblumDetailAdapter ablumDetailAdapter = new AblumDetailAdapter(mContext, mTrackList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext,
                    LinearLayoutManager.HORIZONTAL, false);
            mRecyclerGener.setLayoutManager(layoutManager);
            mRecyclerGener.setAdapter(ablumDetailAdapter);
        }
    }


    public interface ItemHomeMusicClickListener {
        void onItemHomeMusicClick(int postition);
        void onItemGenerMusicClick(int postition);
    }
}
