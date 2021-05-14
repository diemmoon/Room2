package com.example.room_2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PlaceDao {
    @Query("SELECT * FROM place")
    List<Place> getAll();

    @Query("SELECT * FROM place WHERE id = :placeId ")
    Place getById(Integer placeId);

    @Insert
    void add(Place place);

    @Update
    void update(Place place);

    @Delete
    void delete(Place place);
}
