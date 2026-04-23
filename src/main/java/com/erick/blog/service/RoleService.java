package com.erick.blog.service;

import com.erick.blog.dto.request.RoleRequest;
import com.erick.blog.model.Permission;
import com.erick.blog.model.Role;
import com.erick.blog.repository.PermissionRepository;
import com.erick.blog.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    //obtener
    public List<Role> obtenerRoles(){
        return roleRepository.findAll();
    }

    //create
    public Role crearRole(RoleRequest request){
        Set<Permission> permisos = new HashSet<>(
                permissionRepository.findAllById(request.getPermission())
        );

        Role role = new Role();
        role.setNombre(request.getNombre());
        role.setPermissions(permisos);
        role.setCreatedAt(LocalDateTime.now());

        return roleRepository.save(role);
    }

}
