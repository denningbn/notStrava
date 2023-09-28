package com.example.notStrava;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Run")
public class Run {
	
	@ColumnInfo(name="person_id"
	@PrimaryKey(autoGenerate = true)
	int id;

	@ColumnInfo(name = "distance")
	double distance;
	
	@ColumnInfo(name = "avg_speed")
	double avg_speed;

	@ColumnInfo(name = "day")
	int day;

	@ColumnInfo(name = "month")
	int month;

	@ColumnInfo(name = "year")
	int year;

	@Ignore 
	public Run(){
	
	}	

	public Run(double distance, double avg_speed) {
		this.distance = distance;
		this.avg_speed = avg_speed;
		this.id = 0;
	}

	public getDistance(){
		 return this.distance;
	}
	
	public getAvgSpeed(){
		 return this.avg_speed;
	}
	
	public getDate(){
		 return this.date;
	}
}


