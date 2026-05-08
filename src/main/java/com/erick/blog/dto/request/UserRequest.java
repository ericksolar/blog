package com.erick.blog.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {
    private String email;
    private String nombre;
    private String passwordHash;
    private List<Long> roles;
}
