package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    TextView textView1,textView2;
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,
    button_ac,button_del,button_per,button_div,button_add,button_mul,button_sub,button_dot,button_equal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        textView1=findViewById(R.id.text1);
        textView2=findViewById(R.id.text2);

        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);
        button9=findViewById(R.id.button9);
        button0=findViewById(R.id.button0);

        button_ac=findViewById(R.id.button_ac);
        button_del=findViewById(R.id.button_del);
        button_per=findViewById(R.id.button_per);
        button_div=findViewById(R.id.button_div);
        button_add=findViewById(R.id.button_add);
        button_mul=findViewById(R.id.button_mul);
        button_sub=findViewById(R.id.button_sub);
        button_equal=findViewById(R.id.button_equal);
        button_dot=findViewById(R.id.button_dot);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(textView2.getText()+"1");
            }
        });button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(textView2.getText()+"2");
            }
        });button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(textView2.getText()+"3");
            }
        });button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(textView2.getText()+"4");
            }
        });button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(textView2.getText()+"5");
            }
        });button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(textView2.getText()+"6");
            }
        });button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(textView2.getText()+"7");
            }
        });button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(textView2.getText()+"8");
            }
        });button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(textView2.getText()+"9");
            }
        });button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(textView2.getText()+"0");
            }
        });button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(textView2.getText()+".");
            }
        });button_per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(textView2.getText()+"%");
            }
        });button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(textView2.getText()+"÷");
            }
        });button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(textView2.getText()+"×");
            }
        });button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(textView2.getText()+"+");
            }
        });button_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(textView2.getText()+"-");
            }
        });

        button_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(null);
                textView2.setText("");
            }
        });
        button_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val=textView2.getText().toString();
                val=val.substring(0,val.length()-1);
                textView2.setText(val); 
            }
        });
        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=textView2.getText().toString();

                data=data.replaceAll("×","*");
                data=data.replaceAll("%","/100");
                data=data.replaceAll("÷","/");

                Context rhino=Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult;

                Scriptable scriptable=rhino.initSafeStandardObjects();
                finalResult=rhino.evaluateString(scriptable,data,"javascript",1,null).toString();
                textView1.setText(finalResult);


            }
        });


    }
}