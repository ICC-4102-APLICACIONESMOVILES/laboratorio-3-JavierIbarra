package com.example.jaiba.laboratorio;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity
public class Forms {
    @PrimaryKey
    @NonNull
    private String name;

    @ColumnInfo(name = "date")
    private int Date;

    @ColumnInfo(name = "commentary")
    private String Commentary;

    @ColumnInfo(name = "category")
    private String Category;

}
