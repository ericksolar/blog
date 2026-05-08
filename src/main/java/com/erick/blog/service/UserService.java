package com.erick.blog.service;

import com.erick.blog.dto.request.UserRequest;
import com.erick.blog.model.Role;
import com.erick.blog.model.User;
import com.erick.blog.repository.RoleRepository;
import com.erick.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public List<User> obtenerUsuarios(){
        return userRepository.findAll();
    }

    //create
    public User crearRole(UserRequest request){
        Set<Role> roles = new HashSet<>(
                roleRepository.findAllById(request.getRoles())
        );

        User user = new User();
        user.setUsername(request.getNombre());
        user.setEmail(request.getEmail());
        user.setPasswordHash(request.getPasswordHash());
        user.setRoles(roles);

        return userRepository.save(user);
    }
}
