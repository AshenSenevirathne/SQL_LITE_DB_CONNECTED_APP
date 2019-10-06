package com.example.sql_lite_db_connected_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import DataBase.DbHelper;
import Modal.User;

public class SignUp extends AppCompatActivity {
    private EditText name, password;
    private CheckBox teacher, student;
    private Button signUp;
    private DbHelper dbHelper;
    private String n,p,t;
    private User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name =(EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        teacher =(CheckBox) findViewById(R.id.checkBox);
        student = (CheckBox) findViewById(R.id.checkBox2);
        signUp =(Button) findViewById(R.id.button);
        final DbHelper dbHelper = new DbHelper(this);

        
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user.setName(name.getText().toString());
                user.setPassword(password.getText().toString());

                if(teacher.isChecked()){
                    user.setType("Teacher");
                }else if(student.isChecked()){
                    user.setType("Student");
                }
                Boolean result = dbHelper.insertData(user);
                if(result = true){
                    Toast.makeText(getApplicationContext(), "Sign Up Success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }


                startActivity(new Intent(SignUp.this, Login.class));

            }




        });


    }
}
