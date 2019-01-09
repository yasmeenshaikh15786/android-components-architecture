package com.AndroidComponentArchitecture.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.AndroidComponentArchitecture.R;
import com.AndroidComponentArchitecture.Room.Employee;

import java.io.Serializable;

import static com.AndroidComponentArchitecture.Activity.MainActivity.NEW_WORD_ACTIVITY_REQUEST_CODE;

public class InsertData extends AppCompatActivity {

    EditText txtName,txtSalary;
    RadioGroup rdgGender;
    RadioButton rdbMale,rdbFemale;
    Spinner spi_city;
    Button btnSubmit;

    public static final String EXTRA_REPLY = "com.AndroidComponentArchitecture.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        initview();
    }

    void initview(){
        txtName = findViewById(R.id.edt_insert_Name);
        txtSalary = findViewById(R.id.edt_insert_salary);
        rdgGender = findViewById(R.id.rdg_gender);
        rdbMale = findViewById(R.id.rdb_Male);
        rdbFemale = findViewById(R.id.rdb_female);
        spi_city = findViewById(R.id.spi_City);
        btnSubmit = findViewById(R.id.btn_Submit);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioButton radioButton = findViewById(rdgGender.getCheckedRadioButtonId());
                int Salary  = Integer.parseInt(txtSalary.getText().toString());

                Intent replyIntent = new Intent();

                Employee employee= new Employee(1,txtName.getText().toString(),radioButton.getText().toString(),
                        spi_city.getSelectedItem().toString(),Salary);

                replyIntent.putExtra(EXTRA_REPLY, (Serializable) employee);
                setResult(RESULT_OK,replyIntent);

                finish();
            }
        });
    }


}
