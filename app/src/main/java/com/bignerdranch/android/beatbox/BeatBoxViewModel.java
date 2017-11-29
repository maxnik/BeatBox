package com.bignerdranch.android.beatbox;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.widget.SeekBar;

/**
 * Created by maxnik on 11/29/17.
 */

public class BeatBoxViewModel extends BaseObservable {

    private BeatBox mBeatBox;

    public ObservableField<Float> playbackSpeedValue = new ObservableField<>(1.0f);

    public BeatBoxViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
    }

    public void onPlaybackSpeedChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
        float playbackSpeed;

        if (progressValue == 0) {
            playbackSpeed = 0.5f;
        } else if (progressValue <= 50) {
            playbackSpeed = 0.5f + (0.5f * (progressValue / 50.0f));
        } else {
            playbackSpeed = 1.0f + ((progressValue - 50) / 50.0f);
        }

        mBeatBox.setPlaybackSpeed(playbackSpeed);
        playbackSpeedValue.set(playbackSpeed);
    }
}
