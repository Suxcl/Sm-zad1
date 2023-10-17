package com.example.zad1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Answer_activity extends AppCompatActivity {

    private TextView anwser_points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        anwser_points = findViewById(R.id.answer_points_text_view);
        anwser_points.setText(
                getIntent().getStringExtra("points") + "/" + getIntent().getStringExtra("max_points")
        );



    }
}