package com.example.simplymanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createAccount extends AppCompatActivity {

    private EditText sID, sName, pass, cpass;
    private Button btn_newAccount;
    private DBSupport db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        db = new DBSupport(this);

        sID = findViewById(R.id.ev_storeID1);
        sName = findViewById(R.id.ev_storeName);
        pass = findViewById(R.id.ev_password2);
        cpass = findViewById(R.id.ev_cpassword);
        btn_newAccount = findViewById(R.id.btn_new);

        btn_newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //extract texts from user inpput
                String user = sID.getText().toString();
                String password = pass.getText().toString();
                String cpassword = cpass.getText().toString();

                if (user.equals("") || password.equals("") || cpassword.equals("")){
                    Toast.makeText(createAccount.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                }else{
                    if (password.equals(cpassword)){
                        Boolean usercheckresult = db.checkuser(user);
                        if (usercheckresult == false){
                            Boolean regResult = db.insertData(user, password);
                            if (regResult == true){
                                Toast.makeText(createAccount.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                gotoLogin();
                            }else{
                                Toast.makeText(createAccount.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(createAccount.this, "User Already exits.\n GO to login page.", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(createAccount.this, "Password not Matched", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void gotoLogin(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}