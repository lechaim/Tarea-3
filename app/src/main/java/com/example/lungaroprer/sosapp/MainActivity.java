package com.example.lungaroprer.sosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import com.example.lungaroprer.sosapp.Usuario;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Log.d(TAG,"Entrando al main Activity");
        Log.e(TAG,"Esto es un error");
        Log.i(TAG,"Esto es una informacion");*/

        /*Button btnBotton= findViewById(R.id.button);
        btnBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario usuario= new Usuario();

                try {
                    usuario.setEdad(-12);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,"Edad no permitida",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        });*/

        Usuario usuario= new Usuario();
        usuario.setEmail("juandelospalotes@gmail.com");
        usuario.setNombre("Juan de los Palotes");
        usuario.setUsername("juanpalote");

        Usuario usuario1= new Usuario();
        usuario1.setEmail("escarlinmoran17@hotmail.com");
        usuario1.setNombre("Escarlin Moran");
        usuario1.setUsername("EscarM");

        Usuario usuario2= new Usuario();
        usuario2.setEmail("genesis@hotmail.com");
        usuario2.setNombre("Genesis Collado");
        usuario2.setUsername("GenesisC");

        Usuario usuario3= new Usuario();
        usuario3.setEmail("maria@hotmail.com");
        usuario3.setNombre("Maria Santos");
        usuario3.setUsername("MariaS");

        List<Usuario> usuarioList= new ArrayList<>();
        usuarioList.add(usuario);
        usuarioList.add(usuario1);
        usuarioList.add(usuario2);
        usuarioList.add(usuario3);

        Log.i(TAG,"Tamaño de la lista:"+ usuarioList.size());


        for (Usuario u: usuarioList){
            Log.i(TAG,"Nombre: "+u.getNombre());
        }

    }

}
