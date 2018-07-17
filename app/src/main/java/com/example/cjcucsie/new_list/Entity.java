package com.example.cjcucsie.new_list;
import android.arch.persistence.room.PrimaryKey;
import static com.example.cjcucsie.new_list.Entity.TABLE_EXPENSE;


@android.arch.persistence.room.Entity(tableName = TABLE_EXPENSE)
    public class Entity {
        public static final String TABLE_EXPENSE = "expense";

        @PrimaryKey(autoGenerate = true)
        public int id;
        public String name;
    }
