package com.erick.blog.controller;

import com.erick.blog.dto.request.PostRequest;
import com.erick.blog.dto.response.PostResponse;
import com.erick.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostResponse> listar() {
        return postService.obtenerPosts();
    }

    @PostMapping
    public PostResponse crear(@RequestBody PostRequest request) {
        return postService.crearPost(request);
    }

}
