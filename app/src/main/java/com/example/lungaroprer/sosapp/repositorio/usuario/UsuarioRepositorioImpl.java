package com.example.lungaroprer.sosapp.repositorio.usuario;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.lungaroprer.sosapp.entidad.Usuario;
import com.example.lungaroprer.sosapp.repositorio.DbConnection;

public class UsuarioRepositorioImpl implements UsuarioRepositorio {

    private DbConnection dbConnection;

    public UsuarioRepositorioImpl(Context context) {
        this.dbConnection = new DbConnection(context) {
        };
    }

    @Override
    public void guardar(Usuario usuario) {

        ContentValues cv = new ContentValues();
        cv.put("email", usuario.getEmail());
        cv.put("password", usuario.getPassword());
        cv.put("name", usuario.getNombre());

        // TODO guardar usuario

        SQLiteDatabase db = dbConnection.getWritableDatabase();
        Long id = db.insert("usuario", null, cv);
        usuario.setId(id.intValue());
    }

    @Override
    public Usuario buscar(String email) {
        return null;
    }
}
