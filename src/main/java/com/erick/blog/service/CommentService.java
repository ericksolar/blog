package com.erick.blog.service;

import com.erick.blog.dto.request.CommentRequest;
import com.erick.blog.dto.response.CommentResponse;
import com.erick.blog.model.Comment;
import com.erick.blog.model.Post;
import com.erick.blog.model.User;
import com.erick.blog.repository.CommentRepository;
import com.erick.blog.repository.PostRepository;
import com.erick.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public List<CommentResponse> obtenerComentarios() {
        return commentRepository.findAll().stream()
                .map(CommentResponse::from)
                .collect(Collectors.toList());
    }

    public CommentResponse crearComentario(CommentRequest request) {
        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new RuntimeException("Post no encontrado: " + request.getPostId()));

        User author = userRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + request.getAuthorId()));

        Comment comment = new Comment();
        comment.setPost(post);
        comment.setAuthor(author);
        comment.setContenido(request.getContenido());

        if (request.getParentId() != null) {
            Comment parent = commentRepository.findById(request.getParentId())
                    .orElseThrow(() -> new RuntimeException("Comentario padre no encontrado: " + request.getParentId()));
            comment.setParent(parent);
        }

        return CommentResponse.from(commentRepository.save(comment));
    }

}
