package com.example.project_java_test;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    // 가입 여부 판단
    @Query("SELECT id FROM Usertest")
    List<String> getIdList();

    // 비밀번호 체크
    @Query("SELECT password FROM Usertest WHERE id = :id")
    String getPwByID(String id);

    // 회원가입
    @Insert
    void insertUser(Usertest PutInUser);
}
