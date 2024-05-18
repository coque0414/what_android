package com.example.project_java_test;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Usertest.class}, version = 1, exportSchema = false)
public abstract class UserDB extends RoomDatabase {
    public abstract UserDao getDAO();

    private static UserDB instance;

    public static synchronized UserDB getInstance(Context context) {
        if (instance == null) {
            synchronized (UserDB.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                                    UserDB.class, "user-database")
                            .build();
                }
            }
        }
        return instance;
    }
}
