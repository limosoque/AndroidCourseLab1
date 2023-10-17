package com.example.lab1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends Activity {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create button listener
        Button colorChangeButton = findViewById(R.id.colorChangeButton);
        colorChangeButton.setOnClickListener(view -> {
            Intent startNewActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
            StartNewActivity(startNewActivityIntent);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void StartNewActivity(Intent newActivityIntent){
        //get color from text field
        TextInputEditText colorField = findViewById(R.id.colorField);
        int color = DefineColor(Objects.requireNonNull(colorField.getText()).toString().toLowerCase());

        newActivityIntent.putExtra("color", color);
        startActivity(newActivityIntent);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private int DefineColor(String color){
        switch (color){
            case "red":
                return Color.RED;
            case "blue":
                return Color.BLUE;
            case "green":
                return Color.GREEN;
            default:
                Toast.makeText(getApplicationContext(),
                        "Incorrect input, default white color is used",
                        Toast.LENGTH_SHORT).show();
                return Color.WHITE;
        }
    }
}