package com.erick.blog.controller;

import com.erick.blog.dto.request.RoleRequest;
import com.erick.blog.model.Role;
import com.erick.blog.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
@RequiredArgsConstructor
public class RolController {

    private final RoleService roleService;

    @GetMapping
    public List<Role> listar(){
        return roleService.obtenerRoles();
    }

    @PostMapping
    public Role crear(@RequestBody RoleRequest role){
        return roleService.crearRole(role);
    }

}
