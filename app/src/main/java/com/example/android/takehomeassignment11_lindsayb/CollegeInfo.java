package com.example.android.takehomeassignment11_lindsayb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class CollegeInfo extends AppCompatActivity {


    ImageView image;
    TextView name;
    TextView location;
    TextView displayText;
    String savedText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_info);

        image = (ImageView) findViewById(R.id.college_photo);
        name = (TextView) findViewById(R.id.college_name);
        location = (TextView) findViewById(R.id.college_info);

        Intent intent = getIntent();
        College m = (College) intent.getSerializableExtra(KEYS.COLLEGE);


        //displayText.setText((m.getName().toString()) + "\n" + m.getInfo().toString() + "\n");
        image.setImageResource(m.getPhotoId());
        name.setText(m.getName());
        location.setText(m.getInfo());

    }
}