package com.example.simplymanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DBSupport db;
    private EditText sID, pass;
    private Button btn_signin, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pass = findViewById(R.id.ev_password2);
        sID = findViewById(R.id.ev_storeID1);
        signup = findViewById(R.id.btn_new);
        btn_signin = findViewById(R.id.btn_login);
        db = new DBSupport(this);

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uID = sID.getText().toString();
                String password = pass.getText().toString();

                if (uID.equals("") || password.equals("")){
                    Toast.makeText(MainActivity.this, "Fill All Fields", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean result = db.checkusernamepassword(uID, password);
                    if (result){
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), createAccount.class);
                startActivity(intent);
            }
        });
    }
}