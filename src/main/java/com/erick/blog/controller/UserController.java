package com.erick.blog.controller;

import com.erick.blog.dto.request.UserRequest;
import com.erick.blog.model.User;
import com.erick.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> listar() { return userService.obtenerUsuarios(); }

    @PostMapping
    public User crearUsuario(@RequestBody UserRequest user){
        return userService.crearRole(user);
    }
}
