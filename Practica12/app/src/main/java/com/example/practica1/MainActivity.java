package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText txt_nombre =findViewById(R.id.txt_nombre);
        EditText txt_clave= findViewById(R.id.txt_clave);
        EditText txt_clave2= findViewById(R.id.txt_clave2);
        TextView txt_resultado =findViewById(R.id.txt_resultado);
        Button btn_registarse=findViewById(R.id.btn_registrar);
        btn_registarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String clave = txt_clave.getText().toString();
                String clave2= txt_clave2.getText().toString();
                Context context = MainActivity.this;
                if (txt_nombre.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Campo nombre vacio, llenar por favor",Toast.LENGTH_SHORT).show();
                }else if (txt_clave.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Campo clave vacio, llenar por favor",Toast.LENGTH_SHORT).show();
                }else if (txt_clave2.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Campo repetir clave vacio, llenar por favor",Toast.LENGTH_SHORT).show();
                }else
                if (clave.equals(clave2)){
                    String msg_resultado= "Usuario Registrado Correctamente";
                    txt_resultado.setText(msg_resultado);
                    txt_clave.setText("");
                    txt_clave2.setText("");
                    txt_nombre.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"Las claves no coinciden",Toast.LENGTH_SHORT).show();
                    txt_clave2.setText("");
                }
            }
        });
    }
}