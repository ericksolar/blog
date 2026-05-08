package com.erick.blog.dto.response;

import com.erick.blog.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse {

    private Long id;
    private String nombre;
    private String slug;

    public static CategoryResponse from(Category category) {
        CategoryResponse r = new CategoryResponse();
        r.id = category.getId();
        r.nombre = category.getNombre();
        r.slug = category.getSlug();
        return r;
    }

}
