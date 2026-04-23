package com.erick.blog.dto.request;

import com.erick.blog.model.enums.RoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RoleRequest {
    private RoleEnum nombre;
    private List<Long> permission;
}
