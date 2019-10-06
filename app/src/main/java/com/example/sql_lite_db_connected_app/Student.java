package com.example.sql_lite_db_connected_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import DataBase.DbHelper;
import Modal.Subjects;
import Modal.User;

public class Student extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        listView = findViewById(R.id.list);

        DbHelper dbHelper = new DbHelper(Student.this);

        Intent intent = getIntent();
        User user =(User) intent.getSerializableExtra("user");




        List<Subjects> list   = dbHelper.readAllMassages();

        ArrayAdapter arrayAdapter =  new ArrayAdapter(Student.this,android.R.layout.simple_list_item_activated_1, list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Subjects subjects =(Subjects) adapterView.getAdapter().getItem(i);

                startActivity(new Intent(Student.this, MassageView.class).putExtra("mass", subjects));
            }
        });
    }
}
