package com.AndroidComponentArchitecture;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import com.AndroidComponentArchitecture.Room.Employee;
import com.AndroidComponentArchitecture.Room.EmployeeDao;
import com.AndroidComponentArchitecture.Room.EmployeeRoomDatabase;
import java.util.List;


//This doesn’t come under the architecture component. This is a class where we will
//check whether to fetch data from API or local database, or you can say we
//are putting the logic of database fetching in this class.

public class EmployeeRepository {

    public EmployeeDao employeeDao;
    public LiveData<List<Employee>> mAllEmployee;

    public EmployeeRepository(Application application){
        EmployeeRoomDatabase db= EmployeeRoomDatabase.getEmployeeRoomDatabase(application);
        employeeDao = db.employeeDao();
        mAllEmployee = employeeDao.getAlldata();
    }

    public LiveData<List<Employee>> getmAllEmployee(){
        return mAllEmployee;
    }

    public void insert(Employee employee){
        new insertAsyntask(employeeDao).execute(employee);
    }

    private class insertAsyntask extends AsyncTask<Employee,Void,Void>{

        private EmployeeDao employeeDao;

        insertAsyntask(EmployeeDao employeeDao){
            this.employeeDao =employeeDao;
        }

        @Override
        protected Void doInBackground(Employee... employees) {
            employeeDao.insert(employees[0]);
            return null;
        }
    }
}
