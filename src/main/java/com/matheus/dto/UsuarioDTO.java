package com.matheus.dto;

import com.matheus.model.Telefone;
import com.matheus.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {

    private String nome;
    private String email;
    private List<TelefoneDTO> telefones;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario model) {
        this.nome = model.getNome();
        this.email = model.getEmail();

        List<TelefoneDTO> list = new ArrayList<>();
        model.getTelefones().forEach(telefone -> list.add(new TelefoneDTO(telefone)));

        this.telefones = list;
    }

    public Usuario toEntity() {
        final Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);

        List<Telefone> list = new ArrayList<Telefone>();
        telefones.forEach(telefone -> list.add(telefone.toEntity(usuario)));
        usuario.setTelefones(list);

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

    public List<TelefoneDTO> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneDTO> telefones) {
        this.telefones = telefones;
    }
}
