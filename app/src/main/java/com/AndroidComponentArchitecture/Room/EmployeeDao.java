package com.AndroidComponentArchitecture.Room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Insert
    void insert(Employee employee);

    @Query(" Delete from Employee")
    void deleteAll();

    @Query("Select * from Employee")
    LiveData<List<Employee>> getAlldata();
}
