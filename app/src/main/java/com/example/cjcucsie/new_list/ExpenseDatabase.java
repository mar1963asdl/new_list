package com.example.cjcucsie.new_list;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = {Entity.class}, version = 1, exportSchema = false)
abstract class ExpenseDatabase extends RoomDatabase {


    public abstract Dao getDao();

//        public abstract Dao.Insert(Entity);
}

