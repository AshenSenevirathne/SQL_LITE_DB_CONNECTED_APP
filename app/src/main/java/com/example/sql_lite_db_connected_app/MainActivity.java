package com.example.sql_lite_db_connected_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import DataBase.DbHelper;

public class MainActivity extends AppCompatActivity {
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DbHelper(this);
    }
}
