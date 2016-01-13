package com.malmstein.fenster.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.malmstein.fenster.Constants;

public class MediaPlayerDemoActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo);
        bindViews();
    }

    private void bindViews() {
        findViewById(R.id.start_gesture_media_player_button).setOnClickListener(this);
        findViewById(R.id.start_simple_media_player_button).setOnClickListener(this);
        findViewById(R.id.local_file_media_player_button).setOnClickListener(this);
        findViewById(R.id.start_scale_media_player_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_simple_media_player_button: {
                Intent intent = new Intent(this, SimpleMediaPlayerActivity.class);
                intent.putExtra(Constants.KEY_LOCAL_FILE, true);
                startActivity(intent);
                break;
            }
            case R.id.start_scale_media_player_button: {
                Intent intent = new Intent(this, ScaleMediaPlayerActivity.class);
                intent.putExtra(Constants.KEY_LOCAL_FILE, true);
                startActivity(intent);
                break;
            }
            case R.id.start_gesture_media_player_button: {
                Intent intent = new Intent(this, GestureMediaPlayerActivity.class);
                intent.putExtra(Constants.KEY_LOCAL_FILE, true);
                startActivity(intent);
                break;
            }
            case R.id.local_file_media_player_button:
                Intent localStream = new Intent(this, SimpleMediaPlayerActivity.class);
                localStream.putExtra(Constants.KEY_LOCAL_FILE, true);
                startActivity(localStream);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.demo_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
