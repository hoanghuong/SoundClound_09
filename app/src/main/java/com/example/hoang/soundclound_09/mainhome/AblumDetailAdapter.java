package com.example.hoang.soundclound_09.mainhome;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoang.soundclound_09.R;
import com.example.hoang.soundclound_09.data.Track;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AblumDetailAdapter extends RecyclerView.Adapter<AblumDetailAdapter.AblumDetailAdapterHolder> {
    private Context mContext;
    private List<Track> mTrackList;

    public AblumDetailAdapter(Context context, List<Track> trackList) {
        mContext = context;
        mTrackList = trackList;
    }

    @NonNull
    @Override
    public AblumDetailAdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_music, viewGroup, false);
        return new AblumDetailAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AblumDetailAdapterHolder ablumDetailAdapterHolder, int i) {
        Picasso.get().load(mTrackList.get(i).getArtWorkUrl()).into(ablumDetailAdapterHolder.mImageAvata);
        ablumDetailAdapterHolder.mTextTenBaiHat.setText(mTrackList.get(i).getTitle());
        ablumDetailAdapterHolder.mTextTenCaSi.setText(mTrackList.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return mTrackList.size();
    }

    public class AblumDetailAdapterHolder extends RecyclerView.ViewHolder {
        private ImageView mImageAvata;
        private TextView mTextTenBaiHat;
        private TextView mTextTenCaSi;
        public AblumDetailAdapterHolder(@NonNull View itemView) {
            super(itemView);
            mImageAvata = itemView.findViewById(R.id.image_avata_item);
            mTextTenBaiHat = itemView.findViewById(R.id.text_tenbaihat);
            mTextTenCaSi = itemView.findViewById(R.id.text_tencasi);
        }
    }
}
