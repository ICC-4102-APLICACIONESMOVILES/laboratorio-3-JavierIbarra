package com.example.jaiba.laboratorio;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by jaiba on 03-04-2018.
 */
@Database(entities = {Forms.class}, version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract FormsDao formsDao();

}


