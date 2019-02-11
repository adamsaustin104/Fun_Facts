package com.junipersys.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    // Declare our View variables. Convention is to add m before all member variables
    private TextView factTextView;
    private Button showFactButton;
    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign the Views from the layout file to the corresponding variables
        factTextView = findViewById(R.id.tvFunFacts);
        showFactButton = findViewById(R.id.btShowFacts);
        relativeLayout = findViewById(R.id.relativeLayout);

        showFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //update textview with new fact
                factTextView.setText(FactBook.getFact());
                int color = ColorWheel.getColor();
                relativeLayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);
            }
        });

        Log.d(TAG, "We're logging from the onCreate() method!");
        //Toast.makeText(this, "YAY!", Toast.LENGTH_SHORT).show();

    }
}
