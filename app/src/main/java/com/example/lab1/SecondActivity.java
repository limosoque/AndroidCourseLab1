package com.example.lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent parentIntent = getIntent();
        //set background color
        int backgroundColor = parentIntent.getIntExtra("color", 0);
        ConstraintLayout constraintLayout = findViewById(R.id.constraint_layout);
        constraintLayout.setBackgroundColor(backgroundColor);
    }
}