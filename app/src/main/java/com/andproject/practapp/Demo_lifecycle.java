package com.andproject.practapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Demo_lifecycle extends AppCompatActivity {
    TextView t1;
    ImageView i1;
    TextView t2;
    Button b1;
    Button b2;
    EditText et1;
    Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_lifecycle);
        Log.d("LifeCycle","On Create Method is Invoked");

        TextView t1=(TextView) findViewById(R.id.textView);
        ImageView i1=(ImageView) findViewById(R.id.imageView);
        TextView t2=(TextView) findViewById(R.id.textView2);
        Button b1=(Button) findViewById(R.id.button2);
        Button b2=(Button) findViewById(R.id.button3);
        EditText et1=(EditText) findViewById(R.id.editText);
        Button b3=(Button) findViewById(R.id.button5);

        Intent in1=new Intent(getApplicationContext(),MainActivity.class);

        Intent in2=new Intent(Intent.ACTION_VIEW);
        in2.setData(Uri.parse("https://developer.android.com"));

        Intent in3=new Intent(getApplicationContext(),MainActivity.class);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(in1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(in2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_data=et1.getText().toString().trim();

                if (et1.length()==0 || et1.equals("") || et1==null)
                {
                    Toast me =Toast.makeText(getApplicationContext(),"Data not available to share",Toast.LENGTH_SHORT);
                }
                else
                {
                    in3.putExtra("113",s_data);
                    startActivity(in3);
                }
                }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in4=new Intent();
                in4.setAction(Intent.ACTION_SEND);
                in4.setType("text/plain");
                in4.putExtra(Intent.EXTRA_TEXT,t2.getText().toString());
                startActivity(Intent.createChooser(in4,"ShareTo"));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle","On Start Method is Invoked");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("LifeCycle","On Resume Method is Invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("LifeCycle","On Pause Method is Invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","On Stop Method is Invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle","On Restart Method is Invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle","On Destroy Method is Invoked");
    }
}