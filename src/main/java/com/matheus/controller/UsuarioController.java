package com.matheus.controller;

import com.matheus.dto.UsuarioDTO;
import com.matheus.model.Usuario;
import com.matheus.repository.contracts.IUsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private IUsuarioDAO usuarioDAO;

    public UsuarioController(@Autowired IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Usuario> listar() {
        return usuarioDAO.listar();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UsuarioDTO> criar(@RequestBody UsuarioDTO dto) {
        Usuario usuario = dto.toEntity();
        usuarioDAO.salvar(usuario);
        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }
}
