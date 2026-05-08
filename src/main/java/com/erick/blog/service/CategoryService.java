package com.erick.blog.service;

import com.erick.blog.dto.request.CategoryRequest;
import com.erick.blog.model.Category;
import com.erick.blog.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> obtenerCategorias() {
        return categoryRepository.findAll();
    }

    public Category crearCategoria(CategoryRequest request) {
        Category category = new Category();
        category.setNombre(request.getNombre());
        category.setSlug(request.getSlug());
        return categoryRepository.save(category);
    }

}
