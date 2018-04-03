package com.example.jaiba.laboratorio;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;


/**
 * Created by jaiba on 03-04-2018.
 */
@Dao
public interface FormsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUsers(Forms... forms);

    @Delete
    void delete(Forms forms);
}
