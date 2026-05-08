package com.erick.blog.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {
    private Long postId;
    private Long authorId;
    private Long parentId;
    private String contenido;
}
