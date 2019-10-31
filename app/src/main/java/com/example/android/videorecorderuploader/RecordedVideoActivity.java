package com.example.android.videorecorderuploader;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class RecordedVideoActivity extends AppCompatActivity {

    private static final int GALLERY = 1;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recorded);

         videoView = (VideoView)findViewById(R.id.videoView);


        Button display = (Button) findViewById(R.id.show);
        display.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                choosePhotoFromGallary();
            }
        });

         //onActivityResult();

    }

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == MainActivity.REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = intent.getData();
            videoView.setVideoURI(videoUri);
        }
    }

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }
}
