package com.erick.blog.controller;

import com.erick.blog.dto.request.CategoryRequest;
import com.erick.blog.model.Category;
import com.erick.blog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> listar() {
        return categoryService.obtenerCategorias();
    }

    @PostMapping
    public Category crear(@RequestBody CategoryRequest request) {
        return categoryService.crearCategoria(request);
    }

}
