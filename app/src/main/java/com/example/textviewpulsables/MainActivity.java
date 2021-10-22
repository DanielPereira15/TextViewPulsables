package com.example.textviewpulsables;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_CONTADOR1="key_contador1";
    private static final String KEY_CONTADOR2="key_contador2";
    private static final String KEY_COLOR1="key_color1";
    private static final String KEY_COLOR2="key_color2";


    TextView btn1;
    TextView btn2;
    int contador1, contador2;
    int color1,color2;
    Random r= new Random();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1= findViewById(R.id.boton1);
        btn2= findViewById(R.id.boton2);
        contador1=0;
        contador2=0;

        btn1.setText(""+contador1);
        btn2.setText(""+contador2);

        btn1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                contador1=0;
                btn1.setText(""+contador1);
                btn1.setBackgroundColor(0);
                return true;
            }
        });

        btn2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                contador2=0;
                btn2.setText(""+contador2);
                btn2.setBackgroundColor(0);
                return true;
            }
        });
    }

    public void incrementar1(View v){
        contador1++;
        btn1.setText(""+contador1);
        color1 = Color.rgb(r.nextInt(256),r.nextInt(256),r.nextInt(256));
        btn1.setBackgroundColor(color1);
        //cambiarColor(btn1);
        compruebaIguales();
    }
    public void incrementar2(View v){
        contador2++;
        btn2.setText(""+contador2);
        color2 = Color.rgb(r.nextInt(256),r.nextInt(256),r.nextInt(256));
        btn2.setBackgroundColor(color2);
        //cambiarColor(btn2);
        compruebaIguales();

    }
   /* public void cambiarColor(View v){
        Random r= new Random();
        int color = Color.rgb(r.nextInt(256),r.nextInt(256),r.nextInt(256));
        v.setBackgroundColor(color);
    }*/

    public void compruebaIguales(){
        if (contador1==contador2){
            Toast.makeText(this,"Los botones son iguales",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COLOR1,color1);
        outState.putInt(KEY_COLOR2,color2);
        outState.putInt(KEY_CONTADOR1,contador1);
        outState.putInt(KEY_CONTADOR2,contador2);
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        contador1=savedInstanceState.getInt(KEY_CONTADOR1,0);
        contador2=savedInstanceState.getInt(KEY_CONTADOR2,0);
        color1=savedInstanceState.getInt(KEY_COLOR1,0);
        color2=savedInstanceState.getInt(KEY_COLOR2,0);
        btn1.setText(""+contador1);
        btn1.setBackgroundColor(color1);
        btn2.setText(""+contador2);
        btn2.setBackgroundColor(color2);

    }

}