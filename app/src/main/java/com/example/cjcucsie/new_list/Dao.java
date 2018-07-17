package com.example.cjcucsie.new_list;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.widget.RemoteViews;

import java.util.ArrayList;
import java.util.List;


@android.arch.persistence.room.Dao
public interface Dao {
    @Query("select * from " + Entity.TABLE_EXPENSE)
    public List<Entity> getAll();

    @Query("select * from " + Entity.TABLE_EXPENSE + " where name >= :name")
    public List<Entity> queryByName(String name);

    @Delete
    public void delete(Entity expense);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Entity expense);

//        @Query("delete * from " + Entity.TABLE_EXPENSE)


}

