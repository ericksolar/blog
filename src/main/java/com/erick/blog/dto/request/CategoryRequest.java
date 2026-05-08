package com.erick.blog.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {
    private String nombre;
    private String slug;
}
