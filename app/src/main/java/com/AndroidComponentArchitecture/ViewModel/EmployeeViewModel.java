package com.AndroidComponentArchitecture.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.AndroidComponentArchitecture.EmployeeRepository;
import com.AndroidComponentArchitecture.Room.Employee;

import java.util.List;

public class EmployeeViewModel extends AndroidViewModel {

    public EmployeeRepository employeeRepository;
    public LiveData<List<Employee>> mAllEmployee;

    public EmployeeViewModel(@NonNull Application application) {
        super(application);
        employeeRepository = new EmployeeRepository(application);
        mAllEmployee = employeeRepository.getmAllEmployee();
    }

    public LiveData<List<Employee>> getmAllEmployee(){
        return mAllEmployee;
    }

    public void insert(Employee employee){
        employeeRepository.insert(employee);
    }
}
