package com.rpatil.cybersociety.mobcompqr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class fragmentGenerate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_generate);

        final String URL = "https://api.qrserver.com/v1/create-qr-code/?size=300x300&data=yoyoyoyyy";
        Picasso.get().load(URL).into((ImageView)findViewById(R.id.imageView));
    }
}
