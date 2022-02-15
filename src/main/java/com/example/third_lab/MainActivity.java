package com.example.third_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button sign_up, login_btn;
    EditText edt_email, edt_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sign_up=findViewById(R.id.btn_2);
        login_btn=findViewById(R.id.btn_1);
        edt_email=findViewById(R.id.edit_text);
        edt_password=findViewById(R.id.edit_text_2);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("info_saved", MODE_PRIVATE);
                String login_email = sp.getString("email_reg","Niha");
                String login_password = sp.getString("pass_reg","niharika");

                String Uemail = edt_email.getText().toString();
                String Upassword = edt_password.getText().toString();

                if(login_email.equals(Uemail) && login_password.equals(Upassword)){
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();

                    SharedPreferences lp = getSharedPreferences("state", MODE_PRIVATE);
                    SharedPreferences.Editor et = lp.edit();
                    et.putBoolean("loginstate", true);
                    et.apply();

                    Intent i = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(i);


                }
                else {
                    Toast.makeText(MainActivity.this, "Incorrect username or password",Toast.LENGTH_LONG).show();


                }


            }
        });


        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i);

            }
        });


    }

    private void checkLoginStatus() {
        SharedPreferences sp = getSharedPreferences("state", MODE_PRIVATE);
        boolean state = sp.getBoolean("loginstate",false);
        if(state){
            Intent i = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(i);
        }
    }

}
