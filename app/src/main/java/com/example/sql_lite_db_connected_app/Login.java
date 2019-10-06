package com.example.sql_lite_db_connected_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import DataBase.DbHelper;
import Modal.Subjects;
import Modal.User;

public class Login extends AppCompatActivity {
    private EditText name, password;
    private String na, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final DbHelper dbHelper = new DbHelper(Login.this);
        Button signUp = findViewById(R.id.signUp);
        Button login = findViewById(R.id.login);
        name = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);





        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, SignUp.class));
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 na = name.getText().toString();
                 pass = password.getText().toString();

                User user =(User) dbHelper.getDetailsByName(na);

                if(user.getName() == null){
                    Toast.makeText(getApplicationContext(), "Please Enter Correct Details!", Toast.LENGTH_LONG).show();
                }else if(user.getPassword().equals(pass)  && user.getName().equals(na)){
                    if(user.getType().equals("Teacher")){
                        startActivity(new Intent(Login.this, Teacher.class).putExtra("user", user));
                    }else {
                        startActivity(new Intent(Login.this, Student.class).putExtra("user", user));
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Please Enter Correct Details!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
