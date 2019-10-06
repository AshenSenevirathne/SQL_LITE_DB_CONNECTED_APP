package com.example.sql_lite_db_connected_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import DataBase.DbHelper;
import Modal.Subjects;
import Modal.User;

public class Teacher extends AppCompatActivity {
    private DbHelper dbHelper;
    private TextView head;
    private Button send;
    private EditText sub, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        dbHelper = new DbHelper(this);
        head = findViewById(R.id.textView);
        send = findViewById(R.id.send);
        sub = findViewById(R.id.editText3);
        message = findViewById(R.id.editText4);

        Intent intent = getIntent();
        final User user = (User) intent.getSerializableExtra("user");
        head.setText(user.getName());

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Subjects subjects = new Subjects();
                subjects.setUser(user.getName());
                subjects.setMassage(message.getText().toString());
                subjects.setSubject(sub.getText().toString());

                Boolean result = dbHelper.addMessage(subjects);
                if(result = true){
                    Toast.makeText(getApplicationContext(), "Massage Sent Successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
