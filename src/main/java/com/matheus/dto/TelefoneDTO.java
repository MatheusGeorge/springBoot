package com.matheus.dto;

import com.matheus.model.Telefone;
import com.matheus.model.Usuario;

public class TelefoneDTO {
    private String descricao;
    private String numero;

    public TelefoneDTO() {
    }

    public TelefoneDTO(Telefone model) {
        this.numero = model.getNumero();
        this.descricao = model.getDescricao();
    }

    public Telefone toEntity(Usuario usuario) {
        Telefone telefone = new Telefone();
        telefone.setDescricao(descricao);
        telefone.setNumero(numero);
        telefone.setUsuario(usuario);

        return telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
