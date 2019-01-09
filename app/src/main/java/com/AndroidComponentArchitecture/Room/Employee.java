package com.AndroidComponentArchitecture.Room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import java.io.Serializable;

@Entity(tableName = "Employee")
public class Employee implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "Id")
    private int Id;

    @ColumnInfo(name = "Name")
    private String Name;

    @ColumnInfo(name = "Gender")
    private String Gender ;

    @ColumnInfo(name = "City")
    private String City;

    @ColumnInfo(name = "Salary")
    private int Salary;

    public Employee(@NonNull int id, String name, String gender, String city, int salary) {
        Id = id;
        Name = name;
        Gender = gender;
        City = city;
        Salary = salary;
    }

    public Employee() {
    }

    @NonNull
    public int getId() {
        return Id;
    }

    public void setId(@NonNull int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }




}
