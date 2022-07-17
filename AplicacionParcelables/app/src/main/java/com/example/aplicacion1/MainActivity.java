package com.example.aplicacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplicacion1.databinding.ActivityDetalle2Binding;
import com.example.aplicacion1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    static float valor = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnRegistrar.setOnClickListener(v -> {
            String clave = binding.txtClave.getText().toString();
            String clave2= binding.txtClave2.getText().toString();
            String nombre = binding.txtNombre.getText().toString();

            int cont=0;

            Context context = MainActivity.this;
            if (nombre.isEmpty()){
                Toast.makeText(MainActivity.this,"Campo nombre vacio, llenar por favor",Toast.LENGTH_SHORT).show();
            }else if (clave.isEmpty()){
                Toast.makeText(MainActivity.this,"Campo clave vacio, llenar por favor",Toast.LENGTH_SHORT).show();
            }else if (clave2.isEmpty()){
                Toast.makeText(MainActivity.this,"Campo repetir clave vacio, llenar por favor",Toast.LENGTH_SHORT).show();
            }else if (clave.length()<5){
                Toast.makeText(MainActivity.this,"La clave debe tener minimo 5 caracteres",Toast.LENGTH_SHORT).show();
            }else
            if (clave.equals(clave2)){
                int cont1 = clave.length();
                char[] karen = clave.toCharArray();

                for(int i=0; i<karen.length; i++){
                    if( (karen[i] >=33 && karen[i]<=47) || (karen[i] >=58 && karen[i]<=64) || (karen[i] >=91 && karen[i]<=96) || (karen[i] >=123 && karen[i]<=126) ){
                         cont++;
                    }
                }
                if (cont>=4 && cont1>=12){
                    valor=5;
                }else if(cont>=2 && cont1>=10){
                    valor=4;
                }else if(cont>=1 && cont1>=8) {
                    valor = 3;
                }else if(cont1>=8) {
                    valor = 2;
                }else{
                    valor=1;
                }

                abrir(nombre, clave,valor);
            }else{
                Toast.makeText(MainActivity.this,"Las claves no coinciden",Toast.LENGTH_SHORT).show();
                binding.txtClave2.setText("");
            }
        });
    }
    private void abrir(String usua, String cla,float val) {
        Intent intent = new Intent(this, Detalle.class);
        Usuario usuario = new Usuario(usua,cla,val);
        intent.putExtra(Detalle.USUARIO_KEY,usuario);

        startActivity(intent);
    }
}