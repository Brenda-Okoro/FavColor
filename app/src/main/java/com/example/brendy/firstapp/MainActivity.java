package com.example.brendy.firstapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    EditText etFavColor;
    Button btnDone;
    TextView answer;
    TextInputLayout textInputLayout;
    @Inject
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFavColor = findViewById(R.id.et_fav_color);
        btnDone = findViewById(R.id.btn_done);
        textInputLayout = findViewById(R.id.wrapper_fav_color);
        answer = findViewById(R.id.show);

        FavApplicationComponent component = DaggerFavApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        component.inject(this);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                if (getCurrentFocus() != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    etFavColor.setVisibility(View.GONE);
                    textInputLayout.setVisibility(View.GONE);
                    btnDone.setVisibility(View.GONE);
                    answer.setVisibility(View.VISIBLE);
                    String ans = "Your Favorite colour is " + etFavColor.getText().toString().trim();
                    answer.setText(ans);
                }

            }
        });


    }
}
