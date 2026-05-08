package com.erick.blog.service;

import com.erick.blog.dto.request.PostRequest;
import com.erick.blog.dto.response.PostResponse;
import com.erick.blog.model.Category;
import com.erick.blog.model.Post;
import com.erick.blog.model.User;
import com.erick.blog.model.enums.PostStatus;
import com.erick.blog.repository.CategoryRepository;
import com.erick.blog.repository.PostRepository;
import com.erick.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public List<PostResponse> obtenerPosts() {
        return postRepository.findAll().stream()
                .map(PostResponse::from)
                .collect(Collectors.toList());
    }

    public PostResponse crearPost(PostRequest request) {
        User author = userRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + request.getAuthorId()));

        Set<Category> categories = new HashSet<>(
                categoryRepository.findAllById(request.getCategoryIds())
        );

        Post post = new Post();
        post.setAuthor(author);
        post.setTitulo(request.getTitulo());
        post.setSlug(request.getSlug());
        post.setContenido(request.getContenido());
        post.setStatus(PostStatus.valueOf(request.getStatus()));
        post.setCategories(categories);

        return PostResponse.from(postRepository.save(post));
    }

}
