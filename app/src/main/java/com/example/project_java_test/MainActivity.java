package com.example.project_java_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    private EditText idtv;
    private EditText pwtv;
    private Button btnLogin;
    private Button btnRegister;
    private UserDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idtv = findViewById(R.id.idtv);
        pwtv = findViewById(R.id.pwtv);
        btnLogin = findViewById(R.id.button);
        btnRegister = findViewById(R.id.button2);

        db = Room.databaseBuilder(this, UserDB.class, "UserDB").allowMainThreadQueries().build();
    }

    public void joinUser() {
        db.getDAO().insertUser(new Usertest(idtv.getText().toString(), pwtv.getText().toString()));
    }

    public boolean checkValidUser() {
        return !db.getDAO().getIdList().isEmpty();
    }

    public String checkValidPw(String id) {
        return db.getDAO().getPwByID(id);
    }

//    public void onClick(View v) {
//        int id = v.getId();
//        if (id == R.id.button) {
//            // Login button
//            if (!idtv.getText().toString().isEmpty() && !pwtv.getText().toString().isEmpty()) {
//                if (checkValidUser()) {
//                    if (checkValidPw(idtv.getText().toString()).equals(pwtv.getText().toString())) {
//                        Toast.makeText(this, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(this, "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(this, "가입된 계정이 없습니다.", Toast.LENGTH_SHORT).show();
//                }
//            } else {
//                Toast.makeText(this, "아이디와 비밀번호는 필수 입력 사항입니다.", Toast.LENGTH_SHORT).show();
//            }
//        } else if (id == R.id.button2) {
//            // Register button
//            if (!idtv.getText().toString().isEmpty() && !pwtv.getText().toString().isEmpty()) {
//                joinUser();
//            } else {
//                Toast.makeText(this, "아이디와 비밀번호는 필수 입력 사항입니다.", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
public void btnLogin(View view) {
    if (!idtv.getText().toString().isEmpty() && !pwtv.getText().toString().isEmpty()) {
        if (checkValidUser()) {
            if (checkValidPw(idtv.getText().toString()).equals(pwtv.getText().toString())) {
                Toast.makeText(this, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "가입된 계정이 없습니다.", Toast.LENGTH_SHORT).show();
        }
    } else {
        Toast.makeText(this, "아이디와 비밀번호는 필수 입력 사항입니다.", Toast.LENGTH_SHORT).show();
    }
}
    public void btnRegister(View view) {
        if (!idtv.getText().toString().isEmpty() && !pwtv.getText().toString().isEmpty()) {
            joinUser();
            Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "아이디와 비밀번호는 필수 입력 사항입니다.", Toast.LENGTH_SHORT).show();
        }
    }




}