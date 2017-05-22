package com.matheus.repository;


import com.matheus.model.Usuario;
import com.matheus.repository.contracts.IUsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDAO implements IUsuarioDAO{

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void salvar(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        manager.persist(usuario);
    }

    @Override
    public void atualizar(Usuario usuario) {

    }

    @Override
    public Usuario encontrarPorId(int id) {
        return null;
    }

    @Override
    public List<Usuario> listar() {
        return manager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }
}
