package com.londonappbrewery.climapm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChangeCityActivity extends AppCompatActivity {

    private View.OnClickListener changeScreenListner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_city_layout);

        ImageButton backButton = findViewById(R.id.backButton);
        final EditText editText = findViewById(R.id.queryET);
        backButton.setOnClickListener(changeScreenListner);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                String newCity = editText.getText().toString();
                Intent newCityIntent = new Intent(ChangeCityActivity.this, WeatherController.class);
                newCityIntent.putExtra("city", newCity);
                startActivity(newCityIntent);
                return false;
            }
        });
    }
}
