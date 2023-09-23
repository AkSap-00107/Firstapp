package com.andproject.practapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //TextView text1;
    AutoCompleteTextView autotext;
    Button but;

    Button but1;
    Button but2;
    TextView et2;

    String[] languages={"akash","sapkal","tanvi","tanu","java","android","php","c","html"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         autotext=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
         but=(Button) findViewById(R.id.button);
         but1=(Button)findViewById(R.id.Datebutton);
         but2=(Button)findViewById(R.id.timebutton);
         et2=(TextView) findViewById(R.id.edit1);

        Intent in1=getIntent();
        String str=in1.getStringExtra("113");
        et2.setText(str);


        but1.setOnClickListener(new View.OnClickListener() {
            Calendar c1=Calendar.getInstance();
            int c_year=c1.get(Calendar.YEAR);
            int c_month=c1.get(Calendar.MONTH);
            int c_dayOfMonth=c1.get(Calendar.DAY_OF_MONTH);

            @Override
            public void onClick(View view) {
                DatePickerDialog dialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        but1.setText(year +"/"+ (month+1) +"/"+ dayOfMonth);
                    }
                },c_year,c_month,c_dayOfMonth);

                dialog.show();
            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
                Calendar T=Calendar.getInstance();
                int T_hourOfDay=T.get(Calendar.HOUR_OF_DAY);
                int T_minute=T.get(Calendar.MINUTE);
            @Override
            public void onClick(View v) {
                TimePickerDialog dia = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        but2.setText(hourOfDay + ":" + minute);
                    }
                },T_hourOfDay,T_minute,true);
                dia.show();
            }
        });
        ArrayAdapter<String> akas
                = new ArrayAdapter<>
                (MainActivity.this, android.R.layout.select_dialog_item,languages);

//        ArrayAdapter<String> adapter
//                = new ArrayAdapter<String>(
//                this,
//                android.R.layout.select_dialog_item,
//                languages);
        autotext.setThreshold(1);
        autotext.setAdapter(akas);
        autotext.setTextColor(Color.RED);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast message= Toast.makeText(getApplicationContext(),
                        "I like you,I want to be with you Always",Toast.LENGTH_LONG);
                message.show();
            }
        });
    }
}