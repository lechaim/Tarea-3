package com.example.lungaroprer.sosapp.repositorio.usuario;

import com.example.lungaroprer.sosapp.entidad.Usuario;

public interface UsuarioRepositorio {

    public void guardar(Usuario usuario); // La clase que use ese procedimiento debe hacer el proceso de guardar

    Usuario buscar(String email);


}
