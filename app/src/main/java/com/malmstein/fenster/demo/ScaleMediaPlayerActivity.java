package com.malmstein.fenster.demo;

import android.app.Activity;
import android.os.Bundle;

import com.malmstein.fenster.Constants;
import com.malmstein.fenster.controller.SimpleMediaFensterPlayerController;
import com.malmstein.fenster.view.FensterVideoView;

public class ScaleMediaPlayerActivity extends Activity {

    private FensterVideoView textureView;
    private SimpleMediaFensterPlayerController fullScreenMediaPlayerController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scale_media_player);

        bindViews();
        initVideo();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        textureView.setVideo(Constants.REMOTE_VIDEO_URL);
        textureView.start();
    }

    private void bindViews() {
        textureView = (FensterVideoView) findViewById(R.id.play_video_texture);
        fullScreenMediaPlayerController = (SimpleMediaFensterPlayerController) findViewById(R.id.play_video_controller);
    }

    private void initVideo() {
        textureView.setMediaController(fullScreenMediaPlayerController);
        textureView.setOnPlayStateListener(fullScreenMediaPlayerController);
    }

}
