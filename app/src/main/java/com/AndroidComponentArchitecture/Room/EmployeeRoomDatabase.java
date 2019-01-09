package com.AndroidComponentArchitecture.Room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

//@Database(entities = (Employee.class),version = 1)
@Database(entities = {Employee.class}, version = 2)
public abstract class EmployeeRoomDatabase extends RoomDatabase {

    public abstract EmployeeDao employeeDao();

    //Singleton
    public static volatile EmployeeRoomDatabase employeeRoomDatabase;

    public static EmployeeRoomDatabase getEmployeeRoomDatabase(final Context context){

        if (employeeRoomDatabase == null){
            employeeRoomDatabase = Room.databaseBuilder(context.getApplicationContext(),
            EmployeeRoomDatabase.class,"EmployeeDB").build();
        }

        return employeeRoomDatabase;
    }
}
