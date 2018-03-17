package com.example.administrator.exercise_1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.os.Handler;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText txt_long;
    private EditText txt_la;
    private TextView tv1;
    private Button btn;
    private String result;
    Handler mHandler = new Handler();
    GeoCoding geo=new GeoCoding();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("abc", "create");
        txt_long=(EditText)findViewById(R.id.txt_long);
        txt_la=(EditText)findViewById(R.id.txt_la);
        btn=(Button)findViewById(R.id.btn_location);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        result=geo.getAddress(txt_la.getText().toString().trim(),txt_long.getText().toString().trim());
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                tv1=(TextView) findViewById(R.id.tv1);
                                if(result==null) tv1.setText("Location is null");
                                else tv1.setText(result);
                            }
                        };
                        mHandler.post(runnable);
                    }
                };

                thread.start();
            }
         });
    }
}
