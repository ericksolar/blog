// src/test/java/com/erick/blog/service/PermissionServiceTest.java
package com.erick.blog.service;

import com.erick.blog.model.Permission;
import com.erick.blog.repository.PermissionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PermissionServiceTest {

    @Mock
    private PermissionRepository permissionRepository;

    @InjectMocks
    private PermissionService permissionService;

    @Test
    void obtenerPermisos_debeRetornarListaDePermisos() {
        // Arrange (escribe el test ANTES de implementar)
        Permission p1 = new Permission();
        when(permissionRepository.findAll()).thenReturn(List.of(p1));

        // Act
        List<Permission> resultado = permissionService.obterPermisos();

        // Assert
        assertThat(resultado).hasSize(1);
        verify(permissionRepository, times(1)).findAll();
    }

    @Test
    void crearPermiso_debeGuardarYRetornarElPermiso() {
        // Arrange
        Permission permission = new Permission();
        when(permissionRepository.save(permission)).thenReturn(permission);

        // Act
        Permission resultado = permissionService.crearPermiso(permission);

        // Assert
        assertThat(resultado).isNotNull();
        verify(permissionRepository).save(permission);
    }
}
