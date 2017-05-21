package com.matheus.dto;

import com.matheus.model.Role;
import com.matheus.model.Telefone;
import com.matheus.model.Usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UsuarioDTO {

    private String nome;
    private String email;
    private String senha;
    private Set<TelefoneDTO> telefones;
    private Set<RoleDTO> roles;

    public UsuarioDTO() {
        telefones = new HashSet<>();
        roles = new HashSet<>();
    }

    public UsuarioDTO(Usuario model) {
        this.nome = model.getNome();
        this.email = model.getEmail();
        this.senha = model.getSenha();

        telefones = new HashSet<>();
        model.getTelefones().forEach(telefone -> telefones.add(new TelefoneDTO(telefone)));

        roles = new HashSet<>();
        model.getRoles().forEach(role -> roles.add(new RoleDTO(role)));
    }

    public Usuario toEntity() {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        Set<Telefone> telefoneList = new HashSet<>();
        telefones.forEach(telefone -> telefoneList.add(telefone.toEntity(usuario)));
        usuario.setTelefones(telefoneList);

        Set<Role> roleList = new HashSet<>();
        roles.forEach(role -> roleList.add(role.toEntity()));
        usuario.setRoles(roleList);

        return usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<TelefoneDTO> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<TelefoneDTO> telefones) {
        this.telefones = telefones;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }
}
