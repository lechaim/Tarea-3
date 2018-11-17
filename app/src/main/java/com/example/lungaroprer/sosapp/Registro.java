package com.example.lungaroprer.sosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.lungaroprer.sosapp.entidad.Usuario;
import com.example.lungaroprer.sosapp.repositorio.usuario.UsuarioRepositorio;
import com.example.lungaroprer.sosapp.repositorio.usuario.UsuarioRepositorioImpl;

public class Registro extends AppCompatActivity {

    private static String TAG = "REGISTRO_USUARIO";
    UsuarioRepositorio usuarioRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuarioRepositorio = new UsuarioRepositorioImpl(this);

        final EditText emailText = findViewById(R.id.edtEmailRegistro);
        final EditText nombreText = findViewById(R.id.edtNombre);
        final EditText passwordText = findViewById(R.id.edtContrasenaRegistro);
        EditText password2Text = findViewById(R.id.edtConfirmarContrasena);

        Button btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Usuario usuario = new Usuario();
                usuario.setUsername(nombreText.getText().toString());
                usuario.setEmail((emailText.getText().toString()));
                usuario.setPassword((passwordText.getText().toString()));

                Log.i(TAG, usuario.toString());
                usuarioRepositorio.guardar(usuario);
                Log.i(TAG, usuario.toString());

            }

        });
    }
}
