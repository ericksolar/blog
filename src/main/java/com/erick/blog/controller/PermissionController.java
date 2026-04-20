package com.erick.blog.controller;

import com.erick.blog.model.Permission;
import com.erick.blog.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permission")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping
    public List<Permission> listar(){
        return permissionService.obterPermisos();
    }

    @PostMapping
    public Permission crear(@RequestBody Permission permission){
        return permissionService.crearPermiso(permission);
    }

}
