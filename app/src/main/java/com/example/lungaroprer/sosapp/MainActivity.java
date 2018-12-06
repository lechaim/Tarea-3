package com.example.lungaroprer.sosapp;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import com.example.lungaroprer.sosapp.entidad.Usuario;
import com.example.lungaroprer.sosapp.repositorio.usuario.UsuarioRepositorio;
import com.example.lungaroprer.sosapp.repositorio.usuario.UsuarioRepositorioImpl;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    UsuarioRepositorio usuarioRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioRepositorio = new UsuarioRepositorioImpl(this);
        final EditText emailText = findViewById(R.id.edtEmailLogin);
        final EditText passwordText = findViewById(R.id.edtContrasenaLogin);

        Button register = (Button) findViewById(R.id.btnRegistrar_Login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(MainActivity.this, Registro.class);
                startActivity(register);

            }
        });

        Button login = findViewById(R.id.btnIniciar);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
         public void onClick(View v) {
             if (emailText.getText().toString().isEmpty()){
                 Toast.makeText(getApplicationContext(), "Indique su correo", Toast.LENGTH_LONG).show();
                 return;
             }

            if (passwordText.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "Indique su contrasena", Toast.LENGTH_LONG).show();
                return;
            }

            Usuario usuario = usuarioRepositorio.buscar(emailText.getText().toString().trim());
             if(usuario != null && usuario.getPassword().equals(passwordText.getText().toString().trim())){
                 Toast.makeText(getApplicationContext(), "Usuario loggeado\nNombre : " +usuario.getNombre(),Toast.LENGTH_LONG).show();

             }
             else{
                 Toast.makeText(getApplicationContext(),"Usuario o contrasena invalido.", Toast.LENGTH_LONG).show();
             }
            }
        });

        Usuario usuario= new Usuario();
        usuario.setEmail("juandelospalotes@gmail.com");
        usuario.setNombre("Juan de los Palotes");
        usuario.setUsername("juanpalote");

        Usuario usuario1= new Usuario();
        usuario1.setEmail("escarlinmoran17@hotmail.com");
        usuario1.setNombre("Lemar Alur");
        usuario1.setUsername("LAlur");

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
