package com.erick.blog.dto.response;

import com.erick.blog.model.Post;
import com.erick.blog.model.User;
import com.erick.blog.model.enums.PostStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class PostResponse {

    private Long id;
    private String titulo;
    private String slug;
    private String contenido;
    private PostStatus status;
    private LocalDateTime publishedAt;
    private AuthorResponse author;
    private Set<CategoryResponse> categories;

    public static PostResponse from(Post post) {
        PostResponse r = new PostResponse();
        r.id = post.getId();
        r.titulo = post.getTitulo();
        r.slug = post.getSlug();
        r.contenido = post.getContenido();
        r.status = post.getStatus();
        r.publishedAt = post.getPublishedAt();
        r.author = AuthorResponse.from(post.getAuthor());
        r.categories = post.getCategories().stream()
                .map(CategoryResponse::from)
                .collect(Collectors.toSet());
        return r;
    }

    @Getter
    @Setter
    public static class AuthorResponse {
        private Long id;
        private String nombre;
        private String email;

        public static AuthorResponse from(User user) {
            AuthorResponse r = new AuthorResponse();
            r.id = user.getId();
            r.nombre = user.getNombre();
            r.email = user.getEmail();
            return r;
        }
    }

}
