package com.example.notStrava;

import androidx.room.RoomDatabase;

@Database(entities = {Person.class}, version = 1)
public abstract class RunDatabase extends RoomDatabase {

	
	public abstract RunDAO getRunDAO();
}
