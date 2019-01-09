package com.AndroidComponentArchitecture.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.AndroidComponentArchitecture.R;
import com.AndroidComponentArchitecture.Room.Employee;

import java.util.Collections;
import java.util.List;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.ViewHolder> {

    private final LayoutInflater mLayoutinflator;
    private List<Employee> mAllEmployee = Collections.emptyList();

    public EmployeeListAdapter(Context context) {
        mLayoutinflator = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutinflator.inflate(R.layout.items,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Employee employee = mAllEmployee.get(i);
        viewHolder.txtName.setText(employee.getName());
        viewHolder.txtGender.setText(employee.getGender());
        viewHolder.txtSalary.setText(String.valueOf(employee.getSalary()));
    }

    public void setWords(List<Employee> employees){
        mAllEmployee = employees;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mAllEmployee.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtName,txtGender,txtSalary;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = (TextView) itemView.findViewById(R.id.txt_Name);
            txtGender = (TextView) itemView.findViewById(R.id.txt_Gender);
            txtSalary = (TextView) itemView.findViewById(R.id.txt_Salary);
        }
    }


}
