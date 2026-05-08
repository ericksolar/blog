package com.erick.blog.dto.response;

import com.erick.blog.model.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CommentResponse {

    private Long id;
    private String contenido;
    private LocalDateTime createdAt;
    private Long postId;
    private Long parentId;
    private AuthorResponse author;
    private List<CommentResponse> replies;

    public static CommentResponse from(Comment comment) {
        CommentResponse r = new CommentResponse();
        r.id = comment.getId();
        r.contenido = comment.getContenido();
        r.createdAt = comment.getCreatedAt();
        r.postId = comment.getPost().getId();
        r.parentId = comment.getParent() != null ? comment.getParent().getId() : null;
        r.author = AuthorResponse.from(comment.getAuthor());
        r.replies = comment.getReplies().stream()
                .map(CommentResponse::from)
                .collect(Collectors.toList());
        return r;
    }

    @Getter
    @Setter
    public static class AuthorResponse {
        private Long id;
        private String nombre;
        private String email;

        public static AuthorResponse from(com.erick.blog.model.User user) {
            AuthorResponse r = new AuthorResponse();
            r.id = user.getId();
            r.nombre = user.getUsername();
            r.email = user.getEmail();
            return r;
        }
    }

}
