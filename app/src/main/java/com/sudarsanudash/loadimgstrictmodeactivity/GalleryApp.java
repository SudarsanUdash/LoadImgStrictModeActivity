package com.sudarsanudash.loadimgstrictmodeactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class GalleryApp extends AppCompatActivity {
    private Button btnSaave;
    private ImageView imgGallery;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (data==null);{
                Toast.makeText(this, "Select Image", Toast.LENGTH_SHORT).show();
            }
        }
        Uri uri = data.getData();
        imgGallery.setImageURI(uri);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_app);


        btnSaave = findViewById(R.id.btnSaave);
        imgGallery = findViewById(R.id.imgGallery);

        btnSaave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BrowseImage();
            }

            private void BrowseImage() {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,0);
            }
        });

    }
}
