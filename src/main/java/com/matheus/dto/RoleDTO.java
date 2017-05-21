package com.matheus.dto;

import com.matheus.model.Role;

public class RoleDTO {

    private String name;

    public RoleDTO() { }

    public RoleDTO(Role role) {
        this.name = role.getName();
    }

    public Role toEntity(){
        Role role = new Role();
        role.setName(name);

        return role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
