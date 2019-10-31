package com.example.android.videorecorderuploader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rButton = (Button)findViewById(R.id.record);
        rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakeVideoIntent();
            }
        });

        TextView viewTextView=(TextView)findViewById(R.id.viewRecording);
        viewTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewVideos();
            }
        });
    }


    static final int REQUEST_VIDEO_CAPTURE = 1;

    private void dispatchTakeVideoIntent() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }

    private void viewVideos(){
        Intent viewRecorded =new Intent(this, RecordedVideoActivity.class);
        startActivity(viewRecorded);
    }
}
