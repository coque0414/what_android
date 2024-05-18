package com.example.project_java_test;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public final class Usertest {

    @ColumnInfo(name = "id")
    private String id;

    @ColumnInfo(name = "password")
    private final String password;

    @PrimaryKey(autoGenerate = true)
    private int uid;

    // Constructor
    public Usertest(String id, String password) {
        this.id = id;
        this.password = password;
    }

    // Getter and Setter for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter for password as it is final
    public String getPassword() {
        return password;
    }

    // Getter and Setter for uid
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}