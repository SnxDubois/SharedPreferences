package com.example.sharedpref;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText rememberMe;
    TextView backUp;
    Button save;
    SharedPreferences textToRemember;

    public void updateTextTextView() {
        String text = textToRemember.getString("Text", "Backup");
        backUp.setText(text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rememberMe = findViewById(R.id.etRememberMe);
        backUp = findViewById(R.id.tvBackUp);
        save = findViewById(R.id.btSave);
        textToRemember = getSharedPreferences("Text", MODE_PRIVATE);

        updateTextTextView();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String TEXT_TO_REMEMBER = rememberMe.getText().toString();

                SharedPreferences.Editor editor = textToRemember.edit();

                editor.putString("Text", TEXT_TO_REMEMBER);
                editor.commit();

                updateTextTextView();

            }
        });

    }
}
