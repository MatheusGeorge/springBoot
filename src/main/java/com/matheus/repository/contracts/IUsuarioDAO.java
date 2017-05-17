package com.matheus.repository.contracts;

import com.matheus.model.Usuario;

import java.util.List;

public interface IUsuarioDAO {
    void salvar(Usuario usuario);
    void atualizar(Usuario usuario);
    Usuario encontrarPorId(int id);
    List<Usuario> listar();
}
