package com.junipersys.funfacts;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";
    // Declare our View variables. Convention is to add m before all member variables
    private TextView factTextView;
    private Button showFactButton;
    private ConstraintLayout constraintLayout;
    private FactBook mFactbook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    private String mFact = mFactbook.facts[0];
    private int mColor = Color.parseColor(mColorWheel.colors[8]);

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOR, mColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mFact = savedInstanceState.getString(KEY_FACT);
        factTextView.setText(mFact);
        mColor = savedInstanceState.getInt(KEY_COLOR);
        constraintLayout.setBackgroundColor(mColor);
        showFactButton.setTextColor(mColor);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign the Views from the layout file to the corresponding variables
        factTextView = findViewById(R.id.tvFunFacts);
        showFactButton = findViewById(R.id.btShowFacts);
        constraintLayout = findViewById(R.id.relativeLayout);

        showFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //update textview with new fact
                mFact = mFactbook.getFact();
                factTextView.setText(mFact);
                mColor = mColorWheel.getColor();
                constraintLayout.setBackgroundColor(mColor);
                showFactButton.setTextColor(mColor);
            }
        });

        Log.d(TAG, "We're logging from the onCreate() method!");
        //Toast.makeText(this, "YAY!", Toast.LENGTH_SHORT).show();

    }
}
