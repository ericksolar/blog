package com.erick.blog.controller;

import com.erick.blog.dto.request.CommentRequest;
import com.erick.blog.dto.response.CommentResponse;
import com.erick.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public List<CommentResponse> listar() {
        return commentService.obtenerComentarios();
    }

    @PostMapping
    public CommentResponse crear(@RequestBody CommentRequest request) {
        return commentService.crearComentario(request);
    }

}
