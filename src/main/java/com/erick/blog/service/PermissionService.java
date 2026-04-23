package com.erick.blog.service;

import com.erick.blog.model.Permission;
import com.erick.blog.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService {

    private final PermissionRepository permissionRepository;

    //obtener
    public List<Permission> obterPermisos(){
        return permissionRepository.findAll();
    }

    //create
    public Permission crearPermiso(Permission permission){
        permissionRepository.save(permission);
        return permission;
    }

}
