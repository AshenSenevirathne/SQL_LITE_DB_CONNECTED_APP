package com.example.sql_lite_db_connected_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import Modal.Subjects;

public class MassageView extends AppCompatActivity {
    TextView sub, mass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massage_view);
        sub = findViewById(R.id.textView5);
        mass = findViewById(R.id.textView6);


        Intent intent = getIntent();
        Subjects subjects = (Subjects)intent.getSerializableExtra("mass");
        sub.setText(subjects.getSubject());
        mass.setText(subjects.getMassage());

    }
}
