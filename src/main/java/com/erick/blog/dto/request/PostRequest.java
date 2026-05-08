package com.erick.blog.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostRequest {
    private Long authorId;
    private String titulo;
    private String slug;
    private String contenido;
    private String status;
    private List<Long> categoryIds;
}
