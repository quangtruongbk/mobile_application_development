package com.example.administrator.currency_converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    String categoryexchange[]={"USD->VNĐ","VNĐ->USD","Euro->VNĐ","VNĐ->Euro"};
    ArrayAdapter<String> adapter;
    EditText input;
    TextView output;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=(Spinner)findViewById(R.id.category);
        input=findViewById(R.id.input);
        output=findViewById(R.id.result);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,categoryexchange);
        sp.setAdapter(adapter);
        btn=findViewById(R.id.exchange_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().trim().isEmpty()==true){
                    Toast.makeText(getApplicationContext(),"Input must not be null!", Toast.LENGTH_SHORT).show();
                }
                else{
                    double value = Double.parseDouble(input.getText().toString().trim());
                    exchange(value,sp.getSelectedItem().toString());
                }
            }
        });

    }
    public void exchange(double value, String mode) {
        double result;
        Log.d("1abc",mode);
        String resultstring;
        switch (mode) {
            case "USD->VNĐ":
                result = value * 23000;
                resultstring = String.valueOf(result);
                output.setText(resultstring);
                break;
            case "VNĐ->USD":
                result = value / 23000;
                resultstring = String.valueOf(result);
                output.setText(resultstring);
                break;
            case "Euro->VNĐ":
                result = value * 28000;
                resultstring = String.valueOf(result);
                output.setText(resultstring);
                break;
            case "VNĐ->Euro":
                result = value / 28000;
                resultstring = String.valueOf(result);
                output.setText(resultstring);
                break;
            default:
                Toast.makeText(getApplicationContext(), "Something wrong just happened. Please try again. Please make sure your input is in float format!", Toast.LENGTH_SHORT).show();
        }
    }
}
